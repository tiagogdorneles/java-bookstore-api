package br.com.bookstore.api.autor;

/**
 *
 * @author Tiago
 */
public enum Genero {
    M("Masculino"),
    F("Feminino");
    //
    private String descricao;
    //
    private Genero(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }
}
