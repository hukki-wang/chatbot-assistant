package com.hukki.chatbot.assistant.interfaces.test;

import com.hukki.chatbot.assistant.domain.zsxq.IZsxqApi;
import com.hukki.chatbot.assistant.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author YC02289 wanghui
 * @description: springboot测试类
 * @email xx@xx.com
 * @date 2023/2/14 10:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRunTest {

    private static Logger logger = LoggerFactory.getLogger(SpringbootRunTest.class);

    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void test() throws IOException {
        String groupId = "48884842444448";
        String cookie = "zsxq_access_token=F7A63AFE-47E9-1BB8-A0EB-067DF34EB609_4342A9D74B7C9FE7; UM_distinctid=1863943ab39118-08c47fa1f6bb5e-26021051-1fa400-1863943ab3a1149; sensorsdata2015jssdkcross={\"distinct_id\":\"414455411558148\",\"first_id\":\"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDQ0N2RlOTkxMWUtMDMwNTQ0N2EzNGFjYzYtMjYwMjExNTEtMjA3MzYwMC0xODUwNDQ3ZGU5YWI4OSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNDQ1NTQxMTU1ODE0OCJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"414455411558148\"},\"$device_id\":\"1850447de9911e-0305447a34acc6-26021151-2073600-1850447de9ab89\"}; abtest_env=product; zsxqsessionid=4df2d708c23d0191262a3e8abf9cb8df; __cuid=e47353f396c448aeaa9ce910472a39fb; amp_fef1e8=6c44c3aa-16f6-45fa-b36e-1ed7d5dbfbf3R...1gp9q3mds.1gp9q3me5.g.a.q";
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId,cookie);
        logger.info("结果数据：{}",unAnsweredQuestionsAggregates);
    }


}
