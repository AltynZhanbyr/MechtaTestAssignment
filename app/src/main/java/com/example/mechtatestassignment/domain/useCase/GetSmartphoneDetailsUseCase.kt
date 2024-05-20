package com.example.mechtatestassignment.domain.useCase

import com.example.mechtatestassignment.data.mapper.toModel
import com.example.mechtatestassignment.data.remote.model.handle
import com.example.mechtatestassignment.domain.model.ItemDetails
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSmartphoneDetailsUseCase(
    private val remoteRepository: RemoteRepository
) {
    operator fun invoke(code: String): Flow<ItemDetails> = flow {
        val result = remoteRepository.getSmartphoneDetails(code)
        result.handle {
            emit(result.data!!.toModel())
        }
    }
}