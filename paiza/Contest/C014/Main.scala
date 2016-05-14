object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input nr
    val n,r = sc.nextInt

    // Input Boxes(h_N, w_N, d_N)
    var boxes: List[List[Int]] = Nil
    for (x <- 1 to n) {
        val h,w,d = sc.nextInt
        boxes = List(x, h, w, d) :: boxes
    }
    boxes = boxes.reverse
    
    //val boxes = readBoxes(Nil, n, 0)

    // calculate Boxes to contain ball
    val boxesToContainBall = calcBoxesToContainBall(r, boxes)

    // Output Result
    boxesToContainBall.foreach(x => println(x(0)))
    
    /*
    def readBoxes(boxes: List[List[Int]], N: Int, n: Int): List[List[Int]] = (n) match {
        case N => boxes.reverse
        case _ => readBoxes((n :: readLine.split(' ').map(_.toInt).toList) :: boxes, N, n + 1)
    }
    */

    def calcBoxesToContainBall(r: Int, boxes: List[List[Int]]): List[List[Int]] = {
        boxes.filter(x => (r*2 <= x(1) && r*2 <= x(2) && r*2 <= x(3)))
    }
}
