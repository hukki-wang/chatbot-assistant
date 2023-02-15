package com.hukki.chatbot.assistant.interfaces.test;

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

/**
 * @author YC02289 wanghui
 * @description: api测试类
 * @email xx@xx.com
 * @date 2023/2/14 10:37
 */
public class ApiTest {

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
