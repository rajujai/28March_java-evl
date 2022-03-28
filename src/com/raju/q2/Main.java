package com.raju.q2;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Employee employee = new Employee("001", "employee1", new Address("HR", "Bhiwani", "127032"), "raju@mail.in","rajujai");
        Path p = null;
            try {
                p = Paths.get("emp.txt");
                if(!Files.exists(p))
                p = Files.createFile(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
//            Files.write(p, employee.getBytes());
            FileOutputStream fos = new FileOutputStream("emp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.txt"));
            Employee employee2 = (Employee) ois.readObject();
            System.out.println("employeeId : "+employee2.getEmpId());
            System.out.println("employeeName : "+employee2.getEmpName());
            System.out.println("employeeAddress : "+employee2.getAddress());
            System.out.println("employeeEmail : "+employee2.getEmail());
            System.out.println("employeePassword : "+employee2.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Address implements Serializable{
    private String state;
    private String city;
    private String pincode;

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

    public Address(String state, String city, String pincode) {
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public Address() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}

class Employee implements Serializable {
    private String empId;
    private String empName;
    private Address address;
    private String email;
    transient private String password;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Employee() {
    }

    public Employee(String empId, String empName, Address address, String email, String password) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}