package edu.us.ischool.yimengl.quizdroid

class TopicRepoClass : TopicRepository {
    override fun getTopic(i: Int): TopicRepository.Topic {
        lateinit var arrayOfTopics: Array<TopicRepository.Topic>
        val math = TopicRepository.Topic(
            "Math", "This is a Math Quiz!", "This is a Math Quiz! Are you ready?",
            arrayOf(
                TopicRepository.Quiz("Which one is prime number?", arrayOf("4", "11", "39", "25"), 2),
                TopicRepository.Quiz("11 * 11 = ?", arrayOf("121", "211", "321", "161"), 1),
                TopicRepository.Quiz(
                    "How many seconds is 9 minutes and 10 seconds?",
                    arrayOf("176", "1290", "580", "550"),
                    4
                )
            )
        )
        val physics = TopicRepository.Topic(
            "Physics", "This is a Physics Quiz!", "This is a Physics Quiz! Are you ready?",
            arrayOf(
                TopicRepository.Quiz(
                    "The laws of physics tell us that energy is:",
                    arrayOf("Conserved", "Concerned", "Constant", "Contained"), 1
                ),
                TopicRepository.Quiz(
                    "Which of the following is not a form of energy?",
                    arrayOf("Light", "Friction", "Heat", "Sound"),
                    2
                ),
                TopicRepository.Quiz(
                    "What’s the difference between weight and mass?", arrayOf(
                        "No difference",
                        "Mass is the amount of matter in an object, weight is the gravitational force on an object",
                        "Mass is metric, weight is imperial",
                        "Mass is a measure of size, weight is a measure of density"
                    ), 2
                )
            )
        )
        val marvelSuperHeroes = TopicRepository.Topic(
            "Mavel Super Heroes",
            "This is a Marvel Super Heroes Quiz!",
            "This is a Marvel Super Heroes Quiz! Are you ready?",
            arrayOf(
                TopicRepository.Quiz(
                    "Which is the real name of Iron Man?",
                    arrayOf("Sansa Stark", "Arya Stark", "Tony Stark", "Brandon Stark"), 3
                ),
                TopicRepository.Quiz(
                    "Which of the following is not a Marvel Super Hero?",
                    arrayOf("Captain America", "Hulk", "Thor", "Super Man"), 4
                ),
                TopicRepository.Quiz("How many avengers movies are there?", arrayOf("1", "2", "3", "4"), 4)
            )
        )
        arrayOfTopics = arrayOf(math,physics,marvelSuperHeroes)
        return arrayOfTopics[i]
    }
}
