package com.easyetech.qticket


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)

class GenerateCodeTest {

    @Test

    fun GUIDIsTrue(){
        val GUID_Status : Boolean = true
        val GUID : String = "S1003"
        val result = GenerateCode.RECGenerator(GUID_Status,GUID)
        assertThat(result).isNotNull()
    }


    @Test

    fun GUIDIsTrueAndIsNull(){
        val GUID_Status : Boolean = true
        val GUID : String? = null
        val result = GenerateCode.RECGenerator(GUID_Status,GUID)
        assertThat(result).isEqualTo("ERROR : GUID can not be null when GUID_STATUS is TRUE")
    }



    @Test

    fun GUIDIsFalseIsNull(){
        val GUID_Status : Boolean = false
        val GUID : String? = "null"
        val result = GenerateCode.RECGenerator(GUID_Status)
        assertThat(result).doesNotContainMatch("null")
    }

    @Test

    fun GUIDIsFalseAndNotNull(){
        val GUID_Status : Boolean = false
        val GUID : String? = "S1003"
        val result = GenerateCode.RECGenerator(GUID_Status)
        assertThat(result).isEqualTo("Error: function must have at least 1 argument or it can be BAD USER INPUT in argument")
    }




}