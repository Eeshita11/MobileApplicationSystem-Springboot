package com.example1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example1.model.Mobile;
import com.example1.repository.MobileJpaRepository;
import com.example1.repository.MobileRepository;

@Service
public class MobileJpaService implements MobileRepository
{
	@Autowired
	private MobileJpaRepository mobileJpaRepository;

	@Override
	public ArrayList<Mobile> getMobiles() 
	{
		// TODO Auto-generated method stub
		List<Mobile> mobileList= mobileJpaRepository.findAll();
		ArrayList<Mobile> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}

	@Override
	public Mobile getMobileById(int mobileId) 
	{
		try
		{
			Mobile mobile = mobileJpaRepository.findById(mobileId).get();
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
		mobileJpaRepository.save(mobile);
		return mobile;
	}

	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile) 
	{
		try
		{
		Mobile existingMobile = mobileJpaRepository.findById(mobileId).get();
		if(mobile.getName()!=null)
		{
		    existingMobile.setName(mobile.getName());
		}
		if(mobile.getImage()!=null)
		{
			existingMobile.setImage(mobile.getImage());
		}
		mobileJpaRepository.save(existingMobile);
		return existingMobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
    }

	@Override
	public void deleteMobile(int mobileId) 
	{
		try
		{
		Mobile mobile = mobileJpaRepository.findById(mobileId).get();
		if(mobile!=null)
		{
			mobileJpaRepository.deleteById(mobileId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}


