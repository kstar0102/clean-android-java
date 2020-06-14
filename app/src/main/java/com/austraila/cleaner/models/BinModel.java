package com.austraila.cleaner.models;

public class BinModel {
     String Bindate;
     int BinImage1, BinImage2, BinImage3;

     public BinModel(String bindate, int binImage1, int binImage2, int binImage3){
         this.Bindate = bindate;
         this.BinImage1 = binImage1;
         this.BinImage2 = binImage2;
         this.BinImage3 = binImage3;
     }

     public String getBindate(){
         return Bindate;
     }

     public int getBinImage1(){
         return BinImage1;
     }

     public int getBinImage2(){
         return BinImage2;
     }

     public int getBinImage3(){
         return BinImage3;
     }
}
