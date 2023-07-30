package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entitites.Account;
import model.exceptions.DomainException;

public class AccountProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	Account account = new Account();
	 try {
		 
		 System.out.println("Enter de account data: ");
		 System.out.print("Number: ");
		 int number = sc.nextInt();
		 sc.nextLine();
		 System.out.print("Holder: ");
		 String holder = sc.nextLine();
		 System.out.print("Initial Balance: ");
		 double balance = sc.nextDouble();
		 //account.deposit(balance);
		 System.out.print("Withdraw Limit: ");
		 double withdrawLimit = sc.nextDouble();
		 
		account =  new Account(number, holder, balance, withdrawLimit);
		 
		 System.out.println();
		 System.out.print("Enter ammount for withdraw: ");
		 double amount = sc.nextDouble();
		 account.withDraw(amount);
		 System.out.println("New Balance: " + account);
		 
	    }
	 catch(DomainException e) {
			System.out.println(e.getMessage());
		}
	 catch(RuntimeException e) {
			System.out.println("Unexpected error: ");
		}
	
	
	
	sc.close();
	}

}
