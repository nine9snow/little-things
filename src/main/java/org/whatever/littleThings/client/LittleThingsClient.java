package org.whatever.littleThings.client;

import net.fabricmc.api.ClientModInitializer;
import org.whatever.littleThings.registry.LittleBlocks;

public class LittleThingsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		LittleBlocks.clientInit();
	}

}
