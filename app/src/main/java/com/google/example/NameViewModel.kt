package com.google.example

import android.annotation.SuppressLint
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import com.google.example.db.user.User
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class NameViewModel(val arg: String) : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val liveData1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val liveData2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mediatorLiveData: MediatorLiveData<String> by lazy {
        MediatorLiveData<String>()
    }

    val db by lazy {
        App.getInstance().getDatabase()
    }

    init {
        mediatorLiveData.addSource(liveData1, {
            mediatorLiveData.value = it
        })

        mediatorLiveData.addSource(liveData2, {
            mediatorLiveData.value = it
        })
    }

    @SuppressLint("CheckResult")
    fun insertUser(userName: String) {
        val user = com.google.example.db.user.User(firstName = userName, lastName = "Smith")
        Single.create<Boolean> {
            db.userDao().insertAll(user)
            it.onSuccess(true)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val result = it
                },{
                    Log.e("Room", "Insert")
                })
    }

    @SuppressLint("CheckResult")
    fun selectUsers() {
        Single.create<List<User>> {
            val list = db.userDao().getAll()
            if(list != null) {
                it.onSuccess(list)
            } else {
                it.onError(Throwable("Select error"))
            }
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val result = it
                }, {
                    Log.e("Room", "Select")
                })
    }

    fun insertComment(userId: Int) {

    }

    fun checkArg() {
        val arg = this.arg
    }

    // Rest of the ViewModel...

    override fun onCleared() {
        super.onCleared()
    }

    class NameViewFactory(val arg: String) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return NameViewModel(arg) as T
        }
    }
}