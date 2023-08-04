package com.example.eldar.model;

import java.time.LocalDate;
import java.text.DecimalFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long perId;

	@Column(name = "brand")
	@Nonnull
	private Brand brand;

	@Column(name = "card_number")
	@Nonnull
	private String cardNumber;

	@Column(name = "card_holder")
	@Nonnull
	private String cardholder;

	@Column(name = "due_date")
	@Nonnull
	private LocalDate dueDate;

	public CreditCard(String brand, String cardNumber, String cardholder, LocalDate dueDate) {
		super();
		this.brand = getBrandName(brand);
		this.cardNumber = cardNumber;
		this.cardholder = cardholder;
		this.dueDate = dueDate;
	}

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isValidCard() {
		LocalDate today = LocalDate.now();
		return today.isBefore(this.getDueDate()) || today.isEqual(this.getDueDate());
	}

	public boolean isValidAmount(float amount) {
		return amount <= 1000.0f;
	}

	public Brand getBrandName(String brand) {
		for (Brand b : Brand.values()) {
			if (brand.equals(b.getName())) {
				return b;
			}
		}
		return null;
	}

	public float getRate() {
		try {
			LocalDate today = LocalDate.now();
			// No agregaré DateTimeException por ser la fecha actual que se obtiene
			int month = today.getMonthValue();
			switch (this.getBrand()) {
			case VISA:
				int year = today.getYear() - 2000;
				// el valor month nunca será 0 ni nulo por ser la fecha actual por lo que no
				// necesita agregar ArithmeticException
				return year / month;
			case AMEX:
				return month * 0.1f;
			case NARA:
				int dayOfMonth = today.getDayOfMonth();
				return dayOfMonth * 0.5f;
			default:
				throw new IllegalArgumentException("Marca desconocida: " + this.getBrand());
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return 2.35f; // Retorna un valor medio de la tasa ya que dice que puede ir de 0.3 a 5
		}
	}

	public String getInform(float amount) {
		if (amount <= 1000.0f) {
			float sum = amount * (1 + this.getRate());
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			String inform = "Tasa de " + this.getBrand().getName() + ": " + decimalFormat.format(this.getRate()) + "\n"
					+ "Importe:" + decimalFormat.format(sum);
			return inform;
		} else {
			return "Esta operacion no es válida";
		}
	}
}
