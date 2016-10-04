package io.maltronic.checkout;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.maltronic.checkout.resources.AppHealthCheck;
import io.maltronic.checkout.resources.BasketResource;
import org.slf4j.LoggerFactory;

public class CheckoutApplication extends Application<CheckoutApplicationConfiguration> {
    private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        new CheckoutApplication().run(args);
    }

    @Override
    public String getName() {
        return "Shop Checkout";
    }

    @Override
    public void initialize(Bootstrap<CheckoutApplicationConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    public void run(CheckoutApplicationConfiguration checkoutApplicationConfiguration, Environment environment) throws Exception {
        logger.info("Method App#run() called");
        System.out.println("Run Instance called");

        environment.jersey().register(new BasketResource());
        environment.healthChecks().register("checkout-app", new AppHealthCheck());
    }
}
