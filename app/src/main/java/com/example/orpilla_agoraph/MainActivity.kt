package com.example.orpilla_agoraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orpilla_agoraph.adapter.UserListAdapter
import com.example.orpilla_agoraph.data.ApiService
import com.example.orpilla_agoraph.model.UserItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), UserListAdapter.OnItemClickListener {

    private val mAdapter: UserListAdapter by lazy { UserListAdapter(onItemClickListener = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_users.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        defaultInit()
    }

    private fun defaultInit() {
        val service: ApiService = ApiService.create()
        val call = service.getUsers()

        call.enqueue(object : Callback<List<UserItem>> {
            override fun onResponse(
                call: Call<List<UserItem>>,
                response: Response<List<UserItem>>
            ) {
                val userItemList = response.body()
                mAdapter.submitList(userItemList)
                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {
                Log.d("Failed", t.message.toString())
            }

        })
    }

    override fun onItemClicked(item: UserItem) {
        TODO("Not yet implemented")
    }
}