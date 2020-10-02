package view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.CarCrud;
import model.CarPojo;

public class Runner {
	// Md Ahmed
	static Scanner in = new Scanner(System.in);
	static CarCrud Car = new CarCrud();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a make: ");
		String make = in.nextLine();
		System.out.print("Enter a model: ");
		String model = in.nextLine();
		System.out.print("Enter a year: ");
		String year = in.nextLine();

		CarPojo toAdd = new CarPojo(make, model, year);
		Car.insertItem(toAdd);
	}

	private static void deleteAnItem() {

		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
//		System.out.print("Enter the year to delete: ");
//		int year = in.nextInt();
		CarPojo toDelete = new CarPojo(make, model);
		Car.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		System.out.println("3 : Search by Year");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CarPojo> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the make: ");
			String make = in.nextLine();
			foundItems = Car.searchForItemByMake(make);
		} else if (searchBy == 2) {
			System.out.print("Enter the model: ");
			String model = in.nextLine();
			foundItems = Car.searchForItemByModel(model);
		} else {
			System.out.print("Enter the year: ");
			int year = in.nextInt();
			foundItems = Car.searchForItemByYear(year);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (CarPojo l : foundItems) {
				System.out.println(l.getId() + " : " + l.returnItemDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CarPojo toEdit = Car.searchForItemById(idToEdit);
			System.out.println("Retrieved result Make: " + toEdit.getMake() + " Model: " + toEdit.getModel() + " Year: "
					+ toEdit.getYear());
			System.out.println("1 : Update Make");
			System.out.println("2 : Update Model");
			System.out.println("3 : Update Year");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			} else if (update == 3) {
				System.out.print("New Year: ");
				String newYear = in.nextLine();
				toEdit.setYear(newYear);
			}

			Car.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome Car list! ---");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Car");
			System.out.println("*  2 -- Edit a Car");
			System.out.println("*  3 -- Delete a Car");
			System.out.println("*  4 -- View all the Cars");
			System.out.println("*  5 -- Exit the awesome Car program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				Car.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() {
		List<CarPojo> allItems = Car.showAllItems();
		for (CarPojo singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}
	}
}
