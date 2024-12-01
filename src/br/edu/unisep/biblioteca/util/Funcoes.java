package br.edu.unisep.biblioteca.util;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.LivroDigital;
import br.edu.unisep.biblioteca.model.LivroFisico;

import java.util.ArrayList;
import java.util.List;

public class Funcoes {
    private List<Livro> livrosEmprestados = new ArrayList<>();

    // Construtor de exemplo com dados simulados
    public Funcoes() {
        livrosEmprestados.add(new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1"));
        livrosEmprestados.add(new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe"));
    }

    // Método para listar títulos dos livros emprestados
    public List<String> listarTitulosEmprestados() {
        List<String> titulos = new ArrayList<>();
        for (Livro livro : livrosEmprestados) {
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }
}
