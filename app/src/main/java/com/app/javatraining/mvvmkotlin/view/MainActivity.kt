package com.app.javatraining.mvvmkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.app.javatraining.mvvmkotlin.BR
import com.app.javatraining.mvvmkotlin.R
import com.app.javatraining.mvvmkotlin.databinding.ActivityMainBinding
import com.app.javatraining.mvvmkotlin.model.User
import com.app.javatraining.mvvmkotlin.viewmodel.VM

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityMainBinding.vm = VM()
        activityMainBinding.executePendingBindings()
    }
    companion object{
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun display(view:View,message:String){
            if(message != null){
                Toast.makeText(
                    view.context,
                    message,
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
