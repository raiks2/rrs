package ru.vtb.rrs.driving.port;

import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * An interface to a storage containing rules used for message routing
 */
@ArchitecturalElement(
        type = ArchitecturalElement.Type.PORT,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public interface FindRoutingRulesPort {
    public String invoke(String mdmCode);
}
