package br.edu.unisep.biblioteca.view.telas;

import javax.swing.*;
import br.edu.unisep.biblioteca.util.Funcoes;
import java.awt.*;

public class TelaListarEmprestimo extends JFrame {
    private Funcoes controle = new Funcoes();

    public TelaListarEmprestimo() {
        setTitle("Livros Emprestados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para exibição
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false); // Bloqueia edição
        JScrollPane scrollPane = new JScrollPane(areaTexto); // Adiciona barra de rolagem
        add(scrollPane, BorderLayout.CENTER);

        // Botão de atualização
        JButton btnAtualizar = new JButton("Atualizar");
        add(btnAtualizar, BorderLayout.SOUTH);

        // Ação do botão
        btnAtualizar.addActionListener(e -> {
            areaTexto.setText(""); // Limpa o texto atual
            for (String titulo : controle.listarTitulosEmprestados()) {
                areaTexto.append(titulo + "\n"); // Adiciona cada título na área de texto
            }
        });
    }
}
