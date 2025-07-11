package org.whatever.littleThings.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import org.whatever.littleThings.LittleThings;

public class LittleTags {

	public static final TagKey<Block> MYSTERY_CROP = of("mystery_crop", RegistryKeys.BLOCK);

	public static <T> TagKey<T> of(String name, RegistryKey<Registry<T>> registry) {
		return TagKey.of(registry, LittleThings.of(name));
	}

}
