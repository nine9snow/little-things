execute as @a[gamemode=!spectator] at @s run function little_things:player/tick

execute as @e[type=minecraft:interaction, tag=little_things.toolbox] at @s unless predicate little_things:sustains_blocks run function little_things:block/toolbox/break/main