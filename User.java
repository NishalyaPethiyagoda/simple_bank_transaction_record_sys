package com.company;
import java.io.*;

class User {//user class
    String Name_of_the_user;//user name
    account account_name;//account name
    User(){}
    User(String NAME){
       Name_of_the_user=NAME;
       account_name=new account(NAME);
   }
    void Create_Bank_Account(String NAME,double NUM){
        account_name=new account(NAME,NUM);
        Name_of_the_user=NAME;
    }
    void Deposit_Money(String file,double NUM){
        account_name.deposit(NUM);
        System.out.println("Deposited Rs "+String.format("%.2f", NUM) +" to " +account_name);
        try{
           FileWriter fr=new FileWriter(file+".txt",true);
           fr.write("\ndeposited Rs "+String.format("%.2f", NUM));
           fr.close();
       }catch(IOException EXCEPTION){
            System.out.println("error");
            EXCEPTION.printStackTrace();
        }
        
        
    }
    static double user_get_balance(String filename){
       String lastLine = "",sCurrentLine;
            try{
               BufferedReader br = new BufferedReader(new FileReader(filename+".txt"));
                   while ((sCurrentLine = br.readLine()) != null) 
                        {
                            lastLine = sCurrentLine;
                        }
                   br.close();
                    
                }catch(IOException EXCEPTION){
                EXCEPTION.printStackTrace();
                  }
            String[] arr=lastLine.split(" ");//split the line by spaces and stroe it in the array
            double d=Double.parseDouble(arr[arr.length-1]); //then get the last elemnt of array 
            return d;
   }
   void withdrawmoney(String file,double NUM){
        if(account_name.getbalance(file)>=NUM){
            account_name.Withdraw(NUM);
            System.out.println("Withdrawed Rs "+String.format("%.2f", NUM));
            try{
                FileWriter fr=new FileWriter(file+".txt",true);
                fr.write("\nWithdrawed Rs "+String.format("%.2f", NUM)+"  "+" Balance Rs "+String.format("%.2f", account_name.Returning_the_Balance()));
                fr.close();
            }catch(IOException EXCEPTION){
                System.out.println("error");
                EXCEPTION.printStackTrace();
            }
        }else{
            System.out.println("Balance is Not Enough");
        }
    }
    void transfermoney(String filename,double NUM,String reciver){
        if(account_name.getbalance(filename)>=NUM){//user can withdraw money if balance is greater than the transfer value
            String filen=reciver.replace(" ","_");
            File accountfile=new File(filen+".txt");
            if(accountfile.exists()){
                account_name.Withdraw(NUM);
                 
        System.out.println("Transfered Rs "+String.format("%.2f", NUM)+" to "+reciver);//print the transferdvalue
        try{
           FileWriter fr=new FileWriter(filename+".txt",true);//write the details into account txt file
           fr.write("\nTransfered Rs "+String.format("%.2f", NUM)+" to "+reciver+" Balance Rs "+String.format("%.2f", account_name.Returning_the_Balance()));//write the transfered amout to his account
           fr.close();
           fr=new FileWriter(filen+".txt",true);
           fr.write("\nRecived Rs "+String.format("%.2f", NUM)+" from "+Name_of_the_user+" Balance Rs "+String.format("%.2f",user_get_balance(filen)+NUM));//write the recived amount to recivers account
           fr.close();
       }catch(IOException EXCEPTION){
            System.out.println("error");
            EXCEPTION.printStackTrace();
        }
      }else{
                 System.out.println("No valid User");//if the transferring account is not exsists 
            }
       
    }else{
            System.out.println("Balance is Not Enough");//if balance is less than user cant transfer and this msg is shown
        }
    }
   
}

