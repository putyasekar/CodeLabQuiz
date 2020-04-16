package com.diki.idn.codelabquiz.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreVMFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreVM::class.java)) {
            return ScoreVM(finalScore) as T
        }
        throw IllegalArgumentException("Anonym View Model Class")
    }
}