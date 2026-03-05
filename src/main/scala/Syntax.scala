case class Instruction(operation: Operation, operand: Int)

sealed trait Operation
case object Xdv extends Operation
case object Yxl extends Operation
case object Yst extends Operation
case object Jnz extends Operation
case object Yxz extends Operation
case object Out extends Operation
case object Ydv extends Operation
case object Zdv extends Operation
