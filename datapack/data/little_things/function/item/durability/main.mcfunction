execute if items entity @s weapon.mainhand *[minecraft:enchantments~[{enchantments: "minecraft:unbreaking", levels:1}]] unless predicate little_things:chance/0.5 run return fail
execute if items entity @s weapon.mainhand *[minecraft:enchantments~[{enchantments: "minecraft:unbreaking", levels:2}]] unless predicate little_things:chance/0.33 run return fail
execute if items entity @s weapon.mainhand *[minecraft:enchantments~[{enchantments: "minecraft:unbreaking", levels:3}]] unless predicate little_things:chance/0.25 run return fail

data remove storage little_things:temp root
data modify storage little_things:temp root.item set from entity @s SelectedItem

execute if data storage little_things:temp root.item{id: "minecraft:golden_axe"} run scoreboard players set #max_damage little_things.dummy 32
execute if data storage little_things:temp root.item{id: "minecraft:wooden_axe"} run scoreboard players set #max_damage little_things.dummy 59
execute if data storage little_things:temp root.item{id: "minecraft:stone_axe"} run scoreboard players set #max_damage little_things.dummy 131
execute if data storage little_things:temp root.item{id: "minecraft:copper_axe"} run scoreboard players set #max_damage little_things.dummy 190
execute if data storage little_things:temp root.item{id: "minecraft:iron_axe"} run scoreboard players set #max_damage little_things.dummy 250
execute if data storage little_things:temp root.item{id: "minecraft:diamond_axe"} run scoreboard players set #max_damage little_things.dummy 1561
execute if data storage little_things:temp root.item{id: "minecraft:netherite_axe"} run scoreboard players set #max_damage little_things.dummy 2031
execute if data storage little_things:temp root.item.components."minecraft:max_damage" store result score #max_damage little_things.dummy run data get storage little_things:temp root.item.components."minecraft:max_damage"

scoreboard players set #damage little_things.dummy 0
execute if data storage little_things:temp root.item.components."minecraft:damage" store result score #damage little_things.dummy run data get storage little_things:temp root.item.components."minecraft:damage"
execute store result storage little_things:temp root.damage int 1 run scoreboard players add #damage little_things.dummy 1

execute if score #damage little_things.dummy = #max_damage little_things.dummy run return run function little_things:item/durability/break with storage little_things:temp root
function little_things:item/durability/macro with storage little_things:temp root