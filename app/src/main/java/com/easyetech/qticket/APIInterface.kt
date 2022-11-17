package com.easyetech.qticket

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {

    @POST("/CodeCenter/storingcode")
    fun ReqCodeStore(@Body requestModel: RequestModel) : Call<ResponseClass>
}