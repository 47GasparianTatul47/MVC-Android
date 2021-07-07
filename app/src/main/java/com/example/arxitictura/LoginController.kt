package com.example.arxitictura

class LoginController(iLoginView2: MainActivity) :ILoginController {

    var iLoginView:ILoginView = iLoginView2

    override fun onLogin(email: String, password: String) {

        val user = User(email, password)
        val loginCode = user.getValid()



        if (loginCode == 0 ){
            iLoginView.onLoginError("Please Enter Email")

        }else if (loginCode == 1){
            iLoginView.onLoginError("Please Enter a valid Email")

        }else if (loginCode == 3){
            iLoginView.onLoginError("Password should be more 6 character")
        }else{
            iLoginView.onLoginSuccess("LoginSuccsses")
        }
    }

}