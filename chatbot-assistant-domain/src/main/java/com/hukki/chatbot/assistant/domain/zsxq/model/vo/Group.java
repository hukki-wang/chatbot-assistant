package com.hukki.chatbot.assistant.domain.zsxq.model.vo;

/**
 * @author YC02289 wanghui
 * @description: some desc
 * @email xx@xx.com
 * @date 2023/2/15 10:52
 */
public class Group {
    private int group_id;

    private String name;

    private String type;

    public void setGroup_id(int group_id){
        this.group_id = group_id;
    }
    public int getGroup_id(){
        return this.group_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
