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
import net.minecraft.world.World;
import org.whatever.littleThings.registry.LittleItems;
import org.whatever.littleThings.registry.LittleTags;

public class MysterySeedsBlock extends CropBlock {

	public static final MapCodec<BeetrootsBlock> CODEC = createCodec(BeetrootsBlock::new);

	@Override
	public MapCodec<BeetrootsBlock> getCodec() {
		return CODEC;
	}

	public MysterySeedsBlock(Settings settings) {
		super(settings);
	}

	@Override
	public int getMaxAge() {
		return 1;
	}

	@Override
	protected ItemConvertible getSeedsItem() {
		return LittleItems.MYSTERY_SEEDS;
	}

	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(3) == 0) return;

		if (world.getBaseLightLevel(pos, 0) < 9) return;

		float moisture = getAvailableMoisture(this, world, pos);
		if (random.nextInt((int)(25.0F / moisture) + 1) != 0) return;

		mutate(world, pos, state, random);
	}

	@Override
	public void applyGrowth(World world, BlockPos pos, BlockState state) {
		mutate(world, pos, state, world.random);
	}

	public static void mutate(World world, BlockPos pos, BlockState state, Random random) {
		RegistryEntryList<Block> possibleCrops = world.getRegistryManager()
			.getWrapperOrThrow(RegistryKeys.BLOCK)
			.getOrThrow(LittleTags.MYSTERY_SEEDS_TRANSFORM_INTO);
		BlockState newState = possibleCrops.getRandom(random).orElseThrow().value().getDefaultState();
		world.setBlockState(pos, newState);
	}

	@Override
	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return Block.createCuboidShape(0, 0, 0, 16, 2, 16);
	}

}
