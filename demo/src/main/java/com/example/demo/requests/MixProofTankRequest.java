package com.example.demo.requests;

public class MixProofTankRequest {
private String nameMP;
private String nameT;

   public MixProofTankRequest() {
   }

   public MixProofTankRequest(String nameMP, String nameT) {
      this.nameMP = nameMP;
      this.nameT = nameT;
   }

   public String getnameMP() {
      return this.nameMP;
   }

   public void setnameMP(String nameMP) {
      this.nameMP = nameMP;
   }

   public String getnameT() {
      return this.nameT;
   }

   public void setnameT(String nameT) {
      this.nameT = nameT;
   }
}
