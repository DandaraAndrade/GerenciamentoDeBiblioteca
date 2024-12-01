package br.edu.unisep.biblioteca.view;

import br.edu.unisep.biblioteca.model.*;
import br.edu.unisep.biblioteca.util.Funcoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcoes controle = new Funcoes();

        List<Livro> livros = new ArrayList<>();
        livros.add(new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1"));
        livros.add(new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe"));


        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João", "123456"));
        usuarios.add(new Usuario("Maria", "654321"));

        System.out.println("Bem-vindo à Biblioteca!");
        boolean sair = false;

        while (!sair) {
            System.out.println("\nMenu:");
            System.out.println("1. Emprestar Livro");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Listar Livros Emprestados");
            System.out.println("4. Cadastrar Usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Qual livro deseja emprestar?");
                    for (int i = 0; i < livros.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, livros.get(i).getTitulo());
                    }
                    System.out.print("Escolha: ");
                    int escolhaEmprestar = validarEscolha(scanner, livros.size());
                    if (escolhaEmprestar == -1) continue;

                    Livro livroEscolhidoEmprestar = livros.get(escolhaEmprestar - 1);
                    System.out.println("Escolha o usuário para o empréstimo:");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, usuarios.get(i).getNome());
                    }
                    System.out.print("Escolha: ");
                    int escolhaUsuario = validarEscolha(scanner, usuarios.size());
                    if (escolhaUsuario == -1) continue;

                    Usuario usuarioEscolhido = usuarios.get(escolhaUsuario - 1);
                    if (controle.emprestarLivro(livroEscolhidoEmprestar, usuarioEscolhido)) {
                        System.out.println("Livro emprestado com sucesso para: " + usuarioEscolhido.getNome());
                    } else {
                        System.out.println("Livro indisponível para empréstimo.");
                    }
                    break;

                case 2:
                    System.out.println("Qual livro deseja devolver?");
                    for (int i = 0; i < livros.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, livros.get(i).getTitulo());
                    }
                    System.out.print("Escolha: ");
                    int escolhaDevolver = validarEscolha(scanner, livros.size());
                    if (escolhaDevolver == -1) continue;

                    Livro livroEscolhidoDevolver = livros.get(escolhaDevolver - 1);
                    if (controle.devolverLivro(livroEscolhidoDevolver)) {
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Esse livro não está emprestado.");
                    }
                    break;

                case 3:
                    List<String> emprestados = controle.listarTitulosEmprestados();
                    if (emprestados.isEmpty()) {
                        System.out.println("Nenhum livro emprestado no momento.");
                    } else {
                        System.out.println("Livros emprestados:");
                        for (String titulo : emprestados) {
                            System.out.println("- " + titulo);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Cadastro de novo usuário:");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    usuarios.add(new Usuario(nome, senha));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 5:
                    sair = true;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static int validarEscolha(Scanner scanner, int maxOpcoes) {
        try {
            int escolha = Integer.parseInt(scanner.nextLine());
            if (escolha < 1 || escolha > maxOpcoes) {
                System.out.println("Escolha inválida. Tente novamente.");
                return -1;
            }
            return escolha;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
            return -1;
        }
    }
}
