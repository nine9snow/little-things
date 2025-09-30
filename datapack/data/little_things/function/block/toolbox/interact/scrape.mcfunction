scoreboard players reset @s little_things.dummy
playsound minecraft:item.axe.scrape block @a[distance=..16]
particle minecraft:scrape ~ ~0.25 ~ 0.25 0.25 0.25 0 16

data modify storage little_things:temp root.oxidation set from entity @s data.state
execute if data storage little_things:temp root{oxidation: "exposed"} run data modify entity @s data.state set value "default"
execute if data storage little_things:temp root{oxidation: "weathered"} run data modify entity @s data.state set value "exposed"
execute if data storage little_things:temp root{oxidation: "oxidized"} run data modify entity @s data.state set value "weathered"
function little_things:block/toolbox/update