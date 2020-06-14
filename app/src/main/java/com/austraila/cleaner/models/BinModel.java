package com.austraila.cleaner.models;

public class BinModel {
     String Bindate, BinImage1, BinImage2, BinImage3;

     public BinModel(String bindate, String binImage1, String binImage2, String binImage3){
         this.Bindate = bindate;
         this.BinImage1 = binImage1;
         this.BinImage2 = binImage2;
         this.BinImage3 = binImage3;
     }

     public String getBindate(){
         return Bindate;
     }

     public String getBinImage1(){
         return BinImage1;
     }

     public String getBinImage2(){
         return BinImage2;
     }

     public String getBinImage3(){
         return BinImage3;
     }
}
