package org.whatever.littleThings.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import org.solstice.euclidsElements.autoDatagen.api.generator.AutoLanguageGenerator;
import org.solstice.euclidsElements.autoDatagen.api.generator.AutoModelGenerator;
import org.solstice.euclidsElements.autoDatagen.api.supplier.BlockModelSupplier;
import org.whatever.littleThings.content.block.MysterySeedsBlock;

import java.util.stream.IntStream;

public class LittleDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(AutoLanguageGenerator::new);
		pack.addProvider(AutoModelGenerator::new);

		BlockModelSupplier.register(CropBlock.class, LittleDataGenerator::registerCrop);
		BlockModelSupplier.register(MysterySeedsBlock.class, LittleDataGenerator::registerGenericCrop);
	}

	public static void registerGenericCrop(BlockStateModelGenerator generator, Block block, Identifier id) {
		Models.CROP.upload(block, TextureMap.crop(id.withPrefixedPath("block/")), generator.modelCollector);
		generator.registerSimpleState(block);
//		generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate());
		generator.registerItemModel(block.asItem());
	}

	public static void registerCrop(BlockStateModelGenerator generator, Block block, Identifier id) {
		if (block instanceof CropBlock cropBlock) generator.registerCrop(block,
			cropBlock.getAgeProperty(),
			IntStream.rangeClosed(1, cropBlock.getMaxAge()).toArray()
		);
		generator.registerParentedItemModel(block, id);
	}

}
