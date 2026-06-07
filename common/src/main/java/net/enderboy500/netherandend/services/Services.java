package net.enderboy500.netherandend.services;

import net.enderboy500.netherandend.services.type.IPlatformHelper;
import net.enderboy500.netherandend.services.type.RegistryHelperService;

import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final RegistryHelperService REGISTRY = load(RegistryHelperService.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        return loadedService;
    }
}