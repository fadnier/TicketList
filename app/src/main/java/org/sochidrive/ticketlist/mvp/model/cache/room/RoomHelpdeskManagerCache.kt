package org.sochidrive.ticketlist.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskManagerCache
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.room.Database
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomManager

class RoomHelpdeskManagerCache(val db: Database): IHelpdeskManagerCache {
    override fun saveAuthManager(manager: Manager) = Completable.fromAction {
        val roomManager = RoomManager(id = manager.id,
            login = manager.login,
            name = manager.name,
            user_level = manager.user_level,
            token = manager.token)
        db.manager.deleteAll()
        db.manager.insert(roomManager)
    }.subscribeOn(Schedulers.io())


    override fun getAuthManager() = Single.fromCallable {
        db.manager.getCountManager().let {
            if (it>0) {
                db.manager.getManager().let { roomManager ->
                    AuthAnswer(
                        result = "ok",
                        data = Manager(answer = null,
                            id = roomManager.id,
                            login = roomManager.login,
                            name = roomManager.name,
                            user_level = roomManager.user_level,
                            token = roomManager.token)
                    )
                }
            } else {
                AuthAnswer(
                    result = "Error",
                    data = Manager(answer = null,
                        id = 0,
                        login = "",
                        name = "",
                        user_level = 0,
                        token = "")
                )
            }
        }
    }

    override fun delSaveManager() = Completable.fromAction {
        db.manager.deleteAll()
    }.subscribeOn(Schedulers.io())
}