package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	//view
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
	public void view(ArrayList<DepartmentDTO> ar) {
		for(DepartmentDTO dto : ar) {
			this.view(dto);
		}
		
	}
	public void view(DepartmentDTO dto) {
		System.out.println(dto.getDepartment_id());
		System.out.println(dto.getDepartment_name());
		System.out.println(dto.getManager_id());
		System.out.println(dto.getLocation_id());
		
	}
}