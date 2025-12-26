package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtils
{
	Connection conn = null;
	ResultSet result = null ; 
	public void connectToDB() throws SQLException
	{
//		registerDB
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
//		get connection for DB
		conn = DriverManager.getConnection(IpathConstants.dbURL,IpathConstants.dbUserName,IpathConstants.bdPassword);
	}
	public ResultSet executeQuery(String query)throws SQLException
	{
		  Statement state = conn.createStatement();
		  result = state.executeQuery(query);
		  return result;
	}
	public int updateQuery(String query) throws SQLException
	{
		
		Statement state = conn.createStatement();
		int res = state.executeUpdate(query);
		return res;
		
	}
	public void disconnectDB()throws SQLException
	{
		conn.close();
	}
	
}
