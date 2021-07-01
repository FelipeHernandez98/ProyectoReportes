package co.edu.ufps.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;



	public class Conexion <T> {
		private Class<T> c;
		private static EntityManager em = null;
		
		public Conexion() {
			em = Conexion.getEm();
		}
		
		public Conexion(Class<T> c) {
			em = Conexion.getEm();
			this.c = c;
		}
		
		public void setC(Class<T> c){
			this.c = c;
		}
		
		public static EntityManager getEm(){
			if ( em == null ) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Reportes");
	            em = emf.createEntityManager();
	        }
			return em;
		}
		
		public <E> T find(E id){
			T object = (T) em.find(c, id);
			return object;
		}
		
		public List<T> list(){
			TypedQuery<T> consulta= em.createNamedQuery(c.getSimpleName()+".findAll", c);
			List<T> lista = (List<T>) consulta.getResultList();
			return lista;
		}
		
		
		public void insert(T obj){
			try {
				em.getTransaction().begin();
				em.persist(obj);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				//em.close();
			}
			
		}
		
		public void update(T obj){
			try {
				em.getTransaction().begin();
				em.merge(obj);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				//em.close();
			}
			
		}
		
		public void delete(T id){
			try {
				em.getTransaction().begin();
				em.remove(id);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				//em.close();
			}
			
		}
		public <E> T buscarFila(String fieldName, E fieldValue) {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(c);
			Root<T> root = criteriaQuery.from(c);
			criteriaQuery.select(root);

			ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
			criteriaQuery.where(criteriaBuilder.equal(root.get(fieldName), params));

			TypedQuery<T> query = (TypedQuery<T>) em.createQuery(criteriaQuery);
			query.setParameter(params, (String) fieldValue);

			List<T> queryResult = query.getResultList();

			T returnObject = null;

			if (!queryResult.isEmpty()) {
				returnObject = queryResult.get(0);
			}

			return returnObject;
		}

}
