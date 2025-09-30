tag @s add little_things.raycaster
execute store result score #raycast little_things.dummy run attribute @s minecraft:block_interaction_range get 100
execute anchored eyes run function little_things:block/toolbox/place/raycast
tag @s remove little_things.raycaster