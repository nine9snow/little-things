playsound little_things:block.toolbox.swap block @a[distance=..16]
data modify storage little_things:temp root.reduce set value false
execute on vehicle run function little_things:block/toolbox/items/interact/reset_slot with entity @s data