package org.whatever.littleThings.registry;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import org.solstice.euclidsElements.tag.api.MapTagKey;
import org.whatever.littleThings.LittleThings;
import org.whatever.littleThings.content.CropEffectType;

import java.util.List;

public class LittleTags {

	public static final TagKey<Block> SOIL = of("soil", RegistryKeys.BLOCK);
	public static final TagKey<Block> MYSTERY_SEEDS_TRANSFORM_INTO = of("mystery_seeds_transform_into", RegistryKeys.BLOCK);

	public static final MapTagKey<Block, List<CropEffectType>> CROP_COMPANION_EFFECTS = ofMap("crop_companion_effects",
		RegistryKeys.BLOCK,
		CropEffectType.CODEC.listOf()
	);

	public static <T> TagKey<T> of(String name, RegistryKey<Registry<T>> registry) {
		return TagKey.of(registry, LittleThings.of(name));
	}

	public static <T, R> MapTagKey<T, R> ofMap(String name, RegistryKey<Registry<T>> registry, Codec<R> codec) {
		return MapTagKey.of(registry, codec, LittleThings.of(name));
	}

}
