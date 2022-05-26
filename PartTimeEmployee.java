package com.mycompany.mavenproject1;

/**
 *
 * @author ---
 */
public class PartTimeEmployee extends Employee{
    Float hourlyRate;
    Integer numberOfHours;
    
    public Float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }
    
    public Float calculatePayment(){
        return hourlyRate * numberOfHours ;
    }
        
}
