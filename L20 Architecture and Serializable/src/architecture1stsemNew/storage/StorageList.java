package architecture1stsemNew.storage;

import architecture1stsemNew.model.Company;
import architecture1stsemNew.controller.*;
import architecture1stsemNew.model.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StorageList implements Storage, Serializable {
    private final ArrayList<Company> companies = new ArrayList<>();
    private final ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public List<Company> getCompanies() {
        return new ArrayList<>(companies);
    }

    @Override
    public void storeCompany(Company company) {
        companies.add(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companies.remove(company);
    }

    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public void storeEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }
}
