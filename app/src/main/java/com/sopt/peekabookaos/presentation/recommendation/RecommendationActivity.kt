package com.sopt.peekabookaos.presentation.recommendation

import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.peekabookaos.R
import com.sopt.peekabookaos.data.entity.Book
import com.sopt.peekabookaos.data.entity.FriendUser
import com.sopt.peekabookaos.databinding.ActivityRecommendationBinding
import com.sopt.peekabookaos.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendationActivity :
    BindingActivity<ActivityRecommendationBinding>(R.layout.activity_recommendation) {
    private val recommendationViewModel: RecommedationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = recommendationViewModel
        initCloseBtnOnClickListener()
        initCheckBtnOnClickListener()
        initView()
    }

    private fun initView() {
        recommendationViewModel.initRecommendData(
            // 추후 intent값 넘어올시 주석 제거
//            intent.getParcelable(BOOK_INFO, Book::class.java)!!,
//            intent.getParcelable(FRIEND_INFO, FriendUser::class.java)!!
            bookDummy,
            friendDummy
        )
    }

    private fun initCloseBtnOnClickListener() {
        binding.btnRecommendationClose.setOnClickListener {
            finish()
        }
    }

    private fun initCheckBtnOnClickListener() {
        binding.btnRecommendationCheck.setOnClickListener {
//            다이얼로그가 들어갈것이와요
        }
    }

    companion object {
        const val BOOK_INFO = "book_info"
        const val FRIEND_INFO = "friend_info"

        private val bookDummy = Book(
            bookImage = "http://image.yes24.com/goods/90365124/XL",
            bookTitle = "아무튼, 여름",
            author = "김신회",
            description = "",
            memo = ""
        )
        private val friendDummy = FriendUser(
            name = "문새연",
            profile = "",
            comment = ""
        )
    }
}