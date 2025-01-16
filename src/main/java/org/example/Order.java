package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private long id;
	private String status;
	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;
	private List<Product> prodotti;
	private Customer cliente;

	public Order(long id, String status, LocalDateTime orderDate, LocalDateTime deliveryDate, List<Product> prodotti, Customer clienti) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.prodotti = prodotti;
		this.cliente = clienti;
	}

	public List<Product> getProdotti() {
		return prodotti;
	}

	public long getId() {
		return id;
	}

	public Customer getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "Order{" +
				  "id=" + id +
				  ", status='" + status + '\'' +
				  ", orderDate=" + orderDate +
				  ", deliveryDate=" + deliveryDate +
				  ", prodotti=" + prodotti +
				  ", clienti=" + cliente +
				  '}';
	}
}
