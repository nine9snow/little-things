data remove entity @s interaction

execute if data storage little_things:temp root.item unless data storage little_things:temp root{illegal: true} run return run function little_things:block/toolbox/items/interact/swap/main

execute on vehicle if data entity @s item.components."minecraft:custom_data".little_things{id: "invalid"} run return fail
execute unless data storage little_things:temp root.item run function little_things:block/toolbox/items/interact/take