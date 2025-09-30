playsound little_things:block.toolbox.swap block @a[distance=..16]
data modify storage little_things:temp root.reduce set value true
execute on vehicle unless data entity @s item.components."minecraft:custom_data".little_things{id: "invalid"} run data modify storage little_things:temp root.swap set from entity @s item
execute on vehicle run data modify entity @s item set from storage little_things:temp root.item