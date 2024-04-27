package com.venom.myquizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val q1 = Question(
            1, "What Country does this flag belong to?", R.drawable.ic_flag_of_india,"India", "China", "America", "Japan",1
        )
        val q2 = Question(
            2, "What Country does this flag belong to?", R.drawable.ic_flag_of_argentina,"India", "China", "Argentina", "Japan",3
        )
        val q3 = Question(
            3, "What Country does this flag belong to?", R.drawable.ic_flag_of_australia,"India", "China", "America", "Australia",4
        )
        val q4 = Question(
            4, "What Country does this flag belong to?", R.drawable.ic_flag_of_belgium,"India", "Belgium", "America", "Japan",2
        )
        val q5 = Question(
            5, "What Country does this flag belong to?", R.drawable.ic_flag_of_brazil,"India", "China", "Brazil", "Japan",3
        )
        val q6 = Question(
            6, "What Country does this flag belong to?", R.drawable.ic_flag_of_denmark,"India", "China", "America", "Denmark",4
        )
        val q7 = Question(
            7, "What Country does this flag belong to?", R.drawable.ic_flag_of_fiji,"India", "China", "America", "Fiji",4
        )
        val q8 = Question(
            8, "What Country does this flag belong to?", R.drawable.ic_flag_of_germany,"India", "Germany", "America", "Japan",2
        )
        val q9 = Question(
            9, "What Country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,"India", "China", "America", "New Zealand",4
        )
        val q10 = Question(
            10, "What Country does this flag belong to?", R.drawable.ic_flag_of_kuwait,"India", "China", "America", "Kuwait",4
        )
        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)
        return questionList
    }
}