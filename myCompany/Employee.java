package myCompany;
import java.util.LinkedHashMap;
import java.util.Scanner;

@SuppressWarnings({"resource"})

public class Employee {
	final String companyName="X pvt limited";
    private String name;
    private int employeeID;
    private double experience;
    private double salary;

    static LinkedHashMap<Integer,Employee> employees=new LinkedHashMap<>();

    public Employee(String name,int employeeID,double experience,double salary){
        this.name=name;
        this.employeeID=employeeID;
        this.experience=experience;
        this.salary=salary;
    }

    public Employee(Employee other,int employeeID){
        this.name=other.name;
        this.employeeID=employeeID;
        this.experience=other.experience;
        this.salary=other.salary;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getEmployeeID(){
        return employeeID;
    }
    public void setEmployeeID(int employeeID){
        this.employeeID=employeeID;
    }

    public double getExperience(){
        return experience;
    }
    public void setExperience(double experience){
        this.experience=experience;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    // Inserting an employee

    public static void insertEmployee(){

        Scanner sc=new Scanner(System.in);
        System.out.println("\nFill the details below.");
        System.out.print("Enter name of Employee:");
        String name=sc.nextLine();

        System.out.print("Enter the employee ID:");
        int Id=sc.nextInt();

        System.out.print("Enter experience in months:");
        double experience=sc.nextInt();

        System.out.print("Enter monthly salary of the employee:");
        double salary=sc.nextDouble();

        if(employees.containsKey(Id)) {
        	System.out.println("No two employees can't be registered with same employee Id. Try again with a new employee Id.");
        }else {
            Employee employee=new Employee(name, Id, experience, salary);
            employees.put(Id, employee);
            System.out.println("\nEmployee added successfully.");
        }
    }

    // Making an employee permanent
    
    public static void makeEmployeePermanent(){
        Scanner sc=new Scanner(System.in);
        if(employees.isEmpty()) {
        	System.out.println("Database is empty.First insert details of employees.");
        }else {
        	System.out.println("\nFill the details below.");
            System.out.print("Enter the employee ID:");
            int Id=sc.nextInt();
            if(employees.containsKey(Id)) {
                employees.get(Id).doubletheSalary();
                System.out.println("Employee got permanent position.");
            }else 
            	System.out.println("No employee with id:"+Id +" exists in company.");
        }
        
    }
    
    public void doubletheSalary(){
        this.salary=salary*2;
    }
    
    // Printing all employee details

    public static void showAllEmployees(){
    	int count=0;
    	if(employees.isEmpty()) {
    		System.out.println("\nDatabase is empty.");
    	}else {
    		for(int e: employees.keySet()){
            System.out.print(count++ +". "+employees.get(e));
            System.out.println();
    		}
    	} 
    }
    
    // Printing individual employee details

   
	public static void showEmployee(){
        Scanner sc=new Scanner(System.in);
        
        if(employees.isEmpty()) {
        	System.out.println("Database is empty. First insert details of employees.");
        }else {
        	System.out.println("\nFill the details below.");
            System.out.print("Enter the EmployeeID:");
            int Id=sc.nextInt();
            
            if(employees.containsKey(Id))
                System.out.println(employees.get(Id));
            else
                System.out.println("No employee with id:"+Id +" exists in company.");
        }
    }
	
	public static void removeEmployee(int Id) {
		Scanner sc=new Scanner(System.in);
		System.out.print("This action can't be undone.Are you sure about deleting the employee? :");
		String response=sc.next();
		if(response.charAt(0)=='Y' || response.charAt(0)=='y') {
			employees.remove(Id);
			System.out.println("Employee with Id:"+Id+" has been removed from the company's database successfully.");
		}else if(response.charAt(0)=='N' || response.charAt(0)=='n'){
		}else {
			System.out.println("Choose between Y or N.");
		}
	}

    @Override
    public String toString(){
        return "Name:"+this.getName()+", Id:"+this.getEmployeeID()+", experience:"+(int)this.getExperience()+" months"+", salary:"+this.getSalary()+" INR";
    }
    
    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);

        while(true){
            
        	System.out.println("\nWelcome to X pvt limited.\n");

            System.out.println("0.Add new employee.");
            System.out.println("1.Show any employee details.");
            System.out.println("2.Show all employees of company.");
            System.out.println("3.Promote any employee to permanent position.");
            System.out.println("4.Update employee name.");
            System.out.println("5.Update employee experience.");
            System.out.println("6.Update employee salary.");
            System.out.println("7.Remove any employee details.");
            System.out.println("8.Exit.");
            
            System.out.print("\nChoose action to be performed:");
            int input=sc.nextInt();
            		
            if(input==0) {
            	insertEmployee();
            }else if(input==1) {
            	showEmployee();
            }else if(input==2) {
            	showAllEmployees();
            }else if(input==3) {
            	makeEmployeePermanent();
            }else if(input==4) {
            	if(employees.isEmpty()) {
            		System.out.println("Database is empty. First insert details of employees.");
            	}else {
            		System.out.println("\nFill the details below.");
                	System.out.print("Enter the employee Id:");
                	int Id=sc.nextInt();
                	System.out.print("Enter the new name to update:");
                	String name=sc.nextLine();
                	
                	if(employees.containsKey(Id)) {
                    	employees.get(Id).setName(name);
                    	System.out.println("Name updated successfully.");
                    	System.out.println("\nUpdated details of employee:");
                    	System.out.println(employees.get(Id));
                	}else {
                		System.out.println("No employee with id:"+Id +" exists in company.");
                	}
            	}
                
            	
            }else if(input==5) {
            	if(employees.isEmpty()) {
            		System.out.println("Database is empty. First insert details of employees.");
            	}else {
            		System.out.println("\nFill the details below.");
                	System.out.print("Enter employee Id:");
                	int Id=sc.nextInt();
                	System.out.print("Enter the new experience duration in months to update:");
                	double exp=sc.nextDouble();
                	
                	if(employees.containsKey(Id)) {
                		if(exp<6 && exp>=0)
                    		employees.get(Id).setExperience(exp);
                    	else if(exp>=6){
                    		employees.get(Id).setExperience(exp);
                    		employees.get(Id).setSalary(employees.get(Id).getSalary()*2);
                    	}else
                    		System.out.println("Experience can't be negative.");
                    	
                    	System.out.println("Experience updated successfully.");
                    	System.out.println("\nUpdated details of employee:");
                    	System.out.println(employees.get(Id));
                	}else {
                		System.out.println("No employee with id:"+Id +" exists in company.");
                	}
            	}
            	
            }else if(input==6) {
            	if(employees.isEmpty()) {
            		System.out.println("Database is empty. First insert details of employees.");
            	}
                System.out.println("\nFill the details below.");
            	System.out.print("Enter employee Id:");
            	int Id=sc.nextInt();
            	System.out.print("Enter the new monthly salary of employee in INR to update:");
            	double salary=sc.nextDouble();
            	
            	if(employees.containsKey(Id)) {
                	employees.get(Id).setSalary(salary);
                	System.out.println("Monthly salary updated successfully.");
                	System.out.println("\nUpdated details of employee:");
                	System.out.println(employees.get(Id));
            	}else {
            		System.out.println("No employee with id:"+Id +" exists in company.");
            	}
            	
            }else if(input==7) {
            	if(employees.isEmpty()) {
            		System.out.println("Database is already empty.");
            	}else {
            		System.out.print("Enter employee Id:");
            		int Id=sc.nextInt();
            		if(employees.containsKey(Id)) {
            			removeEmployee(Id);
            		}else {
            			System.out.println("No employee with id:"+Id +" exists in company.");
            		}
            	}
            }else if(input==8) {
            	System.out.println("Are you sure to exit? Y or N");
            	String response=sc.next();
            	if(response.charAt(0)=='Y' || response.charAt(0) =='y') {
            		System.out.println("Thanks for using the app. Best wishes!!!");
            		return;
            	}else if(response.charAt(0)=='N' || response.charAt(0)=='n'){
            	}else {
            		System.out.println("Choose between Y or N.");
            	}
            	
            }else 
            	System.out.println("Choose any of the valid options.");
        }
        
        
        
        
        // Developed by Debadarshi Omkar.

    }
}

