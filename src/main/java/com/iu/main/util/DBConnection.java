package com.iu.main.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		
		//1. 접속 정보 준비
		//1. id
		String username="hr";
		//2.pw
		String password="hr";
		//3.url(172.17.144.1 = localhost) port 1521
		//String url = "jdbc:oracle:thin:@localhost:1521:SID;
		//String url = "jdbc:oracle:thin:@localhost:1521/ServiceName";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";//SID는 :을 쓰고 ServiceName은 /를 씀
		//4. driver 정보
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		
		//Connection이 Java의 Socket 역할을 함
		//2.DB 접속 실행
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
		
		
		
		
		
		
		
	}
	
	public static void disConnect(ResultSet rs,PreparedStatement st, Connection connection) throws Exception{
		rs.close();
		st.close();
		connection.close();
	}
	public static void disConnect(PreparedStatement st, Connection connection) throws Exception{
		
		st.close();
		connection.close();
	}
	
	
}