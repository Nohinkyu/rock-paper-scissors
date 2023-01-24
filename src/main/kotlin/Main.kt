fun main(args: Array<String>) {
    var shouldRestart = true

    while (shouldRestart){
        gameStart()
        shouldRestart = reGame()
    }
}

fun genElem ():String{
    val elem = listOf("rock", "paper", "scissors")
    return elem.random()
}

fun genTwoElem(): List<String>{
    var twoElem = mutableListOf<String>()
    twoElem.add(genElem())
    twoElem.add(genElem())
    return twoElem
}

fun computerChoiceElem(computerInput : List<String>) : String{
    val computerChoice = computerInput
    return computerChoice.random()
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

fun readTwoText() : List<String>{
    var inputList = mutableListOf<String>()
    inputList.add(readText())
    println("두번째 값을 입력해 주세요")
    inputList.add(readText())
    return inputList
}

fun readSecondText(userInput1:List<String>):String{
    var input = readLine()
    val userChoiceText = userInput1
    while (input.isNullOrBlank() || (input != userInput1[0] && input != userInput1[1])){
        println("다른 값을 입력하셨습니다 $userInput1 중 하나를 정확히 입력해주세요")
        input = readLine()
    }
    return input
}

fun gameStart(){
    val computerElem = genTwoElem()

    println("가위바위보 하나빼기 게임에 오신것을 환영합니다.")
    println("rock, paper, scissors 중 두가지를 정확히 입력해주세요.")
    println("첫번째 값을 입력해 주세요.")
    val userElem =readTwoText()
    userElem

    println("컴퓨터는 $computerElem 을 냈습니다.")
    println("유저님은 $userElem 을 냈습니다")
    println("$userElem 중 하나를 입력해주세요")
    val computer = computerChoiceElem(computerElem)
    val userChoice = readSecondText(userElem)
    userChoice
    println("컴퓨터는 $computer 를 냈습니다")
    println("유저님은 $userChoice 를 냈습니다")
    println(gameResult(userChoice, computer))

}

fun reGame() :Boolean {
    println("게임을 다시 시작하시겠습니까?[Y/N]")
    println("Y 또는 N 을 입력해 주세요")
    var reGameStart = readLine()
    val isY = {input: String? -> input == "Y" || input == "y" || input == "ㅛ"}
    val isN = {input: String? -> input == "N" || input == "n" || input == "ㅜ"}

    while (reGameStart.isNullOrBlank() || (!isY(reGameStart) && !isN(reGameStart))) {
        println("빈칸 또는 공백없이 Y 또는 N 을 입력해주세요")
        reGameStart = readLine()
    }
    return isY(reGameStart)
}




