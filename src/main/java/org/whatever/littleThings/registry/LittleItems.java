package org.whatever.littleThings.registry;

import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.whatever.littleThings.LittleThings;
import org.whatever.littleThings.content.item.GardenGogglesItem;

import java.util.function.Function;

public class LittleItems {

	public static void init() {}

	public static final Item GARDEN_GOGGLES = register("garden_goggles", GardenGogglesItem::new,
		new Item.Settings()
			.maxCount(1)
	);

	public static final Item MYSTERY_SEEDS = register("mystery_seeds",
		settings -> new AliasedBlockItem(LittleBlocks.MYSTERY_CROP, settings),
		new Item.Settings()
	);
	public static final Item POTATO_SEEDS = register("potato_seeds",
		settings -> new AliasedBlockItem(Blocks.POTATOES, settings),
		new Item.Settings()
	);
	public static final Item CARROT_SEEDS = register("carrot_seeds",
		settings -> new AliasedBlockItem(Blocks.CARROTS, settings),
		new Item.Settings()
	);

	public static Item register(String name) {
		return register(name, Item::new);
	}

	public static Item register(String name, Function<Item.Settings, Item> function) {
		return register(name, function, new Item.Settings());
	}

	public static Item register(String name, Item.Settings settings) {
		return register(name, Item::new, settings);
	}

	public static Item register(String name, Function<Item.Settings, Item> function, Item.Settings settings) {
		Identifier id = LittleThings.of(name);
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
		Item item = function.apply(settings);
		return Registry.register(Registries.ITEM, key, item);
	}

}
