package org.sochidrive.ticketlist.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.entity.Manager

interface IHelpdeskManagerCache {
    fun saveAuthManager(manager: Manager): Completable
    fun getAuthManager(): Single<AuthAnswer>
    fun delSaveManager(): Completable
}