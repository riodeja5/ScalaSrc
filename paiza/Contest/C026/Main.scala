object Main extends App {

    // Input NSp
    val sc = new java.util.Scanner(System.in)
    val N,S,p = sc.nextInt

    // Input Carrots(m_N s_N)
    val listMS = readCarrots(Nil, N, 0)

    // calculate Best Carrot Number
    val carrotNumber = calcBestCarrotNumber(S, p, listMS)

    // Output Result
    if (carrotNumber > 0) {
        println(carrotNumber)
    } else {
        println("not found")
    }
    
    def readCarrots(carrots: List[List[Int]], N: Int, n: Int): List[List[Int]] = (n) match {
        case N => carrots.reverse
        case _ => readCarrots((n :: readLine.split(" ").map(_.toInt).toList) :: carrots, N, n + 1)
    }
    
    def calcBestCarrotNumber(S: Int, p: Int, listMS: List[List[Int]]): Int = {
        listMS.filter(x => ((S - p) <= x(2) && x(2) <= (S + p))) match {
            case listFiltered: List[List[Int]] if (listFiltered.size > 0) => listFiltered.maxBy(_(1)).apply(0) + 1
            case _ => 0
        }
    }
}
