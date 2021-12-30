package ru.vtb.rrs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vtb.rrs.core.application.usecase.RouteMessageUseCase;
import ru.vtb.rrs.driven.adapter.RestEndpoint;
import ru.vtb.rrs.driven.adapter.SoapEndpoint;
import ru.vtb.rrs.driving.adapter.FindAccountToMdmCodeMappingRedisRepository;
import ru.vtb.rrs.driving.adapter.FindRoutingRulesPostgresRepository;
import ru.vtb.rrs.driving.adapter.SendMessageToOracleBasedDestinationGateway;
import ru.vtb.rrs.driving.adapter.SendMessageToPostgresBasedDestinationGateway;
import ru.vtb.rrs.driving.port.FindAccountToMdmCodeMappingPort;
import ru.vtb.rrs.driving.port.FindRoutingRulesPort;
import ru.vtb.rrs.driving.port.SendMessageToOracleBasedDestinationPort;
import ru.vtb.rrs.driving.port.SendMessageToPostgresBasedDestinationPort;

/**
 * Declare all your dependencies here whenever possible. Storing configuration
 * in a separate source file allows for a nice decoupling from the framework (compared
 * to pollution sources files with annotations)
 */
@Configuration
public class RoutingServiceAppConfiguration {
    @Bean
    public RestEndpoint restEndpoint() {
        return new RestEndpoint(routeMessageUseCase());
    }

    @Bean
    public SoapEndpoint soapEndpoint() {
        return new SoapEndpoint(routeMessageUseCase());
    }

    @Bean
    public FindAccountToMdmCodeMappingPort findAccountToMdmCodeMappingRedisRepository() {
        return new FindAccountToMdmCodeMappingRedisRepository();
    }

    @Bean
    public FindRoutingRulesPort findRoutingRulesPostgresRepository() {
        return new FindRoutingRulesPostgresRepository();
    }

    @Bean
    public SendMessageToOracleBasedDestinationPort sendMessageToOracleBasedDestinationGateway() {
        return new SendMessageToOracleBasedDestinationGateway();
    }

    @Bean
    public SendMessageToPostgresBasedDestinationPort sendMessageToPostgresBasedDestinationGateway() {
        return new SendMessageToPostgresBasedDestinationGateway();
    }   

    @Bean
    public RouteMessageUseCase routeMessageUseCase() {
        return new RouteMessageUseCase(
            findAccountToMdmCodeMappingRedisRepository(),
            findRoutingRulesPostgresRepository(),
            sendMessageToOracleBasedDestinationGateway(),
            sendMessageToPostgresBasedDestinationGateway()
        );
    }
}
