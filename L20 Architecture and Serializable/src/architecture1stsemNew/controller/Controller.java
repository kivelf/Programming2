package architecture1stsemNew.controller;

import architecture1stsemNew.model.Company;
import architecture1stsemNew.model.Employee;
import architecture1stsemNew.storage.StorageList;

import java.util.List;

public abstract class Controller {
    private static StorageList storage;

    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        storage.storeCompany(company);
        return company;
    }

    /**
     * Delete the company.
     * Pre: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        storage.deleteCompany(company);
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    public static List<Company> getCompanies() {
        return storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new employee.
     * Pre: name not empty, wage >= 0.
     */
    public static Employee createEmployee(String name, int wage) {
        Employee employee = new Employee(name, wage);
        storage.storeEmployee(employee);
        return employee;
    }

    /**
     * Delete the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
        }
        storage.deleteEmployee(employee);
    }

    /**
     * Update the employee.
     * Pre: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage) {
        employee.setName(name);
        employee.setWage(wage);
    }

    public static List<Employee> getEmployees() {
        return storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    /**
     * Add the employee to the company.
     * If the employee is connected to another company, this connected is removed.
     */
    public static void addEmployeeToCompany(Employee employee, Company company) {
        var oldCompany = employee.getCompany();
        if (oldCompany != null) {
            oldCompany.removeEmployee(employee);
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    /**
     * Remove the employee's company, if the employee has a company.
     */
    public static void removeEmployeeFromCompany(Employee employee, Company company) {
        if (employee.getCompany() != null) {
            company.removeEmployee(employee);
            employee.setCompany(null);
        }
    }

    public static void setStorage(StorageList storage) {
        Controller.storage = storage;
    }
}
