package com.example.demo.service;

import com.example.demo.entity.List;
import java.util.*;

public interface ListService {
	
	java.util.List<List> getAllList();
	
	List savePackage(List list);

	List getListById(Long id);

	 void deletePackageById(Long id);

	List updatePackage(List list);

	

}
