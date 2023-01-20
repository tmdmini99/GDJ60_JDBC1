package com.iu.main;

import java.util.Scanner;

import com.iu.main.departments.DepartmentControllar;
import com.iu.main.employees.EmployeeControllar;
import com.iu.main.locations.LocationControllar;

public class FrontController {
	private Scanner sc;
	private DepartmentControllar departmentControllar;
	private LocationControllar locationControllar;
	private EmployeeControllar employeeControllar;
	
	public FrontController() {
		this.sc=new Scanner(System.in);
		this.departmentControllar = new DepartmentControllar();
		this.locationControllar = new LocationControllar();
		this.employeeControllar = new EmployeeControllar();
	}
	
	public void start() throws Exception{
		
		boolean check =true;
		
		while(check) {
			System.out.println("1. 부서 관리");
			System.out.println("2. 지역 관리");
			System.out.println("3. 사원 관리");
			System.out.println("4. 종   료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				this.departmentControllar.start();
				break;
			case 2:
				this.locationControllar.start();
				break;
			case 3:
				this.employeeControllar.start();
				break;
				
			default:
				check = false;
				break;
			}
		}
	}
	
	
	
}
