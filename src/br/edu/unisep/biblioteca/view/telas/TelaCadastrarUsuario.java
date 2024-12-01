package br.edu.unisep.biblioteca.view.telas;

import br.edu.unisep.biblioteca.model.Usuario;
import br.edu.unisep.biblioteca.util.Funcoes;

import javax.swing.*;
import java.awt.*;

public class TelaCadastrarUsuario extends JPanel {
    public TelaCadastrarUsuario(Funcoes controle) {
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Cadastro de Usuários", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelForm = new JPanel(new GridLayout(0, 2));
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        painelForm.add(lblNome);
        painelForm.add(txtNome);
        painelForm.add(lblEmail);
        painelForm.add(txtEmail);

        add(painelForm, BorderLayout.CENTER);

        JPanel painelRodape = new JPanel(new BorderLayout());
        JButton btnCadastrar = new JButton("Cadastrar");
        painelRodape.add(btnCadastrar, BorderLayout.NORTH);

        JLabel lblStatus = new JLabel(" ", JLabel.CENTER);
        lblStatus.setForeground(Color.BLUE);
        painelRodape.add(lblStatus, BorderLayout.SOUTH);

        add(painelRodape, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String email = txtEmail.getText().trim();

            if (!nome.isEmpty() && !email.isEmpty()) {
                controle.cadastrarUsuario(new Usuario(nome, email));
                lblStatus.setText("Usuário cadastrado com sucesso!");
                txtNome.setText("");
                txtEmail.setText("");
            } else {
                lblStatus.setText("Preencha todos os campos.");
            }
        });
    }
}
