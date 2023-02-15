package com.hukki.chatbot.assistant.domain.ai.service;

import com.alibaba.fastjson.JSON;
import com.hukki.chatbot.assistant.domain.ai.IOpenAI;
import com.hukki.chatbot.assistant.domain.ai.model.aggregates.AIAnswer;
import com.hukki.chatbot.assistant.domain.ai.model.vo.Choices;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author YC02289 wanghui
 * @description: chatgpt自动回答问题
 * @email xx@xx.com
 * @date 2023/2/15 16:38
 */
public class OpenAI implements IOpenAI {

    @Override
    public String doChatGpt(String question,String openAiKey) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAiKey);

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + question + "\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            List<Choices> choices = aiAnswer.getChoices();

            StringBuilder answer = new StringBuilder();
            for (Choices choice : choices){
                answer.append(choice.getText());
            }
            return answer.toString();
        } else {
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }
}
