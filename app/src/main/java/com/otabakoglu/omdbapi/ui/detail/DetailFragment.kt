package com.otabakoglu.omdbapi.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.otabakoglu.omdbapi.OmdbApplication

import com.otabakoglu.omdbapi.databinding.FragmentDetailBinding
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DetailVM by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arguments?.let {
            val property = DetailFragmentArgs.fromBundle(requireArguments()).property
            viewModel.setProperty(property)
        }

        val binding = FragmentDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDagger()
    }

    private fun injectDagger(){
        (requireActivity().application as OmdbApplication).appComponent.inject(this)
    }

}
