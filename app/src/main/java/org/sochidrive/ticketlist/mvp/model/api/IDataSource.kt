package org.sochidrive.ticketlist.mvp.model.api

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.entity.AuthData
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketAnswer
import retrofit2.http.*

interface IDataSource {

    @GET("auth_manager/{login}/{pass}/")
    fun getAuth(@Path("login") login: String, @Path("pass") password: String): Single<AuthAnswer>

    @POST("auth_manager/")
    fun getAuth(@Body authData: AuthData): Single<AuthAnswer>

    //@Headers("api-authorization-token: {token}")
    @POST("get_tickets/")
    fun getTickets(@Body manager: Manager, @Header("api-authorization-token") token: String): Single<TicketAnswer>
}