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

        db = UserDatabase.getDatabase(this)!!

        val user1 =
            User("Pink Bag", "$20", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0sGeKNQngI4Ou_4xoLkM8V_SEHnBZwYMshg&usqp=CAU")
        val user2 =
            User("Bag Black", "$30", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlTwVdQhinpCJoJSq7ErtO8XSLZXKWX4FrNw&usqp=CAU")
        val user3 =
            User("Red Bag", "$10", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4Q8UbOq6OZzvZBdtURmc3JC-7aQGqXnyWCg&usqp=CAU")
        val user4 =
            User("Bag Pink", "$15", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJgLEJqFbZbUGqV23KY7XTXcxLpxBZhYs-2w&usqp=CAU")
        val user5 =
            User("New Bag", "$17", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfTQwInYeHWNR-3Kwb1337U1GWItol1sI5Vw&usqp=CAU")
        val user6 =
            User("My Bag", "$24", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwQ0syEOfQ8TnEUczI1Xmy8Tc4lwsSkGDyRA&usqp=CAU")
        val user7 =
            User("Bag b", "$23", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDUgVcWDOUxkEb0fOrxenG2o_ujljbUaS3aQ&usqp=CAU")
        val user8 =
            User("Bags", "$20", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgvk9zW-IGR1kFjdtWGp6CG6oZtlStGJnDHw&usqp=CAU")
        val user9 =
            User("shopping Bag", "$14", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2YwDgCT83wfikBrI9mMhX4YItHxVNy5t26w&usqp=CAU")
        val user10 =
            User("bags", "$43", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu-PsgBuoFAaL_DuAbwjNN3YZ8U0YQy8NGeA&usqp=CAU")
        val user11 =
            User("my bags", "$23", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSb791D7qVA3F9QL25FtCCHqC-GDR6uIRE7Ew&usqp=CAU")
        val user12 =
            User("New Bags  ", "$31", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNhGtr7RE2Y3INqiKbn6qz-CC4lUSeVsUyew&usqp=CAU")

        GlobalScope.launch {
            db.UserDao().deleteAll()
            db.UserDao().insert(user1, user2, user3, user4,user5,user6,user7,user8,user9,user10,user11,user12)
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