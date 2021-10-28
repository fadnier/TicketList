package org.sochidrive.ticketlist

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.presenter.LoginPresenter
import org.sochidrive.ticketlist.mvp.view.LoginView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router

class Test {


    private lateinit var presenter: LoginPresenter

    @Mock
    private lateinit var router: Router

    @Mock
    private lateinit var view: LoginView

    @Mock
    private lateinit var authManager: IHelpdeskLogin

    @Mock
    private lateinit var mainThreadScheduler: Scheduler

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LoginPresenter()
        presenter.router = router
        presenter.authManager = authManager
        presenter.mainThreadScheduler = mainThreadScheduler
        presenter.attachView(view)
    }

    @Test
    fun checkBackClick() {
        presenter.backClick()
        verify(router, times(1)).exit()
    }

    @Test
    fun checkAuthOk() {
//        var answ = mock(AuthAnswer::class.java)
//        `when`(answ.result).thenReturn("Ok")
//        `when`(answ.data.name).thenReturn("Login")
        var answ = AuthAnswer(result = "Ok",
            Manager(answer = null, id = 1, name = "", login = "", user_level = 1, token = ""))
        presenter.auth(answ)
        verify(view, times(1)).showMessage("Успешно: "+answ.data.name)
    }

    @Test
    fun checkAuthError() {
        var answ = AuthAnswer(result = "Error",
            Manager(answer = null, id = 1, name = "", login = "", user_level = 1, token = ""))
        presenter.auth(answ)
        verify(view, times(1)).showMessage(answ.data.answer)
    }
}