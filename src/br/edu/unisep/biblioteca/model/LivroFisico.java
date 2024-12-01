package br.edu.unisep.biblioteca.model;

public class LivroFisico extends Livro {
    private String localizacao;

    public LivroFisico(String titulo, String autor, String genero, String localizacao) {
        super(titulo, autor, genero);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro Físico: " + getTitulo() + " (Localização: " + localizacao + ")");
    }
}
