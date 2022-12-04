package com.company;
import java.io.*;


class account { //account class
   String Name_of_the_account;//name OF THE ACCOUNT
   private double Balance_of_the_account;//balance of the account
   account(String NAME){
       Name_of_the_account = NAME;
       Balance_of_the_account=0;
   }
   account(String NAME,double NUM){
       Name_of_the_account = NAME;
       Balance_of_the_account = NUM;
       String Name_of_the_file=Name_of_the_account.replace(" ","_");
       File newNewAccount=new File(Name_of_the_file+".txt");
              try{
       if(newNewAccount.createNewFile()){
           System.out.println(Name_of_the_account +"'s  Account is created");
           FileWriter initial=new FileWriter(Name_of_the_file+".txt");
           initial.write("deposited Rs "+String.format("%.2f", Balance_of_the_account)+"  "+ " Balance Rs "+String.format("%.2f", Balance_of_the_account));//after creating a txt file add the deposit
           initial.close();
           
       }else{
           System.out.println("User exists");
       }
   }
   catch(IOException EXCEPTION){
            System.out.println("error");
       EXCEPTION.printStackTrace();
}
   }



  static double getbalance(String file){
       String endLine = "",currentLinr;
            try{
               BufferedReader br = new BufferedReader(new FileReader(file+".txt"));
                   while ((currentLinr = br.readLine()) != null)
                        {
                            endLine = currentLinr;
                        }
                   br.close();
                    
                }catch(IOException EXCEPTION){
                EXCEPTION.printStackTrace();
                  }
            String[] arr=endLine.split(" ");
            double d=Double.parseDouble(arr[arr.length-1]);
            return d;
   }
    void setbalance(double NUM){//method for set the balance of the account
        Balance_of_the_account = NUM;
    }
    void deposit(double NUM){//method to increase the balance of the account when deposit made
        Balance_of_the_account+=NUM;
    }
    void Withdraw(double NUM){//method to reduce balance when the withdrawed
        Balance_of_the_account-=NUM;
    }
    double Returning_the_Balance(){//method for get the balacne of the account
       return Balance_of_the_account;
   }
   

}
