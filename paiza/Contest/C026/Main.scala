object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input NSp
    val N,S,p = sc.nextInt

    // Input Carrots(m_N s_N)
    var carrots: List[List[Int]] = Nil
    for (x <- 1 to N) {
        val m,s = sc.nextInt
        carrots = List(x, m, s) :: carrots
    }
    carrots = carrots.reverse

    // calculate Best Carrot Number
    val carrotNumber = calcBestCarrotNumber(S, p, carrots)

    // Output Result
    if (carrotNumber > 0) {
        println(carrotNumber)
    } else {
        println("not found")
    }
    
    def calcBestCarrotNumber(S: Int, p: Int, carrots: List[List[Int]]): Int = {
        carrots.filter(x => ((S - p) <= x(2) && x(2) <= (S + p))) match {
            case listFiltered: List[List[Int]] if (listFiltered.size > 0) => listFiltered.maxBy(_(1)).apply(0)
            case _ => 0
        }
    }
}
