package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.CarPojo;
import model.ListDetails;
import model.Owner;

public class OwnerTester {
	
	public static void main(String[] args) {
		Owner susan = new Owner("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		CarPojo tom = new CarPojo("Nissan", "Zuck" ,"2020");
		List<CarPojo> tomCar = new ArrayList<CarPojo>();
		tomCar.add(tom);
		ListDetails tomList = new ListDetails("Susan's ShoppingList", LocalDate.now(), susan);
		tomList.setListOfCars(tomCar);
		ldh.insertNewListDetails(tomList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
		System.out.println(a.toString());
		}
		
	}
}
