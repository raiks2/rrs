package ru.vtb.rrs.driving.adapter;

import ru.vtb.rrs.driving.port.FindRoutingRulesPort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

@ArchitecturalElement(
        type = ArchitecturalElement.Type.ADAPTER,
        variety = ArchitecturalElement.Variety.REPOSITORY,
        layer = ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class FindRoutingRulesPostgresRepository implements FindRoutingRulesPort {
    @Override
    public String invoke(String mdmCode) {
        return null;
    }
}