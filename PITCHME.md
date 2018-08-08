### Spark introduction

---
![WaitingForSpark](images/endless-waiting.png)
@snap[north]
What was before spark?
@snapped
---
### Hadoop/MapReduce

Hadoop is widely used large-scale barch data processing framework
It was great because of
* simple API
* fault tolerance

*** that's why it becomes framework for large files. It is because we can use ot on 1k nodes ***

---
### and now Spark is here
It is:
* still fault tolerant
* functional style api
* different strategy for handling latency

all data is immutable and in-memory. 
operations == functional transformations
fault tolerance is achieved by replaying transformations starting from original dataset

As result Spark can be 100x (watch the numbers) faster then Hadoop
--- 
#### Iterations in Hadoop/MapReduce vs Spark
![Hadoop iterations](images/hadoop-iterations.png)
![Spark iterations](images/spark-iterations.png)

---
Some cool things: 
* native Python, Scala, R interface
* interactive shell (repl)
* in-memory caching level, specified by user
* efficient distributed operations
* reusing existing Hadoop ecosystem

---
There are 3 collections

--
средства работы (облака, идие, способы деплоя и тк)

--
различные коллекции