object Parser {
    def parse(program: List[Char]): List[Instruction] = program match {
        case first :: second :: rest => {
            val operation = first - '0' match {
                case 0 => Xdv
                case 1 => Yxl
                case 2 => Yst
                case 3 => Jnz
                case 4 => Yxz
                case 5 => Out
                case 6 => Ydv
                case 7 => Zdv
                case x => throw Exception("Incorrect, got: " ++ first.toString)
            }
            val operand = second - '0'
            Instruction(operation, operand) :: parse(rest)
        } 
        case Nil => Nil
        case _ => throw new Exception("Trailing operation with no operand")
    }
}
