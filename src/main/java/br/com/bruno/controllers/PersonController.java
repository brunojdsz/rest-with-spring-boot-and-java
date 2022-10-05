package br.com.bruno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.exceptions.UnsupportedMathOperationException;
import br.com.bruno.model.Person;
import br.com.bruno.services.PersonServices;
import br.com.bruno.utils.Utility;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() throws Exception{		
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception{
		
		if(!Utility.isNumeric(id)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) throws Exception{
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) throws Exception{
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) throws Exception{
		
		if(!Utility.isNumeric(id)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		service.delete(id);
	}
}
