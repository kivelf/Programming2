package architecture1stsemNew.controller;

import java.util.List;
import architecture1stsemNew.model.*;

public interface Storage {
    List<Company> getCompanies();
    void storeCompany(Company company);
    void deleteCompany(Company company);

    List<Employee> getEmployees();
    void storeEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
