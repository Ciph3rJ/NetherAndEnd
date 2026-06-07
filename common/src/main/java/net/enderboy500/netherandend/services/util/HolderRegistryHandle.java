package net.enderboy500.netherandend.services.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public interface HolderRegistryHandle<T> extends Supplier<Holder<T>> {
    Identifier id();
}
