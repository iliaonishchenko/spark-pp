### Spark introduction

---
@snap[north]
#### what was before Spark?
@snapped
![WaitingForSpark](images/endless-waiting.png)&size=80% auto
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
* fault tolerant
* functional style api
* different strategy for handling latency

all data is immutable and in-memory   
operations are functional transformations   
fault tolerance is achieved by replaying transformations starting from original dataset   
  
As result Spark can be 100x (watch the numbers) faster then Hadoop    
--- 
### iterations in Hadoop/MapReduce vs Spark
![Hadoop iterations](images/hadoop-iterations.png)
![Spark iterations](images/spark-iterations.png)

---
### some cool things about Spark: 
* native Python, Scala, R interface   
* interactive shell (repl)    
* efficient distributed operations   
* reusing existing Hadoop ecosystem  
* opensource

--- 
### Spark nowadays
![Spark stack](images/spark-stack.png)

--- 
### Spark distributed mode
@snap[west]
![Spark distributed mode](images/spark-distributed-mode.png)
@snapped

@snap[east]
* master-slave architecture   
* driver is the process where the main method runs  
* executors are responsible for running the individual tasks in given Spark job
* driver + executor == spark app
@snapped
---
### There are 3 collection types:
@Snap[east]
* Resilient Distributed Datasets
* DataFrame
* Dataset
@snapped
@snap[west]
* resilient
* distributed
* immutable
* in-memory
* lazy
* parallel-partitioned
@snapped
--- 
### Resilient Distributed Dataset 
@snap[east]
![RDD Flow](images/rdd-flow.png)
@snapped
@snap[wesr]
Seems like immutable sequential or parallel Scala collection.
@snapped
---
### first peace of rdd
adsad
---
### RDD operations
There are two main types:
* transformations
returns new collection as a result
```scala
map([B]f: A => B): RDD[B]
```
* actions
```scala
reduce(op: (A, A) => A): A
```
---
### world count 
```scala
val text = spark.textFile("hdfs://path/to/file.txt")
val count = rdd.flatMap(line => line.split(" "))
                    .map(word => (word, 1))
                    .reduceByKey(_ + _)
```
---
### Dataframes
---
### Datasets