package com.easyetech.qticket

import android.util.Log
import io.github.g0dkar.qrcode.QRCode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.FileOutputStream


object GenerateCode {






    //REC function : This function will generate Random Encrypted Code (REC) for us.


    fun RECGenerator(GUID_Status : Boolean = false, GUID : String? = "IDdefault#" ) : String {

        val EncriptionCharList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G")
        var REC: MutableList<String> = ArrayList()

        if (GUID_Status){
            // When We do have a GUID
            if (GUID != null){
                var CodeGUID = "ID$GUID#"
                REC.add(CodeGUID)
                var i:Int = 1
                while (i < 12){
                    var randNum = (0..15).random()
                    REC.add(EncriptionCharList[randNum])
                    i++
                }
                return REC.joinToString("")
            }else{
                return "ERROR : GUID can not be null when GUID_STATUS is TRUE"
            }
        }else if(GUID == null){
            // When We don't have a GUID
            var i:Int = 1
            while (i < 12){
                var randNum = (0..15).random()
                REC.add(EncriptionCharList[randNum])
                i++
            }
            return REC.joinToString("")
        }
        return "Error: function must have at least 1 argument or it can be BAD USER INPUT in argument"
    }

    

    // Code Generator & Exporter

    fun CodeGenerator(QrcodeCount : Int, GUID : String , REC: String, FileType : String ) {
        var i = 1

        while (i <= QrcodeCount){
            val fileOut = FileOutputStream("Code_$i.$FileType")
            QRCode(REC).render().writeImage(fileOut)
            // send Request to the server
            val retrofit = ServiceBuilder.buildService(APIInterface::class.java)
            val obj = RequestModel(GUID,REC)
            retrofit.ReqCodeStore(obj).enqueue(
                object:Callback<ResponseClass>{
                    override fun onResponse(
                        call: Call<ResponseClass>,
                        response: Response<ResponseClass>
                    ) {
                        Log.d("TAG", "${response.body()?.message.toString()}")
                    }

                    override fun onFailure(call: Call<ResponseClass>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                }
            )

            i++
        }
    }









}