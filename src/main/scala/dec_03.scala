import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.control.Breaks._
// --- Day 3: Rucksack Reorganization ---
// https://adventofcode.com/2022/day/3


// Part 1
@main def main_03a(): Unit = {

    var priority_sum = 0
    
    val f = scala.io.Source.fromFile("input/dec_03_input.txt")
    for (line <- f.getLines()) {

        var compartment_1 = mutable.Set[Char]()
        var compartment_2 = mutable.Set[Char]()

        for (i <- 0 to line.length() - 1) {
            if (i < line.length() / 2) {
                compartment_1.add(line(i))
            } else if (compartment_1.contains(line(i)) &&  !compartment_2.contains(line(i))) {
                if (line(i).isUpper) {
                    priority_sum += line(i).toInt - 64 + 26
                } else {
                    priority_sum += line(i).toInt - 96
                }

                compartment_2.add(line(i))
            }
        }
    }
    println(priority_sum)
}


// Part 2
@main def main_03b(): Unit = {
    // Creates a HashMap with items as keys and 
    // a list of the elves having that item as value

    var priority_sum = 0
    var item_map = mutable.HashMap[Char, mutable.ArrayBuffer[Boolean]]()
    
    val f = scala.io.Source.fromFile("input/dec_03_input.txt")
    var lines = f.getLines().toArray

    for (line_num <- 0 to lines.length - 1) {
        var line = lines(line_num)

        // When we start a new group of elves we clear the item set
        if (line_num % 3 == 0) {
            item_map.clear()
        }

        breakable {
            for (i <- 0 to line.length() - 1) {
                val item = line(i)

                // Add item if it does not exist
                if (!item_map.contains(item)) {
                    item_map.update(item, mutable.ArrayBuffer(false, false, false))
                }

                // Mark elf has the item
                item_map(item)(line_num % 3) = true

                // Add priority of item if all elves have it
                if (item_map(item).forall(_ == true)) {
                    if (item.isUpper) {
                        priority_sum += item.toInt - 64 + 26
                    } else {
                        priority_sum += item.toInt - 96
                    }
                    break
                }
            }
        }
    }
    println(priority_sum)
}