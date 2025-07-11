package org.whatever.littleThings;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.whatever.littleThings.registry.LittleItems;

public class LittleThings implements ModInitializer {

	public static final String MOD_ID = "little_things";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String name) {
		return Identifier.of(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		LittleItems.init();
	}

}
