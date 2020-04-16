package com.diki.idn.codelabquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.diki.idn.codelabquiz.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    data class Questions(
        val text: String,
        val answer: List<String>
    )

    private val questions: MutableList<Questions> = mutableListOf(
        Questions(
            text = "Mt. Fuji is the highest point in what Asian country?",
            answer = listOf("Bangladesh", "Indonesia", "China", "Japan")
        ),
        Questions(
            text = "What is western Asia's longest river?",
            answer = listOf("Tigris", "Xi Jang", "Kurobes", "Euphrates")
        ),
        Questions(
            text = "What tiny country, known to its inhabitants as Druk Yul (Land of the Thunder Dragon), is sandwiched between China and India?",
            answer = listOf("Bhutan", "Bangladesh", "Mongolia", "Burma")
        ),
        Questions(
            text = "What mountain range runs along the northern border of India?",
            answer = listOf("Urul", "Tatra", "Himalaya", "Everest")
        ),
        Questions(
            text = "Korea is separated from Japan by what strait?",
            answer = listOf(
                "Cheju",
                "Tsushima",
                "Gibraltar",
                "Bungo"
            )
        ),
        Questions(
            text = "Iran is slightly larger than what U.S. state?",
            answer = listOf("Rhode", "Montana", "Texas", "Alaska")
        ),
        Questions(
            text = "What Chinese city is situated at the mouth of the Chang Jiang (Yangtze) River?",
            answer = listOf(
                "Shanghai",
                "Beijing",
                "Taipei",
                "Changgun"
            )
        ),
        Questions(
            text = "What is the tallest mountain in Asia?",
            answer = listOf("Qogir", "Au dah", "Cho Oyu", "Mount Everest")
        ),
        Questions(
            text = "What Japanese city is the site of the Peace Memorial Park and the eternal Peace Flame which is never to be extinguished until all nuclear weapons are dismantled?",
            answer = listOf("Hiroshima", "Nagasaki", "Tokyo", "Kyoto")
        ),
        Questions(
            text = "What is the capital of Indonesia?",
            answer = listOf("Jakarta", "Kalimantan", "Bandung", "Yogyakarta")
        )
    )

    lateinit var currentQuestions: Questions
    lateinit var answer: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 5)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        randomizeQuestions()
        binding.game = this
        binding.buttonSubmit.setOnClickListener { view: View ->
            val checkedId = binding.rgGame.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerPosition = 0
                when (checkedId) {
                    R.id.radioButton2 -> answerPosition = 1
                    R.id.radioButton3 -> answerPosition = 2
                    R.id.radioButton4 -> answerPosition = 3
                }
                if (answer[answerPosition] == currentQuestions.answer[0]) {
                    questionIndex++
                    if (questionIndex < numQuestions) {
                        currentQuestions = questions[questionIndex]
                        setQuestions()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(R.id.action_gameFragment2_to_endGameFragment2)
                    }
                }
            }
        }
        return binding.root
    }

    private fun setQuestions() {
        currentQuestions = questions[questionIndex]
        answer = currentQuestions.answer.toMutableList()
        answer.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_trivia_question, questionIndex + 1, numQuestions)
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestions()
    }
}

