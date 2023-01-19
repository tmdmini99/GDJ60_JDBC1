package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {

	
	public ArrayList<Double> getAvg() throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql="SELECT AVG(SALARY), SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st= connection.prepareStatement(sql);
		
		
		ResultSet rs = st.executeQuery();
		
		
		rs.next();
		
		System.out.println(rs.getDouble(1)); //index 번호로 꺼내기 가능
		System.out.println(rs.getInt(2));
		
		
		ArrayList<Double> ar = new ArrayList<Double>();
		ar.add(rs.getDouble(1));
		ar.add((double) rs.getInt(2));
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	
	
	
	
	public int updateData(EmployeeDTO dto) throws Exception{
		Connection connection =DBConnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ? WHERE EMPLOYEE_ID = ?";
		PreparedStatement st= connection.prepareStatement(sql);
		st.setString(1, dto.getFirst_name());
		st.setString(2, dto.getLast_name());
		st.setInt(3, dto.getEmployee_id());

		int result = st.executeUpdate();

		return result;

	}

	public int deleteData(EmployeeDTO dto) throws Exception{
		Connection connection =DBConnection.getConnection();

		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st= connection.prepareStatement(sql);
		st.setInt(1, dto.getEmployee_id());
		int result = st.executeUpdate();

		return result;

	}

	public int setData(EmployeeDTO dto) throws Exception{
		Connection connection =DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,"
				+ "HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)"
						+" VALUES(EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?,?,?,?)";
		PreparedStatement st= connection.prepareStatement(sql);
		
		st.setString(1, dto.getFirst_name());
		st.setString(2, dto.getLast_name());
		st.setString(3,dto.getEmail());
		st.setString(4,dto.getPhone_number());
		st.setString(5,dto.getJob_id());
		st.setInt(6,dto.getSalary());
		st.setDouble(7,dto.getCommission_pct());
		st.setInt(8,dto.getManager_id());
		st.setInt(9,dto.getDepartment_id());
		
		
		int result = st.executeUpdate();

		return result;

	}







	public ArrayList<EmployeeDTO> search(String name) throws Exception{
		Connection connection =DBConnection.getConnection();
		ArrayList<EmployeeDTO> ar= new ArrayList<EmployeeDTO>();
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
		PreparedStatement st= connection.prepareStatement(sql);


		st.setString(1, name);
		ResultSet rs = st.executeQuery();



		while(rs.next()) {
			EmployeeDTO employeeDTO= new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));

			ar.add(employeeDTO);




		}
		return ar;

	}


	public EmployeeDTO getDetail(int num) throws Exception{
		Connection connection = DBConnection.getConnection();
		EmployeeDTO employeeDTO= null;
		String sql ="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";

		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			employeeDTO= new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		}

		return employeeDTO;
	}


	public ArrayList<EmployeeDTO> getList() throws Exception{
		ArrayList<EmployeeDTO> ar= new ArrayList<EmployeeDTO>();

		Connection connection =DBConnection.getConnection();

		String sql ="SELECT * FROM EMPLOYEES ORDER BY HIRE_DATE DESC" ;
		PreparedStatement st = connection.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			EmployeeDTO employeeDTO= new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			employeeDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));

			ar.add(employeeDTO);
		}

		return ar;

	}
	public ArrayList<EmployeeDTO> list() throws Exception{

		ArrayList<EmployeeDTO> ar= new ArrayList<EmployeeDTO>();
		Connection connection =DBConnection.getConnection();


		String sql ="SELECT  FIRST_NAME, LAST_NAME,JOB_ID, DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		PreparedStatement st = connection.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			EmployeeDTO employeeDTO= new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}


		return ar;
	}

}