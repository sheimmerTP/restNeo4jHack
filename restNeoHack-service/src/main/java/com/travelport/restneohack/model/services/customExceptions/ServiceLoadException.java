/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.services.customExceptions;

/**
 *
 * @author sheimmer
 */
public class ServiceLoadException extends Exception {
    
    private static final long serialVersionUID = 3683909033869581872L;
	public ServiceLoadException ()
	{
		super();
	}
	public ServiceLoadException (String message)
	{
		//call base class constructor
		super(message);
	}
	public ServiceLoadException(String message, Exception cause)
	{
		super(message, cause);
	}
	public ServiceLoadException(Exception cause)
	{
		super(cause);
	}
}
