package org.sochidrive.ticketlist.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}