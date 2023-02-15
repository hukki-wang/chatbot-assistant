package com.hukki.chatbot.assistant.domain.zsxq.model.vo;


/**
 * @author YC02289 wanghui
 * @description: some desc
 * @email xx@xx.com
 * @date 2023/2/15 10:52
 */
public class Questionee {
    private int user_id;

    private String name;

    private String avatar_url;

    private String location;

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAvatar_url(String avatar_url){
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url(){
        return this.avatar_url;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }
}