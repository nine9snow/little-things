schedule function little_things:technical/clock/second 1s replace

execute as @a at @s run function little_things:player/second
execute as @e[type=minecraft:item_display, tag=little_things.toolbox, tag=!little_things.waxed] at @s run function little_things:block/toolbox/second

execute as @e[type=#little_things:processing_needed, tag=!little_things.processed] run function little_things:entity/processing