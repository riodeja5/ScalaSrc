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
        var newQuerys: Array[String] = querys.toArray
        val n = querys.size
        for (x <- 0 until n) {
            newQuerys(x) = replaceBack2Go(querys, x, 0)
        }
        newQuerys.toList
    }

    def replaceBack2Go(querys: List[String], target: Int, backnum: Int): String = {
        val query: String = querys(target)
        query match {
            case "use"// the back button"
             if "use"/* the back button"*/ == querys(target - 1) => replaceBack2Go(querys, target - 1, backnum + 1)
/*            case "use"/* the back button"*/
             if "use"/* the back button"*/ == querys(target - 2) => replaceBack2Go(querys, target - 3, backnum)
             */
            case "use"/* the back button"*/                      => replaceBack2Go(querys, target - 2, backnum)
            case _                                          => querys(target - backnum)
        }
    }

    def convQuery2Page(query: String): String = {
        query.replaceFirst("go to ", "")
    }
}
