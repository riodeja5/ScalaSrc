object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input a,b
    val a,b = sc.nextInt
    // Input n
    val n = sc.nextInt

    // Input children(A_n, B_n)
    var children: List[(Int, Int)] = Nil
    for (x <- 1 to n) {
        val A,B = sc.nextInt
        children = (A, B) :: children
    }
    children = children.reverse

    // calculate
    val results: List[String] = children.map(x => judge((a, b), x))

    // Output Result
    results.foreach(println)

    def judge(parent: (Int, Int), child: (Int, Int)): String = {
        if (parent._1 < child._1) "Low"
        else if (parent._1 > child._1) "High"
        else {
            if (parent._2 > child._2) "Low"
            else "High"
        }
    }
}
