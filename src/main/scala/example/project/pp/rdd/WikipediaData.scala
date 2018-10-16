package example.project.pp.rdd

import java.io.File

object WikipediaData {

  def filePath: String = {
    new File(this.getClass.getClassLoader.getResource("wikipedia").toURI).getPath
  }

  def parse(line: String): WikipediaArticle = {
    val subs = "</title><text>"
    val i = line.indexOf(subs)
    val title = line.substring(14, i)
    val text  = line.substring(i + subs.length, line.length-16)
    WikipediaArticle(title, text)
  }
}