object sheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
  
  val bound = 1000                                //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean
  
    def singletonSet(elem: Int): Set = {
    def si(arg: Int): Boolean = elem == arg
    si
  }                                               //> singletonSet: (elem: Int)Int => Boolean
    val s1 = singletonSet(1)                      //> s1  : Int => Boolean = <function1>
    val s2 = singletonSet(2)                      //> s2  : Int => Boolean = <function1>
    val s3 = singletonSet(3)                      //> s3  : Int => Boolean = <function1>
    val s4 = singletonSet(4)                      //> s4  : Int => Boolean = <function1>
      def union(s: Set, t: Set): Set = {
    def un(arg: Int): Boolean = {
      contains(s, arg) || contains(t, arg)
    }
    un
  }                                               //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  	val se12 = union(s1,s2)                   //> se12  : Int => Boolean = <function1>
  	val se34 = union(s3,s4)                   //> se34  : Int => Boolean = <function1>
  	val se = union(se12,se34)                 //> se  : Int => Boolean = <function1>
  	
  	def p(i: Int): Boolean = (i < 5)          //> p: (i: Int)Boolean
  	forall(se, p)                             //> res0: Boolean = true
  	
  	
}