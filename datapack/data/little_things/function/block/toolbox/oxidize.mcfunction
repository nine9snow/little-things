scoreboard players reset @s little_things.dummy
data modify storage little_things:temp root.oxidation set from entity @s data.state
execute if data storage little_things:temp root{oxidation: "oxidized"} run return fail

execute if data storage little_things:temp root{oxidation: "default"} run data modify entity @s data.state set value "exposed"
execute if data storage little_things:temp root{oxidation: "exposed"} run data modify entity @s data.state set value "weathered"
execute if data storage little_things:temp root{oxidation: "weathered"} run data modify entity @s data.state set value "oxidized"

function little_things:block/toolbox/update