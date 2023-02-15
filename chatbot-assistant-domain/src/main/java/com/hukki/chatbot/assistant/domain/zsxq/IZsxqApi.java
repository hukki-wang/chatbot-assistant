package com.hukki.chatbot.assistant.domain.zsxq;

import com.hukki.chatbot.assistant.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @author YC02289 wanghui
 * @description: 知识星球领域接口
 * @email xx@xx.com
 * @date 2023/2/15 10:50
 */
public interface IZsxqApi {

    /**
     * 查询待回答的问题
     * @param groupId 知识星球星主groupId
     * @param cookie 知识星球星主个人cookie
     * @return
     * @throws IOException
     *
     */
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    /**
     * 回答问题
     * @param groupId 知识星球星主groupId
     * @param cookie 知识星球星主个人cookie
     * @param topicId 问题topicId可以理解为问题编号
     * @param text 问题答案
     * @param silenced
     * @return
     * @throws IOException
     * 封装请求体 {@link com.hukki.chatbot.assistant.domain.zsxq.model.req.AnswerReq}
     * 封装返回体 {@link com.hukki.chatbot.assistant.domain.zsxq.model.res.AnswerRes}
     */
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
