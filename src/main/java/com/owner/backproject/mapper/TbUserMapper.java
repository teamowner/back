package com.owner.backproject.mapper;



import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.owner.backproject.domain.model.TbUser;


@Mapper
public interface TbUserMapper{

	/**
	 * TB_USER Insert data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id
	 * 		  paramsMap.put("name","")  name
	 * 		  paramsMap.put("age","")  age
	 * @exception HdbException
	 * @return
	 */
    public int insertTbUser(TbUser entity);
	
    /**
	 * TB_USER modify data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id
	 * 		  paramsMap.put("name","")  name
	 * 		  paramsMap.put("age","")  age
	 * @exception HdbException
	 * @return
	 */
	public int updateTbUser(TbUser entity);
	
	/**
	 * TB_USER Logical delete data method
	 * @author 
	 * @param parameter type HashMap Custom parameters (delStatus required)
	 * 		  paramsMap.put("delStatus","") 
	  		  paramsMap.put("id","")  id 
	 * @exception HdbException
	 * @return
	 */
	public int updateTbUserDel(Map<String, Object> paramsMap);
	

	/**
	 * TB_USER Primary key array batch delete data method
	 * @author 
	 * @param parameter type HashMap Primary key id array
	 * 		  paramsMap.put("ids","") 
	 * @exception HdbException
	 * @return
	 */
	public int deleteTbUserToManyId(Map<String, Object> paramsMap);
	
	/**
	 * TB_USER The primary key deletes the data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id      
	 * @exception HdbException
	 * @return
	 */
	public int deleteTbUserById(Map<String, Object> paramsMap);
	
	/**
	 * TB_USER The primary key gets the entity data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id    
	 * @return 
	 */
	public TbUser getTbUserById(Map<String, Object> paramsMap);
	
	/**
	 * TB_USER Get the entity data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id
	 * 		  paramsMap.put("name","")  name
	 * 		  paramsMap.put("age","")  age
	 * @return
	 */
	public TbUser getTbUser(Map<String, Object> paramsMap);
	
	/**
	 * TB_USER Get the result set data method
	 * @author 
	 * @param parameter type HashMap
	 * 		  paramsMap.put("id","")  id
	 * 		  paramsMap.put("name","")  name
	 * 		  paramsMap.put("age","")  age
	 * @return
	 */
	public List<TbUser> listTbUser(Map<String, Object> paramsMap);
}
