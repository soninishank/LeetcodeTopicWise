volatile : used to solve the visibility problem
if you added volatile keyword in front of variable
than the changes are flushed into a shared cache
and from the shared cache it will get refreshed to other threads

when we have compound operation - volatile will not work
when we have one atomic operation - we need to synchronized keyword - where we have read & write
other than synchronized keyword we can use atomic integer

AtomicInteger value = new AtomicInteger(1);
value.increment();// read & write operations are done atomically




volatile : used for flags
atomicInteger/atomicLong : counters
atomicReferences : caches , non blocking references 