package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentControllar{
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	private DepartmentView dv;
	private Departmentinput di;
	
	//의존성이 필요하다
	
	public DepartmentControllar() {
		this.sc=new Scanner(System.in);
		this.departmentDAO=new DepartmentDAO();
		this.dv = new DepartmentView();
		this.di=new Departmentinput();
		//의존선 주입
		
	}
	
	
	
	public void start() throws Exception{
		boolean check = true;
		DepartmentDTO departmentDTO = null;
		ArrayList<DepartmentDTO>ar = null;
		
		while(check) {
			System.out.println("1. 부서 리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 부서 추가");
			System.out.println("4. 부서 삭제");
			System.out.println("5. 부서 수정");
			System.out.println("6. 종료");
			int select=sc.nextInt();
			switch(select) {
				case 1:
					ar=departmentDAO.getList();
					dv.view(ar);
					break;
				case 2:
					System.out.println("부서번호를 입력하세요");
					select = sc.nextInt();
					departmentDTO=departmentDAO.getDetail(select);
					if(departmentDTO != null) {
					dv.view(departmentDTO);
					}else
						dv.view("Data가 없다");
					break;
					
				case 3:
					 departmentDTO=di.setData();
					 select=departmentDAO.setData(departmentDTO);
					 if(select>0) {
						 dv.view("추가 성공");
					 }else {
						 dv.view("추가 삭제");
					 }
					break;
					
				case 4:
					departmentDTO=di.deleteData();
					select=departmentDAO.deleteData(departmentDTO);
					String msg = "삭제 실패";
					if(select>0) {
						msg = "삭제 성공";
					 }
					dv.view(msg);
					break;
				case 5:
					departmentDTO=di.updateData();
					select=departmentDAO.updateData(departmentDTO);
					if(select>0) {
						 dv.view("수정 성공");
					 }else {
						 dv.view("수정 삭제");
					 }
					break;
				default:
					check=false;
					break;
			}
			
			
		}
		
	}
}