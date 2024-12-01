package br.edu.unisep.biblioteca.view.telas;

import javax.swing.*;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.LivroDigital;
import br.edu.unisep.biblioteca.model.LivroFisico;
import br.edu.unisep.biblioteca.util.Funcoes;

public class TelaDevolver extends JFrame {
    private Funcoes controle = new Funcoes();

    public TelaDevolver() {
        setTitle("Devolver Livro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título do Livro:");
        lblTitulo.setBounds(50, 50, 100, 30);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(150, 50, 200, 30);
        add(txtTitulo);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(150, 100, 100, 30);
        add(btnDevolver);

        JLabel lblMensagem = new JLabel("");
        lblMensagem.setBounds(50, 150, 300, 30);
        add(lblMensagem);

        btnDevolver.addActionListener(e -> {
            String titulo = txtTitulo.getText();
            Livro livro = buscarLivro(titulo); // Simula a busca por um livro (implemente este método)
            if (livro != null && controle.devolverLivro(livro)) {
                lblMensagem.setText("Livro devolvido com sucesso!");
            } else {
                lblMensagem.setText("Erro ao devolver o livro!");
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
