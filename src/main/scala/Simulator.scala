class Simulator(val instructions: Array[Instruction], var x: Int, var y: Int, var z: Int) {

    var instruction_pointer = 0
    var output = ""

    def step() = {
        val Instruction(operation, operand) = instructions(instruction_pointer)
        instruction_pointer = instruction_pointer + 1 // Here it is increased by 1 since we had a parsing step first
        operation match {
            case Xdv => x = x / math.pow(2, getCombo(operand)).toInt // scala automatically truncates
            case Yxl => y = y ^ operand 
            case Yst => y = getCombo(operand) % 8
            case Jnz => if x != 0 then instruction_pointer = operand
            case Yxz => y = y ^ z // Operand is ignored, no issue there
            case Out => output = output ++ (getCombo(operand) % 8).toString
            case Ydv => y = x / math.pow(2, getCombo(operand)).toInt // scala automatically truncates
            case Zdv => z = x / math.pow(2, getCombo(operand)).toInt // scala automatically truncates
        }
    }

    def simulate(): String = {
        while(instruction_pointer < instructions.length) step()
        output
        // When exactly does the program halt? Best guess for now, IP is outside of reach
    }

    def getCombo(operand: Int): Int = operand match {
        case num if num >= 0 && num <= 3  => num
        case 4 => x
        case 5 => y
        case 6 => z
        case incorrect => throw new Exception("Invalid operation: " ++ incorrect.toString())
    }
}
