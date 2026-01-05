package com.example.Dynamic_Routes.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {

        String body = exchange.getIn().getBody(String.class);

        if (body != null && body.trim().startsWith("{")) {
        }
    }
}
