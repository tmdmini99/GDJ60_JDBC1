package com.iu.main.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

import oracle.net.aso.c;

public class LocationDAO {
	
	public int updateData(LocationDTO dto) throws Exception{
		
		Connection c = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS =?, POSTAL_CODE = ?"
					+" WHERE LOCATION_ID = ?";
		PreparedStatement st= c.prepareStatement(sql);
		st.setString(1, dto.getStreet_address());
		st.setString(2, dto.getPostal_code());
		st.setInt(3, dto.getLocation_id());
		
		int result = st.executeUpdate();
		DBConnection.disConnect(st, c);
		return result;
	}
	
	public int deleteData(LocationDTO dto) throws Exception{
		
		Connection connection = DBConnection.getConnection();
		
		String sql="DELETE LOCATIONS WHERE LOCATION_ID= ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, dto.getLocation_id());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public int setData(LocationDTO dto) throws Exception{
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS(LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)"
				+" VALUES(LOCATIONS_SEQ.NEXTVAL,?,?,?,?,?)";
		
		PreparedStatement st= connection.prepareStatement(sql);
		
		st.setString(1, dto.getStreet_address());
		st.setString(2, dto.getPostal_code());
		st.setString(3, dto.getCity());
		st.setString(4, dto.getState_province());
		st.setString(5, dto.getCountry_id());
		
		int result =st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		return result;
		
		
	}
	
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception{
		ArrayList<LocationDTO>ar = new ArrayList<LocationDTO>();
		
		
		
		
		Connection connection =DBConnection.getConnection();
		
		String sql ="SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			
		}
		return ar;
		
	}
	
	
	
	
	public LocationDTO getDetail(int location_id) throws Exception{
		LocationDTO locationDTO = null;
		Connection connection=DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, location_id);//????????? ???? ?????? ????????? sql??? ???? location_id??? ?????? ?????????
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}else {
			System.out.println("NO DATA");
		}
		
		
		
		DBConnection.disConnect(rs, st, connection);
		
		return locationDTO;
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<LocationDTO> getList() throws Exception{
		//1. ?????? ?????? ??????
		//2. DB ??????
		//3. Query??? ??????
		//4. Query??? ?????? ??????
		//5. ? ??????
		//6. ?????? ?????? ??? ????????? ??????
		//7. ?????? ??????
		ArrayList<LocationDTO> ar= new ArrayList<LocationDTO>();
		
		
		Connection connection=DBConnection.getConnection();
		
		
		//3. Query??? ??????
		String sql="SELECT * FROM LOCATIONS";
		//4. Query??? ?????? ??????
		PreparedStatement st =connection.prepareStatement(sql);
		//5. ? ??????

		//6. ?????? ?????? ??? ????????? ??????
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			
			LocationDTO locationDTO= new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			
			
			
			
			ar.add(locationDTO);
		}
		//7. ?????? ??????
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}