package com.example.coroutines_retrofit.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines_retrofit.R
import com.example.coroutines_retrofit.adapter.AdapterUser
import com.example.coroutines_retrofit.databinding.MainFragmentBinding
import com.example.coroutines_retrofit.model.Users
import com.example.coroutines_retrofit.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private val adapter = AdapterUser()

    private val userObserver = Observer<List<Users>> { newList ->
        adapter.refresh(newList)
    }
    private val errorObserver = Observer<String> { error ->
        Snackbar.make(requireView(), error, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.userResponse.observe(viewLifecycleOwner,userObserver)
        viewModel.error.observe(viewLifecycleOwner,errorObserver)

        viewModel.getUsers()
    }

}