package com.bari.model;
import java.util.Date;
 
public class User {
  private String firstName,lastName,email, password,uname;
  private int phone,egn,roles_id;
  private Date registration;
  
   public String getFirstName()
{
     
    return this.firstName;
}
public void setFirstName(String firstName)
{
     
     this.firstName = firstName;
}
public String getLastName()
{
     
    return this.lastName;
}
public void setLastName(String lastName)
{
     
     this.lastName = lastName;
}
public String getEmail()
{
     
    return this.email;
}
public void setEmail(String email)
{
     
     this.email = email;
}
public String getPassword()
{
     
    return this.password;
}
public void setPassword(String password)
{
     
     this.password = password;
}
  public String getUname()
{
     
    return this.uname;
}
public void setUname(String uname)
{
     
     this.uname= uname;
}
public int getPhone()
{
     
    return this.phone;
}
public void setPhone(int phone)
{
     
     this.phone= phone;
}
public int getEGN()
{
     
    return this.egn;
}
public void setEGN(int egn)
{
     
     this.egn= egn;
}
public int getRoles_id()
{
     
    return this.roles_id;
}
public void setRoles_id(int roles_id)
{
     
     this.roles_id= roles_id;
}
public Date getRegistration()
{
     
    return this.registration;
}
public void setRegistration(Date registration)
{
     
     this.registration= registration;
}

}

