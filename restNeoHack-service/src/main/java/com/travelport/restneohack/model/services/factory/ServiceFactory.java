/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.services.factory;

import com.travelport.restneohack.model.services.customExceptions.ServiceLoadException;
import com.travelport.restneohack.model.services.marker.Service;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author sheimmer
 */
public class ServiceFactory {
    
    /**
	 * 
	 * @param serviceName
	 *                 Name of the service interface
	 * @return
	 *                 Implementation of the service interface
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Service getService (String serviceName) throws ServiceLoadException
	{
	try{

		Class c = Class.forName(getImplName(serviceName));
		return (Service) c.newInstance();
		} catch (ClassNotFoundException e)
		{
			throw new ServiceLoadException(serviceName + "not found");
		} catch (InstantiationException e){
			throw new ServiceLoadException(serviceName + "not found");
		} catch (IllegalAccessException e)
		{
			throw new ServiceLoadException(serviceName + "not found");
		} catch (Exception e)
		{
			throw new ServiceLoadException(serviceName + "not found");
		}
	}
	
	private String getImplName(String serviceName) throws Exception
	{
		Context iniCtx = new InitialContext();
		
		Context envCtx = (Context)iniCtx.lookup("java:comp/env");
		
		return (String)envCtx.lookup(serviceName);
	}
    
}
