execute on vehicle run function little_things:block/toolbox/break/particles
playsound minecraft:block.copper.break block @a[distance=..16]

execute if entity @s[tag=little_things.open] run function little_things:block/toolbox/state/close_alt
data modify storage little_things:temp root.contents set from entity @s data.items
execute unless data entity @s data.items run data modify storage little_things:temp root.contents set value []
data modify storage little_things:temp root.name set from entity @s data.name

execute on vehicle run function little_things:block/toolbox/break/update
kill @s