package br.com.bruno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.model.Book;
import br.com.bruno.model.Person;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
