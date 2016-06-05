object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input N
    val N = sc.nextInt

    // Input Receipt(d_N, p_N)
    var receipts: List[List[Int]] = Nil
    for (x <- 1 to N) {
        val d,p = sc.nextInt
        receipts = List(d,p) :: receipts
    }

    // calculate Points from receipts
    val points = calcPoints(receipts)

    // Output Result
    println(points)

    def calcPoints(receipts: List[List[Int]]): Int = {
        receipts.map(x => (x(0) match {
            case num if (3 == num % 10) || (3 == num / 10) => (x(1) * 0.03).toInt
            case num if (5 == num % 10)                    => (x(1) * 0.05).toInt
            case num                                       => (x(1) * 0.01).toInt
            })).sum
    }
}
