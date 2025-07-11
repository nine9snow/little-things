package org.whatever.littleThings.content;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringIdentifiable;

public enum CropEffectType implements StringIdentifiable {

	COMPOST("compost"),
	GROWTH("growth"),
	FERTILE("FERTILE");

	public static final Codec<CropEffectType> CODEC = StringIdentifiable.createCodec(CropEffectType::values);

	private final String name;

	CropEffectType(String name) {
		this.name = name;
	}

	@Override
	public String asString() {
		return this.name;
	}

}
