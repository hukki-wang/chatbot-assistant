package com.hukki.chatbot.assistant.application.ext;

import com.hukki.chatbot.assistant.application.job.ChatbotTask;
import com.hukki.chatbot.assistant.common.util.PropertyUtil;
import com.hukki.chatbot.assistant.domain.ai.IOpenAI;
import com.hukki.chatbot.assistant.domain.zsxq.IZsxqApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author YC02289 wanghui
 * @description: 任务注册服务，支持多组任务配置
 * 采用配置的方式运行多组任务
 * @email xx@xx.com
 * @date 2023/2/17 14:42
 */
@Configuration
@EnableScheduling
public class TaskRegistrarAutoConfig implements EnvironmentAware, SchedulingConfigurer {


    private Map<String, Map<String, Object>> taskGroupMap = new HashMap<>();

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Override
    public void setEnvironment(Environment environment) {
        String prefix = "chatbot-assistant.";
        String launchListStr = environment.getProperty(prefix + "launchList");
        if (StringUtils.isEmpty(launchListStr)) return;
        for (String groupKey : launchListStr.split(",")) {
            Map<String, Object> taskGroupProps = PropertyUtil.handle(environment, prefix + groupKey, Map.class);
            taskGroupMap.put(groupKey, taskGroupProps);
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Set<String> taskGroups = taskGroupMap.keySet();
        for (String groupKey : taskGroups){
            Map<String,Object> taskGroup = taskGroupMap.get(groupKey);

            String groupName = taskGroup.get("groupName").toString();
            String groupId = taskGroup.get("groupId").toString();
            String cookie = taskGroup.get("cookie").toString();
            String openAiKey = taskGroup.get("openAiKey").toString();
            String cronExpressionBase64 = taskGroup.get("cronExpression").toString();
            String cronExpression = new String(Base64.getDecoder().decode(cronExpressionBase64), StandardCharsets.UTF_8);

            //添加任务
            scheduledTaskRegistrar.addCronTask(new ChatbotTask(groupName,groupId,cookie,openAiKey,zsxqApi,openAI),cronExpression);

        }


    }
}
