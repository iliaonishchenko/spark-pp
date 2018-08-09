### Spark introduction

---
### Hadoop/MapReduce

Hadoop is widely used large-scale batch data processing framework  
It was great because of:
* simple API
* fault tolerance
---
@snap[north]
#### and it was like
@snapped
![WaitingForSpark](images/endless-waiting.png)&size=90% auto
---
### and now Spark is here
* fault tolerant
* functional style api
* different strategy for handling latency
--- 
Data is immutable and stored in-memory     
Operations are functional transformations       
Fault tolerance is achieved by replaying transformations starting from original dataset     
  
As result Spark can be 100x (watch the numbers) faster then Hadoop      
---
### iterations in Hadoop/MapReduce vs Spark
![Hadoop iterations](images/hadoop-iterations.png)
![Spark iterations](images/spark-iterations.png)

---
### some cool things about Spark: 
* native Scala, Java, Python, R interface   
* interactive shell (repl)    
* efficient distributed operations   
* reusing existing Hadoop ecosystem  
* opensource

---
@snap[south]
?image=images/spark-stack.png&size=60%
@snapped
@snap[north]
### Spark nowadays
@snapped
<!-- ![Spark stack](images/spark-stack.png)&size=contain -->


---?image=images/spark-distributed-mode.png&size=50%
@snap[north]
### Spark distributed mode
@snapped
<!-- @snap[west] -->
<!-- ![Spark distributed mode](images/spark-distributed-mode.png)&size=40% auto -->
<!-- @snapped -->

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
![RDD Flow](images/rdd-flow.png)&size=80%
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