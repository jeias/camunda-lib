package com.example.camunda.lib.workflow.service;

import java.util.Map;

public interface WorkflowService {
    void start(String processDefinitionKey, String businessKey, Map<String, Object> variables);
}
