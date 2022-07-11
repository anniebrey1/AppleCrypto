package com.apple.crypto;

import com.apple.crypto.controller.APIController;
import com.apple.crypto.health.TemplateHealthCheck;
import com.apple.crypto.model.HelloWorldConfiguration;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class nameApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new nameApplication().run(args);
    }

    @Override
    public String getName() {
        return "crypto";
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final APIController resource = new APIController(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("crypto", healthCheck);
        environment.jersey().register(resource);

    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

    }
}
