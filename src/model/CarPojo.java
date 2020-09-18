package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle.cars")

public class CarPojo {
	// Md Ahmed
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "MAKE")
	private String make;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "YEAR")
	private int year;

	public CarPojo() {
		super();
	}

	public CarPojo(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String returnItemDetails() {
		return make + " " + model + " " + year;
	}

	@Override
	public String toString() {
		return "CarPojo [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	}
}
