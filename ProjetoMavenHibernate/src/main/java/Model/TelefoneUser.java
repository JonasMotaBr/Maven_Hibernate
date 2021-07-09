package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class TelefoneUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)//obrigatorio preenchimento
	private String tipo;
	@Column(nullable = false)//obrigatorio preenchimento
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)//optional obrigatorio
	private UsuarioPessoa usuariopessoa;

	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioPessoa getUsuariopessoa() {
		return usuariopessoa;
	}

	public void setUsuariopessoa(UsuarioPessoa usuariopessoa) {
		this.usuariopessoa = usuariopessoa;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
