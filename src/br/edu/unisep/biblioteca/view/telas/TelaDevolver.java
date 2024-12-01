package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.LivroFisico;
import br.edu.unisep.biblioteca.model.LivroDigital;
import br.edu.unisep.biblioteca.util.Funcoes;

import javax.swing.*;
import java.awt.*;

public class TelaDevolver extends JPanel {
    public TelaDevolver(Funcoes controle) {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Devolução de Livros", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridLayout(0, 1));
        JButton btnLivro1 = new JButton("Devolver: 1984");
        JButton btnLivro2 = new JButton("Devolver: O Pequeno Príncipe");

        painelCentral.add(btnLivro1);
        painelCentral.add(btnLivro2);

        add(painelCentral, BorderLayout.CENTER);

        JLabel lblStatus = new JLabel(" ", JLabel.CENTER);
        lblStatus.setForeground(Color.BLUE);
        add(lblStatus, BorderLayout.SOUTH);

        btnLivro1.addActionListener(e -> {
            Livro livro = new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1");
            if (controle.devolverLivro(livro)) {
                lblStatus.setText("Livro '1984' devolvido com sucesso!");
            } else {
                lblStatus.setText("O livro '1984' não está emprestado.");
            }
        });

        btnLivro2.addActionListener(e -> {
            Livro livro = new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe");
            if (controle.devolverLivro(livro)) {
                lblStatus.setText("Livro 'O Pequeno Príncipe' devolvido com sucesso!");
            } else {
                lblStatus.setText("O livro 'O Pequeno Príncipe' não está emprestado.");
            }
        });
    }
}
