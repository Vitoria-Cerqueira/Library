package org.example.view;

import org.example.model.BookModel;
import org.example.service.BookService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
        private Scanner scanner;
        BookModel bookModel;
        BookService bookService;

        public MenuView() {
            scanner = new Scanner(System.in);
            bookModel = new BookModel();
            bookService = new BookService();
        }

        public void start() {
            int option;
            int code;
            String nameBook;
            String nameAuthor;
            String date;
            do {
                showMenu();
                option = selectedOption();
                switch (option) {
                    case 1:
                        System.out.println("=== Cadastro de livro ===");
                        System.out.println("Digite o código:");
                        code = scanner.nextInt();
                        bookModel.setCode(code);
                        System.out.println("Digite o nome do livro:");
                        nameBook = scanner.next();
                        bookModel.setNameBook(nameBook);

                        System.out.println("Digite o nome do autor:");
                        nameAuthor = scanner.next();
                        bookModel.setNameAuthor(nameAuthor);

                        System.out.println("Digite a data de lançamento:");
                        date = scanner.next();
                        bookModel.setDate(date);

                        bookService.register(bookModel.getCode(), bookModel.getNameBook(), bookModel.getNameAuthor(), bookModel.getDate());
                        break;
                    case 2:
                        bookService.showBooks();
                        break;
                    case 3:
                        System.out.println("Digite o código do livro que deseja ver:");
                        code = scanner.nextInt();
                        bookService.showSpecificBooks(code);
                        break;
                    case 4:
                        System.out.println("Digite o código do livro que deseja deletar:");
                        code = scanner.nextInt();
                        bookService.deleteInfo(code);
                        break;
                    case 5:
                        System.out.println("Digite o código do livro para alterar o nome do autor:");
                        code = scanner.nextInt();
                        System.out.println("Digite o novo nome do autor:");
                        nameAuthor = scanner.next();
                        bookModel.setNameAuthor(nameAuthor);
                        bookService.changeInfo(code, bookModel.getNameAuthor());
                        break;
                    case 6:
                        System.out.println("Obrigada por frequentar nossa biblioteca!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente");
                        break;
                }
            } while (option != 6);
        }

        public void showMenu() {
            System.out.println("=== Bem-vindo à Biblioteca ===");
            System.out.println("Você deseja:\n1-Cadastrar livro | 2-Ver todos os livros | 3-Ver livro por código");
            System.out.println("4-Deletar um livro | 5-Alterar nome do autor do livro | 6-Sair");
        }

        public int selectedOption() {
            try {
                int option = scanner.nextInt();
                return option;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
            return 0;
        }
    }

