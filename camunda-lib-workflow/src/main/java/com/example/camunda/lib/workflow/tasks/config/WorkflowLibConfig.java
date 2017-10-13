package com.example.camunda.lib.workflow.tasks.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.camunda.lib.workflow", "org.camunda.bpm"})
public class WorkflowLibConfig {
}
