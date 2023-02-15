package com.hukki.chatbot.assistant.application.job;

import com.hukki.chatbot.assistant.domain.ai.IOpenAI;
import com.hukki.chatbot.assistant.domain.zsxq.IZsxqApi;
import com.hukki.chatbot.assistant.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.hukki.chatbot.assistant.domain.zsxq.model.vo.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @author YC02289 wanghui
 * @description: 自动回答问题job计划
 * @email xx@xx.com
 * @date 2023/2/15 16:57
 */
@EnableScheduling
@Configuration
public class ChatbotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);

    @Value("${chatbot-assistant.zsxq.groupId}")
    private String groupId;
    @Value("${chatbot-assistant.zsxq.cookie}")
    private String cookie;
    @Value("${chatbot-assistant.chatgpt.openAiKey}")
    private String openAiKey;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;


    @Scheduled(cron = "0/30 * * * * ?")
    public void run(){
        logger.info("test");
        try{
            if (new Random().nextBoolean()) {
                logger.info("随机打烊中...");
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                logger.info("打烊时间不工作，AI 下班了！");
                return;
            }

            //1.zsxq检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId,cookie);
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (null == topics || topics.isEmpty()) {
                logger.info("本次检索未查询到待会答问题");
                return;
            }

            //2.chatgpt回答问题得到答案
            Topics topic = topics.get(0);
            String question = topic.getQuestion().getText();
            String answer = openAI.doChatGpt(question,openAiKey);

            //3.将答案回复给提问者
            int topicId = topic.getTopic_id();
            boolean status = zsxqApi.answer(groupId,cookie,String.valueOf(topicId),answer,false);
            logger.info("编号：{} 问题：{} 回答：{} 状态：{}", topic.getTopic_id(), topic.getQuestion().getText(), answer, status);

        }catch (Exception e){
            logger.error("自动回答问题异常", e);
        }

    }
}
