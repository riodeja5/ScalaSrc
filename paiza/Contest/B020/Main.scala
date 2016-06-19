object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input n
    val sn = sc.nextLine
    val n = Integer.valueOf(sn)

    // Input querys(q_n)
    var querys: List[String] = Nil
    for (x <- 1 to n) {
        val word = sc.nextLine
        querys = word :: querys
    }
    querys = querys.reverse

    val newQuerys: List[String] = replaceBack2Go(querys)
    val pages: List[String] = newQuerys.map(convQuery2Page)

    // Output Result
    pages.foreach(x => println(x))

    def replaceBack2Go(querys: List[String]): List[String] = {
        // TODO recursion to 
        var newQuerys: Array[String] = querys.toArray
        val n = querys.size
        for (x <- 0 until n if "use the back button" == newQuerys(x)) {
            newQuerys(x) = newQuerys(x - 2)
        }
        newQuerys.toList
    }

    def convQuery2Page(query: String): String = {
        query.replaceFirst("go to", "")
    }
}
