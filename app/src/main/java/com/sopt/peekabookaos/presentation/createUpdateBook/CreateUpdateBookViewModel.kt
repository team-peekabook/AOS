package com.sopt.peekabookaos.presentation.createUpdateBook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateUpdateBookViewModel : ViewModel() {
    private val _createUpdateBookData = MutableLiveData<CreateUpdateBook>()
    val createUpdateBookData: LiveData<CreateUpdateBook> = _createUpdateBookData


    val comment = MutableLiveData("")

    val memo = MutableLiveData("")

    init {
        initRegisterBookData()
    }

    /* 더미데이터. 추후 서버 통신 시 제거 예정 */
    private fun initRegisterBookData() {
        _createUpdateBookData.value = BookRegister(
            img = "http://image.yes24.com/goods/90365124/XL",
            title = "아무튼, 여름",
            author = "김신회",
            comment = "",
            memo = ""
        )
    }
}
