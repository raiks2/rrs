package ru.vtb.rrs.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ArchitecturalElement {
    Layer layer();
    Type type();
    Variety variety() default Variety.GENERIC;
    String description() default "";

    enum Type {
        GENERIC, PORT, ADAPTER, USE_CASE, SERVICE;
    }

    enum Layer {
        FRAMEWORK_INFRASTRUCTURE, INFRASTRUCTURE, APPLICATION, DOMAIN;
    }

    enum Variety {
        GENERIC,

        // Time-triggered
        SCHEDULED_JOB,

        // REST
        REST_ENDPOINT,
        REST_CLIENT,

        // SOAP
        SOAP_ENDPOINT,
        SOAP_CLIENT,

        // Persistence
        DAO,
        REPOSITORY,

        // Queue
        MESSAGE_LISTENER,
        MESSAGE_SENDER,

        EXTERNAL_SYSTEM_GATEWAY
    }
}
