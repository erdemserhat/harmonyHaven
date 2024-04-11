package com.erdemserhat.harmonyhaven.domain.usecase.users

import android.util.Log
import com.erdemserhat.harmonyhaven.data.network.PasswordResetApiService
import com.erdemserhat.harmonyhaven.dto.requests.password_reset.PasswordResetFinalRequest
import com.erdemserhat.harmonyhaven.dto.responses.password_reset.PasswordResetFinalResponse
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class CompletePasswordResetAttempt @Inject constructor(
    private val passwordResetApiService: PasswordResetApiService
) {

    suspend fun executeRequest(complete: PasswordResetFinalRequest): PasswordResetFinalResponse? {
        try {
            val response = passwordResetApiService.completePasswordResetAttempt(complete)
            if (response.isSuccessful)
                return response.body()
            else {
                val errorJsonBody = response.errorBody()?.string()
                val errorBody =
                    Gson().fromJson(errorJsonBody, PasswordResetFinalResponse::class.java)
                return errorBody

            }

        } catch (e: Exception) {

            return null
        }


    }
}