package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class MyDaoImpl implements MyDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	public int addEmployee(User emp) {
		// TODO Auto-generated method stub
		String sql = "insert into emp (id,address,email,name,telephone) values(?,?,?,?,?)";
		System.out.printf("emp {}",emp);
		return jdbc.update(sql,new Object[] {emp.getId(),emp.getAddress(),emp.getEmail(),emp.getName(),emp.getTelephone()});	
		
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql="select * from emp";
		List<User> plist=jdbc.query(sql, new RowMapper<User>()
		{	
			public User mapRow(ResultSet rs,int nrows) throws SQLException
			{
				User p=new User();
				p.setId(rs.getInt(1));
				p.setAddress(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setName(rs.getString(4));
				p.setTelephone(rs.getString(5));
				return p;
			
			}});
		return plist;
	}

	public int updateEmployee(User emp, int id) {
		String sql = "update emp set address=?,email=?,name=?,telephone=? where id=?";
		System.out.printf("emp {}",emp);
		return jdbc.update(sql,new Object[] {emp.getAddress(),emp.getEmail(),emp.getName(),emp.getTelephone(),id});	
	}

	public int deleteUser(int id) {
		String sql="delete from emp where id=?";
		return jdbc.update(sql,new Object[] {id});
	}

	public User getAllUsersById(int id) {
		String sql="select * from emp where id=?";
		return jdbc.queryForObject(sql,new Object[] {id},new RowMapper<User>()
		{

			public User mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				
				User p= new User();
				
				p.setId(rs.getInt(1));
				p.setAddress(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setName(rs.getString(4));
				p.setTelephone(rs.getString(5));		
				return p;
			}
			
		});
	}

	

}
