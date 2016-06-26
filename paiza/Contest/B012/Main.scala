object Main extends App {

    val COLUMUNS_NUM = 16
    val sc = new java.util.Scanner(System.in)

    // Input N
    val N = sc.nextInt

    // Input creditNumbers
    var creditNumbers: List[String] = Nil
    for (x <- 1 to N) {
        val creditNumber = sc.next
        creditNumbers = creditNumber :: creditNumbers
    }
    creditNumbers = creditNumbers.reverse

    // calculation
    val credit1stColumns = creditNumbers.map(get1stColumn)

    // Output Result
    credit1stColumns.map(println)

    def get1stColumn(creditNumber:String) :Int = {

        val even = calcEven(creditNumber)
        val oddWithout1stColumn = calcOddWithout1stColumn(creditNumber)
        (10 - ((even + oddWithout1stColumn) % 10)) % 10
    }

    def calcEven(creditNumber:String) :Int = {
        var even = 0
        for (x <- 2 to COLUMUNS_NUM) {
            if (0 == x%2) {
                val addNum = 2 * creditNumber.substring(COLUMUNS_NUM - x, COLUMUNS_NUM - x + 1).toInt
                if (addNum >= 10) {
                    even += (addNum / 10 + addNum % 10)
                } else {
                    even += addNum
                }
            }
        }
        even
    }

    def calcOddWithout1stColumn(creditNumber:String) :Int = {
        var oddWithout1stColumn = 0
        for (x <- 2 to COLUMUNS_NUM) {
            if (1 == x%2) {
                oddWithout1stColumn += creditNumber.substring(COLUMUNS_NUM - x, COLUMUNS_NUM - x + 1).toInt
            }
        }
        oddWithout1stColumn
    }
}
