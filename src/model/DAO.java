package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class DAO {
	public static String JsonSearch(String sql) {
		Connection con;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e){
			System.out.print(e);
		} 
		try
		{
			String uri="jdbc:mysql://localhost:3306/builder_ikit_org_GES_2014_2015";
			con=DriverManager.getConnection(uri,"root","051633b$");
			PreparedStatement ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			JSONArray array = new JSONArray(); 
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {  
		        JSONObject jsonObj = new JSONObject();
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rs.getString(columnName);  
		            jsonObj.put(columnName, value);  
		        }   
		        array.put(jsonObj);   
		    }  
			con.close();
			return array.toString();
		}
		catch(SQLException | JSONException e1){
			System.out.print(e1);
		}
		return null;
	}
}
