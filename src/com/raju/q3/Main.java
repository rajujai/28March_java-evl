package com.raju.q3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Employee> originalMap = new HashMap<>();
        originalMap.put("HR", new Employee("001", "emp1", 20));
        originalMap.put("Sales", new Employee("002", "emp2", 60));
        originalMap.put("Marketing", new Employee("003", "emp3", 40));
        originalMap.put("Accounts", new Employee("004", "emp4", 25));
        Map<String, Employee> sortedMap = new Main().getSortedMapWithValue(originalMap);
        Set<String> set = sortedMap.keySet();
        set.forEach(s-> System.out.println("Department Name: "+s+"\nEmployee Details: "+sortedMap.get(s)));
    }
    public Map<String,Employee> getSortedMapWithValue (Map<String,Employee> originalMap){
        Set<Map.Entry<String, Employee>> map = originalMap.entrySet();
        List<Map.Entry<String, Employee>> list = new ArrayList<>(map);
        Collections.sort(list, (Map.Entry<String, Employee> o1, Map.Entry<String, Employee> o2)->{
            Employee e1 = o1.getValue();
            Employee e2 = o2.getValue();
            return e1.getSalary()> e2.getSalary() ? +1 : -1;
        });
        Map<String, Employee> res = new HashMap<>();
        list.forEach((Map.Entry<String, Employee> e)-> System.out.println(e.getValue()));
        list.forEach((Map.Entry<String, Employee> e)-> res.put(e.getKey(), e.getValue()));
        return res;
    }
}

class Employee {
    private String empId;
    private String empName;
    private double salary;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}