package models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// é um tipo de pessoa, representa pessoa fisica, possui cpf
@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pes_fis_id")
    private int id;
    
    @Column(name="pes_fis_sobrenome")
    private String sobrenome;
    
    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;
    
    @Column(name="pes_fis_cpf")
    private long cpf;
    
    @Temporal (TemporalType.DATE)
    @Column(name="pes_fis_data_nascimento")
    private Date dataNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
