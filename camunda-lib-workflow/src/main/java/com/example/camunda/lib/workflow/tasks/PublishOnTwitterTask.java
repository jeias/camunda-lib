package com.example.camunda.lib.workflow.tasks;

import com.example.camunda.lib.workflow.enums.WorkflowVariableKey;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Component
public class PublishOnTwitterTask implements JavaDelegate {

    @Value("${twitter.access.token}")
    private String accessToken;
    @Value("${twitter.access.token.secret}")
    private String accessTokenSecret;
    @Value("${twitter.consumer.key}")
    private String consumerKey;
    @Value("${twitter.consumer.secret}")
    private String consumerSecret;

    private final Logger logger = LoggerFactory.getLogger(PublishOnTwitterTask.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            String content = (String) execution.getVariable(WorkflowVariableKey.CONTENT.name());

            AccessToken token = new AccessToken(accessToken, accessTokenSecret);
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(consumerKey, consumerSecret);
            twitter.setOAuthAccessToken(token);

            twitter.updateStatus(content);
        } catch (TwitterException e) {
            logger.error("Error : ", e);
            throw e;
        }
    }
}
