package com.hukki.chatbot.assistant.domain.ai;

import java.io.IOException;

/**
 * @author YC02289 wanghui
 * @description: chatgpt自动回答问题
 * @email xx@xx.com
 * @date 2023/2/15 16:38
 */
public interface IOpenAI {


    /**
     * 对接chatgpt api回答问题
     * @param question 问题
     * @param openAiKey chatgpt账号秘钥
     * @return 答案
     * @throws IOException
     */
    String doChatGpt(String question,String openAiKey) throws IOException;
}
