package ru.vtb.rrs.driving.adapter;

import ru.vtb.rrs.driving.port.SendMessageToOracleBasedDestinationPort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

@ArchitecturalElement(
        type = ArchitecturalElement.Type.ADAPTER,
        variety = ArchitecturalElement.Variety.EXTERNAL_SYSTEM_GATEWAY,
        layer = ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class SendMessageToOracleBasedDestinationGateway implements SendMessageToOracleBasedDestinationPort {
    @Override
    public void invoke(String message) {

    }
}
