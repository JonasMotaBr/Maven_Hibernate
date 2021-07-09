package ProjetoMavenHibernate.ProjetoMavenHibernate;

import java.util.List;

import Dao.DaoGenerico;
import Model.UsuarioPessoa;

public class TestCompiler {

	public static void main(String[] args) {
		
		
		String nome = "bruna";
		UsuarioPessoa usuario01 = new UsuarioPessoa();
		DaoGenerico<UsuarioPessoa> dao = new DaoGenerico<>(UsuarioPessoa.class);
		String jpql = "FROM UsuarioPessoa where nome = '" +nome+"'";
		List<UsuarioPessoa> lista = dao.getEm().createQuery(jpql).getResultList();
		
		for(UsuarioPessoa u : lista) {
			System.out.println(u.getNome());
		}
	}

}
