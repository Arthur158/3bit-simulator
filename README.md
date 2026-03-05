# 3-bit computer

This is my implementation of a 3-bit computer, done in the context of Jetbrain internship application. To build the project, one can run `sbt build`, and then to run the test, one can run `sbt test`. 

To add test, one can modify the file `src/test/scala/TestSuite.scala`

The simulator is defined in `src/main/scala/Simulator.scala`.

I decided to have a parser, defined in  `src/main/scala/Parser.scala`, which would turn a number string into a list of instruction, whose syntax is defined in `src/main/scala/Syntax.scala`. I was first also translating the operand into a enum which could either be a register or a value, which was also handled during parsing, before I realized that one could also need the literal operands, which made me decide the combo conversion was a task best suited for the simulator, and operands are simply kepts as Integer during parsing. Because of this transformation, the parser looks slightly bare and maybe a bit unnecessary, even though it does add clarity to the simulator.
