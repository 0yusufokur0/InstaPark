package com.veripark.instapark.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VDB : ViewDataBinding, VM : ViewModel>
    (@LayoutRes private val layoutRes: Int, private val viewModelClass: Class<VM>) : Fragment(),
    LifecycleObserver {

    private var _binding: VDB? = null
    val binding get() = _binding!!

    abstract fun init(savedInstanceState: Bundle?)

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return _binding!!.root
    }

    protected val viewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}