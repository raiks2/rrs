package ru.vtb.rrs.driving.port;

import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * An interface to a final destination of a routed message (Postgres-based one, aka "System B")
 */
@ArchitecturalElement(
        type = ArchitecturalElement.Type.PORT,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public interface SendMessageToPostgresBasedDestinationPort {
    void invoke(String message);
}
