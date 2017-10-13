package com.example.camunda.lib.workflow.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TestTask implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTask.class);
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.error(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println("----------------------- TEST ----------------------------");
        throw new RuntimeException("teste");
    }
}
