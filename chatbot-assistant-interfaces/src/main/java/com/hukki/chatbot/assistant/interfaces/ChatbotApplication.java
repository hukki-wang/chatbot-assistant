package com.hukki.chatbot.assistant.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YC02289 wanghui
 * @description: chatbot自动回答助手启动类
 * @email xx@xx.com
 * @date 2023/2/14 10:33
 * @apiNote spirngboot默认扫描启动类所在的包也就是com.hukki.chatbot.assistant.interfaces,
 * 所以包名最好指定com.hukki.chatbot.assistant,同时其他子module前缀包名需要一致
 */
@SpringBootApplication(scanBasePackages = "com.hukki.chatbot.assistant")
public class ChatbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class,args);
    }
}
