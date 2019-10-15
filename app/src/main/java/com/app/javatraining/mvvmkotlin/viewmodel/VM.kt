package com.app.javatraining.mvvmkotlin.viewmodel

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.app.javatraining.mvvmkotlin.model.User

class VM: BaseObservable() {
    private val SUCESS:String = "Successfully logged in"
    private val FAILD:String = "Failed to login"
    private var user: User?=null
    init {
        user = User()
        user!!.email = "a@a.com"
        user!!.password = "123456"
    }
    @Bindable
    private var toastMessage:String? = ""

    public fun setToastMessage(s:String){
        this.toastMessage = s
        notifyPropertyChanged(BR.toastMessage)
    }
    @Bindable
    public fun getToastMessage():String{
        return toastMessage!!
    }
    public fun setEmail(email:String){

        this.user!!.email = email
        notifyPropertyChanged(BR.email)
    }
    @Bindable
    public fun getEmail():String{
        return this.user!!.email!!
    }
    public fun setPassword(password:String){
        this.user!!.password = password
        notifyPropertyChanged(BR.password)
    }
    @Bindable
    public fun getPassword():String{
        return this.user!!.password!!
    }
    public fun loginBTN(){
        if(checkIfValid()){
            setToastMessage(SUCESS)
        }else{
            setToastMessage(FAILD)
        }
    }

    private fun checkIfValid(): Boolean {
        return TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length > 5
    }


}