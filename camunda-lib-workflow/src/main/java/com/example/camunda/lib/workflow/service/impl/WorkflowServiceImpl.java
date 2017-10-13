package com.example.camunda.lib.workflow.service.impl;

import com.example.camunda.lib.workflow.service.WorkflowService;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    private RuntimeService runtimeService;

    @Autowired
    public WorkflowServiceImpl(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void start(String processDefinitionKey, String businessKey, Map<String, Object> variables) {
        runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    }
}
