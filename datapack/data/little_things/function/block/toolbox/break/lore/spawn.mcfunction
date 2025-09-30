$summon minecraft:item ~ ~ ~ {Item:$(spawn), Tags: ["little_things.temp"]}
execute as @n[type=minecraft:item, tag=little_things.temp] run function little_things:block/toolbox/break/lore/as_item