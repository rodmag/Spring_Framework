package br.com.treinaweb.twclientes.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    private Date dataNascimento;

    @Column(nullable = false)
    private String profissao;

    public Cliente() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Cliente(long id, String nome, Date dataNascimento, String profissao) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nome, cliente.nome) && Objects.equals(dataNascimento, cliente.dataNascimento) && Objects.equals(profissao, cliente.profissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, profissao);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", profissao='" + profissao + '\'' +
                '}';
    }
}
