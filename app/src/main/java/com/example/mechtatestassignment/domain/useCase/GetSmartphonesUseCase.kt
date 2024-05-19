package com.example.mechtatestassignment.domain.useCase

import com.example.mechtatestassignment.data.mapper.toModel
import com.example.mechtatestassignment.domain.model.Item
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import retrofit2.HttpException
import java.io.IOException

class GetSmartphonesUseCase(
    private val remoteRepository: RemoteRepository
) {
    suspend operator fun invoke(
        page: Int,
        limit: Int
    ): Result<List<Item>> {
        try {
            val result = remoteRepository.getSmartphones(page, limit)
            val isSuccess = result.data != null && result.result
            if (isSuccess) return Result.success(result.data?.items?.map { dto ->
                dto.toModel()
            } ?: emptyList())

            if (!result.result && result.errors.isNotEmpty()) return Result.failure(Exception(result.errors[0]))

            return Result.failure(Exception("An unexpected error occurred"))

        } catch (e: IOException) {
            return Result.failure(Exception("Couldn't reach server. Check your internet connection."))
        } catch (e: HttpException) {
            return Result.failure(Exception(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}
