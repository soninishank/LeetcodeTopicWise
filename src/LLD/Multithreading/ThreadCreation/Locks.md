pessimistic locks(lot of conflicts) : washroom - if one person is inside the other person will wait

- get the key
- not return the key unless their work is done
- mutual exclusion
- Pros : Never need to retry
- cons : Always need to acquire & release locks

optimistic locks (Not many conflicts):
- compare and swap - before writing it compares 
- assumes there is no race condition
- int x = 2;
- Thread 1 Thread 2
  read x = 2 read x = 2
  inc; x = 3 inc; x = 3
  write 3 write - will not happen - again retry from start
- A thread retries when the value at the time of writing is different from what it was at the time of writing
- Thread 2 -> read x = 3;
  inc; x= 4;
  write(4)
- pros : Don't need to spend time taking locks
- cons : You might need to retry in case of conflicts - where you are expecting a lot of conflict - don't use it

Database row : multiple servers trying to write - versioning concept is used
- row v1
read row v1 read row',v2
update row v1 update row''
write v2 , row' write row'' v3

which lock is better ?

