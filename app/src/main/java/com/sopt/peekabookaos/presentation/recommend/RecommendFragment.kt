package com.sopt.peekabookaos.presentation.recommend

import android.os.Bundle
import android.view.View
import com.sopt.peekabookaos.R
import com.sopt.peekabookaos.data.entity.Recommend
import com.sopt.peekabookaos.databinding.FragmentRecommendBinding
import com.sopt.peekabookaos.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendFragment :
    BindingFragment<FragmentRecommendBinding>(R.layout.fragment_recommend) {
    private val recommendAdapter: BookRecommendAdapter?
        get() = binding.rvRecommend.adapter as? BookRecommendAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTextAppearance()
        initAdapter()
        initRecommendedClickListener()
        initRecommendingClickListener()
    }

    private fun initRecommendedClickListener() {
        binding.tvRecommendRecommended.setOnClickListener {
            recommendAdapter?.submitList(recommendedList)
            with(binding) {
                tvRecommendRecommended.isSelected = true
                tvRecommendRecommending.isSelected = false
                if (tvRecommendRecommended.isSelected) {
                    tvRecommendRecommending.setTextAppearance(R.style.H4)
                    tvRecommendRecommended.setTextAppearance(R.style.NameBd)
                }
            }
        }
    }

    private fun initRecommendingClickListener() {
        binding.tvRecommendRecommending.setOnClickListener {
            recommendAdapter?.submitList(recommendingList)
            with(binding) {
                tvRecommendRecommended.isSelected = false
                tvRecommendRecommending.isSelected = true
                if (tvRecommendRecommending.isSelected) {
                    tvRecommendRecommending.setTextAppearance(R.style.NameBd)
                    tvRecommendRecommended.setTextAppearance(R.style.H4)
                }
            }
        }
    }

    private fun initTextAppearance() {
        with(binding) {
            tvRecommendRecommended.isSelected = true
            tvRecommendRecommended.setTextAppearance(R.style.NameBd)
        }
    }

    private fun initAdapter() {
        binding.rvRecommend.adapter = BookRecommendAdapter()
    }

    }
}
