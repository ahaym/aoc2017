import scala.io.Source
object a12 extends App {
  val in = Source.fromFile("input").mkString.split("\n").map(_.split(" <-> "))
  var programs = Map[Int, Array[Int]]()
  for(a <- in) {
    val x = a(0).toInt
    val ys = a(1).split(", ").map(_.toInt)
    programs += (x -> ys) 
  }
  val visited = collection.mutable.HashSet[Int](0)
  def mg(x: Int): Int = {
    var n = 0
    var q = collection.mutable.Queue[Int](x)
    while(q.size > 0) {
     val cur = q.dequeue
     n += 1
     for(y <- programs(cur)) {
       if(!visited.contains(y)) {
         visited += y
         q += y
       }
      }
    }
    n
  }
  println(mg(0))
  var c = 1
  for(p <- programs.keys) {
    if(!visited.contains(p)) {
      mg(p)
      c += 1
    }
  }
    
  println(c)
}
