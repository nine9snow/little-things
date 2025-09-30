advancement revoke @s only little_things:technical/entity_hurt_player/block_with_slagforged_blade
playsound little_things:item.slagforged_blade.block player @a[distance=..16]

data remove storage little_things:temp root
execute if items entity @s weapon.offhand minecraft:iron_sword[minecraft:custom_data~{little_things: {id: "slagforged_blade"}}] run data modify storage little_things:temp root.item set from entity @s equipment.offhand
execute if items entity @s weapon.offhand minecraft:iron_sword[minecraft:custom_data~{little_things: {id: "slagforged_blade"}}] run data modify storage little_things:temp root.item.hand set value "offhand"

execute if items entity @s weapon.mainhand minecraft:iron_sword[minecraft:custom_data~{little_things: {id: "slagforged_blade"}}] run data modify storage little_things:temp root.item set from entity @s SelectedItem
execute if items entity @s weapon.mainhand minecraft:iron_sword[minecraft:custom_data~{little_things: {id: "slagforged_blade"}}] run data modify storage little_things:temp root.item.hand set value "mainhand"

execute store result score #count little_things.dummy run data get storage little_things:temp root.item.components."minecraft:custom_data".little_things.hits_left
execute store result storage little_things:temp root.item.components."minecraft:custom_data".little_things.hits_left int 1 run scoreboard players remove #count little_things.dummy 1

function little_things:item/slagforged_blade/modify with storage little_things:temp root.item