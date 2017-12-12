import scala.io.Source
object a2 extends App {
  val in = Source.fromFile("input").mkString.split("\n").map(_.split("\t").map(_.toInt))
  def mdif(xs: Array[Int]): Int = {
    var max = -1
    var min = 10000
    for(x <- xs) {
      for(x2 <- xs) {
        if(x % x2 == 0 && x != x2) return x / x2
      }
    }
    -69420
  }
  println {in.map(mdif(_)).fold(0)(_ + _)}
}
