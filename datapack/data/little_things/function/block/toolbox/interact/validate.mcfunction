data modify entity @s item set from storage little_things:temp root.item
execute if items entity @s container.0 #minecraft:axes run data modify storage little_things:temp root.axe set value true
kill @s