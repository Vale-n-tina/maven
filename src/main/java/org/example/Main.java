package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) {

		Customer cliente = new Customer(123467774, "valentina", 2);
		Customer cliente2 = new Customer(3467774, "Giulia", 3);
		Customer cliente3 = new Customer(3467774, "gianmarco", 2);

		Product prodotto1 = new Product(123242432, "telefono", "elettronica", 500.99);
		Product prodotto2 = new Product(124899932, "biberon", "baby", 9.99);
		Product prodotto3 = new Product(129788972, "lavandino", "casa", 109.99);
		Product prodotto4 = new Product(129756652, "harryPotters", "books", 9.99);
		Product prodotto5 = new Product(129788972, "gioco cane", "animali", 3.99);
		Product prodotto6 = new Product(129788972, "le 8 montagne", "books", 101.99);
		Product prodotto7 = new Product(129788972, "ciuccio", "baby", 1.99);
		Product prodotto8 = new Product(1297972, "maglietta", "boys", 9.99);
		Product prodotto9 = new Product(788675697, "playstation", "boys", 400.99);


		List<Product> prodotti = Arrays.asList(prodotto1, prodotto2, prodotto3, prodotto4, prodotto5, prodotto6, prodotto7, prodotto8, prodotto9);
		List<Product> prodotti2 = Arrays.asList(prodotto1, prodotto2, prodotto4, prodotto6, prodotto7);
		List<Product> prodotti3 = Arrays.asList(prodotto1, prodotto4, prodotto6);


		Order ordine1 = new Order(23434467, "in elaborazione", LocalDateTime.now(), LocalDateTime.now().plusDays(3), prodotti, cliente);
		Order ordine2 = new Order(2142343423, "spedito", LocalDateTime.now(), LocalDateTime.now().plusDays(1), prodotti2, cliente2);
		Order ordine3 = new Order(21423423, "spedito", LocalDateTime.now(), LocalDateTime.now().plusDays(1), prodotti3, cliente3);
		Order ordine4 = new Order(21455523, "spedito", LocalDateTime.now(), LocalDateTime.now().plusDays(1), prodotti2, cliente3);

		// ES1
		//Raggruppare gli ordini per cliente utilizzando Stream e lambda Expressions. Crea una mappa in cui la chiave è il cliente e il valore
		// è una lista di ordini effettuati da quel cliente
		List<Order> tuttiOrdini = Arrays.asList(ordine1, ordine2, ordine3, ordine4);
		Map<Customer, List<Order>> ordiniPerCliente = tuttiOrdini.stream().collect(Collectors.groupingBy(o -> o.getCliente()));
		for (Customer clientie : ordiniPerCliente.keySet()) {
			System.out.println("cliente \t" + clientie + "\n ordini" + ordiniPerCliente.get(clientie) + "\n");
		}

		//ES2
		//Dato un elenco di ordini, calcola il totale delle vendite per ogni cliente utilizzando Stream e Lambda Expressions.
		// crea una mappa in cui la chiave è il cliente e il valore è l'importo totale dei suoi aquisti

		Map<Customer, Double> spesaTotalexCliente = tuttiOrdini.stream().collect(Collectors.groupingBy(o -> o.getCliente(),
				  Collectors.summingDouble(o -> o.getProdotti().stream()
							 .mapToDouble(p -> p.getPrice()).sum())));
		spesaTotalexCliente.forEach((client, totale) -> System.out.println("cliente " + client + "speso totale " + totale));


	}
}