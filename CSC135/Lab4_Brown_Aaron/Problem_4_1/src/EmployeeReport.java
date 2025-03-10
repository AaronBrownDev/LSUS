/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class EmployeeReport {

    public static void main(String[] args) {
        Employee david, alissa, jeremy;
        david = new Employee("David Smith", 32, 76432.53);
        alissa = new Employee();
        jeremy = new Employee("Jeremy White", 25, 68250.74);
        
        alissa.setName("Alissa Jane");
        alissa.setAge(28);
        alissa.setSalary(63324.26);
        
        System.out.println(david);
        System.out.println(alissa);
        System.out.println(jeremy);
    }
    
}
