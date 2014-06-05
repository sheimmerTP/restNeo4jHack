package com.travelport.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.travelport.dao.TravelDao;
import com.travelport.model.SearchReq;
import com.travelport.model.Travel;

@Controller
@RequestMapping(value = "/rest")
public class CRUDServiceController {
	
	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	private TravelDao travelDao ;
    
    @RequestMapping(value = "/searchTravel", method = RequestMethod.POST , consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
	@ResponseBody
    public Travel retrieveRecord(@RequestBody SearchReq request) throws Throwable {
    	if (request == null) {
    		throw new RuntimeException("Request cannot be empty");
    	}
        return travelDao.findById(request.getId());
    }
    
    @RequestMapping(value = "/searchTravel/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
	@ResponseBody
    public Travel retrieveRecord(@PathVariable(value="id") String id) throws Throwable {
        return travelDao.findById(id);
    }
}
