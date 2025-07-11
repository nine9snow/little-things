package org.whatever.littleThings.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.whatever.littleThings.content.item.NotBlockItem;

@Mixin(Items.class)
public class ItemsMixin {

	@Redirect(
		method = "<clinit>",
		at = @At(
			value="NEW",
			target = "net/minecraft/item/AliasedBlockItem"
		),
		slice = @Slice(
			from = @At(
				value = "FIELD",
				target = "Lnet/minecraft/item/Items;FLOWER_POT:Lnet/minecraft/item/Item;",
				opcode = Opcodes.PUTSTATIC
			),
			to = @At(
				value = "FIELD",
				target = "Lnet/minecraft/item/Items;BAKED_POTATO:Lnet/minecraft/item/Item;",
				opcode = Opcodes.PUTSTATIC
			)
		)
	)
	private static AliasedBlockItem reregisterPotatoAndCarrot(Block block, Item.Settings settings) {
		return new NotBlockItem(settings);
	}

}
