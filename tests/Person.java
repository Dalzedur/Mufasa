import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class Person {
	BankStub stubBank;

	@Test
	public void testVerifyAlphabet()
	{
	 boolean ok = true;	
	 String inputs = "test"; 
	 String failmsg = "";
	 
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case ' '://need spacebar to be accepted, since this is used for firstname lastname verification
	   case '-'://compound names can have dashes in them.
	   //case '''://apostrophes can be found in some surnames, not sure how to implement it, though.
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
	   failmsg = "alphabet mode had illegal char.";
	   break;
	   }
	  }  	 
	
     if(ok == false)
     fail(failmsg);
	}
	
	@Test
	public void testVerifyAlphanumerical()
	{
	 boolean ok = true;	
	 String inputs = "test123"; 
	 String failmsg = "";
	
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
	   failmsg = "alphanumerical mode had illegal char.";
	   break;
	   }
	  }  	 

     if(ok == false)
     fail(failmsg);
	}
	 
	@Test
	public void testVerifyMaxLength()
	{
	 boolean ok = true;	
	 String inputs = "test length";  
	 int length = 15; 
	 String failmsg = "";
	
	 if(length > 0)
	 {
	  if(inputs.length() > length)
	  {	  
	  ok = false;
	  failmsg = "length exceeded maximum length.";	  
	  }
	 }
	 if(ok == false)
	 fail(failmsg);
	}

	@Test
	public void testVerifyUnderscores()
	{
	 boolean ok = true;	
	 String inputs = "test_input"; 
	 int underscores = 1; 
	 String failmsg = "";
	
	 if(underscores > 0)
	 {
	  int count = inputs.length() - inputs.replace("_", "").length();
	  if(count > underscores)
	  {	  
	  ok = false;
	  failmsg = "inputs had exceeded allowed number of underscores '_'.";
	  }
	 }
	 if(ok == false)
	 fail(failmsg);
	}
	
	@Test
	public void testVerifyMinLength()
	{
	 boolean ok = true;	
	 String inputs = "test min";  
	 int minlength = 8;
	 String failmsg = "";
	
	 if(minlength > 0)
	 {
	  if(inputs.length() < minlength)
	  {	  
	  ok = false;
	  failmsg = "input length under minimum length.";
	  }
	 }
	 if(ok == false)
	 fail(failmsg);
	}

	@Test
	public void testVerifyBirthdate()
	{
	 boolean ok = true;	
	 String inputs = "11/11/1111"; 
	 String failmsg = "";
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
		failmsg = "birthdate mode had illegal char.";
		break;
	   }
	  }  	 
		 	 
	  if(inputs.charAt(2) != '/')
	  {
	  ok = false;
	  failmsg = "birthdate format missing '/' at pos 3.";
	  }
	  if(inputs.charAt(5) != '/')
	  {
      ok = false;
      failmsg = "birthdate format missing '/' at pos 6.";
	  }
	  if(inputs.length() != 10)
	  {
	  ok = false;
	  failmsg = "birthdate format not exactly 10.";
	  }
	  
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
		 failmsg = "The age for given birthdate under 18.";
		}
	   }
	  }
	   
     if(ok == false)
     fail(failmsg);
	}

	@Test
	public void testVerifyNumerical()
	{
	 boolean ok = true;	
	 String inputs = "1234"; 
	 String failmsg = "";
	
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case '0': case '1': case '2': case '3': case '4': 
	   case '5': case '6': case '7': case '8': case '9':
	   break;
	   default:
	   ok = false;
	   failmsg = "numerical mode had illegal char.";
	   break;
	   }
	  }  	 

     if(ok == false)
     fail(failmsg);
	}

	@Test
	public void testVerifyPostal()
	{
	 boolean ok = true;	
	 String inputs = "2051920"; 
	 String failmsg = "";
	
	  for(int i = 0; i < inputs.length(); i++)
	  {
	   switch(inputs.charAt(i))
	   {
	   case '0': case '1': case '2': case '3': case '4': 
	   case '5': case '6': case '7': case '8': case '9': case '-':
	   break;
	   default:
	   ok = false;
	   failmsg = "postal mode had illegal char.";
	   break;
	   }
	  }  	 

	 if(ok == false)
	 fail(failmsg);
	}

	@Test
	public void testVerifyExpiry()
	{
	 boolean ok = true;	
	 String inputs = "20/9999"; 
	 String failmsg = "";
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
		failmsg = "expiry mode had illegal char.";
		break;
	   }
	  }  	 
		 	 
	  if(inputs.charAt(2) != '/')
	  {	  
	  ok = false;
	  failmsg = "expiry format missing '/' at pos 3.";
	  }
	  if(inputs.length() != 7)
	  {
	  ok = false;	  
	  failmsg = "expiry length not exactly 7.";
	  }
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
		 failmsg = "The expiry date given would have expired already.";
	   }
	  } 	
	 
	 if(ok == false)
	 fail(failmsg);	 
	}
	
	@Test
	public void testCountry()
	{
	 boolean ok = true;	
	 String country = "Finland";
	 String failmsg = "";
	 
	 switch(country)
	 {
	 case "Finland": case "Sweden": case "UK":
	 break;
	 default:
	 ok = false;
	 failmsg = "Country "+country+" not in the list of accepted countries.";
	 }
	 if(ok == false)
	 fail(failmsg);
	}

	@Test
	public void testVerifyCard()
	{
		 boolean ok = true;
		 String choice = "VISA";
		 String failmsg = "";
		 
		 switch(choice)
		 {
		 case "Mastercard": case "VISA": case "Discover": case "mastercard": case "visa": case "discover":
		 break;
		 default:
		 ok = false;
		 failmsg = "Choice "+choice+" not among the legal options.";
		 }
		 if(ok == false)
		 fail(failmsg);
		
	}
	
	//stub
	@Before
	public void setupStub()
	{
	 stubBank = new BankStub("placeholder");
     stubBank.setName("Millionaire bank of Harare");		
	}
	
	@Test
	public void testFakeTestTransaction()
	{	
	 System.out.println("-> Attempting to deduct 0.01 euro from your account.");
	 if(stubBank.trafficOk() == false)
	 fail("Unable to verify with bank.");
	}
	
	@Test
	public void testFakeTestRefund()
	{
 	 System.out.println("-> Attempting to refund 0.01 euro to your account.");
	 if(stubBank.trafficOk() == false)
	 fail("Unable to verify with bank.");
	}
	
}
