object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input w,h,n,x,y
    val w,h,n,x,y = sc.nextInt

    // Input moveLogs(dir_n,m_n)
    var moveLogs: List[(String,Int)] = Nil
    for (x <- 1 to n) {
        val dir = sc.next
        val m = sc.nextInt
        moveLogs = (dir,m) :: moveLogs
    }
    moveLogs = moveLogs.reverse

    // calculation
    val lastPos = getLastPos(w, h, x, y, moveLogs)

    // Output Result
    println(lastPos._1 + " " + lastPos._2)

    def getLastPos(w:Int, h:Int, x:Int, y:Int, moveLogs:List[(String,Int)]) :(Int,Int) = {

        moveLogs match {
            case Nil => (x,y)
            case _   => {
                val moveLog: (String,Int) = moveLogs.head
                val newPos: (Int,Int) = getPos(w,h,x,y,moveLog._1,moveLog._2)
                getLastPos(w,h,newPos._1,newPos._2,moveLogs.tail)
            }
        }
    }

    def getPos(w:Int, h:Int, x:Int, y:Int, dir:String, m:Int) :(Int,Int) = {

        dir match {
            case "U" => (x, (y+m)%h)
            case "D" if ((y-m)%h < 0)  => (x, (y-m)%h + h)
            case "D" if ((y-m)%h >= 0) => (x, (y-m)%h)
            case "R" => ((x+m)%w, y)
            case "L" if ((x-m)%w < 0)  => ((x-m)%w + w, y)
            case "L" if ((x-m)%w >= 0) => ((x-m)%w, y)
        }
    }
}
