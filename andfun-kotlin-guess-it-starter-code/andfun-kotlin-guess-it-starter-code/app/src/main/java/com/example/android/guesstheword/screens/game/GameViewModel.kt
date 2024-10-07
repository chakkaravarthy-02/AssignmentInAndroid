package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private val CORRECT_BUZZ_PATTERN = longArrayOf(100,100,100,100,100,100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0,200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0,2000)
private val NO_BUZZ_PATTERN = longArrayOf(0)

class GameViewModel : ViewModel() {

    companion object{
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
        private const val COUNTDOWN_TIME = 10000L
    }

    private val timer : CountDownTimer

    // The current word
    private var _word = MutableLiveData<String>()
    val word:LiveData<String>
        get() = _word

    // The current score
    private var _score = MutableLiveData<Int>()
    val score:LiveData<Int>
        get() = _score

    private var _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish : LiveData<Boolean>
        get() = _eventGameFinish

    private var _eventBuzzOn = MutableLiveData<BuzzType>()
    val eventBuzzOn : LiveData<BuzzType>
        get() = _eventBuzzOn


    private var _time = MutableLiveData<Long>()

    private var _newTime = MutableLiveData<String>()
    val newTime : LiveData<String>
        get() = _newTime

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        _eventGameFinish.value=false
        resetList()
        nextWord()
        _score.value = 0

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){

            override fun onTick(milisUntilFinished: Long) {
                _time.value=milisUntilFinished/1000
                if(milisUntilFinished< COUNTDOWN_TIME/4){
                    _eventBuzzOn.value = BuzzType.COUNTDOWN_PANIC
                }
                _newTime.value = DateUtils.formatElapsedTime(_time.value!!)
            }

            override fun onFinish() {
                _eventBuzzOn.value = BuzzType.GAME_OVER
                _eventGameFinish.value=true
            }
        }

        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)
    }

    fun onSkip() {
        _score.value=(score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _eventBuzzOn.value = BuzzType.CORRECT
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value=false
    }
}

enum class BuzzType(val pattern : LongArray){
    CORRECT(CORRECT_BUZZ_PATTERN),
    GAME_OVER(GAME_OVER_BUZZ_PATTERN),
    COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
    NO_BUZZ(NO_BUZZ_PATTERN)
}