package com.example.nikita.aac

import android.arch.lifecycle.MediatorLiveData
import com.example.nikita.aac.network.NetworkProvider
import com.example.nikita.aac.network.bean.UserBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserLiveData : MediatorLiveData<Pair<UserBean?, Throwable?>>() {
    private var disposable: Disposable? = null

    fun loadUser(id : Long) {
        disposable = NetworkProvider.getUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data -> this@UserLiveData.value = Pair(data, null) },
                        { error -> this@UserLiveData.value = Pair(null, error) })
    }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}