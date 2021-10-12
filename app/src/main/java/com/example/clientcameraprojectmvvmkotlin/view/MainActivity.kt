tpackage com.example.clientcameraprojectmvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clientcameraprojectmvvmkotlin.Car
import com.example.clientcameraprojectmvvmkotlin.R
import com.example.clientcameraprojectmvvmkotlin.model.User
import com.example.clientcameraprojectmvvmkotlin.model.repo.RepositoryImpl
import com.example.clientcameraprojectmvvmkotlin.utils.UserClickListener
import com.example.clientcameraprojectmvvmkotlin.utils.showToast
import com.example.clientcameraprojectmvvmkotlin.view.adapter.UserAdapter
import com.example.clientcameraprojectmvvmkotlin.viewmodel.UserViewModel
import com.example.clientcameraprojectmvvmkotlin.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity(), UserClickListener {
    private lateinit var userList: List<User?>
    private val repository: RepositoryImpl by lazy {
        RepositoryImpl()
    }
    private val viewModelFactory by lazy {
        UserViewModelFactory(repository)
    }
    private val viewmodel by lazy {
        ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
    }
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()

        //we're gonna have to grab data from viewmodel and
        //display to our view
        //..how do?
        //well first, let's make our network call
        viewmodel.updateUserListLiveData()

        //now let's have our view *observe* our livedata
        viewmodel.userListLiveData.observe(this,
            {
                userList = it
                it?.let {
                    userAdapter.userList = it
                }
            })
    }

    fun initUi() {
        userAdapter = UserAdapter(this)
        userRecyclerView = findViewById(R.id.users_recyclerview)
        //we're making multiple calls here to change the properties of
        //user recyclerview
        //anytime you want to change a property of a class,
        //you can use apply { } (if you remember, we talked about this
        //being one of the scope functions)
        /**
        userRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        userRecyclerView.adapter = userAdapter
        */

        userRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = userAdapter
        }
    }

    override fun onUserClicked(view: View, position: Int) {
        val message = userList[position]?.fullName
        message?.let {
            showToast(it)
        }
    }
}