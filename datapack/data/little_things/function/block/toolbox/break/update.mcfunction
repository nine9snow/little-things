execute if data entity @s data{state: "default"} run loot replace entity @s container.0 loot little_things:items/toolbox
execute if data entity @s data{state: "exposed"} run loot replace entity @s container.0 loot little_things:items/exposed_toolbox
execute if data entity @s data{state: "weathered"} run loot replace entity @s container.0 loot little_things:items/weathered_toolbox
execute if data entity @s data{state: "oxidized"} run loot replace entity @s container.0 loot little_things:items/oxidized_toolbox
execute if entity @s[tag=little_things.waxed] run function little_things:block/toolbox/break/waxed

data modify entity @s item.components."minecraft:custom_name" set from storage little_things:temp root.name
data modify entity @s item.components."minecraft:custom_data".little_things.items set from storage little_things:temp root.contents
execute store result storage little_things:temp root.count int 1 run execute store result score #count little_things.dummy run data get storage little_things:temp root.contents
data modify entity @s item.components."minecraft:lore"[2].with[0] set from storage little_things:temp root.count

data remove entity @s item.components."minecraft:lore"[3]
data remove entity @s item.components."minecraft:lore"[3]
data remove entity @s item.components."minecraft:lore"[3]
data remove entity @s item.components."minecraft:lore"[3]
data remove entity @s item.components."minecraft:lore"[3]
data remove entity @s item.components."minecraft:lore"[3]

data modify storage little_things:temp root.export set from entity @s item

execute if data storage little_things:temp root.contents[0] run function little_things:block/toolbox/break/lore/main {index: 0}
execute if data storage little_things:temp root.contents[1] run function little_things:block/toolbox/break/lore/main {index: 1}
execute if data storage little_things:temp root.contents[2] run function little_things:block/toolbox/break/lore/main {index: 2}
execute if data storage little_things:temp root.contents[3] run function little_things:block/toolbox/break/lore/main {index: 3}
execute if data storage little_things:temp root.contents[4] run function little_things:block/toolbox/break/lore/main {index: 4}
execute if data storage little_things:temp root.contents[5] run function little_things:block/toolbox/break/lore/main {index: 5}
data modify storage little_things:temp root.export.components."minecraft:custom_model_data".floats set value [0]
data modify storage little_things:temp root.export.components."minecraft:custom_model_data".floats[0] set from storage little_things:temp root.count

function little_things:block/toolbox/break/spawn with storage little_things:temp root

kill @s