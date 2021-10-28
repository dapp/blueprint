package com.xfinity.blueprint.architecture.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xfinity.blueprint.presenter.ScreenPresenter
import com.xfinity.blueprint.architecture.DefaultScreenView
import com.xfinity.blueprint.architecture.DefaultScreenViewArchitect
import com.xfinity.blueprint.architecture.activity.ScreenViewFragmentDelegate

abstract class ScreenViewFragment : androidx.fragment.app.Fragment() {
    abstract var architect: DefaultScreenViewArchitect
    private val screenViewFragmentDelegate = ScreenViewFragmentDelegate()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return screenViewFragmentDelegate.onCreateView(this, inflater, container, architect)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    abstract val presenter: ScreenPresenter<DefaultScreenView>
}