package com.easyetech.qticket

object GenerateCode {






    //REC function : This function will generate Random Encrypted Code (REC) for us.


    fun RECGenerator(GUID_Status : Boolean = false, GUID : String? = "GUIDDefault" ) : String {

        val EncriptionCharList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G")
        var ERC: MutableList<String> = ArrayList()

        if (GUID_Status){
            // When We do have a GUID
            if (GUID != null){
                ERC.add(GUID)
                var i:Int = 1
                while (i < 12){
                    var randNum = (0..15).random()
                    ERC.add(EncriptionCharList[randNum])
                    i++
                }
                return ERC.joinToString("")
            }else{
                return "ERROR : GUID can not be null when GUID_STATUS is TRUE"
            }
        }else if(GUID == null){
            // When We don't have a GUID
            var i:Int = 1
            while (i < 12){
                var randNum = (0..15).random()
                ERC.add(EncriptionCharList[randNum])
                i++
            }
            return ERC.joinToString("")
        }
        return "Error: function must have at least 1 argument or it can be BAD USER INPUT in argument"
    }





    // meisam pull test






}