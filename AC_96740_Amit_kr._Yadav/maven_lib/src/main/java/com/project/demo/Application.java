package com.project.demo;

import org.apache.log4j.Logger;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;

import com.project.entity.*;
import com.project.exception.EmployeeNotFoundException;

public class Application {

	public static void main(String[] args) {
		
		Logger log = Logger.getRootLogger();
    	log.info("Root Logger Started.....");
    	
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int choice=0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        EmployeeService service = new EmployeeService();
        while(true) {
        	
        	System.out.println("Welcome\n Enter Your Choice");
        	System.out.println("Enter your Choose \n 1 => Add Employee \n 2 => Get Details of employee using First Name \n 3 => Get Details of employee using id \n 4 => Edit the details of employee \n 5 => Get employees using Birthdaydate \n 6 => Get employees by Wedding Anniversary \n 7 => Get Details of all employees \n 8 =>Exit");

        	choice = sc.nextInt();
       
        	switch(choice) {
        		case 1:	System.out.println("Enter The Details of Employee");
        				System.out.println("ID: ");
        				int id=sc.nextInt();
        				System.out.println("First Name: ");
        				String firstName=sc.next();
        				System.out.println("Last Name: ");
        				String lastName = sc.next();
        				System.out.println("Address: ");
        				String address = sc.next();
        				System.out.println("Email: ");
        				String email = sc.next();
        				System.out.println("Phone Number: ");
        				String phoneNumber = sc.next();
        				System.out.println("Birthday: (DD-MM-YYYY) ");
        				LocalDate birthday = null;
        				try {
        					birthday = LocalDate.parse(sc.next(), formatter);
    					}
        				 
    					catch(DateTimeParseException e) {
    						log.error(e.getMessage());
    						System.out.println(e.getMessage());
    						System.out.println("Try Again");
    						break;
    					}
        				System.out.println("Wedding Anniversary: ");
        				LocalDate weddingAnniversary = null;
        				try {
        					weddingAnniversary = LocalDate.parse(sc.next(),formatter);
    					}
    					catch(DateTimeParseException e) {
    						log.error(e.getMessage());
    						System.out.println(e.getMessage());
    						System.out.println("Try Again");
    						break;
    					}
        				log.info("Employee Details entered");
        				boolean result = service.addEmployee(new Employee(id,firstName,lastName,address,email,phoneNumber,birthday,weddingAnniversary));
        				String res = result?"Employee Added Successfully":"Employee Failed to add";
        				System.out.println(res);
        				log.info(res);
        				break;
        		case 2:
        				System.out.println("Enter the first name of Employee");
        		        String name= sc.next();
        		        log.info("Entered name =>"+ name );
        		        List<Employee> list= null;
        		        
        		        try {
        		        	list =service.getEmployee(name);
							
						} catch (Exception e) {
							log.error(e.getMessage());
							System.out.println("Bad name! Employee not found.");
							System.out.println(e.getMessage());
							break;
						}
        		        log.info("Employee details");
        		        for(Employee each:list) {
        					System.out.println(each);
        				}
        		        break;
        	
        		
        			
        			
        			
        			
        		case 3:System.out.println("Enter the id of employee");
        		int id1 = sc.nextInt();
        		log.info("Entered id => "+id1);
        		
        		 try {
                     Employee emp= service.getEmployeeByID(id1);
                     System.out.println(emp);
                 } catch (Exception e) {
                     log.error(e.getMessage());
                     System.out.println("Bad id! Employee not found.");
                     System.out.println(e.getMessage());
                     break;
                 }
                 log.info("Employee details found");
                 break;
                 
        		case 4:System.out.println("Enter id of employee");
		        int id11 = sc.nextInt();
		        log.info("id is "+id11);
		        
		        Employee employee =null;
		        try {
		         employee = service.getEmployeeByID(id11);
		        } catch(EmployeeNotFoundException e) {
			        log.error(e.getMessage());
			        System.out.println(e.getMessage());
			        break;
		        }
		        
		      
		     System.out.println("First Name: ");
		     String firstName1 = sc.next();
		     System.out.println("Last Name: ");
		     String lastName1 =sc.next();
		     System.out.println("Address: ");
		     String address1 = sc.next();
		     System.out.println("Email: ");
		     String email1 =sc.next();
		     System.out.println("Phone Number: ");
		     String phoneNumber1 =sc.next();
		     System.out.println("Birthday: [DD-MM-YYYY] ) ");
		     String input=sc.next();
		     LocalDate myBirthDate =employee.getBirthDate();
			 try {
				myBirthDate = LocalDate.parse(input, formatter);
			 }
			 catch(DateTimeParseException e) {
				log.error(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println("Bad date! date format should be [DD-MM-YYYY]");
				break;
			}
		
		 
		   System.out.println("Wedding Anniversary: [DD-MM-YYYY]");
		   input=sc.next();
		   LocalDate myWeddingAnniversary = employee.getWeddingAnniversary();
		    try {
		    	myWeddingAnniversary = LocalDate.parse(input, formatter);
			}
			catch(DateTimeParseException e) {
				log.error(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println("Bad date! date format should be [DD-MM-YYYY]");
				break;
			}
		
		   boolean myRes = service.editEmployee(new Employee(id11,firstName1,lastName1,address1,email1,phoneNumber1,myBirthDate,myWeddingAnniversary));
		   if(myRes) {
			  System.out.println("Successfullyy! Eployee DetailS Edited");
			  log.info("Successful! Employee details Edited");
		   }else {
			 System.out.println("Error! Failed to edit");
			 log.info("Error! Failed to Edit");
		    }
		   break;
	  
        		case 5:System.out.println("ENTER any Date [DD-MM-YYYY]");
			      LocalDate date=null;
			      
			      try {
			        date = LocalDate.parse(sc.next(), formatter);
			        log.info("Birthdate date entered "+date);
			      } catch(DateTimeParseException e) {
				      log.error(e.getMessage());
				      System.out.println(e.getMessage());
				      System.out.println("Bad date! please again enter your choice");
				      break;
			       }
			      
			     List<String> myList = service.getEmployeeOfGivenBirthDate(date);
			     
			     if(myList.isEmpty()) {
						System.out.println("No employees in the same date having b.day");
				  } else{
						myList.forEach(System.out::println);
				  }
			     log.info("Employee info printed ");
			     break;
        	
              case 6: System.out.println("Enter the date [DD-MM-YYYY]");
		        LocalDate date1=null;
		        try {
		         date1 = LocalDate.parse(sc.next(), formatter);
		         log.info("weddingdate date entered "+date1);
		       }catch(DateTimeParseException e) {
			      log.error(e.getMessage());
			      System.out.println(e.getMessage());
			      System.out.println("Bad date! please again enter your choice");
			      break;
		        }
		      List<String> myList1 = service.getEmployeeOfGivenAnniversary(date1);
		      if(myList1.isEmpty()) {
					System.out.println("No employees in the same date having anniversary");
				} else{
					myList1.forEach(System.out::println);
				}
		      log.info("Employee details printed");
		      break;
              case 7:List<Employee> myEmployeeList = service.getAllEmployees();
              System.out.println("Employee details :");
              for(Employee each:myEmployeeList) {
                 System.out.println(each);
               }
              log.info("Employee info printed");
              break;
              case 8:System.out.println("Status exit..");
		       log.info("Status exit..");
		       System.exit(0);
		 
	  } 
	if(choice >8) {
	    System.out.println("Enter a valid choice [1/2/3/4/5/6/7/8]");
	  } 
	
        	
 
              }
        }
	
		  
		

	}
