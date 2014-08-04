package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def max(r: Int, c: Int) = {
      if (r > c) r else c
    }
    def min(r: Int, c: Int) = {
      if (r > c) c else r
    }
    def prod(from: Int, to: Int): Int = {
      def prodHelper(iter: Int, acc: Int): Int = {
        if (iter <= to-from) prodHelper(iter+1, acc*(from+iter)) else acc
      }      
      if (to == 0 || from > to) 1 else prodHelper(1, from)
    }
    
    if (c == 0 || r == 0 || c == r) 1 else prod(max(Math.abs(r-c),min(r,c))+1, max(r,c)) / prod(1, min(min(r,c), Math.abs(r-c)))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val inward: List[Char] = List[Char]()
    val outward: List[Char] = List[Char]()
    
    def balanceHelper(in: List[Char], curChars: List[Char]): Boolean =
      curChars match {
        case List() => in.isEmpty
        case he::ta => {
          he match {
            case '(' => balanceHelper(he :: in, ta)
            case ')' => if (in.isEmpty) false else balanceHelper(in.tail, ta)
            case _ => balanceHelper(in, ta)
          }
        }
      }
    
    balanceHelper(inward, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def ccHelper(money: Int, coins: List[Int]): Int = money match {
      case 0 if (coins.isEmpty) => 1 
      case i: Int if (i < 0) => 0
      case i: Int => if (coins.isEmpty) 0 else ccHelper(i - coins.head, coins) + ccHelper(i, coins.tail)
    }
    
    if (money == 0) 0 else ccHelper(money, coins)
  }
}
