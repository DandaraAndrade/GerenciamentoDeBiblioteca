package br.edu.unisep.biblioteca.view.telas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("Biblioteca - Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnEmprestar = new JButton("Emprestar Livro");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnListar = new JButton("Listar Empréstimos");

        btnEmprestar.setBounds(100, 50, 200, 30);
        btnDevolver.setBounds(100, 100, 200, 30);
        btnListar.setBounds(100, 150, 200, 30);

        add(btnEmprestar);
        add(btnDevolver);
        add(btnListar);

        // Ações dos botões
        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaEmprestar().setVisible(true);
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaDevolver().setVisible(true);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaListarEmprestimo().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }
}
