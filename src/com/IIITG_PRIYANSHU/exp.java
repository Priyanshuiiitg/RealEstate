package com.IIITG_PRIYANSHU;
class address{
    int house;
    String street;
}
  class  student{
      int roll;
      String name;

      address s;
      public  student()
      {
          s=new address();

      }




}

public class exp {
    public static void main(String[] args) {

        student fg=new student();
        fg.roll=23;
        fg.name="priyanshu shukla";
        fg.s.house=31;
        fg.s.street="sector e lda colony";
        System.out.println(fg.roll+" "+fg.name+" "+fg.s.house+" "+fg.s.street);


    }
}
