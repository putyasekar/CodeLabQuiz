package com.diki.idn.codelabquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.diki.idn.codelabquiz.databinding.FragmentEndGameBinding
import com.diki.idn.codelabquiz.score.ScoreVM
import com.diki.idn.codelabquiz.score.ScoreVMFactory


/**
 * A simple [Fragment] subclass.
 */
class EndGameFragment : Fragment() {
    private lateinit var viewModel: ScoreVM
    private lateinit var viewModelFactory: ScoreVMFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEndGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_end_game, container, false)

//        viewModelFactory = ScoreVMFactory(EndGameFragment.fromBundle(arguments!!).score)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ScoreVM::class.java)

        //add observer for score
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.totalScore.text = newScore.toString()
        })
        return null //hapus ini
    }
}
