package org.whatever.littleThings.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class LittleItemGroups {

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addBefore(Items.BEETROOT_SEEDS, LittleItems.CARROT_SEEDS, LittleItems.POTATO_SEEDS);
			entries.addBefore(Items.WHEAT_SEEDS, LittleItems.MYSTERY_SEEDS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
			entries.addAfter(Items.TURTLE_HELMET, LittleItems.GARDEN_GOGGLES)
		);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->
			entries.addAfter(Items.PUMPKIN_PIE,
				LittleItems.VEGETABLE_STEW,
				LittleItems.GOURD_SOUP,
				LittleItems.MEATY_SOUP,
				LittleItems.HEARTY_STEW,
				LittleItems.MEATBALLS,
				LittleItems.SURF_N_TURF_STEW,
				LittleItems.STUFFED_MEAT,
				LittleItems.PIEROGIS,
				LittleItems.GLAZED_MEAT,
				LittleItems.RATATOUILLE,
				LittleItems.GELATIN,
				LittleItems.DELUXE_BERRY_PIE,
				LittleItems.CUSTARD,
				LittleItems.PANINI,
				LittleItems.JAM_TOAST,
				LittleItems.GLOW_JAM_TOAST,
				LittleItems.GLAZED_APPLE
			)
		);
	}

}
