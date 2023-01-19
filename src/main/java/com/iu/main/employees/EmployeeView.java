package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {

	public void view(String msg) {
		System.out.println(msg);
	}
	public void view(ArrayList<EmployeeDTO> ar) {
		for(EmployeeDTO dto : ar) {
			this.view(dto);
		}
	}
	public void view(EmployeeDTO dto) {
		if(dto.getEmployee_id() != null) {
		System.out.println(dto.getEmployee_id());
		}if(dto.getFirst_name() != null)
			System.out.println(dto.getFirst_name());
		if(dto.getLast_name() != null) {
		System.out.println(dto.getLast_name());
		}if(dto.getEmail() != null) {
		System.out.println(dto.getEmail());
		}if(dto.getPhone_number() != null) {
		System.out.println(dto.getPhone_number());
		}if(dto.getHire_date() != null) {
		System.out.println(dto.getHire_date());
		}if(dto.getJob_id() != null) {
		System.out.println(dto.getJob_id());
		}if(dto.getSalary() != null) {
		System.out.println(dto.getSalary());
		}if(dto.getCommission_pct()!= null) {
		System.out.println(dto.getCommission_pct());
		}if(dto.getManager_id() != null) {
		System.out.println(dto.getManager_id());
		}if(dto.getDepartment_id() != null) {
		System.out.println(dto.getDepartment_id());
		}
	}
}