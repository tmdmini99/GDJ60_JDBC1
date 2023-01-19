package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationControllar {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView lv;
	private ArrayList<LocationDTO> ar;
	private LocationInput li;
	
	
	public LocationControllar() {
		this.sc=new Scanner(System.in);
		this.locationDAO=new LocationDAO();
		this.lv= new LocationView();
		this.ar=new ArrayList<LocationDTO>();
		this.li = new LocationInput();
		
	}
	
	public void start() throws Exception{
		boolean check = true;
		LocationDTO locationDTO = null;
		while(check) {
			System.out.println("1. 지역리스트");
			System.out.println("2. 지역상세정보");
			System.out.println("3. 주소 검색");
			System.out.println("4. 지역 추가");
			System.out.println("5. 지역 삭제");
			System.out.println("6. 지역 수정");
			System.out.println("7. 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar =locationDAO.getList();
				lv.view(ar);
				break;
				
			case 2:
				System.out.println("부서 위치 번호 입력");
				select = sc.nextInt();
				 locationDTO=locationDAO.getDetail(select);
				if(locationDTO !=null) {
					lv.view(locationDTO);	
				}else {
					lv.view("Data가 없다");
				}
				break;
			case 3:
				System.out.println("검색할 주소");
				String add=sc.next();
				ar=locationDAO.getFind(add);
			case 4:
				locationDTO=li.setData();
				select=locationDAO.setData(locationDTO);
				if(select>0) {
					lv.view("성공");
				}else {
					lv.view("실패");
				}
				break;
				
			case 5:
				locationDTO=li.deleteData();
				select = locationDAO.deleteData(locationDTO);
				if(select>0) {
					lv.view("성공");
				}else {
					lv.view("실패");
				}
				break;
			case 6:
				locationDTO=li.updateData();
				select = locationDAO.updateData(locationDTO);
				if(select>0) {
					lv.view("성공");
				}else {
					lv.view("실패");
				}
				break;
				
			default:
				check = false;
				break;
			}
			
			
			
		}
		
	}
}