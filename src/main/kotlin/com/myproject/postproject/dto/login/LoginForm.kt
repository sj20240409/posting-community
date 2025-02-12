package com.myproject.postproject.dto.login

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern

data class LoginForm (
    @NotEmpty
    var accountId : String? = null,


    @NotEmpty
    var password : String? = null
)