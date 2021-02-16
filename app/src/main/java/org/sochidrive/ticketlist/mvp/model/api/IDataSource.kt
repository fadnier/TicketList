package org.sochidrive.ticketlist.mvp.model.api

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Answer
import retrofit2.http.*

interface IDataSource {

    @GET("auth_manager/{login}/{pass}/")
    fun getAuth(@Path("login") login: String, @Path("pass") password: String): Single<Answer>

    @POST("auth_manager/")
    fun getAuth(@Body authData: AuthData): Single<Answer>
}