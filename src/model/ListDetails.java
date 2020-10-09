package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIST_ID")
	private int id;
	@Column(name = "LIST_NAME")
	private String listName;
	@Column(name = "CREATION_DATE")
	private LocalDate creationDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "OWNER_ID")
	private Owner owner;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "items_on_list", joinColumns = {
			@JoinColumn(name = "LIST_ID", referencedColumnName = "LIST_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", unique = true) })
	private List<CarPojo> listOfCars;

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, LocalDate creationDate, Owner owner, List<CarPojo> listOfCars) {
		this.id = id;
		this.listName = listName;
		this.creationDate = creationDate;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate creationDate, Owner owner, List<CarPojo> listOfCars) {
		this.listName = listName;
		this.creationDate = creationDate;
		this.owner = owner;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate creationDate, Owner owner) {
		this.listName = listName;
		this.creationDate = creationDate;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner ;
	}

	public List<CarPojo> getListOfCars() {
		return listOfCars;
	}

	public void setListOfCars(List<CarPojo> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", creationDate=" + creationDate + ", owner=" + owner
				+ ", listOfCars=" + listOfCars + "]";
	}

}
