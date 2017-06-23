package com.cqut.controller;


import java.util.Map;

import javax.annotation.Resource;  

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqut.Service.IUserService;
  

@Controller  
public class UserController {  
    @Resource  
    private IUserService userService;  
      
    /**
     * @desciption 新增用户
     * @param user  user实体
     * @return 
     */
    @RequestMapping(value="/user",method=RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody Map<String,Object> user){
    	return null;
    }
    
    /**
     * 
     * @desciption 根据id删除用户
     * @param 
     * @return
     */
	@RequestMapping(value="/user/{ids}",method =RequestMethod.DELETE)
	@ResponseBody
	public String delSubareaById(@PathVariable("ids") String subareaIds){
		return null;
	}
	
	/**
	 * 
	 * @desciption 根据id修改用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/user/{subareaId}",method = RequestMethod.PUT)
	@ResponseBody
	public String upSubareaById(@PathVariable("id")String id,
			@RequestBody  Map<String,Object> user){
		return null;
	}
	
	/**
	 * @url GET /user/1000
	 * @desciption 根据id获取用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value ="/user/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String getSubareaById(@PathVariable("id")String id){
		return null;
	}	
    
	/**
	 * @url GET /user?condition=''
	 * @desciption 根据条件获取用户
	 * @param 
	 * @return
	 */
	@RequestMapping(value ="/user",method=RequestMethod.GET)
	@ResponseBody
	public String getSubareaByCondition(@RequestParam(value="condition",required=false)String condition){
		return null;
	}	
} 