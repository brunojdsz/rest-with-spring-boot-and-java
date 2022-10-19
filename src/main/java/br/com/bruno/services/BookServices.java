package br.com.bruno.services;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.bruno.controllers.BookController;
import br.com.bruno.controllers.PersonController;
import br.com.bruno.exceptions.RequiredObjectIsNullException;
import br.com.bruno.exceptions.ResourceNotFoundException;
import br.com.bruno.mapper.DozerMapper;
import br.com.bruno.mapper.custom.BookMapper;
import br.com.bruno.mapper.custom.PersonMapper;
import br.com.bruno.model.Book;
import br.com.bruno.model.Person;
import br.com.bruno.repositories.BookRepository;
import br.com.bruno.repositories.PersonRepository;
import br.com.bruno.vo.v1.BookVO;
import br.com.bruno.vo.v1.PersonVO;
import br.com.bruno.vo.v2.BookVOV2;
import br.com.bruno.vo.v2.PersonVOV2;

@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookMapper mapper;
	
	public List<BookVO> findAll() {
		
		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);		
		books.stream().forEach(p -> {
			try {
				p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
			} catch (Exception e) {
				logger.info("Erro ao tentar implementar o hateoas");
			}
		});

		
		return books;
	}

	public BookVO findById(Long id) throws Exception {
		logger.info("Finding one book!");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		
		return vo;
	}
	
	public BookVO create(BookVO book) throws Exception {
		
		if(book == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);		
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
	}
	
	public BookVOV2 createV2(BookVOV2 book) {
		
		logger.info("Creating one book with v2!");
		var entity = mapper.convertVoToEntity(book);		
		var vo = mapper.convertEntityToVo(repository.save(entity));
		
		return vo;
	}
	
	public BookVO update(BookVO book) throws Exception {
		
		if(book == null) throw new RequiredObjectIsNullException();
		logger.info("Updating one book!");
		
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
		
	}

}
