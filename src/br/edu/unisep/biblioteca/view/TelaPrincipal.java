package br.edu.unisep.biblioteca.view;

import br.edu.unisep.biblioteca.util.Funcoes;
import br.edu.unisep.biblioteca.view.telas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel painelConteudo;

    public TelaPrincipal(Funcoes controle) {
        setTitle("Sistema de Biblioteca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);

        painelConteudo.add(new TelaEmprestar(controle), "emprestar");
        painelConteudo.add(new TelaDevolver(controle), "devolver");
        painelConteudo.add(new TelaListarEmprestimo(controle), "listar");
        painelConteudo.add(new TelaCadastrarUsuario(controle), "usuarios");
        painelConteudo.add(new TelaCadastrarLivro(controle), "livros");

        add(painelConteudo, BorderLayout.CENTER);

        JPanel painelNavegacao = new JPanel();
        painelNavegacao.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnEmprestar = new JButton("Emprestar Livro");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnListar = new JButton("Livros Emprestados");
        JButton btnUsuarios = new JButton("Cadastrar Usuário");
        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        painelNavegacao.add(btnEmprestar);
        painelNavegacao.add(btnDevolver);
        painelNavegacao.add(btnListar);
        painelNavegacao.add(btnUsuarios);
        painelNavegacao.add(btnCadastrarLivro);

        add(painelNavegacao, BorderLayout.NORTH);

        btnEmprestar.addActionListener(e -> cardLayout.show(painelConteudo, "emprestar"));
        btnDevolver.addActionListener(e -> cardLayout.show(painelConteudo, "devolver"));
        btnListar.addActionListener(e -> cardLayout.show(painelConteudo, "listar"));
        btnUsuarios.addActionListener(e -> cardLayout.show(painelConteudo, "usuarios"));
        btnCadastrarLivro.addActionListener(e -> cardLayout.show(painelConteudo, "livros"));  // Ação para a tela de cadastro de livros

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controle.salvarDados();  // Salva os dados antes de fechar
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Funcoes controle = new Funcoes();
            TelaPrincipal tela = new TelaPrincipal(controle);
            tela.setVisible(true);
        });
    }
}
