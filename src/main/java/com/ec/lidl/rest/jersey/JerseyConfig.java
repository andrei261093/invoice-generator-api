package com.ec.lidl.rest.jersey;

import com.ec.lidl.rest.impl.DocumentCtrl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(DocumentCtrl.class);
    }
}