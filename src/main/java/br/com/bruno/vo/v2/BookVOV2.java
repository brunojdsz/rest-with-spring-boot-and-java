package br.com.bruno.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookVOV2 implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String author;
	
	private Date lauchDate;
	
	private Double price;
	
	private String title;

	public BookVOV2() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLauchDate() {
		return lauchDate;
	}

	public void setLauchDate(Date lauchDate) {
		this.lauchDate = lauchDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, lauchDate, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVOV2 other = (BookVOV2) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(lauchDate, other.lauchDate) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}
}