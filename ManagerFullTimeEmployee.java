package com.mycompany.mavenproject1;

/**
 *
 * @author --- 
 */
public class ManagerFullTimeEmployee extends FullTimeEmployee{
    Integer monthlyBonus;

    public Integer getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(Integer monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }
    
    public Float calculatePayment(){
        Float basePayment = super.calculatePayment();
        return basePayment + monthlyBonus;
    }
}
