case class Instruction(operation: Operation, operand: Operand)

sealed trait Operation
case object xdv extends Operation
case object yxl extends Operation
case object yst extends Operation
case object jnz extends Operation
case object yxz extends Operation
case object out extends Operation
case object ydv extends Operation
case object zdv extends Operation

sealed trait Operand
case class Num(v: Int) extends Operand
case class Reg(r: Register) extends Operand

sealed trait Register
case object X extends Register
case object Y extends Register
case object Z extends Register
