package com.example1.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.model.Mobile;

public interface MobileJpaRepository extends JpaRepository<Mobile,Integer>
{
	//wE will not write anything
}
