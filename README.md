# reactive-spring


Why to use Reactive Programming ?

- Today what we have is thread per request model 
- For each request there will be a thread assigned and each thread takes some memory
- For many requests , it will take a lot of memory 
- Horizontal scaling can be done in the above case but reactive programming removes the usage of so many threads
- Imperative style of programming leads to blocking calls leading to more latency 
- No back pressure compatibility 

What is Reactive programming ?

- Asynchronous and non blocking 
- Data flow as event driven streams
- We get an event from every result item from the data source 



Reactive streams specification :

https://www.reactive-streams.org/
