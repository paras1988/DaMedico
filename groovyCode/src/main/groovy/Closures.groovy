class Closures {

  public static void main(String[] args) {

    ///////////////////////
    def closure = { println 'Simplest closure' }

    closure()
    closure.call()

    /////////////////
    def multiple = {
      println 'Simplest closure1'
      println 'Simplest closure2'
      println 'Simplest closure3'
    }

    multiple()
    ///////////////////

    def closureWithParams = { x, y -> println x + y }
    closureWithParams("Hey ", "UU")
    //////////////////////////
    //passing this to different closure.

    def add = { x, y -> println x + y }
    def subtract = { x, y -> println x - y }
    def multiply = { x, y -> println x * y }

    def closureInsideClosure = { x, y ->
      add(x, y)
      subtract(x, y)
      multiply(x, y)
    }

    closureInsideClosure.call(1, 2)
    ///////////////////////////////////////
    //another way to pass and call
    method(add)

    ///closure with return type
    def addWithReturn = { x -> x + 1 }

    def result = method2(addWithReturn)

    println result

    //IMPORTANT
    //more practical xample. here method3 can be in different class which do some operation before calling closure.
    //So basically i have 101(below example) do some operation on it from different class then call * or - operation.
    //this we can all do in one line. as we did in EntityAggregator.

    def mulRes = method3(101, 103, { x, y -> x * y })
    def subRes = method3(110, 103, { x, y -> x - y })

    println mulRes + "--" + subRes

    ///////////////////////////////////////////
    List<String> strs = ['java', 'groovy', 'LISP']

    //Simple
    List<Character> firs = strs.collect { it.charAt(0) }
    println firs

    //TO Practical
    def closureToGetFirstElementAndOtherOp = { String it -> it.charAt(0).toString() + "aa" }
    def listOfAllFirstElement = strs.collect {
      closureToGetFirstElementAndOtherOp(it)
    }
    println listOfAllFirstElement

  }

  static <T> T method3(int i, int j, Closure<T> closure) {
    closure.call(i - 100, j - 100);
  }

  static <T> T method2(Closure<T> closure) {
    closure.call(3)
  }

  static def method(Closure closure) {
    closure.call(1, 2)
  }
}
