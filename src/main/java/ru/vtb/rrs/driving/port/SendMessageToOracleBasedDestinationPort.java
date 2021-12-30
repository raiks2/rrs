package ru.vtb.rrs.driving.port;

import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * An interface to a final destination of a routed message (Oracle-based one, aka "System A")
 */
@ArchitecturalElement(
        type = ArchitecturalElement.Type.PORT,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public interface SendMessageToOracleBasedDestinationPort {
    void invoke(String message);
}
