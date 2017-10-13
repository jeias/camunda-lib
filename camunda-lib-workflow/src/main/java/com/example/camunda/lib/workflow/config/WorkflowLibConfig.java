package com.example.camunda.lib.workflow.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.example.camunda.lib.workflow", "org.camunda.bpm"})
@PropertySource("classpath:workflow.properties")
public class WorkflowLibConfig {
}
