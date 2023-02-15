package com.hukki.chatbot.assistant.domain.zsxq.model.req;

/**
 * @author YC02289 wanghui
 * @description: 请求对象
 * @email xx@xx.com
 * @date 2023/2/15 16:11
 */
public class ReqData {

    private String text;
    private String[] image_ids = new String[]{};
    //是否全部可见
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }

}
