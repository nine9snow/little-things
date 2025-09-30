data modify entity @s data.name set from storage little_things:temp root.macro.components."minecraft:custom_name"
data modify entity @s data.items set from storage little_things:temp root.macro.components."minecraft:custom_data".little_things.items

execute on vehicle if data storage little_things:temp root.macro.components."minecraft:custom_data".little_things{waxed: true} run tag @s add little_things.waxed
execute on vehicle run data modify entity @s data.state set from storage little_things:temp root.macro.components."minecraft:custom_data".little_things.state
execute if data storage little_things:temp root.macro.components."minecraft:custom_data".little_things{state: "exposed"} on vehicle run data modify entity @s item.components."minecraft:item_model" set value "little_things:block/exposed_toolbox"
execute if data storage little_things:temp root.macro.components."minecraft:custom_data".little_things{state: "weathered"} on vehicle run data modify entity @s item.components."minecraft:item_model" set value "little_things:block/weathered_toolbox"
execute if data storage little_things:temp root.macro.components."minecraft:custom_data".little_things{state: "oxidized"} on vehicle run data modify entity @s item.components."minecraft:item_model" set value "little_things:block/oxidized_toolbox"