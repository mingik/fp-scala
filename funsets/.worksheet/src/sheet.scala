object sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet")
  type Set = Int => Boolean;$skip(149); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(22); 
  
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(286); 

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
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(99); 
  
    def singletonSet(elem: Int): Set = {
    def si(arg: Int): Boolean = elem == arg
    si
  };System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(29); 
    val s1 = singletonSet(1);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(29); 
    val s2 = singletonSet(2);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(29); 
    val s3 = singletonSet(3);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(29); 
    val s4 = singletonSet(4);System.out.println("""s4  : Int => Boolean = """ + $show(s4 ));$skip(135); 
      def union(s: Set, t: Set): Set = {
    def un(arg: Int): Boolean = {
      contains(s, arg) || contains(t, arg)
    }
    un
  };System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(27); 
  	val se12 = union(s1,s2);System.out.println("""se12  : Int => Boolean = """ + $show(se12 ));$skip(27); 
  	val se34 = union(s3,s4);System.out.println("""se34  : Int => Boolean = """ + $show(se34 ));$skip(29); 
  	val se = union(se12,se34);System.out.println("""se  : Int => Boolean = """ + $show(se ));$skip(40); 
  	
  	def p(i: Int): Boolean = (i < 5);System.out.println("""p: (i: Int)Boolean""");$skip(17); val res$0 = 
  	forall(se, p);System.out.println("""res0: Boolean = """ + $show(res$0))}
  	
  	
}
