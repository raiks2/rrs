package ru.vtb.rrs.driving.adapter;

import ru.vtb.rrs.driving.port.FindAccountToMdmCodeMappingPort;
import ru.vtb.rrs.metadata.ArchitecturalElement;

@ArchitecturalElement(
        type = ArchitecturalElement.Type.ADAPTER,
        variety = ArchitecturalElement.Variety.REPOSITORY,
        layer = ArchitecturalElement.Layer.INFRASTRUCTURE
)
public class FindAccountToMdmCodeMappingRedisRepository implements FindAccountToMdmCodeMappingPort {
    @Override
    public String invoke(String accountId) {
        // Replace with something meaningful
        return accountId;
    }
}
