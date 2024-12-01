package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.util.Funcoes;

import javax.swing.*;
import java.awt.*;

public class TelaListarEmprestimo extends JPanel {

    public TelaListarEmprestimo(Funcoes controle) {
        setLayout(new BorderLayout(10, 10)); // Espaçamento entre componentes
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem externa

        JLabel lblTitulo = new JLabel("Livros Emprestados", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);


        JButton btnAtualizar = new JButton("Atualizar");
        add(btnAtualizar, BorderLayout.SOUTH);

        btnAtualizar.addActionListener(e -> {
            areaTexto.setText("");
            var livrosEmprestados = controle.listarTitulosEmprestados();
            if (livrosEmprestados.isEmpty()) {
                areaTexto.append("Nenhum livro emprestado no momento.\n");
            } else {
                for (String titulo : livrosEmprestados) {
                    areaTexto.append(titulo + "\n");
                }
            }
        });
    }
}
