package br.edu.unisep.biblioteca.util;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.Usuario;

import java.io.*;
import java.util.*;

public class Funcoes {
    private List<Livro> livrosDisponiveis = new ArrayList<>();
    private List<Livro> livrosEmprestados = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Funcoes() {
        carregarDados();
    }

    public boolean emprestarLivro(Livro livro, Usuario usuario) {
        if (livrosDisponiveis.contains(livro)) {
            livrosDisponiveis.remove(livro);
            livrosEmprestados.add(livro);
            salvarDados();
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            livrosDisponiveis.add(livro);
            salvarDados();
            return true;
        }
        return false;
    }

    public List<String> listarTitulosEmprestados() {
        List<String> titulos = new ArrayList<>();
        for (Livro livro : livrosEmprestados) {
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }


    private void carregarDados() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("livros.dat"))) {
            livrosDisponiveis = (List<Livro>) in.readObject();
            System.out.println("Livros carregados: " + livrosDisponiveis.size());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo livros.dat não encontrado, criando novos livros...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar livros. Criando novos livros...");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            usuarios = (List<Usuario>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo usuarios.dat não encontrado.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar usuários.");
        }
    }
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        salvarDados();
    }
    public void cadastrarLivro(Livro livro) {
        livrosDisponiveis.add(livro);
        salvarDados();
    }

    public void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("livros.dat"))) {
            out.writeObject(livrosDisponiveis);
            out.writeObject(livrosEmprestados);
        } catch (IOException e) {
            System.out.println("Erro ao salvar livros: " + e.getMessage());
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
