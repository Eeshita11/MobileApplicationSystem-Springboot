package com.example1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example1.model.Mobile;
import com.example1.service.MobileJpaService;
//import com.example1.service.MobileMYSQLService;
//import com.example1.service.MobileService;

@RestController
public class MobileController 
{
	//MobileService mobileService=new MobileService();
	
	//@Autowired
	//private MobileMYSQLService mobileService;
	
	@Autowired
	private MobileJpaService mobileService;
	
	
	@GetMapping("/mobiles")
	public ArrayList<Mobile> getMobiles() 
	{
		return mobileService.getMobiles();
	}
	
	@GetMapping("mobiles/{mobileId}")
	public Mobile getMobileById(@PathVariable("mobileId")int mobileId) 
	{
		return mobileService.getMobileById(mobileId);
	}
	
     @PostMapping("/mobiles/addnewmobile")
	  public Mobile addMobile(@RequestBody Mobile mobile)
	  {
		return mobileService.addMobile(mobile);
	  }

	
	@PutMapping("mobiles/{mobileId}")
	public Mobile updateMobile(@PathVariable("mobileId") int mobileId, @RequestBody Mobile mobile) 
	{
		return mobileService.updateMobile(mobileId, mobile);
	}
	
	@DeleteMapping("mobiles/{mobileId}")
	public void deleteMobile(@PathVariable("mobileId") int mobileId)
	{
		mobileService.deleteMobile(mobileId);
	}
}
