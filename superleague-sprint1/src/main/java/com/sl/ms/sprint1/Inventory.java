package com.sl.ms.sprint1;

import java.util.Date;


public class Inventory {

	public int id;
	public String name;
	public int price;
	public int quantityInStock;
	public int quantitySold;
	public Date SaleOfDate;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int id, String name, int price, int quantityInStock, int quantitySold, Date saleOfDate) {
	
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.quantitySold = quantitySold;
		this.SaleOfDate = saleOfDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
		
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public Date getSaleOfDate() {
		return SaleOfDate;
	}

	public void setSaleOfDate(Date saleOfDate) {
		SaleOfDate = saleOfDate;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", price=" + price + ", quantityInStock=" + quantityInStock
				+ ", quantitySold=" + quantitySold + ", SaleOfDate=" + SaleOfDate + "]";
	}
}