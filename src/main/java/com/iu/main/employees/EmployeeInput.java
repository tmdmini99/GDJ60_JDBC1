package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	private Scanner sc;

	public EmployeeInput() {
		this.sc = new Scanner(System.in);
	}




	public EmployeeDTO updateData() {
		EmployeeDTO dto = new EmployeeDTO();
		System.out.println("수정할 사원 번호 입력");
		dto.setEmployee_id(sc.nextInt());
		System.out.println("수정할 첫번째 이름");
		dto.setFirst_name(sc.next());
		System.out.println("수정할 성");
		dto.setLast_name(sc.next());
		return dto;
	}

	public EmployeeDTO deleteData() {
		EmployeeDTO dto = new EmployeeDTO();
		System.out.println("삭제할 사원 번호 입력");
		dto.setEmployee_id(sc.nextInt());
		
		return dto;
	}

	public EmployeeDTO setData() {
		EmployeeDTO dto = new EmployeeDTO();
		
		
		System.out.println("추가할 첫번째 이름");
		dto.setFirst_name(sc.next());
		System.out.println("추가할 성");
		dto.setLast_name(sc.next());
		System.out.println("추가할 이메일");
		dto.setEmail(sc.next());
		System.out.println("추가할 폰넘버");
		dto.setPhone_number(sc.next());
		System.out.println("추가할 직업");
		dto.setJob_id(sc.next());
		System.out.println("추가할 월급");
		dto.setSalary(sc.nextInt());
		System.out.println("추가할 추가수입");
		dto.setCommission_pct(sc.nextDouble());
		System.out.println("추가할 상사ID");
		dto.setManager_id(sc.nextInt());
		System.out.println("추가할 부서ID");
		dto.setDepartment_id(sc.nextInt());
		
		return dto;
	}
}
