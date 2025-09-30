advancement revoke @s only little_things:technical/interact_with_entity/toolbox_item

data remove storage little_things:temp root
data modify storage little_things:temp root.item set from entity @s SelectedItem
execute if items entity @s weapon.mainhand #little_things:disallowed_in_toolbox run data remove storage little_things:temp root.item
execute if items entity @s weapon.mainhand minecraft:warped_fungus_on_a_stick[minecraft:custom_data~{little_things: {id: "toolbox"}}] run data modify storage little_things:temp root.illegal set value true
execute if items entity @s weapon.mainhand *[minecraft:custom_data~{little_things: {toolbox_illegal: true}}] run data modify storage little_things:temp root.illegal set value true
execute if predicate little_things:full_inventory run data modify storage little_things:temp root.illegal set value true

execute as @n[type=minecraft:interaction,tag=little_things.toolbox_item,nbt={interaction:{}}] at @s run function little_things:block/toolbox/items/interact/as_entity

execute if data storage little_things:temp root{reduce: true} run item modify entity @s weapon.mainhand little_things:reduce_count
execute if data storage little_things:temp root.swap run function little_things:block/toolbox/items/interact/swap/check