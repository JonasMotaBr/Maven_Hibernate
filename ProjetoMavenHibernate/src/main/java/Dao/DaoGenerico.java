package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ProjetoMavenHibernate.ProjetoMavenHibernate.HibernateUtil;


public class DaoGenerico<T> {

	private Class<T> classe;
	private EntityManager em = HibernateUtil.getEntityManager();
	private EntityTransaction transaction = em.getTransaction();
	
	
	
	
	
	public DaoGenerico(Class<T> classe) {
		this.classe = classe;
	}


	public DaoGenerico<T>  Abrir(){
		transaction.begin();
		return this;
	}
	
	
	public DaoGenerico<T>  Fechar(){
		transaction.commit();
		return this;
	}
	
	
	public void add(T entidade) {
		em.persist(entidade);
	}
	
	
	
	                  //(Class<T> entityClass,Long codigo
	public T consultar(Long codigo) {
		 T t = em.find(classe, codigo);
		return t;
	}
	
	
	public T Update(T entidade, Long id) {
		
		T t = em.find(classe, id);
		T t2 =em.merge(t);
		return t;
	}
	
	public T deletar(Long codigo) {
		T t = consultar(codigo);
		em.remove(t);
		return t;
		

	}
	
	public List<T> ListarTodos(){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql ="SELECT u FROM "+ classe.getName()+" u";
		TypedQuery<T> query = em.createQuery(jpql, classe);
		List<T> lista = query.getResultList();
	
		/* ou exibe no metodo, ou na main
		 * for(T c : lista) { System.out.println(c); }
		 */
		
		return lista;
	}

	public void addTelefone(T entidade) {
		em.persist(entidade);
	}
	
	
	
	

	public EntityManager getEm() {
		return em;
	}
	
	

	
}
