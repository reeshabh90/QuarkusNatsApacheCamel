package org.acme;

import io.quarkus.runtime.QuarkusApplication;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelNatsReader implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new CamelNatsRoute());
        camelContext.start();
        return 0;
    }
}
