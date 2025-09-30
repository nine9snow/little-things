data remove storage little_things:temp root
data modify storage little_things:temp root.macro set from entity @s equipment.offhand
data modify storage little_things:temp root.slot set value "offhand"
function little_things:item/wfoas/use