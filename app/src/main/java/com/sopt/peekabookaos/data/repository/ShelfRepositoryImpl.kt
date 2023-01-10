package com.sopt.peekabookaos.data.repository

import com.sopt.peekabookaos.data.entity.response.MyShelfResponse
import com.sopt.peekabookaos.data.source.remote.ShelfDataSource
import javax.inject.Inject

class ShelfRepositoryImpl @Inject constructor(
    private val shelfDataSource: ShelfDataSource
) : ShelfRepository {
    override suspend fun getMyShelf(): Result<MyShelfResponse> =
        kotlin.runCatching { shelfDataSource.getMyShelf() }.map { response ->
            response.data!!
        }
}
