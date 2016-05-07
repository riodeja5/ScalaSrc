object Test extends App {

	println(getFirst(List(3,2,1,2)))

	def getFirst[A](lst: List[A]): A = lst(0)
}
