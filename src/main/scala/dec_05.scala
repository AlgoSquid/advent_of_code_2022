import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.control.Breaks._
// --- Day 5: Supply Stacks ---
// https://adventofcode.com/2022/day/5


// Part 1
@main def main_05a(): Unit = {
    // Create array with dequeues for each stack and operate changes with a stack

    var stacks = mutable.ArrayBuffer[mutable.ArrayDeque[Char]]()
    
    val f = scala.io.Source.fromFile("input/dec_05_input.txt")
    for (line <- f.getLines()) {
        if (line.startsWith("move")) {
            // Move action
            val commands = line.split(" from ")
            val stack_num = commands(1).split(" to ").map(n => n.toInt - 1)
            for (_ <- 0 to commands(0).substring(5).toInt - 1) {
                val crate = stacks(stack_num(0)).removeLast()
                stacks(stack_num(1)).append(crate)
            }
        } else {
            // Construct correct number of stacks
            if (stacks.length == 0) {
                stacks = mutable.ArrayBuffer.fill((line.length() + 1) / 4)(mutable.ArrayDeque[Char]())
            }
            
            // Construct starting stack
            for (i <- 1 to line.length() by 4) {
                if (line(i).isLetter) {
                    stacks(i / 4).prepend(line(i))
                }
            }
        }
    }
    println(stacks.map(stack => stack.last).mkString)
}


// Part 2
@main def main_05b(): Unit = {
    // Create array with dequeues for each stack and operate changes with a queue

    var stacks = mutable.ArrayBuffer[mutable.ArrayDeque[Char]]()
    
    val f = scala.io.Source.fromFile("input/dec_05_input.txt")
    for (line <- f.getLines()) {
        if (line.startsWith("move")) {
            // Move action
            val commands = line.split(" from ")
            val stack_num = commands(1).split(" to ").map(n => n.toInt - 1)

            var temp_queue = mutable.ArrayBuffer[Char]() 
            for (_ <- 0 to commands(0).substring(5).toInt - 1) {
                temp_queue.append(stacks(stack_num(0)).removeLast())
            }
            stacks(stack_num(1)).appendAll(temp_queue.reverse)

        } else {
            // Construct correct number of stacks
            if (stacks.length == 0) {
                stacks = mutable.ArrayBuffer.fill((line.length() + 1) / 4)(mutable.ArrayDeque[Char]())
            }
            
            // Construct starting stack
            for (i <- 1 to line.length() by 4) {
                if (line(i).isLetter) {
                    stacks(i / 4).prepend(line(i))
                }
            }
        }
    }
    println(stacks.map(stack => stack.last).mkString)
}
