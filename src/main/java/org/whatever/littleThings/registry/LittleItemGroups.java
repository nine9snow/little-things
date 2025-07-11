package org.whatever.littleThings.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class LittleItemGroups {

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
			entries.addAfter(Items.TURTLE_HELMET, LittleItems.GARDEN_GOGGLES)
		);
	}

}
