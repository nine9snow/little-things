package org.whatever.littleThings.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.whatever.littleThings.LittleThings;
import org.whatever.littleThings.content.block.MysteryCropBlock;
import org.whatever.littleThings.content.item.GardenGogglesItem;

import java.util.function.Function;

public class LittleBlocks {

	public static void init() {}

	public static final Block MYSTERY_CROP = register("mystery_crop",
		MysteryCropBlock::new,
		AbstractBlock.Settings.create()
			.mapColor(MapColor.DARK_GREEN)
			.noCollision()
			.ticksRandomly()
			.breakInstantly()
			.sounds(BlockSoundGroup.CROP)
			.pistonBehavior(PistonBehavior.DESTROY)
	);

	public static Block register(String name) {
		return register(name, Block::new, AbstractBlock.Settings.create());
	}

	public static Block register(String name, AbstractBlock.Settings settings) {
		return register(name, Block::new, settings);
	}

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings settings) {
		return register(name, function, settings, new Item.Settings());
	}

	public static Block register(String name, Function<AbstractBlock.Settings, Block> function, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
		Identifier id = LittleThings.of(name);
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
		Block block = function.apply(blockSettings);
		Registry.register(Registries.BLOCK, blockKey, block);
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
		Item item = new BlockItem(block, itemSettings);
		Registry.register(Registries.ITEM, itemKey, item);
		return block;
	}

}
