// --- Day 2: Rock Paper Scissors ---
// https://adventofcode.com/2022/day/2


// Part 1
@main def main_02a(): Unit = {

    var score = 0

    val f = scala.io.Source.fromFile("input/dec_02_input.txt")
    for (line <- f.getLines()) {

        val opp = line(0).toInt - 64    // A is 65
        val guide = line(2).toInt - 87  // X is 88

        // Shape score and outcome of round
        score += guide
        if (opp == guide) {
            score += 3
        } else if (opp + 1 == guide || opp - 2 == guide) {
            score += 6
        }
    }
    println(score)
}


// Part 2
@main def main_02b(): Unit = {

    var score = 0

    val f = scala.io.Source.fromFile("input/dec_02_input.txt")
    for (line <- f.getLines()) {

        val opp = line(0).toInt - 64    // A is 65
        val guide = line(2).toInt - 87  // X is 88

        if (guide == 1) {
            score += 0 + (if (opp > 1) opp - 1 else 3) 
        } else if (guide == 2) {
            score += 3 + opp
        } else {
            score += 6 + (if (opp < 3) opp + 1 else 1)
        }
    }

    println(score)
}
