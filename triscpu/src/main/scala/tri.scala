import scala.io.Source

/* Tri en utilisant le tri comptage */
object tri_comptage {
  def main(args: Array[String]): Unit = {

    val fileContent = Source.fromFile("10Mega.txt").mkString
    val tableauString  = fileContent.split(" ")
    val tableau = tableauString.map(_.toInt)

    val result: Array[Int] = new Array[Int](tableau.length)

    val min: Int = tableau.min
    val max: Int = tableau.max

    var count: Array[Int] = new Array[Int](max - min + 1)

    tableau.foreach( (el: Int) => count(el - min) += 1 )


    for (i <- 1 to (max-min)) {
        count(i) += count(i-1)
    }


    for (el <- tableau.reverseIterator) {
        count(el - min) -= 1
        result(count(el - min)) = el
    }

    println(result.mkString(" "))
  }  
}
