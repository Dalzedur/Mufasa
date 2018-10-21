
public class BankStub 
{
 private String name;
 public BankStub(String name) 
 {
  this.name = name;
 }
	
 public String getName() 
 {
  return name;
 }

 public void setName(String name) 
 {
  this.name = name;
 }
 
 public boolean trafficOk()
 {
  return true;	 
 }
}
