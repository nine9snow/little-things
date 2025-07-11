package org.whatever.littleThings.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.whatever.littleThings.registry.LittleItems;
import org.whatever.littleThings.registry.LittleTags;

public class MysteryCropBlock extends CropBlock {

	public static final MapCodec<BeetrootsBlock> CODEC = createCodec(BeetrootsBlock::new);

	public MapCodec<BeetrootsBlock> getCodec() {
		return CODEC;
	}

	public MysteryCropBlock(Settings settings) {
		super(settings);
	}

	public int getMaxAge() {
		return 1;
	}

	protected ItemConvertible getSeedsItem() {
		return LittleItems.MYSTERY_SEEDS;
	}

	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(3) == 0) return;

		if (world.getBaseLightLevel(pos, 0) < 9) return;

		float f = getAvailableMoisture(this, world, pos);
		if (random.nextInt((int)(25.0F / f) + 1) == 0) {
			RegistryEntryList<Block> possibleCrops = world.getRegistryManager()
				.getWrapperOrThrow(RegistryKeys.BLOCK)
				.getOrThrow(LittleTags.MYSTERY_CROP);
			BlockState newState = possibleCrops.getRandom(random).get().value().getDefaultState();
			world.setBlockState(pos, newState);
		}
	}

	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return Block.createCuboidShape(0, 0, 0, 16, 2, 16);
	}

}
