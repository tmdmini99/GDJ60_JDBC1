package com.iu.main;


import com.iu.main.departments.DepartmentControllar;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeeControllar;
import com.iu.main.locations.LocationControllar;
import com.iu.main.locations.LocationDAO;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		DepartmentControllar dc = new DepartmentControllar();
		LocationControllar lc = new LocationControllar();
		EmployeeControllar ec = new EmployeeControllar();
		
		DepartmentDAO dao = new DepartmentDAO();
		LocationDAO dao1 = new LocationDAO();
		
		try {
			
			ec.start();
			
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("finish");

	}

}