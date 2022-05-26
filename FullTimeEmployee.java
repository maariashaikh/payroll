package com.mycompany.mavenproject1;

/**
 *
 * @author ---
 */
public class FullTimeEmployee extends Employee{

    Float monthlySalary;
    Float taxRate;

    public Float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }
    
    public Float calculatePayment(){
        return monthlySalary - (monthlySalary * taxRate) ;
    }
}
