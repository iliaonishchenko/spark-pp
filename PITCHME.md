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

all data is immutable and in-memory   
operations == functional transformations   
fault tolerance is achieved by replaying transformations starting from original dataset   
  
As result Spark can be 100x (watch the numbers) faster then Hadoop    
--- 
#### iterations in Hadoop/MapReduce vs Spark
![Hadoop iterations](images/hadoop-iterations.png)
![Spark iterations](images/spark-iterations.png)

---
#### some cool things about Spark: 
* native Python, Scala, R interface   
* interactive shell (repl)   
* in-memory caching level, specified by user   
* efficient distributed operations   
* reusing existing Hadoop ecosystem  

--- 
#### Spark nowadays
![Spark stack](images/spark-stack.png)

--- 
#### Spark distributed mode
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
#### There are 3 collection types:
* Resilient Distributed Datasets
* DataFrame
* Dataset
--- 
#### Collections are: 
* resilient
* distributed
* immutable
* in-memory
* lazy
* parallel-partitioned
--- 
#### Resilient Distributed Dataset 
---
средства работы (облака, идие, способы деплоя и тк)

---
различные коллекции