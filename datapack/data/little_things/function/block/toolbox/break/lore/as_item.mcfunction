execute unless data entity @s Item.components."minecraft:custom_name" run item modify entity @s container.0 little_things:lore/default
execute if data entity @s Item.components."minecraft:custom_name" run item modify entity @s container.0 little_things:lore/custom_name
data modify storage little_things:temp root.export.components."minecraft:lore" append from entity @s Item.components."minecraft:lore"
kill @s