package dev.exercise.model;

import java.time.LocalDateTime;

public class Adventure {

	private int id;
	private String item;
	private int item_weight;
	private int item_price;
	private LocalDateTime input_time;
	private int item_power;
	
	public Adventure(int id, String item, int item_weight, int item_price, LocalDateTime dueDate, int item_power) {
		super();
		this.id = id;
		this.item = item;
		this.item_weight = item_weight;
		this.item_price = item_price;
		this.input_time = dueDate;
		this.item_power = item_power;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItem_weight() {
		return item_weight;
	}

	public void setItem_weight(int item_weight) {
		this.item_weight = item_weight;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public LocalDateTime getInput_time() {
		return input_time;
	}
	
	public int getItem_power() {
		return item_power;
	}

	@Override
	public String toString() {
		return "Adventure [id=" + id + ", item=" + item + ", item_weight=" + item_weight + ", item_price=" + item_price
				+ ", input_time=" + input_time + "]";
	}
}
