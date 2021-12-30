package ru.vtb.rrs.driven.adapter;

import org.springframework.web.bind.annotation.RequestBody;
import ru.vtb.rrs.driven.port.RouteMessagePort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * The endpoint responsible for receiving messages via REST. There can be multiple endpoints
 * per message type, or, more likely just one for every external system (since we merely
 * relay messages a use case without deserializing them
 */
@ArchitecturalElement(
        type = ru.vtb.rrs.metadata.ArchitecturalElement.Type.ADAPTER,
        variety = ru.vtb.rrs.metadata.ArchitecturalElement.Variety.REST_ENDPOINT,
        layer = ru.vtb.rrs.metadata.ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class RestEndpoint {
    private final RouteMessagePort routeMessageUseCase;

    public RestEndpoint(RouteMessagePort routeMessageUseCase) {
        this.routeMessageUseCase = routeMessageUseCase;
    }

    private String extractHeader(String message) {
        // Replace with meaningful implementation
        return message.substring(0, message.length() - 2);
    }

    public void invoke(@RequestBody String message) {
        String header = extractHeader(message);
        routeMessageUseCase.invoke(header, message);
    }
}
