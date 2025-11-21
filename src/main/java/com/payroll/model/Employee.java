package com.payroll.model;

public class Employee {

    private int id;
    private String name;
    private String designation;
    private double basicSalary;
    private double hra;
    private double da;
    private double pf;

    public Employee() {}

    public Employee(int id, String name, String designation, double basicSalary, double hra, double da, double pf) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.pf = pf;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }

    public double getPf() { return pf; }
    public void setPf(double pf) { this.pf = pf; }
}
