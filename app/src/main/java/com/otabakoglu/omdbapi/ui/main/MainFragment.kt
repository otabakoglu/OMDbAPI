package com.otabakoglu.omdbapi.ui.main

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.otabakoglu.omdbapi.OmdbApplication

import com.otabakoglu.omdbapi.R
import com.otabakoglu.omdbapi.databinding.FragmentMainBinding
import com.otabakoglu.omdbapi.ui.main.adapter.FilmGridAdapter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainVM by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with Main Fragment lifecycle
        binding.lifecycleOwner = this

        // Binding View Model to the MainFragment
        binding.viewModel = viewModel

        binding.recyclerView.adapter = FilmGridAdapter(FilmGridAdapter.OnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailFragment(
                    it
                )
            )
        })
        setHasOptionsMenu(true)
        showActionBar()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDagger()
    }

    private fun showActionBar(){
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    private fun injectDagger() {
        (requireActivity().application as OmdbApplication).appComponent.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem: MenuItem = menu.findItem(R.id.searchBar)

        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.queryHint = getString(R.string.search_film)
        searchView.setOnQueryTextListener(this)
        searchView.setIconifiedByDefault(true)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            viewModel.getFilm(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText.isNullOrBlank()) {
            viewModel.clearList()
        }
        return true
    }

}
