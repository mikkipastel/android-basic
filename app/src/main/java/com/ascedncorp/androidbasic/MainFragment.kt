package com.ascedncorp.androidbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ascedncorp.androidbasic.adapter.UserListAdapter
import com.ascedncorp.androidbasic.databinding.FragmentMainBinding
import com.ascedncorp.androidbasic.model.DataItem
import com.ascedncorp.androidbasic.model.UserListResponse
import com.ascedncorp.androidbasic.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val network = Network()
        network.getUsers().enqueue(object: Callback<UserListResponse> {
            override fun onResponse(
                call: Call<UserListResponse>,
                response: Response<UserListResponse>
            ) {
                response.body()?.data?.let {
                    initRecyclerView(it)
                }
            }

            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                t.printStackTrace()
                context?.let {
                    Toast.makeText(it, "error", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private fun initRecyclerView(dataList: List<DataItem>) {
        val adapter = UserListAdapter(dataList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            this.adapter = adapter
        }
    }
}