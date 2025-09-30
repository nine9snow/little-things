execute positioned ~-0.01 ~-0.99 ~-0.01 as @n[dx=0,type=!#little_things:intangible,tag=!little_things.raycaster] positioned ~-0.99 ~0.99 ~-0.99 if entity @s[dx=0] run return fail

execute positioned ^ ^ ^0.01 unless predicate little_things:raycast_ignore if predicate little_things:replaceable rotated ~ 0 align xyz positioned ~0.5 ~ ~0.5 if predicate little_things:replaceable unless entity @e[distance=..0.5,tag=smithed.block] if block ~ ~-1 ~ #little_things:sustains_blocks run return run function little_things:block/toolbox/place/place
execute positioned ^ ^ ^0.01 unless predicate little_things:raycast_ignore positioned ^ ^ ^-0.1 rotated ~ 0 align xyz positioned ~0.5 ~ ~0.5 if predicate little_things:replaceable unless entity @e[distance=..0.5,tag=smithed.block] if block ~ ~-1 ~ #little_things:sustains_blocks run return run function little_things:block/toolbox/place/place

scoreboard players remove #raycast little_things.dummy 1
execute if score #raycast little_things.dummy matches 1.. positioned ^ ^ ^0.01 if predicate little_things:raycast_ignore run function little_things:block/toolbox/place/raycast