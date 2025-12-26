package AdvancePractice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Exception
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/tp30","root","root");
		Statement state = con.createStatement();
		String query ="select * from emp;";
		ResultSet res = state.executeQuery(query);
		System.out.println(res.getMetaData()+" ");
		while(res.next())
		{
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		con.close();
		

	}

}

