package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.util.Funcoes;

import javax.swing.*;
import java.awt.*;

public class TelaCadastrarLivro extends JPanel {
    public TelaCadastrarLivro(Funcoes controle) {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Cadastro de Livros", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelForm = new JPanel(new GridLayout(0, 2));
        JLabel lblTituloLivro = new JLabel("Título:");
        JTextField txtTitulo = new JTextField();
        JLabel lblAutor = new JLabel("Autor:");
        JTextField txtAutor = new JTextField();
        JLabel lblGenero = new JLabel("Gênero:");
        JTextField txtGenero = new JTextField();

        painelForm.add(lblTituloLivro);
        painelForm.add(txtTitulo);
        painelForm.add(lblAutor);
        painelForm.add(txtAutor);
        painelForm.add(lblGenero);
        painelForm.add(txtGenero);

        add(painelForm, BorderLayout.CENTER);

        JPanel painelRodape = new JPanel(new BorderLayout());
        JButton btnCadastrar = new JButton("Cadastrar");
        painelRodape.add(btnCadastrar, BorderLayout.NORTH);

        JLabel lblStatus = new JLabel(" ", JLabel.CENTER);
        lblStatus.setForeground(Color.BLUE);
        painelRodape.add(lblStatus, BorderLayout.SOUTH);

        add(painelRodape, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            String autor = txtAutor.getText().trim();
            String genero = txtGenero.getText().trim();

            if (!titulo.isEmpty() && !autor.isEmpty() && !genero.isEmpty()) {
                Livro livro = new Livro(titulo, autor, genero) {
                    @Override
                    public void exibirDetalhes() {

                    }
                };
                controle.cadastrarLivro(livro);
                lblStatus.setText("Livro cadastrado com sucesso!");
                txtTitulo.setText("");
                txtAutor.setText("");
                txtGenero.setText("");
            } else {
                lblStatus.setText("Preencha todos os campos.");
            }
        });
    }
}
