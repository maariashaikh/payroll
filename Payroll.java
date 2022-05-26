package com.mycompany.mavenproject1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ---
 */
public class Payroll {

    private static Scanner scanner;
    private static List<PartTimeEmployee> partTimeEmployees = new ArrayList();
    private static List<FullTimeEmployee> fullTimeEmployees = new ArrayList();
    private static List<ManagerFullTimeEmployee> managerFullTimeEmployees = new ArrayList();
    
    public static void main(String[] args){
        System.out.println("Welcome to the Payroll Application !");
        System.out.println("------------------------------------");
        inputData();
        printOutput();
    }
    
    private static void inputData(){
        System.out.println("Let\'s enter data for each employee");
        scanner = new Scanner(System.in);

        do{
            System.out.println("What is the type of the employee ? (Hit \'P\' for Part-Time, \'F\' for Full-Time, \'M\' for Manager) : ");
            String type = scanner.nextLine();
            switch (type) {
                case "P":
                    addPartTimeEmployee();
                    break;
                case "F":
                    addFullTimeEmployee();
                    break;
                case "M":
                    addManagerEmployee();
                    break;
                default:
                    System.out.println("Please enter valid employee type. (Hit \'P\' for Part-Time, \'F\' for Full-Time, \'M\' for Manager) : ");
                    break;
            }            
            System.out.println("Do you want to enter more data ? (Y/N)");
            String moreData = scanner.nextLine();
            if(moreData.equals("N")){
               if(partTimeEmployees.isEmpty() || fullTimeEmployees.isEmpty() || managerFullTimeEmployees.isEmpty() ){
                   System.out.println("You need to enter employee data for all types of employess");
               }else{
                   System.out.println("You have correctly entered data for all type of employees");
                   break; 
               }
            }
        } while(true);
    }
    
    private static void addPartTimeEmployee(){
        PartTimeEmployee employee = new PartTimeEmployee();
        inputEmployeeBasicData(employee);
        System.out.println("For part-Time Employee, also enter the following data :");
        System.out.println("Enter Hourly Rate (in CDN $):");
        employee.setHourlyRate(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter Number Of Hours:");
        employee.setNumberOfHours(Integer.parseInt(scanner.nextLine()));
        partTimeEmployees.add(employee);
    }
    
    private static void addFullTimeEmployee(){
        FullTimeEmployee employee = new FullTimeEmployee();
        inputFullTimeEmployeeData(employee);
        fullTimeEmployees.add(employee);
    }
    
    private static void addManagerEmployee(){
        ManagerFullTimeEmployee employee = new ManagerFullTimeEmployee();
        inputFullTimeEmployeeData(employee);
        System.out.println("For Manager Employee, also enter the Monthly Bonus (in CDN $):");
        employee.setMonthlyBonus(Integer.parseInt(scanner.nextLine()));
        managerFullTimeEmployees.add(employee);
    }
    
    private static void inputFullTimeEmployeeData(FullTimeEmployee employee){
        inputEmployeeBasicData(employee);
        System.out.println("As Full-Time Employee, also enter the following data :");
        System.out.println("Enter Monthly Salary (in CDN $):");
        employee.setMonthlySalary(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter Tax Rate (in decimal):");
        employee.setTaxRate(Float.parseFloat(scanner.nextLine()));
    }
    
    private static void inputEmployeeBasicData(Employee employee){
        System.out.println("Enter Name :");
        employee.setName(scanner.nextLine());
        System.out.println("Enter Address :");
        employee.setAddress(scanner.nextLine());
        System.out.println("Enter Phone Number :");
        employee.setPhoneNumber(scanner.nextLine());
    }
      
    private static void printOutput(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Following are the names of all the employees and their calculated payments");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Name : Payment(in CDN $)");
        for(int i=0; i < partTimeEmployees.size(); i++){
            printRow(partTimeEmployees.get(i)); 
        }
        for(int i=0; i < fullTimeEmployees.size(); i++){
            printRow(fullTimeEmployees.get(i)); 
        }
        for(int i=0; i < managerFullTimeEmployees.size(); i++){
            printRow(managerFullTimeEmployees.get(i)); 
        }
        
    }
    
    private static void printRow(Employee employee){
        System.out.println( employee.getName() + " : " + employee.calculatePayment());
    }
    
}
