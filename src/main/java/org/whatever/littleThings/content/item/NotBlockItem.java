package org.whatever.littleThings.content.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class NotBlockItem extends AliasedBlockItem {

	public NotBlockItem(Settings settings) {
		super(Blocks.AIR, settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		return ActionResult.PASS;
	}

}
