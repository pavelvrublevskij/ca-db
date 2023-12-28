package eu.codeacademy.service;

import java.math.BigDecimal;
import java.util.List;

import eu.codeacademy.dao.EmployeeDao;
import eu.codeacademy.exception.DataNotFoundException;
import eu.codeacademy.pojo.EmployeePojo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeDao employeeDao;

	public List<EmployeePojo> getAll() {
		return employeeDao.getAll();
	}

	public EmployeePojo getById(long id) {
		return employeeDao
				.getOneById(id)
				.orElseThrow(DataNotFoundException::new);
	}

	public void save(String fullName, BigDecimal salary) {
		Transaction transaction = employeeDao.getSession().beginTransaction();
		try {
			employeeDao.persist(EmployeePojo.builder()
										.firstName(fullName.split(" ")[0])
										.lastName(fullName.split(" ")[1])
										.salary(salary)
										.build());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}
}
