package br.edu.unisep.biblioteca.model;

public class LivroDigital extends Livro {
    private String urlDownload;

    public LivroDigital(String titulo, String autor, String genero, String urlDownload) {
        super(titulo, autor, genero);
        this.urlDownload = urlDownload;
    }

    public String getUrlDownload() {
        return urlDownload;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro Digital: " + getTitulo() + " (Download: " + urlDownload + ")");
    }
}
