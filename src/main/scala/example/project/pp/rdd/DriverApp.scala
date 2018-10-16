package example.project.pp.rdd

import example.project.pp.rdd.WikipediaRanking._
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object DriverApp extends App {
  val sc = {
    val conf = new SparkConf().setAppName("HelloWorldName").setMaster("local[*]")
    new SparkContext(conf)
  }

//  val range = (1 to 10^100000).to
/* Languages ranked according to (1) */
val langsRanked: List[(String, Int)] = timed("Part 1: naive ranking", rankLangs(langs, wikiRdd))
  langsRanked.foreach(println)

  /* An inverted index mapping languages to wikipedia pages on which they appear */
  def index: RDD[(String, Iterable[WikipediaArticle])] = makeIndex(langs, wikiRdd)

  /* Languages ranked according to (2), using the inverted index */
  val langsRanked2: List[(String, Int)] = timed("Part 2: ranking using inverted index", rankLangsUsingIndex(index))
  langsRanked2.foreach(println)

  /* Languages ranked according to (3) */
  val langsRanked3: List[(String, Int)] = timed("Part 3: ranking using reduceByKey", rankLangsReduceByKey(langs, wikiRdd))
  langsRanked3.foreach(println)

  /* Output the speed of each ranking */
  println(timing)
  sc.stop()
}