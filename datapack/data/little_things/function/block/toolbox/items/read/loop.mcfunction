execute store result storage little_things:temp root.index int 1 run scoreboard players get #iterate little_things.dummy
function little_things:block/toolbox/items/read/macro with storage little_things:temp root

scoreboard players add #iterate little_things.dummy 1
execute unless score #iterate little_things.dummy matches 6.. run function little_things:block/toolbox/items/read/loop