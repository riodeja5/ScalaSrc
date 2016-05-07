object Main extends App{
	val sc = new java.util.Scanner(System.in)
	val n = sc.nextInt

	println(calcGameNum(n))

	def calcGameNum(p1: Int) = p1 * (p1 - 1) / 2
}