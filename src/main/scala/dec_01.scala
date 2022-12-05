// --- Day 1: Calorie Counting ---
// https://adventofcode.com/2022/day/1


@main def main_01(): Unit = {

    var ab = collection.mutable.ArrayBuffer[Int]()
    var sum = 0 

    val f = scala.io.Source.fromFile("input/dec_01_input.txt")
    for (line <- f.getLines()) {
        if (line == "") {
            ab += sum
            sum = 0
        } else {
            sum += line.toInt
        }
    }

    val sorted_ab = ab.sorted(Ordering[Int].reverse)
    println(sorted_ab.slice(0, 3).sum)
}
