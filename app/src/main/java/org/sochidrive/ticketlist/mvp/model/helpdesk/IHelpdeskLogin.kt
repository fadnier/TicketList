package org.sochidrive.ticketlist.mvp.model.helpdesk

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer

interface IHelpdeskLogin {
    fun getAuth(login: String, password: String): Single<AuthAnswer>
}