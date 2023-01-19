package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
	public void view(ArrayList<LocationDTO>ar) {
		for(LocationDTO dto : ar) {
			this.view(dto);
		}
	}
	public void view(LocationDTO dto) {
		System.out.println(dto.getLocation_id());
		System.out.println(dto.getStreet_address());
		System.out.println(dto.getPostal_code());
		System.out.println(dto.getCity());
		System.out.println(dto.getState_province());
		System.out.println(dto.getCountry_id());
	}
}