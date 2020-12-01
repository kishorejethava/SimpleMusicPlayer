package com.kishorejethava.simplemusicplayer.base

import com.kishorejethava.simplemusicplayer.model.BaseResult
import com.kishorejethava.simplemusicplayer.model.Resource
import com.kishorejethava.simplemusicplayer.utils.Constants.SOMETHING_WENT_WRONG
import retrofit2.Response

open class AppRepository {

    suspend fun <T : BaseResult> safeApiCall(call: suspend () -> Response<T>): BaseResult? {
        val result: Resource<T> = safeApiResult(call)
        var data: BaseResult? = null
        when (result) {
            is Resource.Success -> data = result.data
        }
        return data
    }

    private suspend fun <T : BaseResult> safeApiResult(call: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful && response.body() != null) {
                if (response.code() == 200) {
                    Resource.Success(response.body()!!)
                } else {
                    Resource.Error(SOMETHING_WENT_WRONG)
                }
            } else {
                Resource.Error(SOMETHING_WENT_WRONG)
            }
        } catch (error: Exception) {
            Resource.Error(SOMETHING_WENT_WRONG)
        }
    }
}