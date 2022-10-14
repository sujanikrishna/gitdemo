package Impelmentation;

import java.util.ArrayList;
import java.util.List;

public class Product {
private String productname;
private int price;
public Product(String productname, int price) {
	
	this.productname = productname;
	this.price = price;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public List<String> getProductList()
{
	List<String> productList= new ArrayList<String>();
	productList.add("Apple MacBook Pro");

	productList.add("Apple MacBook air");
	productList.add("Apple MacBook 12");
	return productList;
}
}


