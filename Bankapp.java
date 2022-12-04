package com.company;
import java.util.*;
import java.io.*;


public class Bankapp {
    public static void main(String[] args) {

        while(true){
            String name="";
            String fil="";
            double Balance;
            User X_user=null;
            Scanner Search=new Scanner(System.in);
            boolean UserCreatedOrNot=false;
            while(!UserCreatedOrNot){
                System.out.println("\n\n1 = Create Account");
                System.out.println("2 = Already user");
                System.out.println("3 = Exit");
                System.out.print("\nEnter the input:");
                int choice=Search.nextInt();

                switch(choice){
                    case 1:{
                        System.out.print("Enter Your Name : ");
                        Scanner search= new Scanner(System.in);
                        name= search.nextLine();
                        fil=name.replace(" ","_");
                        System.out.print("Enter the initial deposit : ");
                        Balance=Search.nextDouble();
                        X_user=new User();
                        X_user.Create_Bank_Account(name,Balance);
                        UserCreatedOrNot=true;
                        Balance=X_user.account_name.Returning_the_Balance();

                        break;
                    }
                    case 2:{
                        System.out.print("Enter Your Name : ");
                        Scanner search= new Scanner(System.in);
                        name= search.nextLine();
                        fil=name.replace(" ","_");
                        File accountfile=new File(fil+".txt");
                        if(accountfile.exists()){
                            System.out.println("Welcome "+name);
                            UserCreatedOrNot=true;
                            X_user=new User(name);
                            Balance=X_user.account_name.getbalance(fil);
                            X_user.account_name.setbalance(Balance);


                        }else{
                            System.out.println("Invalid");
                        }
                        break;
                    }case 3:{
                        return;

                    }
                }

            }

            while(UserCreatedOrNot){
                System.out.println("\n\n 1 = Check balance");
                System.out.println(" 2 = Deposit");
                System.out.println(" 3 = Withdarw");
                System.out.println(" 4 = Transfer Money");
                System.out.println(" 5 = Cloase Account");
                System.out.println(" 6 = Exit");
                System.out.print("\n\nEnter the input :");
                int Choice=Search.nextInt();
                double NUM=0;
                switch(Choice){
                    case 1:{
                        System.out.println("Balance is Rs "+String.format("%.2f", X_user.account_name.Returning_the_Balance()));
                        break;
                    }
                    case 2:{
                        System.out.print("Enter the deposit amount ");
                        NUM=Search.nextDouble();
                        X_user.Deposit_Money(fil,NUM);
                        break;
                    }
                    case 3:{
                        System.out.print("Enter Amount for Withdraw Rs ");
                        NUM=Search.nextDouble();
                        X_user.withdrawmoney(fil,NUM);
                        break;
                    }case 4:{
                        Scanner searching= new Scanner(System.in);
                        System.out.print("Enter the account to tansfer ");
                        name= searching.nextLine();

                        System.out.print("Amount to transfer Rs ");
                        NUM=Search.nextDouble();
                        X_user.transfermoney(fil,NUM,name);
                        break;

                    }
                    case 5:{
                        File file = new File(fil+".txt");
                        X_user=null;
                        File Path=new File(file.getAbsolutePath());

                        if(Path.delete()){
                            System.out.println("Account Closed");
                            UserCreatedOrNot=false;
                        }
                    }
                    case 6:{
                        UserCreatedOrNot=false;
                        break;
                    }
                }
            }


        }
    }

}
