package com.example.roomdatabaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var db: UserDatabase
    var recyclerView: RecyclerView? = null
    var Manager: GridLayoutManager? = null
    var adapter: RecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<View>(R.id.rv_design) as RecyclerView
        Manager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = Manager
        adapter = RecyclerAdapter()
        recyclerView!!.adapter = adapter

        db= UserDatabase.getDatabase(this)!!
        val user1 = User("harshu", "bambure","https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
        val user2 = User("harshita", "xyz","https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
        val user3 = User("minu", "cutu","https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")
        val user4 = User("rv", "qwerty","https://openai.com/content/images/2021/01/2x-no-mark-1.jpg")

        GlobalScope.launch {
            db.UserDao().deleteAll()
            db.UserDao().insert(user1, user2, user3, user4)
            displayUsers()
        }

    }


     private suspend fun displayUsers(){
         val users: List<User> = db.UserDao().getAllUsers()
         runOnUiThread(){
             adapter?.Updatedata(users)

         }
     }


}