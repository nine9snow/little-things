package org.whatever.littleThings.mixin;

import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
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

//	@ModifyArg(
//		method = "<clinit>",
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;"
//		),
//		slice = @Slice(
//			from = @At(
//				value = "CONSTANT",
//				args = "stringValue=glow_item_frame"
//			),
//			to = @At(
//				value = "FIELD",
//				target = "Lnet/minecraft/item/Items;CARROT:Lnet/minecraft/item/Item;",
//				opcode = Opcodes.PUTSTATIC
//			)
//		),
//		index = 1
//	)
//	private static Item reregisterCarrot(String id, Item item) {
//		return new Item(new Item.Settings().food(FoodComponents.CARROT));
//	}
//
//	@ModifyArg(
//		method = "<clinit>",
//		at = @At(
//			value = "INVOKE",
//			target = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;"
//		),
//		slice = @Slice(
//			from = @At(
//				value = "CONSTANT",
//				args = "stringValue=carrot"
//			),
//			to = @At(
//				value = "FIELD",
//				target = "Lnet/minecraft/item/Items;POTATO:Lnet/minecraft/item/Item;",
//				opcode = Opcodes.PUTSTATIC
//			)
//		),
//		index = 1
//	)
//	private static Item reregisterPotato(Item item) {
//		return new Item(new Item.Settings().food(FoodComponents.POTATO));
//	}

}
