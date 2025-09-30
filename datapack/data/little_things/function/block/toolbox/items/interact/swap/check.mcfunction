execute unless data storage little_things:temp root.swap.components run data modify storage little_things:temp root.swap.components set value {}

execute if data entity @s SelectedItem run return run function little_things:block/toolbox/items/interact/swap/give with storage little_things:temp root.swap
execute unless data entity @s SelectedItem run function little_things:block/toolbox/items/interact/swap/replace with storage little_things:temp root.swap