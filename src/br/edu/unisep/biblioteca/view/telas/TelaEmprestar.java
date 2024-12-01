package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.Livro;
import br.edu.unisep.biblioteca.model.LivroFisico;
import br.edu.unisep.biblioteca.model.LivroDigital;
import br.edu.unisep.biblioteca.model.Usuario;
import br.edu.unisep.biblioteca.util.Funcoes;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaEmprestar extends JPanel {
    public TelaEmprestar(Funcoes controle) {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Empréstimo de Livros", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridLayout(0, 1));
        JButton btnLivro1 = new JButton("Emprestar: 1984");
        JButton btnLivro2 = new JButton("Emprestar: O Pequeno Príncipe");
        painelCentral.add(btnLivro1);
        painelCentral.add(btnLivro2);
        add(painelCentral, BorderLayout.CENTER);

        JLabel lblStatus = new JLabel(" ", JLabel.CENTER);
        lblStatus.setForeground(Color.BLUE);
        add(lblStatus, BorderLayout.SOUTH);

        btnLivro1.addActionListener(e -> realizarEmprestimo(controle, new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1"), lblStatus));
        btnLivro2.addActionListener(e -> realizarEmprestimo(controle, new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe"), lblStatus));
    }

    private void realizarEmprestimo(Funcoes controle, Livro livro, JLabel lblStatus) {
        Usuario usuario = selecionarUsuario(controle);
        if (usuario != null) {
            if (controle.emprestarLivro(livro, usuario)) {
                lblStatus.setText("Livro emprestado para: " + usuario.getNome());
            } else {
                lblStatus.setText("Livro já está emprestado.");
            }
        } else {
            lblStatus.setText("Operação cancelada.");
        }
    }

    private Usuario selecionarUsuario(Funcoes controle) {
        List<Usuario> usuarios = controle.listarUsuarios();
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String[] opcoes = usuarios.stream().map(Usuario::toString).toArray(String[]::new);
        String selecionado = (String) JOptionPane.showInputDialog(this, "Selecione um usuário:", "Usuários", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (selecionado != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.toString().equals(selecionado)) {
                    return usuario;
                }
            }
        }
        return null;
    }
}
