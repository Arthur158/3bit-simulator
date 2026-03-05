@main def Main(): Unit = {
  println(Parser.parse("015430".toList))
  val simulator = Simulator(Parser.parse("015430".toList).toArray, 3729, 0, 0)
  println(simulator.simulate())
}
