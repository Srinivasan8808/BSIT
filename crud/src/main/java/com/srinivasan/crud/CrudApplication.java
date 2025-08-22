package com.srinivasan.crud;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class CrudApplication {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Bean.xml");
			EmployeeDao empDao=(EmployeeDao) context.getBean("employeeDao");

			Employee e1=new Employee();
			e1.setId(1);
			e1.setName("Srinivasan");
			e1.setDept("IT");
			empDao.insert(e1);

			Employee e=empDao.getById(1);
			System.out.println("Fetched:"+e);

			e.setDept("NetWorking");
			empDao.update(e);

			List<Employee> list =empDao.getAll();
			list.forEach(System.out::println);

		empDao.delete(1);
	}

}
