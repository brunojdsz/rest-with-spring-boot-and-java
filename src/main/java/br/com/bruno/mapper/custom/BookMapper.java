package br.com.bruno.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.bruno.model.Book;
import br.com.bruno.vo.v2.BookVOV2;


@Service
public class BookMapper {

	public BookVOV2 convertEntityToVo(Book book) {
		BookVOV2 vo = new BookVOV2();
		vo.setId(book.getId());
		vo.setAuthor(book.getAuthor());
		vo.setLauchDate(new Date());
		vo.setPrice(book.getPrice());
		vo.setTitle(book.getTitle());
		
		return vo;
	}
	
	public Book convertVoToEntity(BookVOV2 book) {
		Book entity = new Book();
		entity.setId(book.getId());
		entity.setAuthor(book.getAuthor());
		//vo.setBirthDay(new Date());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return entity;
	}
}
