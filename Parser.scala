import java.rmi.server.Operation
object Parser {
    def parse(program: List[Char]): List[Instruction] = program match {
        case first :: second :: rest => {
            val operation = first.toInt match {
                case 0 => xdv
                case 1 => yxl
                case 2 => yst
                case 3 => jnz
                case 4 => yxz
                case 5 => out
                case 6 => ydv
                case 7 => zdv
            }
            val operand = second.toInt match {
                case num if num >= 0 && num <= 3  => Num(num)
                case 4 => Reg(X)
                case 5 => Reg(Y)
                case 6 => Reg(Z)
                case incorrect => throw new Exception("Invalid operation: " ++ incorrect.toString())
            }
            Instruction(operation, operand) :: parse(rest)
        } 
        case Nil => Nil
        case _ => throw new Exception("Trailing operation with no operand")
    }
}
