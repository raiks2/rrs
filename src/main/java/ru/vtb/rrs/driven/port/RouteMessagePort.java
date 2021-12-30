package ru.vtb.rrs.driven.port;

import ru.vtb.rrs.metadata.ArchitecturalElement;

@ArchitecturalElement(
        type = ArchitecturalElement.Type.PORT,
        layer = ArchitecturalElement.Layer.APPLICATION
)
public interface RouteMessagePort {
    public void invoke(String header, String message);
}
