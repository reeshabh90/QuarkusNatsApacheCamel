package org.acme;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CamelNatsRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        System.out.println("Hello World");
        from("nats:world?servers=localhost:4222")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String processedMsg = exchange.getIn().getBody(String.class);

                        processedMsg = processedMsg + "- Reeshabh";
                        exchange.getMessage().setBody(processedMsg);
                    }
                })
                .log("Received : \"${body}\"")
                .to("seda:end");
    }
}
