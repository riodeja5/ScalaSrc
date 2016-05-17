object Main extends App {

    val sc = new java.util.Scanner(System.in)

    // Input N
    val N = sc.nextInt

    // Input words(a_N)
    var words: List[String] = Nil
    for (x <- 1 to N) {
        val word = sc.next
        words = word :: words
    }
    words = words.reverse

    // to plural
    val plurals = words.map(convSingular2Plural)

    // Output Result
    plurals.foreach(x => println(x))

    def convSingular2Plural(word: String): String = {
        val pattern1 = """\w*(s|sh|ch|o|x)$""".r
        val pattern2 = """\w*(f|fe)$""".r
        val pattern3 = """\w*[b-df-hj-np-tv-z](y)$""".r
        word match {
            case pattern1(_*)   => word + "es"
            case pattern2(post) => word.patch(word.size - post.size, "ves", post.size)
            case pattern3(post) => word.patch(word.size - post.size, "ies", post.size)
            case _              => word + "s"
        }
    }
}
