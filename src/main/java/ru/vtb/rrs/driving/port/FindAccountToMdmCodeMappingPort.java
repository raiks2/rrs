package ru.vtb.rrs.driving.port;

import ru.vtb.rrs.metadata.ArchitecturalElement;

/**
 * An interface to a storage containing a mapping between an accountId and mdmCode
 */
@ArchitecturalElement(
        type = ArchitecturalElement.Type.PORT,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public interface FindAccountToMdmCodeMappingPort {
    public String invoke(String accountId);
}
