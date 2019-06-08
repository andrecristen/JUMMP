package models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@NamedQueries(@NamedQuery(name="validarLogin",query="SELECT user FROM Usuario user WHERE user.login = ?1 AND user.senha = ?2"))
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="usu_id")
    private int id;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;
    
    @Enumerated(EnumType.STRING)
    @Column(name="usu_tipo")
    private TipoUsuario tipo;
    
    @Column(name="usu_login", unique=true)
    private String login;
    
    @Column(name="usu_senha")
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
