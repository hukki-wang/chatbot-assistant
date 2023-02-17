package com.hukki.chatbot.assistant.application.ext;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author YC02289 wanghui
 * @description: 任务注册服务，支持多组任务配置
 * 采用配置的方式运行多组任务
 * @email xx@xx.com
 * @date 2023/2/17 14:42
 */
public class TaskRegistrarAutoConfig implements EnvironmentAware, SchedulingConfigurer {


    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    }
}
