package edu.us.ischool.yimengl.quizdroid

interface TopicRepository {
    fun getTopic(i : Int): Topic

    data class Quiz (
        val question: String,
        val answers:Array<String>,
        val correct: Int)

    data class Topic(
        val title: String,
        val shortDes: String,
        val longDes: String,
        val questions:Array<Quiz>)

//    companion object {
//        val math = Topic("Math","This is a Math Quiz!", "This is a Math Quiz! Are you ready?",
//            arrayOf(Quiz("Which one is prime number?", arrayOf("4","11","39","25"),2),
//                Quiz("11 * 11 = ?", arrayOf("121","211","321","161"),1),
//                Quiz("How many seconds is 9 minutes and 10 seconds?", arrayOf("176","1290","580","550"),4)
//            )
//        )
//        val physics = Topic("Physics","This is a Physics Quiz!","This is a Physics Quiz! Are you ready?",
//            arrayOf(Quiz("The laws of physics tell us that energy is:",
//                arrayOf("Conserved","Concerned","Constant","Contained"), 1),
//                Quiz("Which of the following is not a form of energy?", arrayOf("Light","Friction","Heat","Sound"),2),
//                Quiz("What’s the difference between weight and mass?", arrayOf("No difference","Mass is the amount of matter in an object, weight is the gravitational force on an object",
//                    "Mass is metric, weight is imperial","Mass is a measure of size, weight is a measure of density"),2)
//            )
//        )
//        val marvelSuperHeroes = Topic("Mavel Super Heroes", "This is a Marvel Super Heroes Quiz!","This is a Marvel Super Heroes Quiz! Are you ready?",
//            arrayOf(Quiz("Which is the real name of Iron Man?",
//                arrayOf("Sansa Stark","Arya Stark","Tony Stark","Brandon Stark"),3),
//                Quiz("Which of the following is not a Marvel Super Hero?",
//                    arrayOf("Captain America","Hulk","Thor","Super Man"),4),
//                Quiz("How many avengers movies are there?", arrayOf("1","2","3","4"),4)
//            )
//        )
//    }
}

