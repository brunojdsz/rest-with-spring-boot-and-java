package br.com.bruno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.services.BookServices;
import br.com.bruno.services.PersonServices;
import br.com.bruno.utils.MediaType;
import br.com.bruno.vo.v1.BookVO;
import br.com.bruno.vo.v1.PersonVO;
import br.com.bruno.vo.v2.BookVOV2;
import br.com.bruno.vo.v2.PersonVOV2;

@RestController
@RequestMapping("/api/book/v1")
//@Tag(name = "People", description = "Endpoints for Mapping People")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	//@Operation(summary = "Finds all people", description = "Finds all people", 
		//tags = {"People"},
		//responses = {
		//	@ApiResponse(description = "Success", responseCode = "200", 
				//content =  {
					//@Content(
						//mediaType = "application/json",
						//array = @ArraySchema(schema = @Schema(implementantion = PersonVO.class))
					//)
				//}),
		//	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		//	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		//	@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		//	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		//}
	//);
	public List<BookVO> findAll() throws Exception{		
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	//@Operation(summary = "Finds a Person", description = "Finds a person", 
		//tags = {"People"},
		//responses = {
		//	@ApiResponse(description = "Success", responseCode = "200", 
				//content = @Content((schema = @Schema(implementantion = PersonVO.class))
				//),
		//	@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		//	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		//	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		//	@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		//	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		//}
	//);
	public BookVO findById(@PathVariable(value = "id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	//@Operation(summary = "Add a new Person", description = "Add a new person by passing in a JSON, XML or YML representation of the person", 
		//tags = {"People"},
		//responses = {
		//	@ApiResponse(description = "Success", responseCode = "200", 
				//content = @Content((schema = @Schema(implementantion = PersonVO.class))
				//),
		//	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		//	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		//	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		//}
	//);
	public BookVO create(@RequestBody BookVO bookVO) throws Exception{
		return service.create(bookVO);
	}
	
	@PostMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public BookVOV2 createV2(@RequestBody BookVOV2 bookVO) throws Exception{
		return service.createV2(bookVO);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	//@Operation(summary = "Updates a new Person", description = "Updates a new person by passing in a JSON, XML or YML representation of the person", 
		//tags = {"People"},
		//responses = {
		//	@ApiResponse(description = "Success", responseCode = "200", 
				//content = @Content((schema = @Schema(implementantion = PersonVO.class))
				//),
		//	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		//	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		//	@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		//	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		//}
	//);
	public BookVO update(@RequestBody BookVO bookVO) throws Exception{
		return service.update(bookVO);
	}
	
	@DeleteMapping(value = "/{id}")
	//@Operation(summary = "Delete a Person", description = "Deletes a person by passing in a JSON, XML or YML representation of the person", 
		//tags = {"People"},
		//responses = {
		//	@ApiResponse(description = "No Content", responseCode = "204", content = @Content()
		//	@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		//	@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		//	@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		//	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
		//}
	//);
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
