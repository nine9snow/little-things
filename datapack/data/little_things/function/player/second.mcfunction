execute if entity @s[gamemode=creative, tag=!little_things.warned] run function little_things:player/warning
execute if entity @s[gamemode=!creative, gamemode=!spectator, tag=little_things.warned] run tag @s remove little_things.warned

execute if score @s little_things.left matches 1.. run function little_things:player/initiate