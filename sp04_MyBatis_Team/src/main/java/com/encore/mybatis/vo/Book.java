package com.encore.mybatis.vo;

public class Book {
	private String isbn,title,catalogue,nation,publish_date, author, currency,description;
	private int price;
	
	public Book() {}
	public Book(String isbn, String title, String catalogue, String nation, String publish_date, String author, int price,
			String currency, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.catalogue = catalogue;
		this.nation = nation;
		this.publish_date = publish_date;
		this.author = author;
		this.currency = currency;
		this.description = description;
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", catalogue=" + catalogue + ", nation=" + nation
				+ ", publish_date=" + publish_date + ", author=" + author + ", price=" + price +", currency =" + currency + ", description="
				+ description +"]";
	}
	
	
}
