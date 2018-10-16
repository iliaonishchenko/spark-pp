package example.project.pp.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object WikipediaRanking {

  val langs = List(
    "JavaScript", "Java", "PHP", "Python", "C#", "C++", "Ruby", "CSS",
    "Objective-C", "Perl", "Scala", "Haskell", "MATLAB", "Clojure", "Groovy")

  val conf: SparkConf = new SparkConf().setAppName("wikipedia").setMaster("local[*]")
  val sc: SparkContext = new SparkContext(conf)
  sc.setLogLevel("WARN")

  val wikiRdd: RDD[WikipediaArticle] = sc.textFile(WikipediaData.filePath).map(l => WikipediaData.parse(l)).cache()

  def occurrencesOfLang(lang: String, rdd: RDD[WikipediaArticle]): Int = {
    rdd.aggregate(0)((sum, article) => sum + isFound(article, lang), _+_)
  }

  def isFound(article: WikipediaArticle, lang: String): Int = if(article.text.split(" ").contains(lang)) 1 else 0

  def rankLangs(langs: List[String], rdd: RDD[WikipediaArticle]): List[(String, Int)] = {
    val ranks = langs.map(lang => (lang, occurrencesOfLang(lang, rdd)))
    //for{ lang <- langs; occ = occurrencesOfLang(lang, rdd) if occ != 0} yield (lang, occ)
    ranks.sortBy(_._2).reverse
  }

  def makeIndex(langs: List[String], rdd: RDD[WikipediaArticle]): RDD[(String, Iterable[WikipediaArticle])] = {
    val list = rdd.flatMap(article => for( lang <- langs if isFound(article, lang) == 1) yield (lang, article))
    list.groupByKey()
  }

  def rankLangsUsingIndex(index: RDD[(String, Iterable[WikipediaArticle])]): List[(String, Int)] = {
    val ranks = for{ (lang, list) <- index } yield (lang, list.size)
    ranks.collect().toList.sortBy(_._2).reverse
  }

  def rankLangsReduceByKey(langs: List[String], rdd: RDD[WikipediaArticle]): List[(String, Int)] = {
    val list = rdd.flatMap(article => for( lang <- langs if isFound(article, lang) == 1) yield (lang, 1))
    list.reduceByKey(_+_).collect().toList.sortBy(_._2).reverse
  }

  val timing = new StringBuffer
  def timed[T](label: String, code: => T): T = {
    val start = System.currentTimeMillis()
    val result = code
    val stop = System.currentTimeMillis()
    timing.append(s"Processing $label took ${stop - start} ms.\n")
    result
  }
}

