package com.example.redditchallenge

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.krakg.retrofit.RetrofitFactory
import com.example.redditchallenge.models.RickMortyModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DataManager {


    val retrofitInterface by lazy {
        RetrofitFactory.create()
    }

    private val chracterList: MutableLiveData<List<RickMortyModel.Result?>> by lazy {
        MutableLiveData<List<RickMortyModel.Result?>>().also {
            getCharacters()
        }
    }

    fun getCharacterList(): LiveData<List<RickMortyModel.Result?>> {
        getCharacters()
        return chracterList
    }

    fun getFilteredCharacters2(gender: String): LiveData<List<RickMortyModel.Result?>> {
        getFilteredCharacters(gender)
        return chracterList
    }

    @SuppressLint("CheckResult")
    private fun getCharacters() {
        retrofitInterface.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> chracterList.value = response.results },
                { error -> Log.e("ApiHandler", "API request error", error) }
            )
    }

    @SuppressLint("CheckResult")
    private fun getFilteredCharacters(gender: String) {
        retrofitInterface.getGenderCharacters(gender)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> chracterList.value = response.results },
                { error -> Log.e("ApiHandler", "API request error", error) }
            )
    }
}