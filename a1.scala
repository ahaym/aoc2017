object a1 extends App {
  def nsum(ds: Array[Int]): Int = {
    var acc = 0;
    val j = ds.size / 2
    for(n <- (0 until ds.size - 1)) {
      if(ds(n) == ds((n+j) % ds.size)) acc += ds(n)
    }
    acc
  }
  val in = readLine
  println(nsum(in.split("").map(_.toInt)))
}
