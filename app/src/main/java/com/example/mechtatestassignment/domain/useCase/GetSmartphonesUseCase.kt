package com.example.mechtatestassignment.domain.useCase

import com.example.mechtatestassignment.data.remote.model.handle
import com.example.mechtatestassignment.domain.dto.toModel
import com.example.mechtatestassignment.domain.model.Item
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class GetSmartphonesUseCase(
    private val remoteRepository: RemoteRepository,
    private val ioDispatcher: CoroutineContext
) {
    operator fun invoke(
        page: Int,
        limit: Int,
        selection: String
    ): Flow<List<Item>> = flow {
        val result = remoteRepository.getSmartphones(page, limit, selection)
        result.handle { data ->
            val items = data.data?.items?.map { dto -> dto.toModel() } ?: emptyList()
            emit(items)
        }
    }.flowOn(ioDispatcher)
}