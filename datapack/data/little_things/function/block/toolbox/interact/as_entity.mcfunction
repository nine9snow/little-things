data remove entity @s interaction

execute summon minecraft:item_display run function little_things:block/toolbox/interact/validate
execute if data storage little_things:temp root{axe: true} on vehicle if entity @s[tag=little_things.waxed] run return run function little_things:block/toolbox/interact/wax_off
execute if data storage little_things:temp root{axe: true} on vehicle unless data entity @s data{state: "default"} run return run function little_things:block/toolbox/interact/scrape
execute if data storage little_things:temp root.item{id: "minecraft:honeycomb"} on vehicle unless entity @s[tag=little_things.waxed] run return run function little_things:block/toolbox/interact/wax_on

execute if entity @s[tag=little_things.open] run return run function little_things:block/toolbox/state/close
function little_things:block/toolbox/state/open