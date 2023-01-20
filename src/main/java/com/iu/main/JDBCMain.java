package com.iu.main;


import java.util.ArrayList;

import com.iu.main.departments.DepartmentControllar;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeControllar;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationControllar;
import com.iu.main.locations.LocationDAO;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		FrontController controller = new FrontController();
		try {
			controller.start();
			
			//
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("finish");

	}

}