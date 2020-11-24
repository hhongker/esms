package com.dyedu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class JdProduct implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 产品转换成 购物车条目 */
	public  JdCartItem   convertToCartItem(){
		JdCartItem  item  = new JdCartItem();
		item.setProduct_id(product_id);
		item.setPicture(picture);
		item.setName(name);
		item.setLower_price(lower_price);
		item.setBack_money(0.0);
		item.setScore(0);
		item.setProduct_count(1);
		return  item;
	}
	@Override
	public String toString() {
		return "XdlProduct [product_id=" + product_id + ", name=" + name + ", add_time=" + add_time + ", picture="
				+ picture + ", big_picture=" + big_picture + ", fixed_price=" + fixed_price + ", lower_price="
				+ lower_price + ", description=" + description + ", author=" + author + ", publishing=" + publishing
				+ ", publish_time=" + publish_time + ", isbn=" + isbn + ", print_number=" + print_number + "]\n";
	}
	public JdProduct(int product_id, String name, Timestamp add_time, String picture, String big_picture,
                     double fixed_price, double lower_price, String description, String author, String publishing,
                     Timestamp publish_time, String isbn, int print_number) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.add_time = add_time;
		this.picture = picture;
		this.big_picture = big_picture;
		this.fixed_price = fixed_price;
		this.lower_price = lower_price;
		this.description = description;
		this.author = author;
		this.publishing = publishing;
		this.publish_time = publish_time;
		this.isbn = isbn;
		this.print_number = print_number;
	}
	public JdProduct(int product_id, String name, String keywords, Timestamp add_time, String picture,
                     String big_picture, double fixed_price, double lower_price, String description, String author,
                     String publishing, Timestamp publish_time, String isbn, String language, String which_edtion,
                     String total_page, String bind_layout, String book_size, String editor_description, String catalog,
                     String book_summary, String author_summary, String extracts, Timestamp print_time, int print_number,
                     String paper_type, String print_frequency) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.keywords = keywords;
		this.add_time = add_time;
		this.picture = picture;
		this.big_picture = big_picture;
		this.fixed_price = fixed_price;
		this.lower_price = lower_price;
		this.description = description;
		this.author = author;
		this.publishing = publishing;
		this.publish_time = publish_time;
		this.isbn = isbn;
		this.language = language;
		this.which_edtion = which_edtion;
		this.total_page = total_page;
		this.bind_layout = bind_layout;
		this.book_size = book_size;
		this.editor_description = editor_description;
		this.catalog = catalog;
		this.book_summary = book_summary;
		this.author_summary = author_summary;
		this.extracts = extracts;
		this.print_time = print_time;
		this.print_number = print_number;
		this.paper_type = paper_type;
		this.print_frequency = print_frequency;
	}
	public JdProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Timestamp getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Timestamp add_time) {
		this.add_time = add_time;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getBig_picture() {
		return big_picture;
	}
	public void setBig_picture(String big_picture) {
		this.big_picture = big_picture;
	}
	public double getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(double fixed_price) {
		this.fixed_price = fixed_price;
	}
	public double getLower_price() {
		return lower_price;
	}
	public void setLower_price(double lower_price) {
		this.lower_price = lower_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public Timestamp getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Timestamp publish_time) {
		this.publish_time = publish_time;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getWhich_edtion() {
		return which_edtion;
	}
	public void setWhich_edtion(String which_edtion) {
		this.which_edtion = which_edtion;
	}
	public String getTotal_page() {
		return total_page;
	}
	public void setTotal_page(String total_page) {
		this.total_page = total_page;
	}
	public String getBind_layout() {
		return bind_layout;
	}
	public void setBind_layout(String bind_layout) {
		this.bind_layout = bind_layout;
	}
	public String getBook_size() {
		return book_size;
	}
	public void setBook_size(String book_size) {
		this.book_size = book_size;
	}
	public String getEditor_description() {
		return editor_description;
	}
	public void setEditor_description(String editor_description) {
		this.editor_description = editor_description;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getBook_summary() {
		return book_summary;
	}
	public void setBook_summary(String book_summary) {
		this.book_summary = book_summary;
	}
	public String getAuthor_summary() {
		return author_summary;
	}
	public void setAuthor_summary(String author_summary) {
		this.author_summary = author_summary;
	}
	public String getExtracts() {
		return extracts;
	}
	public void setExtracts(String extracts) {
		this.extracts = extracts;
	}
	public Timestamp getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Timestamp print_time) {
		this.print_time = print_time;
	}
	public int getPrint_number() {
		return print_number;
	}
	public void setPrint_number(int print_number) {
		this.print_number = print_number;
	}
	public String getPaper_type() {
		return paper_type;
	}
	public void setPaper_type(String paper_type) {
		this.paper_type = paper_type;
	}
	public String getPrint_frequency() {
		return print_frequency;
	}
	public void setPrint_frequency(String print_frequency) {
		this.print_frequency = print_frequency;
	}
	private  int product_id;
	private  String name;
	private  String keywords;
	private  Timestamp add_time;
	private  String picture;
	private  String big_picture;
	private  double fixed_price;
	private  double lower_price;
	private  String description;
	private  String  author;
	private  String publishing;
	private  Timestamp publish_time;
	private  String  isbn;
	private  String language;
	private  String which_edtion;
	private  String total_page;
	private  String bind_layout;
	private  String book_size;
	private  String  editor_description;
	private  String  catalog;
	private  String  book_summary;
	private  String  author_summary;
	private  String  extracts;
	private  Timestamp print_time;
	private  int print_number;
	private  String paper_type;
	private  String  print_frequency;

}
