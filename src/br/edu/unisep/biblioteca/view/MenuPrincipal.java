package br.edu.unisep.biblioteca.view;

import br.edu.unisep.biblioteca.model.*;
import br.edu.unisep.biblioteca.util.Funcoes;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcoes controle = new Funcoes();

        Livro livro1 = new LivroFisico("1984", "George Orwell", "Ficção", "Estante A1");
        Livro livro2 = new LivroDigital("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil", "www.download.com/principe");

        System.out.println("Bem-vindo à Biblioteca!");
        boolean sair = false;

        while (!sair) {
            System.out.println("\nMenu:");
            System.out.println("1. Emprestar Livro");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Listar Livros Emprestados");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Qual livro deseja emprestar?");
                    System.out.println("1. 1984");
                    System.out.println("2. O Pequeno Príncipe");
                    int escolha = scanner.nextInt();
                    Livro livroEscolhido = (escolha == 1) ? livro1 : livro2;
                    if (controle.emprestarLivro(livroEscolhido)) {
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Livro indisponível para empréstimo.");
                    }
                    break;
                case 2:
                    System.out.println("Qual livro deseja devolver?");
                    System.out.println("1. 1984");
                    System.out.println("2. O Pequeno Príncipe");
                    escolha = scanner.nextInt();
                    livroEscolhido = (escolha == 1) ? livro1 : livro2;
                    if (controle.devolverLivro(livroEscolhido)) {
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Esse livro não está emprestado.");
                    }
                    break;
                case 3:
                    controle.listarEmprestimos();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
