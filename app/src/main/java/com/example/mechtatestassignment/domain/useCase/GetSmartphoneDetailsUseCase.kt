package com.example.mechtatestassignment.domain.useCase

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.DataDetailsDto
import com.example.mechtatestassignment.data.remote.model.handle
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSmartphoneDetailsUseCase(
    private val remoteRepository: RemoteRepository
) {
    operator fun invoke(code: String): Flow<DataDetailsDto> = flow {
        val result = remoteRepository.getSmartphoneDetails(code)
        result.handle {
            emit(result.data!!)
        }
    }
}