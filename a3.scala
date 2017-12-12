object a3 extends App {
  val in = 265149
  var x = true
  var period = 1
  var dir = 1
  var i = 0
  var curx = 0
  var cury = 0
  var a = Map[(Int, Int), Int](((0, 0) -> 1))
  for(n <- 1 until 1000) {
    var acc = 0
    if(x) {
     curx += dir
     i += 1
     if(i >= period) {
       x = false
       i = 0
     }
    } else {
     cury += dir
     i += 1
     if(i >= period) {
      x = true
      i = 0
      dir *= -1
      period += 1
     }
    }
     acc += a.getOrElse((curx - 1, cury), 0)
     acc += a.getOrElse((curx + 1, cury), 0)
     acc += a.getOrElse((curx, cury - 1), 0)
     acc += a.getOrElse((curx, cury + 1), 0)
     acc += a.getOrElse((curx - 1, cury - 1), 0)
     acc += a.getOrElse((curx + 1, cury - 1), 0)
     acc += a.getOrElse((curx - 1, cury + 1), 0)
     acc += a.getOrElse((curx + 1, cury + 1), 0)
     a += ((curx, cury) -> acc)
     if(acc > in) {
       println(acc)
     }

  }
  //println(Math.abs(curx) + Math.abs(cury))
}
