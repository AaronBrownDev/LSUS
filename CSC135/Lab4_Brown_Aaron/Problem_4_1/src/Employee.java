/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aaron
 */
import java.text.NumberFormat;


public class Employee {
    private String name; private int age; private double salary;
    
    public Employee(String inName, int inAge, double inSalary) 
    {
        name = inName;
        age = inAge;
        salary = inSalary;
    }
    public Employee(){}
    
    public void setName(String inName){
        name = inName;
    }
    public String getName(){
        return name;
    }
    public void setAge(int inAge) {
        age = inAge;
    }
    public int getAge() {
        return age;
    }
    public void setSalary(double inSalary){
        salary = inSalary;
    }
    public double getSalary(){
        return salary;
    }
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String info = "Name: " + name + "\nAge: " + age + "\nSalary: " + fmt.format(salary);
        
        return info;
    }
}
