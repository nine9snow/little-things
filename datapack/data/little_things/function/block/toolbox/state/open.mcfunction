playsound little_things:block.toolbox.open block @a[distance=..16]
tag @s add little_things.open

execute on vehicle run data modify entity @s item.components."minecraft:custom_model_data".strings set value ["opened"]

data remove storage little_things:temp root
data modify storage little_things:temp root.uuid set from entity @s UUID
data modify storage little_things:temp root.items set from entity @s data.items
function little_things:block/toolbox/items/data