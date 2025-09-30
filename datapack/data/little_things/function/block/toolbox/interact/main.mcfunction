advancement revoke @s only little_things:technical/interact_with_entity/toolbox

data remove storage little_things:temp root
data modify storage little_things:temp root.item set from entity @s SelectedItem

execute as @n[type=minecraft:interaction,tag=little_things.toolbox,nbt={interaction:{}}] at @s run function little_things:block/toolbox/interact/as_entity

execute if data storage little_things:temp root{reduce: true} run item modify entity @s[gamemode=!creative] weapon.mainhand little_things:reduce_count
execute if data storage little_things:temp root{axe: true} unless entity @s[gamemode=creative] run function little_things:item/durability/main