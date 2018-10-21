import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Requirements Specifications
Mufasa
The Online Payment Handling System
--------------------------
Account Creation
--------------------------
F1: 
Basic Data Collection
In order to have an account, we require the following data from 
the users of our service:
1. First and Last Name – where names contain only the Standard 
English letters.
2. User name – the username may contain digits along with the Standard 
English letters. And, one can also use underscore (_), but only once. 
The maximum length of username is 15 characters.
3. Password – it should be 8 characters minimum and case-sensitive.
4. We also require them to re-enter their password as a mean to
crosscheck their previously chosen password.
5. User is able to select his country from the already provided list 
of countries.
6. User’s birthdate information is required in a format of dd/mm/yyyy. 
We need this information to check that they are at least 18 years old 
because we cannot allow users under the age of 18 to use our service.
7. We need user’s Phone Number but only in digits.
8. We also require an email address of the user. It should be provided 
twice. The second entry is to confirm and check the already entered one.
F2: Real Person Check
SKIPPED
----------------------------
Bank Account Attachment
-------------------------------
F3: Mufasa Account Holder Banking Details
We require following to attach bank account of the user to our service;
Address of the user as:
1. Street Address (digits and alphabets only), City (only alphabetical 
characters), Postal code (only digits and ‘-‘), Country – alphabetical 
characters only. The alphabets should come from the set of standard 
English alphabets.  
2. A password that should be different from the password asked earlier 
for basic information collection. And again, the minimum length is 8 and
is case-sensitive.
3. In order to attach the bank-account, the user has to provide the 
following details: cardholder name, type of the card-selection from 
the already provided list (Mastercard, VISA, Discover), credit/debit 
card number and expiry date of the card.
*/

public class Mufasa
{
	public static void main (String[] args)
	{
	boolean ok = false;
	String passwd1 = "";
	String country = "";
	String email = "";
	String streetaddress = "";
	String city = "";
	String postal = "";
	String country2 = "";
	String passwd2 = "";	 
	String username = "";
	String realname = "";
	String birthdate = "";
	String phonenumber = "";
	String cardholder = "";
	String cardnumber = "";
	String cardtype = "";
	String expiry = "";
	String cvc = "";
	
	System.out.println("Welcome to Banking Thing Mufasa.\n");

	
//	1. First and Last Name – where names contain only the Standard English letters.	
	do 
	 {
		System.out.println("Please enter your first name and last name, using only the standard English alphabet.\n");		
		 realname = input();
		 if(verify(realname, "alphabet",0,0,0))
	     ok = true;
	 }
	while (ok == false);

//2. User name – the username may contain digits along with the Standard 
//English letters. And, one can also use underscore (_), but only once. 
//The maximum length of username is 15 characters.
    ok = false;
	do 
	 {
		System.out.println("Please enter your username. Maximum length 15, alphanumerical. Only one underscore at most.\n");		
		 username = input();
		 if(verify(username, "alphanumerical",15,1,0))
	     ok = true;
	 }
	while (ok == false);
	
//3. Password – it should be 8 characters minimum and case-sensitive.
	ok = false;
	do 
	{
	System.out.println("Please enter your password. Minimum length 8, case-sensitive.\n");		
	 passwd1 = input();	
	 if(verify(passwd1, "all",0,0,8))
	 ok = true;
	}
	while (ok == false);
		

//4. We also require them to re-enter their password as a mean to
//crosscheck their previously chosen password.

	ok = false;
	do 
	{
	System.out.println("Please re-enter your password. Minimum length 8, case-sensitive.\n");		
	 if(input() == passwd1);	
	 ok = true;
	}
	while (ok == false);
		
//5. User is able to select his country from the already provided list 
//of countries.
   ok = false;
   do
   { 
   System.out.println("Please choose your country from the options provided.\n");
   System.out.println("Options: Finland, Sweden, UK.\n");   
	   
	country = input();   
	if(selectCountry(country))
	ok = true;
   }
   while (ok == false);

//6. User’s birthdate information is required in a format of dd/mm/yyyy. 
//We need this information to check that they are at least 18 years old 
//because we cannot allow users under the age of 18 to use our service.
	do 
	 {
	System.out.println("Please enter your birthdate information in the format of dd/mm/yyyy, to verify that you are an adult.\n");		
	  birthdate = input();
		 if(verify(birthdate, "birthdate",0,0,0))
	     ok = true;
	 }
	while (ok == false);
   
   
   
//7. We need user’s Phone Number but only in digits.

    ok = false;
	do 
	 {
		System.out.println("Please enter your phonenumber, in digits only.\n");		
		phonenumber = input();
		 if(verify(phonenumber, "numerical",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
//8. We also require an email address of the user. It should be provided 
//twice. The second entry is to confirm and check the already entered one.
		
	ok = false;
	do 
	{
	System.out.println("Please enter your e-mail address.\n");		
	 email = input();	
	 if(verify(email, "all",0,0,0))
	 ok = true;
	}
	while (ok == false);
		
	ok = false;
	do 
	{
	System.out.println("Please re-enter your e-mail address.\n");		
	 if(input() == email);	
	 ok = true;
	}
	while (ok == false);
	//End of F1
	
	//F2
	//skippety skip

	//F3
//	1. Street Address (digits and alphabets only), City (only alphabetical 
//	characters), Postal code (only digits and ‘-‘), Country – alphabetical 
//	characters only. The alphabets should come from the set of standard 
//	English alphabets.  
	
    ok = false;
	do 
	 {
	System.out.println("Please enter your street address, in alphanumerical form.\n");		
	  streetaddress = input();	
		 if(verify(streetaddress, "alphanumerical",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
    ok = false;
	do 
	 {
		System.out.println("Please enter your city, in alphabetical characters only.\n");		
		city = input();
		 if(verify(city, "alphabet",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
    ok = false;
	do 
	 {
	System.out.println("Please enter your postal code, in digits and dashes only.\n");		
	  postal = input();
		 if(verify(postal, "postal",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
    ok = false;
	do 
	 {
		System.out.println("Please enter your country, in alphabetical characters only.\n");		
		 country2 = input();
		 if(verify(country2, "alphabet",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
	
//	2. A password that should be different from the password asked earlier 
//	for basic information collection. And again, the minimum length is 8 and
//	is case-sensitive.
	ok = false;
	do 
	{
	System.out.println("Please enter bank account password. Minimum length 8, case-sensitive. Cannot be the same as the account's password.\n");		
	 passwd2 = input();	
	 if(verify(passwd2, "all",0,0,8) && passwd2 != passwd1)
	 ok = true;
	}
	while (ok == false);
	
	
//	3. In order to attach the bank-account, the user has to provide the 
//	following details: cardholder name, type of the card-selection from 
//	the already provided list (Mastercard, VISA, Discover), credit/debit 
//	card number and expiry date of the card.
	ok = false;
	do 
	{
	System.out.println("Please enter cardholder's name, in standard alphabet form.\n");		
	 cardholder = input();	
	 if(verify(cardholder, "alphabet",0,0,0))
	 ok = true;
	}
	while (ok == false);

	ok = false;
	do 
	{
	System.out.println("Please choose the card's type: Mastercard, VISA, or Discover.\n");		
	 cardtype = input();	
	 if(verifycard(cardtype))
	 ok = true;
	}
	while (ok == false);

	ok = false;
	do 
	{
	System.out.println("Please enter card's number, in digits only.\n");		
	 cardnumber = input();	
	 if(verify(cardnumber, "numerical",0,0,0))
	 ok = true;
	}
	while (ok == false);
	
	do 
	 {
	System.out.println("Please enter your card's expiry date in form: mm/yyyy.\n");		
	  expiry = input();
		 if(verify(expiry, "expiry",0,0,0))
	     ok = true;
	 }
	while (ok == false);
	
//	F4: 
//	Bank Account Attachment Confirmation
//	On clicking a button called, “Test Bank Account Attachment” our system
//	performs a test-transaction by deducting 0.01€ from the user’s 
//	bank-account. But, before this, the user must be presented with a check 
//	statement, “To proceed with a test, please enter your 3 digit cvc code” 
//	On having a cvc code entered, Mufasa deducts 0.01€ from the user’s 
//	account using the provided card details. The system then displays the
//	status of the test-transaction as either “Failed” or “Pass”.
//	After the successful transaction, our system (Mufasa) refunds the
//	deducted amount. But, for this the user has to click the button, 
//	“Refund”. Our system Mufasa refunds the amount to the user’s account
//	within maximum 4 seconds and displays the status-message to the user, 
//	“Refund Failed” or “Refund Success” respectively.	
	
	
/* OK, I don't know how to code buttons/graphics in Java. So I'm faking this part and any such	
 * buttons that pop up in the future in this program.
 */	
	
	//cvc verification should probably be an external dependancy to some authentication server?
	//how is cvc given to the user in the first place? How will the user know what to enter?
	do 
	 {
	System.out.println("Test transaction: \"To proceed with a test, please enter your 3 digit cvc code\".");		
	  cvc = input();
		 if(verify(cvc, "numerical",3,0,3))
	     ok = true;
	 }
	while (ok == false);

	//this fakes traffic between the two systems, too lazy to make another object to send calls to
	if(fakeTestTransaction())
	{
	System.out.println("Test transaction passed. <-");
	//no button know-how, not sure how to add time-expiration clause either.
	
	if(fakeTestRefund())
	 System.out.println("Test refund success. <-");
	else
	 System.out.println("Test refund failed. <-");		
	}
	else
	System.out.println("Test transaction failed. <-");
	
	}
	
	
	public static String input()
	{
	 String inputs = null;
	 boolean ok = false;
	 Scanner reader = new Scanner(System.in);
	 System.out.print("Input > ");
		 
	 do
	 {
	  inputs = reader.nextLine();
	  ok = true;
	 }
	 while(!ok);
	
	 //reader.close();
	 return inputs;
	}
	
	public static Boolean verify(String inputs, String mode, int length, int underscores, int minlength)
	{
	 boolean ok = true;	
	
	 if(mode == "alphabet")
	 {
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case ' '://need spacebar to be accepted since this is used in firstname lastname verification
	   case '-'://can be in a name
	   //case ''': apostrophes can be found in some surnames. Not sure how to implement it, though.
	   case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h':
	   case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p':		   
	   case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x':		   
	   case 'y': case 'z':		   
	   case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
	   case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P':
	   case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X':
	   case 'Y': case 'Z':		   
	   break;
	   default:
	   ok = false;
	   break;
	   }
	  }  	 
	 }//end of alphabet

	 if(mode == "alphanumerical")
	 {
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h':
	   case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p':		   
	   case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x':		   
	   case 'y': case 'z':		   
	   case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H':
	   case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P':
	   case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X':
	   case 'Y': case 'Z': case '0': case '_':
	   case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
	   break;
	   default:
	   ok = false;
	   break;
	   }
	  }  	 
	 }//end of alphanumerical

	 if(length > 0)
	 {
	  if(inputs.length() > length)
	  ok = false;
	 }
	 
	 if(underscores > 0)
	 {
	  int count = inputs.length() - inputs.replace("_", "").length();
	  if(count > underscores)
	  ok = false;
	 }
	 
	 if(minlength > 0)
	 {
	  if(inputs.length() < length)
	  ok = false;		 
	 }
	 
	 if(mode == "birthdate")
	 {
	  ArrayList<String> tempString = new ArrayList<String>();
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	    case '0': case '/': case '1': case '2': case '3': case '4': 
		case '5': case '6': case '7': case '8': case '9':
		break;
		default:
		ok = false;
		break;
	   }
	  }  	 
		 	 
	  if(inputs.charAt(2) != '/')
	  ok = false;
	  if(inputs.charAt(5) != '/')
      ok = false;
	  if(inputs.length() != 10)
	  ok = false;	  
	  		 
	  for (String chunks : inputs.split("/"))
		 {
		  String temp = chunks;
		  tempString.add(temp);	 
		 }
	  
	  //no idea how to handle age calculation in a different way. There is probably a simple
	  //built-in command for it in the libraries, alas, it's beyond my ken.
	  //Hardcoded to 17/10/2018 for now
	  if(Integer.parseInt(tempString.get(2)) >= 2000)
	  {
	   if(Integer.parseInt(tempString.get(1)) >= 10)
	   {
		if(Integer.parseInt(tempString.get(0)) > 17)
		{
		 ok = false;
		 System.out.println("The given birthdate is for a minor. You can:(t use it. ");
		}
	   }
	  }
	  
	 }//end of birthdate 

	 if(mode == "numerical")
	 {
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case '0': case '1': case '2': case '3': case '4': 
	   case '5': case '6': case '7': case '8': case '9':
	   break;
	   default:
	   ok = false;
	   break;
	   }
	  }  	 
	 }//end of numerical

	 if(mode == "postal")
	 {
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case '0': case '1': case '2': case '3': case '4': 
	   case '5': case '6': case '7': case '8': case '9': case '-':
	   break;
	   default:
	   ok = false;
	   break;
	   }
	  }  	 
	 }//end of postal

	 if(mode == "expiry")
	 {
	  ArrayList<String> tempString = new ArrayList<String>();
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	    case '0': case '/': case '1': case '2': case '3': case '4': 
		case '5': case '6': case '7': case '8': case '9':
		break;
		default:
		ok = false;
		break;
	   }
	  }  	 
		 	 
	  if(inputs.charAt(2) != '/')
	  ok = false;
	  if(inputs.length() != 7)
	  ok = false;	  
	  		 
	  for (String chunks : inputs.split("/"))
		 {
		  String temp = chunks;
		  tempString.add(temp);	 
		 }
	  
	  //no idea how to handle age calculation in a different way. There is probably a simple
	  //built-in command for it in the libraries, alas, it's beyond my ken.
	  //Hardcoded to 17/10/2018 for now
	  if(Integer.parseInt(tempString.get(1)) <= 2018)
	  {
	   if(Integer.parseInt(tempString.get(0)) < 10)
	   {
		 ok = false;
		 System.out.println("The date given would have expired already. It cannot be entered. ");
	   }
	  }
	 }//end of expiry 
	 
	 
	 if(ok) return true; else return false;	 
	}
	
	public static boolean selectCountry(String country)
	{
	 boolean ok = true;	
	 switch(country)
	 {
	 case "Finland": case "Sweden": case "UK":
	 break;
	 default:
	 ok = false;
	 }
	 if(ok) return true; else return false;
	}
	
	public static boolean verifycard(String choice)
	{
		 boolean ok = true;	
		 switch(choice)
		 {
		 case "Mastercard": case "VISA": case "Discover": case "mastercard": case "visa": case "discover":
		 break;
		 default:
		 ok = false;
		 }
		 if(ok) return true; else return false;
		
	}
	
	//stub
	public static boolean fakeTestTransaction()
	{
	 System.out.println("-> Attempting to deduct 0.01 euro from your account.");
	 return true;
	}
	
	//stub
	public static boolean fakeTestRefund()
	{
 	 System.out.println("-> Attempting to refund 0.01 euro to your account.");
	 return true;
	}
}
