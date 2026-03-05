import org.scalatest.funsuite.AnyFunSuite

class MySuite extends AnyFunSuite {
  test("test 1") {
    val simulator = Simulator(Parser.parse("015430".toList).toArray, 3729, 0, 0)
    val result = simulator.simulate()
    assert(result === "042142567310")
  }
  test("test 2") {
    val simulator = Simulator(Parser.parse("035430".toList).toArray, 8642024, 0, 0)
    val result = simulator.simulate()
    assert(result === "57657040")
  }
  test("test 3 (xor operation)") {
    val simulator = Simulator(Parser.parse("17".toList).toArray, 0, 29, 0)
    simulator.simulate()
    assert(simulator.y === 26)
  }
}
