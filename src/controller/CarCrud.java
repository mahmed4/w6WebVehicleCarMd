package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.CarPojo;

public class CarCrud {
	// Md Ahmed
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("VehicleCar");

	public void insertItem(CarPojo li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<CarPojo> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<CarPojo> allItems = em.createQuery("SELECT i	FROM CarPojo i").getResultList();
		return allItems;
	}

	public void deleteItem(CarPojo toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarPojo> typedQuery = em.createQuery(
				"select li from CarPojo li where li.make = :selectedMake, li.model = :selectedModel and  li.year = :selectedYear",
				CarPojo.class);

		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		CarPojo result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public CarPojo searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarPojo found = em.find(CarPojo.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(CarPojo toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<CarPojo> searchForItemByMake(String make) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarPojo> typedQuery = em.createQuery("select li from CarPojo li where li.make = :selectedMake",
				CarPojo.class);
		typedQuery.setParameter("selectedMake", make);

		List<CarPojo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<CarPojo> searchForItemByModel(String model) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarPojo> typedQuery = em.createQuery("select li from CarPojo li where li.model = :selectedModel",
				CarPojo.class);
		typedQuery.setParameter("selectedModel", model);

		List<CarPojo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<CarPojo> searchForItemByYear(int year) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarPojo> typedQuery = em.createQuery("select li from CarPojo li where li.year = :selectedYear",
				CarPojo.class);
		typedQuery.setParameter("selectedYear", year);

		List<CarPojo> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
