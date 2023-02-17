package com.hukki.chatbot.assistant.interfaces.test;

import com.alibaba.fastjson.JSON;
import com.hukki.chatbot.assistant.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.hukki.chatbot.assistant.domain.zsxq.model.vo.Group;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author YC02289 wanghui
 * @description: api测试类
 * @email xx@xx.com
 * @date 2023/2/14 10:37
 */
public class ApiTest {

    @Test
    public void json(){
//        Group group = new Group();
//        group.setGroup_id(1111);
//        group.setName("test");
//
//        String str = JSON.toJSONString(group);
//        System.out.println(str);
//
//        Group group1 = JSON.parseObject(str,Group.class);
//        System.out.println(group1.toString());

        String jsonStr = "{\"succeeded\":true,\"resp_data\":{\"topics\":[{\"topic_id\":814821252452452,\"group\":{\"group_id\":48884842444448,\"name\":\"\\u7801\\u519c\\u9c7c\\u5858\",\"type\":\"pay\"},\"type\":\"q&a\",\"question\":{\"owner\":{\"user_id\":844122118844242,\"name\":\"\\ue419\\u68a8\\u5b50\\u674e\\u5b50\\u6817\\u5b50\",\"avatar_url\":\"https:\\/\\/images.zsxq.com\\/FhUFUCBTC78AjzQD9I2Wg204fxfG?e=1680278399&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:hIR-LDp6sDUtFXLufulC4TKDT2M=\",\"location\":\"\\u6e56\\u5317\"},\"questionee\":{\"user_id\":414455411558148,\"name\":\"hukki-\\ud83c\\udfb8\",\"avatar_url\":\"https:\\/\\/images.zsxq.com\\/FnMGFZm7p_F-ioUZ1Da9pFWuYAC4?e=1680278399&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:wwDuC31ug6x_2-hKzAaj192-hEk=\",\"location\":\"\\u6e56\\u5317\"},\"text\":\"\\u697c\\u697c\\u4eca\\u665a\\u6709\\u5565\\u5b89\\u6392\\u5417\\uff1f\",\"expired\":false,\"anonymous\":false,\"owner_detail\":{\"questions_count\":2,\"join_time\":\"2023-02-15T13:57:47.224+0800\"},\"owner_location\":\"\\u6e56\\u5317\"},\"answered\":false,\"likes_count\":0,\"rewards_count\":0,\"comments_count\":0,\"reading_count\":1,\"readers_count\":2,\"digested\":false,\"sticky\":false,\"create_time\":\"2023-02-17T16:32:30.761+0800\",\"user_specific\":{\"liked\":false,\"subscribed\":false}}]}}";
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = JSON.parseObject(jsonStr, UnAnsweredQuestionsAggregates.class);
        System.out.println("ApiTest.json unAnsweredQuestionsAggregates");
    }

    @Test
    public void base64(){
        String cronExpression = new String(Base64.getDecoder().decode("MC81MCAqICogKiAqID8="), StandardCharsets.UTF_8);
        System.out.println(cronExpression);
        String str = "0/30 * * * * ?";
        String cronExpressionBase64 = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(cronExpressionBase64);
    }


    /**
     * 1.创建知识星球
     * 2.爬取等待我回答的接口信息
     * 测试查询待我回答的问题
     * @throws IOException
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //https://api.zsxq.com/v2/groups/48884842444448/topics?scope=unanswered_questions&count=20
        //zsxq_access_token=F7A63AFE-47E9-1BB8-A0EB-067DF34EB609_4342A9D74B7C9FE7; UM_distinctid=1863943ab39118-08c47fa1f6bb5e-26021051-1fa400-1863943ab3a1149; sensorsdata2015jssdkcross={"distinct_id":"414455411558148","first_id":"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89","props":{"$latest_traffic_source_type":"直接流量","$latest_search_keyword":"未取到值_直接打开","$latest_referrer":""},"identities":"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDQ0N2RlOTkxMWUtMDMwNTQ0N2EzNGFjYzYtMjYwMjExNTEtMjA3MzYwMC0xODUwNDQ3ZGU5YWI4OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNDQ1NTQxMTU1ODE0OCJ9","history_login_id":{"name":"$identity_login_id","value":"414455411558148"},"$device_id":"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89"}; abtest_env=product; zsxqsessionid=4df2d708c23d0191262a3e8abf9cb8df; __cuid=e47353f396c448aeaa9ce910472a39fb; amp_fef1e8=6c44c3aa-16f6-45fa-b36e-1ed7d5dbfbf3R...1gp9q3mds.1gp9q3me5.g.a.q
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/48884842444448/topics?scope=unanswered_questions&count=20");
        httpGet.addHeader("cookie", "zsxq_access_token=F7A63AFE-47E9-1BB8-A0EB-067DF34EB609_4342A9D74B7C9FE7; UM_distinctid=1863943ab39118-08c47fa1f6bb5e-26021051-1fa400-1863943ab3a1149; sensorsdata2015jssdkcross={\"distinct_id\":\"414455411558148\",\"first_id\":\"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDQ0N2RlOTkxMWUtMDMwNTQ0N2EzNGFjYzYtMjYwMjExNTEtMjA3MzYwMC0xODUwNDQ3ZGU5YWI4OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNDQ1NTQxMTU1ODE0OCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"414455411558148\"},\"$device_id\":\"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89\"}; abtest_env=product; zsxqsessionid=4df2d708c23d0191262a3e8abf9cb8df; __cuid=e47353f396c448aeaa9ce910472a39fb; amp_fef1e8=6c44c3aa-16f6-45fa-b36e-1ed7d5dbfbf3R...1gp9q3mds.1gp9q3me5.g.a.q");
        httpGet.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(httpGet);
        int retCode = response.getStatusLine().getStatusCode();
        if (retCode == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(retCode);
        }
    }

    /**
     * 爬取回答问题接口
     */
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //https://api.zsxq.com/v2/topics/214824184441451/answer
        //zsxq_access_token=F7A63AFE-47E9-1BB8-A0EB-067DF34EB609_4342A9D74B7C9FE7; UM_distinctid=1863943ab39118-08c47fa1f6bb5e-26021051-1fa400-1863943ab3a1149; sensorsdata2015jssdkcross={"distinct_id":"414455411558148","first_id":"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89","props":{"$latest_traffic_source_type":"直接流量","$latest_search_keyword":"未取到值_直接打开","$latest_referrer":""},"identities":"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDQ0N2RlOTkxMWUtMDMwNTQ0N2EzNGFjYzYtMjYwMjExNTEtMjA3MzYwMC0xODUwNDQ3ZGU5YWI4OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNDQ1NTQxMTU1ODE0OCJ9","history_login_id":{"name":"$identity_login_id","value":"414455411558148"},"$device_id":"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89"}; abtest_env=product; zsxqsessionid=4df2d708c23d0191262a3e8abf9cb8df; __cuid=e47353f396c448aeaa9ce910472a39fb; amp_fef1e8=6c44c3aa-16f6-45fa-b36e-1ed7d5dbfbf3R...1gp9q3mds.1gp9q3me5.g.a.q
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
        post.addHeader("cookie", "知识星球个人cookie信息");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        int retCode = response.getStatusLine().getStatusCode();
        if (retCode == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(retCode);
        }
    }


    /**
     * 使用chatgpt回答问题
     * @throws IOException
     */
    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 自行申请 https://beta.openai.com/overview");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
