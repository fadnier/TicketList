package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.presenter.LoginPresenter
import org.sochidrive.ticketlist.mvp.view.LoginView
import org.sochidrive.ticketlist.ui.BackButtonListener
import org.sochidrive.ticketlist.ui.image.GlideImageLoader

class LoginFragment : MvpAppCompatFragment(), BackButtonListener, LoginView {

    companion object {
        fun newInstance() = LoginFragment()
    }

    val presenter by moxyPresenter {
        LoginPresenter().apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            View.inflate(context, R.layout.fragment_login, null)

    override fun backPressed() = presenter.backClick()

    override fun init() {
        buttonLogin.setOnClickListener { clickLoginBtn() }
    }

    override fun clickLoginBtn() {
        presenter.clickLoginBtn(loginText.text.toString(),passwordText.text.toString())
    }

    override fun loadLogo(url: String) {
        GlideImageLoader().loadInto(url,logoTvintel);
    }

    override fun showMessage(message: String?) {
        message?.let { textMsg.text = message }
    }

}