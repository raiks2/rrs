package ru.vtb.rrs.driving.adapter;

import ru.vtb.rrs.driving.port.SendMessageToPostgresBasedDestinationPort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

@ArchitecturalElement(
        type = ArchitecturalElement.Type.ADAPTER,
        variety = ArchitecturalElement.Variety.EXTERNAL_SYSTEM_GATEWAY,
        layer = ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class SendMessageToPostgresBasedDestinationGateway implements SendMessageToPostgresBasedDestinationPort {
    @Override
    public void invoke(String message) {

    }
}
