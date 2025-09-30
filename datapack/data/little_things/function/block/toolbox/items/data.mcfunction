data remove storage little_things:temp root.contents
execute on vehicle run data modify storage little_things:temp root.state set from entity @s data.state

# for loops would go so hard unfortunately iterating over macros is less optimized
execute if data storage little_things:temp root.items[0] run function little_things:block/toolbox/items/add_set {index: 0}
execute unless data storage little_things:temp root.items[0] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

execute if data storage little_things:temp root.items[1] run function little_things:block/toolbox/items/add_set {index: 1}
execute unless data storage little_things:temp root.items[1] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

execute if data storage little_things:temp root.items[2] run function little_things:block/toolbox/items/add_set {index: 2}
execute unless data storage little_things:temp root.items[2] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

execute if data storage little_things:temp root.items[3] run function little_things:block/toolbox/items/add_set {index: 3}
execute unless data storage little_things:temp root.items[3] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

execute if data storage little_things:temp root.items[4] run function little_things:block/toolbox/items/add_set {index: 4}
execute unless data storage little_things:temp root.items[4] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

execute if data storage little_things:temp root.items[5] run function little_things:block/toolbox/items/add_set {index: 5}
execute unless data storage little_things:temp root.items[5] run function little_things:block/toolbox/items/add_blank with storage little_things:temp root

# spawn items
data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[0]
data modify storage little_things:temp root.index set value 0
execute on vehicle rotated as @s positioned ^-0.33 ^ ^ positioned ~ ~1.4 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root

data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[1]
data modify storage little_things:temp root.index set value 1
execute on vehicle rotated as @s positioned ~ ~1.4 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root

data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[2]
data modify storage little_things:temp root.index set value 2
execute on vehicle rotated as @s positioned ^0.33 ^ ^ positioned ~ ~1.4 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root

data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[3]
data modify storage little_things:temp root.index set value 3
execute on vehicle rotated as @s positioned ^-0.33 ^ ^ positioned ~ ~1.1 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root

data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[4]
data modify storage little_things:temp root.index set value 4
execute on vehicle rotated as @s positioned ~ ~1.1 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root

data modify storage little_things:temp root.set_item set from storage little_things:temp root.contents[5]
data modify storage little_things:temp root.index set value 5
execute on vehicle rotated as @s positioned ^0.33 ^ ^ positioned ~ ~1.1 ~ run function little_things:block/toolbox/items/spawn with storage little_things:temp root