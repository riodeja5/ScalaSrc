object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input N
    val N = sc.nextInt

    // Input presentation(s_n,a_n)
    var presentation: List[(String,Int)] = Nil
    for (x <- 1 to N) {
        val s = sc.next
        val a = sc.nextInt
        presentation = (s,a) :: presentation
    }
    presentation = presentation.reverse

    // calculation
    val timeTable = getTimeTable(presentation, 10*60, false)

    // Output Result
    timeTable.map(println)

    def getTimeTable(presentation:List[(String,Int)], start:Int, hasLunch:Boolean) :List[String] = {
        val name = presentation.head._1
        val period = presentation.head._2
        val end = start + period
        val timeRecord:String = getTime(start) + " - " + getTime(end) + " " + name

        if (presentation.size < 2) {
            List(timeRecord)
        } else {
            val nextPeriod = presentation(1)._2
            val nextStart = calcNextStart(end, nextPeriod, hasLunch)
            timeRecord :: getTimeTable(presentation.tail, nextStart._1, nextStart._2)
        }
    }

    def calcNextStart(preEnd:Int, nextPeriod:Int, hasLunch:Boolean) :(Int,Boolean) = {
        val nextStart = preEnd + 10
        val nextEnd = nextStart + nextPeriod
        if (hasLunch) {
            (nextStart, hasLunch)
        } else {
            if (nextEnd <= (12*60)) {
                (nextStart, hasLunch)
            } else {
                (preEnd + 60, true)
            }
        }
    }

    def getTime(minutes:Int) :String = {
        "%02d".format(minutes / 60) + ":" + "%02d".format(minutes % 60)
    }
}
