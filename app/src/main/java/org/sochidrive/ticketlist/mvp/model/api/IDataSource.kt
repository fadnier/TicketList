package org.sochidrive.ticketlist.mvp.model.api

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.*
import retrofit2.http.*

interface IDataSource {

    @GET("auth_manager/{login}/{pass}/")
    fun getAuth(@Path("login") login: String, @Path("pass") password: String): Single<AuthAnswer>

    @POST("auth_manager/")
    fun getAuth(@Body authData: AuthData): Single<AuthAnswer>

    @POST("get_tickets_full/")
    fun getTickets(@Body manager: Manager, @Header("api-authorization-token") token: String): Single<TicketAnswer>

    @POST("get_tickets_id/")
    fun getTicketsId(@Body ticketData: TicketData, @Header("api-authorization-token") token: String): Single<TicketDetailAnswer>
}