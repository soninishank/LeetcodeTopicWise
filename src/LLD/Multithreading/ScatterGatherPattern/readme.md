write code to gather prices from N sources ?? 

getPrice(product)
 -> website1
 -> website2
 -> website3
then return the result 

instead of this call all of them parallel & once threads have responses return the result.But it might be possible
that some websites are down.

write code to gather prices from N sources and waiting for maximum 3 seconds ?? 
1.Trigger - wait for N tasks
2.Add timeout 
