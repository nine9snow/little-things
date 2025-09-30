data remove storage little_things:temp root
data modify storage little_things:temp root.macro set from entity @s SelectedItem
data modify storage little_things:temp root.slot set value "mainhand"
function little_things:item/wfoas/use