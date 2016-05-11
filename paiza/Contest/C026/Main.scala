object Main extends App {

    val sc = new java.util.Scanner(System.in)
    val N,S,p = sc.nextInt
 //   val listMS = List.fill(N, 2)(sc.nextInt)
    val listMS = readCarrots(Nil, N, 0)


    println(listMS)

    println(calcBestCarrotNumber(S, p, listMS))


    /*
    for (x <- 1 to N) {
        val m = sc.nextInt
        val s = sc.nextInt
        val carrot = readLine.split(" ").map(_.toInt)
        carrot(2)
    }

    println(listMS)
    */
    
    def readCarrots(carrots: List[List[Int]], N: Int, n: Int): List[List[Int]] = (n) match {
        case N => carrots.reverse
        case _ => readCarrots((n :: readLine.split(" ").map(_.toInt).toList) :: carrots, N, n + 1)
    }
    
    def calcBestCarrotNumber(S: Int, p: Int, listMS: List[List[Int]]): List[List[Int]] = {
        listMS.map(e => e.filter(x => (S - p) <= x && x <= (S + p)))
//        .maxBy(_(1))
    }
}
