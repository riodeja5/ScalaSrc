object Main extends App{
	val sc = new java.util.Scanner(System.in)
	val a = sc.nextInt
	val b = sc.nextInt

	println(Add(a, b))

	def Add(p1: Int, p2: Int) = p1 + p2
}