package com.techsera.assignment.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;


public class IntegrationConfig {


    public ObjectToJsonTransformer objectToJsonTransformer() {
        return new ObjectToJsonTransformer(getMapper());
    }


    public static Jackson2JsonObjectMapper getMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(objectMapper);
    }


    public HeaderValueRouter headerValueRouter() {
        HeaderValueRouter headerValueRouter = new HeaderValueRouter("test");
        headerValueRouter.setChannelMapping("success", "router.channel.outOfStatus");
        headerValueRouter.setChannelMapping("fail", "router.channel.logInfo");
        return headerValueRouter;
    }

}
