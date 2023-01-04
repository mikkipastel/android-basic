package com.ascedncorp.androidbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ascedncorp.androidbasic.adapter.UserListAdapter
import com.ascedncorp.androidbasic.databinding.FragmentMainBinding
import com.ascedncorp.androidbasic.model.DataItem

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val dataList = listOf(
            DataItem(
                id = 1,
                email = "george.bluth@reqres.in",
                firstName = "George",
                lastName = "Bluth",
                avatar = "https://reqres.in/img/faces/1-image.jpg"
            ),
            DataItem(
                id = 2,
                email = "janet.weaver@reqres.in",
                firstName = "Janet",
                lastName = "Weaver",
                avatar = "https://reqres.in/img/faces/2-image.jpg"
            )
        )

        val adapter = UserListAdapter(dataList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            this.adapter = adapter
        }
    }
}