package ru.vtb.rrs.core.application.usecase;

import ru.vtb.rrs.driven.port.RouteMessagePort;
import ru.vtb.rrs.driving.port.FindAccountToMdmCodeMappingPort;
import ru.vtb.rrs.driving.port.FindRoutingRulesPort;
import ru.vtb.rrs.driving.port.SendMessageToOracleBasedDestinationPort;
import ru.vtb.rrs.driving.port.SendMessageToPostgresBasedDestinationPort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * The "brains" of the application. Here we execute the message routing and processing logic
 * The use case is, essentially, an orchestrator that coordinates the execution of the
 * domain and application-specific logic. In our case it receives input from driving adapters,
 * processes a message (if required), makes a routing decision and then sends the message to
 * its final destination
 */
@ArchitecturalElement(
        type = ArchitecturalElement.Type.USE_CASE,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public class RouteMessageUseCase implements RouteMessagePort {
    private final FindAccountToMdmCodeMappingPort findAccountToMdmCodeMappingRedisRepository;
    private final FindRoutingRulesPort findRoutingRulesPostgresRepository;
    private final SendMessageToOracleBasedDestinationPort sendMessageToOracleBasedDestinationRepository;
    private final SendMessageToPostgresBasedDestinationPort sendMessageToPostgresBasedDestinationRepository;

    public RouteMessageUseCase(
        FindAccountToMdmCodeMappingPort findAccountToMdmCodeMappingRedisRepository,
        FindRoutingRulesPort findRoutingRulesPostgresRepository,
        SendMessageToOracleBasedDestinationPort sendMessageToOracleBasedDestinationRepository,
        SendMessageToPostgresBasedDestinationPort sendMessageToPostgresBasedDestinationRepository
    ) {
        this.findAccountToMdmCodeMappingRedisRepository = findAccountToMdmCodeMappingRedisRepository;
        this.findRoutingRulesPostgresRepository = findRoutingRulesPostgresRepository;
        this.sendMessageToOracleBasedDestinationRepository = sendMessageToOracleBasedDestinationRepository;
        this.sendMessageToPostgresBasedDestinationRepository = sendMessageToPostgresBasedDestinationRepository;
    }

    @Override
    public void invoke(String header, String message) {
        String accountId = extractAccountIdFromHeader(header);
        String mdmCode = findAccountToMdmCodeMappingRedisRepository.invoke(accountId);
        String routingRules = findRoutingRulesPostgresRepository.invoke(mdmCode);
        String destination = determineDestination(routingRules);
        if ("A".equals(destination)) {
            sendMessageToOracleBasedDestinationRepository.invoke(message);
        } else {
            sendMessageToPostgresBasedDestinationRepository.invoke(message);
        }
    }

    private String extractAccountIdFromHeader(String header) {
        // Replace with meaningful implementation
        return header;
    }

    private String determineDestination(String routingRules) {
        return "A";
    }
}
