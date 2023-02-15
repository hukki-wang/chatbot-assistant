package com.hukki.chatbot.assistant.domain.zsxq.model.res;
import com.hukki.chatbot.assistant.domain.zsxq.model.vo.Topics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC02289 wanghui
 * @description: some desc
 * @email xx@xx.com
 * @date 2023/2/15 10:52
 */
public class RespData {
    private List<Topics> topics;

    public void setTopics(List<Topics> topics){
        this.topics = topics;
    }
    public List<Topics> getTopics(){
        return this.topics;
    }
}