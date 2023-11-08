package com.example1.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class MobileRowMapper implements RowMapper<Mobile>
{
	@Override
	public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		
		return new Mobile(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("image")
				);
	}
}
