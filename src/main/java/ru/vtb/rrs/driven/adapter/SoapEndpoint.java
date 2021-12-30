package ru.vtb.rrs.driven.adapter;

import ru.vtb.rrs.driven.port.RouteMessagePort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * The endpoint responsible for receiving messages via SOAP. There can be multiple endpoints
 * per message type, or, more likely just one for every external system (since we merely
 * relay messages a use case without deserializing them
 */
@ArchitecturalElement(
        type = ru.vtb.rrs.metadata.ArchitecturalElement.Type.ADAPTER,
        variety = ru.vtb.rrs.metadata.ArchitecturalElement.Variety.SOAP_ENDPOINT,
        layer = ru.vtb.rrs.metadata.ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class SoapEndpoint {
    private final RouteMessagePort routeMessagePort;

    public SoapEndpoint(RouteMessagePort routeMessagePort) {
        this.routeMessagePort = routeMessagePort;
    }
}
