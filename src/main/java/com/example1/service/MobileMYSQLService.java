package com.example1.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example1.model.Mobile;
import com.example1.repository.MobileRepository;
import com.example1.model.MobileRowMapper;
@Service
public class MobileMYSQLService implements MobileRepository
{
	
	@Autowired
	public JdbcTemplate db;
	@Override
	public ArrayList<Mobile> getMobiles()
	{
		List<Mobile> mobileList=db.query("select * from mobile", new MobileRowMapper());
		ArrayList<Mobile> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}
	@Override
	public Mobile getMobileById(int mobileId)
	{
		try
		{
		Mobile mobile=db.queryForObject("select * from mobile where id=?",new MobileRowMapper(),mobileId);
		return mobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Mobile addMobile(Mobile mobile)
	{
		db.update("insert into mobile(name,image) values(?,?)",mobile.getName(),mobile.getImage());
		
		Mobile newMobile=db.queryForObject("select * from mobile where name=? and image=?",new MobileRowMapper(),mobile.getName(),mobile.getImage());	
		return newMobile;
	}
	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile) {
		
		if(mobile.getName()!=null)
		{
			db.update("update mobile set name=? where id=?",mobile.getName(),mobileId);
		}
		if(mobile.getImage()!=null)
		{
			db.update("update mobile set image=? where id=?",mobile.getImage(),mobileId);
		}
		return getMobileById(mobileId);
		
	}
	@Override
	public void deleteMobile(int mobileId)
	{
		db.update("delete from mobile where id =?",mobileId);
		
	}
}
