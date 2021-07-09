package ProjetoMavenHibernate.ProjetoMavenHibernate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dao.DaoGenerico;
import Model.TelefoneUser;
import Model.UsuarioPessoa;

public class TestHibernate {

	@Test
	public void testHibernate() {
		HibernateUtil.getEntityManager();
	}

	@Test
	public void TesteAdd() {
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		usuario01.setNome("Bruna");
		usuario01.setSobrenome("Moura");
		usuario01.setEmail("Email");
		usuario01.setLogin("Login");
		usuario01.setSenha("Senha");

		// -----------------------------
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		dao.Abrir();
		dao.add(usuario01);
		dao.Fechar();
	}
	
	@Test
	public void TesteAddComnumero() {
		TelefoneUser Telefone01 = new TelefoneUser();
		Telefone01.setNumero("11111");
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		List<TelefoneUser> lista = new ArrayList<>();
		lista.add(Telefone01);
		
		
		usuario01.setNome("Bruna");
		usuario01.setSobrenome("Moura");
		usuario01.setEmail("Email");
		usuario01.setLogin("Login");
		usuario01.setSenha("Senha");
		usuario01.setListatelefone(lista);

		// -----------------------------
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		dao.Abrir();
		dao.add(usuario01);
		dao.Fechar();
	}
	
	@Test
	public void TesteAddnumero() {
		
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		dao.Abrir();
		UsuarioPessoa pessoa= dao.consultar(16L);
		dao.Fechar();
		
		if (pessoa != null) {
			TelefoneUser Telefone01 = new TelefoneUser();
			DaoGenerico<TelefoneUser> daoTelefone = new DaoGenerico<>(TelefoneUser.class);
		    Telefone01.setTipo("celular");
			Telefone01.setNumero("11111");
			Telefone01.setUsuariopessoa(pessoa);
			daoTelefone.Abrir();
			daoTelefone.add(Telefone01);
			daoTelefone.Fechar();
			
		}
		
		}
		
		
		
		
	
	
	
	

	@Test
	public void testeConsultar() {
		UsuarioPessoa usuario01 = new UsuarioPessoa();

		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		UsuarioPessoa pessoa= dao.consultar(1L);

		System.out.println("Resultado" + pessoa);

	}
	
	@Test
	public void testeUpdate() {
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		UsuarioPessoa usuario01 = dao.consultar(1L);
		usuario01.setLogin("Login01");
		
		dao.Abrir();
		//dao.Update(usuario01);
		dao.Fechar();
        
	}
	
	@Test
	public void testeDelete() {
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		UsuarioPessoa usuario01 = new UsuarioPessoa();
//		usuario01.setLogin("NovoLogin2");
//		usuario01.setSenha("0000");
//		
		dao.Abrir();
		dao.deletar(1L);
		dao.Fechar();
        
	}
	
	@Test
	public void testeListarTodos() {
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		UsuarioPessoa usuario01 = new UsuarioPessoa();

		dao.Abrir();
		System.out.println(dao.ListarTodos());
		dao.Fechar();
        
	}
	
	@Test
	public void QueryEspecifica() {
		String nome = "bruna";
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		String jpql = "FROM UsuarioPessoa where nome = '" +nome+"'";
		List<UsuarioPessoa> lista = dao.getEm().createQuery(jpql).setMaxResults(2).getResultList();
		
		for(UsuarioPessoa u : lista) {
			System.out.println(u.getNome());
		}
	
	}
	
	@Test
	public void QueryEspecifica2() {
		String nome = "bruna";
		String sobrenome = "moura";
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		String jpql = "FROM UsuarioPessoa where nome = :nome and sobrenome = :sobrenome";
		List<UsuarioPessoa> lista = dao.getEm().createQuery(jpql)
				                      .setParameter("nome", nome)
				                      .setParameter("sobrenome", sobrenome)
				                      .getResultList();
		
		for(UsuarioPessoa u : lista) {
			System.out.println(u.getNome());
		}
	
	}
	
	
	@Test
	public void QueryEspecificaSomandoValores() {
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		String jpql = "SELECT SUM(u.id) FROM UsuarioPessoa u ";
		Long resultado = (Long) dao.getEm().createQuery(jpql).getSingleResult();
		
		System.out.println(resultado);
	}
	
	
	/*  **********  Named Querys  ******************/
	
	//named query da classe UsuarioPessoa
	@Test
	public void NamedQuerydaretornatodos() {
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		
		List<UsuarioPessoa> lista = dao.getEm()
				.createNamedQuery("UsuarioPessoa.todos")
				.getResultList();
		

		for(UsuarioPessoa u : lista) {
			System.out.println(u.getNome());
		}
	}
	
	
	

}
