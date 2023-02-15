package com.hukki.chatbot.assistant.domain.zsxq.model.aggregates;


import com.hukki.chatbot.assistant.domain.zsxq.model.res.RespData;

/**
 * @author YC02289 wanghui
 * @description: 待回答问题聚合
 * @email xx@xx.com
 * @date 2023/2/15 10:52
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;

    private RespData resp_data;

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
    public void setResp_data(RespData resp_data){
        this.resp_data = resp_data;
    }
    public RespData getResp_data(){
        return this.resp_data;
    }
}