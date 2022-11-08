package logica;

import java.sql.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Prueba {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
//		Actividad act = (Actividad) em.find(Actividad.class, 1);
//		System.out.println(act.getNombre());
		Turista dtTur = new Turista("Turista1", "n", "a", "mail1", new Date(0, 0, 0), "nac", null);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dtTur);
		tx.commit();
		em.close();
		emf.close();
	}

}
