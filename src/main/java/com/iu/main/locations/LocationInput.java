package com.iu.main.locations;

import java.sql.Connection;
import java.util.Scanner;

import com.iu.main.util.DBConnection;

public class LocationInput {
	private Scanner sc;
	
	public LocationInput() {
		this.sc = new Scanner(System.in);
	}
	
	
	public LocationDTO updateData() {
		LocationDTO dto= new LocationDTO();
		
		System.out.println("수정할 지역 아이디");
		dto.setLocation_id(sc.nextInt());
		System.out.println("수정할길 주소");
		dto.setStreet_address(sc.next());
		System.out.println("수정할Postal_code");
		dto.setPostal_code(sc.next());
		
		return dto;
	}
	
	
	public LocationDTO setData() {
		LocationDTO dto = new LocationDTO();
		
//		st.setString(1, dto.getStreet_address());
//		st.setString(2, dto.getPostal_code());
//		st.setString(3, dto.getCity());
//		st.setString(4, dto.getState_province());
//		st.setString(5, dto.getCountry_id());
		System.out.println("길 주소");
		dto.setStreet_address(sc.next());
		System.out.println("Postal_code");
		dto.setPostal_code(sc.next());
		System.out.println("지역");
		dto.setCity(sc.next());
		System.out.println("위치");
		dto.setState_province(sc.next());
		System.out.println("지역 ID");
		dto.setCountry_id(sc.next());
		
		return dto;
		
	}
	
	
	
	
	public LocationDTO deleteData() {
		LocationDTO dto = new LocationDTO();
		System.out.println("지우실 아이디 입력");
		
		dto.setLocation_id(sc.nextInt());
		
		return dto;
		
		
	}
	
	
	
	
}
