object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input o_y,s,theta
    val o_y,s,theta = sc.nextInt
    // Input x,y,a
    val x,y,a = sc.nextInt

    val dart = calcDart(o_y, s, theta, x, y)
    val result = getResult(dart, y, a)

    // Output Result
    println(result)

    def getResult(dart: Double, y: Double, a: Double): String = {
//        if (y-a/2 <= dart && dart <= y+a/2) {
        if (0 <= dart.compare(y-a/2+0.05) && dart.compare(y+a/2-0.05) <= 0) {
            "Hit " + BigDecimal(math.abs(y-dart)).setScale(1, BigDecimal.RoundingMode.HALF_UP)
        } else {
            "Miss"
        }
    }

    def calcDart(o_y: Int, s: Int, theta: Int, x: Int, y: Int): Double = {
        math.BigDecimal(
            o_y + x*math.tan(math.Pi * theta / 180) - 9.8 * math.pow(x,2) / (2*math.pow(s,2) * math.pow(math.cos(math.Pi * theta / 180), 2))
        ).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
    }
}
