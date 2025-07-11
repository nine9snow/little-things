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

	public static final Item VEGETABLE_STEW = register("vegetable_stew", Item::new, new Item.Settings()
		.food(LittleFoodComponents.VEGETABLE_STEW)
	);
	public static final Item GOURD_SOUP = register("gourd_soup", Item::new, new Item.Settings()
		.food(LittleFoodComponents.GOURD_SOUP)
	);
	public static final Item MEATY_SOUP = register("meaty_soup", Item::new, new Item.Settings()
		.food(LittleFoodComponents.MEATY_SOUP)
	);
	public static final Item HEARTY_STEW = register("hearty_stew", Item::new, new Item.Settings()
		.food(LittleFoodComponents.HEARTY_STEW)
	);
	public static final Item MEATBALLS = register("meatballs", Item::new, new Item.Settings()
		.food(LittleFoodComponents.MEATBALLS)
	);
	public static final Item SURF_N_TURF_STEW = register("surf_n_turf_stew", Item::new, new Item.Settings()
		.food(LittleFoodComponents.SURF_N_TURF_STEW)
	);
	public static final Item STUFFED_MEAT = register("stuffed_meat", Item::new, new Item.Settings()
		.food(LittleFoodComponents.STUFFED_MEAT)
	);
	public static final Item PIEROGIS = register("pierogis", Item::new, new Item.Settings()
		.food(LittleFoodComponents.PIEROGIS)
	);
	public static final Item GLAZED_MEAT = register("glazed_meat", Item::new, new Item.Settings()
		.food(LittleFoodComponents.GLAZED_MEAT)
	);
	public static final Item RATATOUILLE = register("ratatouille", Item::new, new Item.Settings()
		.food(LittleFoodComponents.RATATOUILLE)
	);
	public static final Item GELATIN = register("gelatin", Item::new, new Item.Settings()
		.food(LittleFoodComponents.GELATIN)
	);
	public static final Item DELUXE_BERRY_PIE = register("deluxe_berry_pie", Item::new, new Item.Settings()
		.food(LittleFoodComponents.DELUXE_BERRY_PIE)
	);
	public static final Item CUSTARD = register("custard", Item::new, new Item.Settings()
		.food(LittleFoodComponents.CUSTARD)
	);
	public static final Item PANINI = register("panini", Item::new, new Item.Settings()
		.food(LittleFoodComponents.PANINI)
	);
	public static final Item JAM_TOAST = register("jam_toast", Item::new, new Item.Settings()
		.food(LittleFoodComponents.JAM_TOAST)
	);
	public static final Item GLOW_JAM_TOAST = register("glow_jam_toast", Item::new, new Item.Settings()
		.food(LittleFoodComponents.GLOW_JAM_TOAST)
	);
	public static final Item GLAZED_APPLE = register("glazed_apple", Item::new, new Item.Settings()
		.food(LittleFoodComponents.GLAZED_APPLE)
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
