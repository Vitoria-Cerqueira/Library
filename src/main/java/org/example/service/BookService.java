package org.example.service;

import java.sql.*;

import static org.example.connetion.ConnetionDB.connection;

public class BookService {
    private Statement stmt;
    private Connection connection = connection();


    public void register(int code, String nameBook, String nameAuthor, String date) {
        String sql = "INSERT INTO books (code, namebook, nameauthor, date) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            preparedStatement.setString(2, nameBook);
            preparedStatement.setString(3, nameAuthor);
            preparedStatement.setString(4, date);
            preparedStatement.executeUpdate();
            System.out.println("Livro registrado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changeInfo(Integer code, String nameAuthor) {
        String sql = "UPDATE books SET nameauthor = ? WHERE code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameAuthor);
            preparedStatement.setInt(2, code);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Livro alterado com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com o código fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInfo(Integer code) {
        String sql = "DELETE FROM books WHERE code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Livro deletado com sucesso!");
            } else {
                System.out.println("Nenhum livro encontrado com o código fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showSpecificBooks(Integer code) {
        String sql = "SELECT * FROM books where code = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println("CODIGO: " + result.getInt("code"));
                System.out.println("NOME DO LIVRO: " + result.getString("namebook"));
                System.out.println("NOME DO AUTOR: " + result.getString("nameauthor"));
                System.out.println("DATA DE LANÇAMENTO: " + result.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showBooks() {
        String sql = "SELECT * FROM books";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println("------- Livros ------");
                System.out.println("CODIGO: " + result.getInt("code"));
                System.out.println("NOME DO LIVRO: " + result.getString("namebook"));
                System.out.println("NOME DO AUTOR: " + result.getString("nameauthor"));
                System.out.println("DATA DE LANÇAMENTO: " + result.getString("date"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
