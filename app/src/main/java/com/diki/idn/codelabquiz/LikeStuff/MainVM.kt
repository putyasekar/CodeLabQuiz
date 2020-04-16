package com.diki.idn.codelabquiz.LikeStuff

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {
    private val _likeNumber = MutableLiveData(0)

    val likeNumbers: LiveData<Int> = _likeNumber

    val popularity: LiveData<MainObservableViewModel.LikeNumbers> =
        Transformations.map(_likeNumber) {
            when {
                it > 30 -> MainObservableViewModel.LikeNumbers.NORMAL
                it > 20 -> MainObservableViewModel.LikeNumbers.STAR
                else -> MainObservableViewModel.LikeNumbers.POPULAR
            }
        }

    fun onLike() {
        _likeNumber.value = (_likeNumber.value ?: 0) + 1
    }
}

class MainObservableViewModel : MainBaseObservableViewModel() {
    enum class LikeNumbers {
        NORMAL, STAR, POPULAR
    }
}