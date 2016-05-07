object Main extends App{
	val sc = new java.util.Scanner(System.in)
	val t_1 = sc.nextInt
	val t_2 = sc.nextInt
	val t_3 = sc.nextInt
	val t_4 = sc.nextInt
	val t_5 = sc.nextInt
	val t_6 = sc.nextInt
	val t_7 = sc.nextInt

	val lstT = List(t_1, t_2, t_3, t_4, t_5, t_6, t_7)

	println(calcDaysToGoOut(lstT))

	def calcDaysToGoOut(lstT: List[Int]) = {
		lstT.filter(x => x <= 30).size
	}
}