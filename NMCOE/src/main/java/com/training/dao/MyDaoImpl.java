package com.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.beans.AdminLogin;
import com.training.beans.DisplayDevice;
@Repository
public class MyDaoImpl implements MyDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	
	public boolean adminLogin(String username, String password) {
		try {
			String sql="select * from nmcoeadmin where username=? and password=?";
			AdminLogin a=jdbc.queryForObject(sql, new Object[] {username,password},new RowMapper<AdminLogin>() {
				
			
				public AdminLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminLogin a=new AdminLogin();
					a.setUsername(rs.getString(1));
					a.setPassword(rs.getString(2));
					return a;
					
				}});
			if(a.getUsername().equals(username) && a.getPassword().equals(password)) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		   }
			catch(Exception e)
			{
				return false;
			}
		
	}


	public void savedevicename(String name) {
		String sql="insert into nmcoedeviceregistration(name) values(?)";
	     jdbc.update(sql,new Object[] {name});	
	}


	public List<DisplayDevice> displaydevice() {
		String sql="select * from nmcoedeviceregistration";
		List<DisplayDevice> plist=jdbc.query(sql, new RowMapper<DisplayDevice>()
		{	
			public DisplayDevice mapRow(ResultSet rs,int nrows) throws SQLException
			{
				DisplayDevice p=new DisplayDevice();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));	
				return p;
			
			}});
		return plist;
	}

}
