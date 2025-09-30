tag @s remove little_things.open

execute on vehicle run data modify entity @s item.components."minecraft:custom_model_data".strings set value ["closed"]

data remove storage little_things:temp root
data modify storage little_things:temp root.uuid set from entity @s UUID

scoreboard players set #iterate little_things.dummy 0
function little_things:block/toolbox/items/read/loop
data remove entity @s data.items
data modify entity @s data.items set from storage little_things:temp root.contents

function little_things:block/toolbox/items/kill/main with storage little_things:temp root