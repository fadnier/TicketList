package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.databinding.FragmentLoginBinding
import org.sochidrive.ticketlist.mvp.presenter.LoginPresenter
import org.sochidrive.ticketlist.mvp.view.LoginView
import org.sochidrive.ticketlist.ui.BackButtonListener
import org.sochidrive.ticketlist.ui.image.GlideImageLoader

class LoginFragment : MvpAppCompatFragment(), BackButtonListener, LoginView {
    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = LoginFragment()
    }

    val presenter by moxyPresenter {
        LoginPresenter().apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View  {
        binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding.root
    }


    override fun backPressed() = presenter.backClick()

    override fun init() {
        binding.buttonLogin.setOnClickListener { clickLoginBtn() }
    }

    override fun clickLoginBtn() {
        presenter.clickLoginBtn(binding.loginText.text.toString(),binding.passwordText.text.toString())
    }

    override fun loadLogo(url: String) {
        GlideImageLoader().loadInto(url,binding.logoTvintel);
    }

    override fun showMessage(message: String?) {
        message?.let { binding.textMsg.text = message }
    }

}