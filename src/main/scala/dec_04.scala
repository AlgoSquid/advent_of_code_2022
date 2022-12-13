import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.control.Breaks._
// --- Day 4: Camp Cleanup ---
// https://adventofcode.com/2022/day/4


// Part 1
@main def main_04a(): Unit = {
    // Create two ranges and check whether one is contained in the other

    var pairs = 0
    
    val f = scala.io.Source.fromFile("input/dec_04_input.txt")
    for (line <- f.getLines()) {
        val jobs = line.split(",").map(elf => elf.split("-"))
        val job_1 = Range.inclusive(jobs(0)(0).toInt, jobs(0)(1).toInt)
        val job_2 = Range.inclusive(jobs(1)(0).toInt, jobs(1)(1).toInt)
        if (job_1.containsSlice(job_2) || job_2.containsSlice(job_1)) {
            pairs += 1
        }
    }
    println(pairs)
}


// Part 2
@main def main_04b(): Unit = {
    // Create two ranges and check whether their intersection is non-empty

    var overlaps = 0
    
    val f = scala.io.Source.fromFile("input/dec_04_input.txt")
    for (line <- f.getLines()) {
        val jobs = line.split(",").map(elf => elf.split("-"))
        val job_1 = Range.inclusive(jobs(0)(0).toInt, jobs(0)(1).toInt)
        val job_2 = Range.inclusive(jobs(1)(0).toInt, jobs(1)(1).toInt)
        if (job_1.intersect(job_2).nonEmpty) {
            overlaps += 1
        }
    }
    println(overlaps)
}