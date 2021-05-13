package br.com.bookstore.api.autor;

import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Autor {
    
    private int id;
    private String nome;
    private Date dataNascimento;
    private Genero genero;
    //
    public Autor() {
    }
    public Autor(String nome, Date dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    public Autor(int id, String nome, Date dataNascimento, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    //
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public Genero getGenero() {
        return genero;
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
