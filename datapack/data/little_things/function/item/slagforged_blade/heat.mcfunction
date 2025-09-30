playsound little_things:item.slagforged_blade.heat player @a[distance=..16]
execute anchored eyes positioned ^ ^ ^0.5 run particle minecraft:lava ~ ~-0.5 ~ 0.3 0.3 0.3 0 5 force
$item modify entity @s weapon.$(hand) little_things:slagforged_blade/heated