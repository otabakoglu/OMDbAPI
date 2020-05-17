package com.otabakoglu.omdbapi.ui.splash

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.otabakoglu.omdbapi.OmdbApplication

import com.otabakoglu.omdbapi.databinding.FragmentSplashBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SplashVM by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplashBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        subscribeNavigateMainFragment()

        hideActionBar()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDagger()
    }

    private fun injectDagger(){
        (requireActivity().application as OmdbApplication).appComponent.inject(this)
    }

    private fun hideActionBar(){
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun subscribeNavigateMainFragment(){
        viewModel.navigateMainFragment.observe(this, Observer {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
        })
    }

}
