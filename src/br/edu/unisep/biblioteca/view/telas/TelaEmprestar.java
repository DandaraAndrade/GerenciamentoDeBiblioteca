package br.edu.unisep.biblioteca.view.telas;

import javax.swing.*;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.LivroDigital;
import br.edu.unisep.biblioteca.model.LivroFisico;
import br.edu.unisep.biblioteca.util.Funcoes;

public class TelaEmprestar extends JFrame {
    private Funcoes controle = new Funcoes();

    public TelaEmprestar() {
        setTitle("Emprestar Livro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título do Livro:");
        lblTitulo.setBounds(50, 50, 100, 30);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(150, 50, 200, 30);
        add(txtTitulo);

        JButton btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(150, 100, 100, 30);
        add(btnEmprestar);

        JLabel lblMensagem = new JLabel("");
        lblMensagem.setBounds(50, 150, 300, 30);
        add(lblMensagem);

        btnEmprestar.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            Livro livro = buscarLivro(titulo); // Simula a busca por um livro (implemente este método)
            if (livro != null && controle.emprestarLivro(livro)) {
                lblMensagem.setText("Livro emprestado com sucesso!");
            } else {
                lblMensagem.setText("Erro ao emprestar o livro!");
            }
        });
    }

    private Livro buscarLivro(String titulo) {
        if ("1984".equalsIgnoreCase(titulo)) {
            return new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1");
        } else if ("O Pequeno Príncipe".equalsIgnoreCase(titulo)) {
            return new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe");
        }
        return null;
    }
}

