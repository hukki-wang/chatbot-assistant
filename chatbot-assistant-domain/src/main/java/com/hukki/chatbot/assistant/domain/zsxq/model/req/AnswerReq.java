package com.hukki.chatbot.assistant.domain.zsxq.model.req;

/**
 * @author YC02289 wanghui
 * @description: 问题请求对象
 * @email xx@xx.com
 * @date 2023/2/15 16:05
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
