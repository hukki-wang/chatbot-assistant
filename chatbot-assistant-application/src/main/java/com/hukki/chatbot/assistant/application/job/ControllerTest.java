package com.hukki.chatbot.assistant.application.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghui
 * @date 2023/2/15 11:24 下午
 * @des
 */
@RestController
@RequestMapping("test")
public class ControllerTest {

    private Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @GetMapping(value = "/hello")
    public String test(){
        logger.info("hello test");
        return "hello test";
    }
}
