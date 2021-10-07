package com.project.demo;

import java.util.List;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.project.daos.EmployeeDaosImp;
import com.project.entity.Employee;
import com.project.exception.EmployeeNotFoundException;
import com.project.exception.NameNotFoundException;
import com.project.ifaces.CRUDRepository;

public class EmployeeService {
	Connection con = null;
    CRUDRepository repo;
    public EmployeeService(){
    	con = DbConnection.getOracleConnection();
    	repo = new EmployeeDaosImp(con);
    }
    public boolean addEmployee(Employee employee) {
    	return repo.addEmployee(employee);
    }
    public List<Employee> getEmployee(String name) throws NameNotFoundException{
        return repo.getEmployee(name);
    }
    public Employee getEmployeeByID(int id) throws EmployeeNotFoundException {
        return repo.getEmployeeByID(id);
    }
    public boolean editEmployee(Employee employee) {
		return repo.editEmployee(employee);
	}
    public List<String> getEmployeeOfGivenBirthDate(LocalDate date){
		List<Employee> list = repo.getEmployeeOfGivenBirthDate(date);
		return list.stream().map(emp -> (emp.getFirstName() +"-----"+ emp.getEmailAddress())).collect(Collectors.toList());
	}
    public List<String> getEmployeeOfGivenAnniversary(LocalDate date) {
		List<Employee> list = repo.getEmployeeOfGivenAnniversary(date);
		return list.stream().map(emp -> (emp.getFirstName()+"-----"+emp.getPhoneNumber())).collect(Collectors.toList());
    }
    public List<Employee> getAllEmployees(){
		return repo.getAllEmployees();
    }
}
