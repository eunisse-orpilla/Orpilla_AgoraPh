package com.example.orpilla_agoraph

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.orpilla_agoraph.data.ApiService
import com.example.orpilla_agoraph.model.ProfileItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val mId = intent?.extras?.getInt(USER_ID)
            ?: throw IllegalArgumentException("`USER_ID` must be non-null")
        val mUserName = intent?.extras?.getString(USER_NAME)
            ?: throw IllegalArgumentException("`USER_NAME` must be non-null")

        initItems(mId, mUserName)

        setSupportActionBar(tb_profile)
        supportActionBar?.apply {
            title = mUserName

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    private fun initItems(mId: Int, mUserName: String) {
//        tb_text_name.setText(mUserName)
        name.setText(mUserName)

        val service = ApiService.create()
        val call = service.getUserProfile(mUserName)

        call.enqueue(object : Callback<ProfileItem> {
            override fun onResponse(call: Call<ProfileItem>, response: Response<ProfileItem>) {
                val profileItemList = response.body()
                following_count.setText(profileItemList?.following.toString())
                followers_count.setText(profileItemList?.followers.toString())
                company.setText(profileItemList?.company)
                blog.setText(profileItemList?.blog)
                Picasso.with(baseContext).load(profileItemList?.avatarUrl).into(img_header)
            }

            override fun onFailure(call: Call<ProfileItem>, t: Throwable) {
                Log.d("Failed", t.message.toString())
            }

        })
    }

    companion object {
        const val USER_ID = "userId"
        const val USER_NAME = "username"
    }
}