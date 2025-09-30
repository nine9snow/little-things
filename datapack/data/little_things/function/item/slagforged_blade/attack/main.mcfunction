advancement revoke @s only little_things:technical/player_hurt_entity/attack_with_slagforged_blade
execute if entity @s[tag=little_things.attack_cooldown] run return fail
tag @s add little_things.attack_cooldown

execute unless items entity @s weapon.mainhand minecraft:iron_sword[minecraft:custom_data~{little_things: {id: "slagforged_blade"}}] run return fail

data remove storage little_things:temp root
data modify storage little_things:temp root.item set from entity @s SelectedItem

execute store result score #count little_things.dummy run data get storage little_things:temp root.item.components."minecraft:custom_data".little_things.hits_left
execute store result storage little_things:temp root.item.components."minecraft:custom_data".little_things.hits_left int 1 run scoreboard players remove #count little_things.dummy 1

function little_things:item/slagforged_blade/attack/modify with storage little_things:temp root.item