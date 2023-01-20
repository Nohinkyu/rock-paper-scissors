fun main(args: Array<String>) {
    println("가위바위보 게임에 오신것을 환영합니다.")
    println("rock, paper, scissors 중 하나를 입력해주세요")
    val start = genElem()
    val userPick = readText()
    println(userPick)
    println(gameResult(userPick, start))
}

fun genElem ():String{
    val elem = listOf("rock", "paper", "scissors")
    return elem.random()
}


fun readText():String{
    var input = readLine()
    while (input.isNullOrBlank() || (input != "rock" && input !="paper" && input != "scissors")){
        println("다른 값을 입력하셨습니다 rock, paper, scissors 중 하나를 정확히 입력해주세요")
        input = readLine()
    }
    return input
}

fun gameResult(userInput:String, opposite:String):String{
    val result = listOf("Draw", "Lose", "Win")
    if (userInput == opposite){
        return result[0]
    }
    else if ((userInput == "rock" && opposite == "paper")
        || (userInput == "paper" && opposite == "scissors")
        || (userInput == "scissors" && opposite == "rock")){
        return result[1]
    }
    else {
        return result[2]
    }
}


