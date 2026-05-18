/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.latres.model;

import com.pbo.latres.config.DatabaseConnection;
import com.pbo.latres.dto.InsertTodoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class MySQLTodoRepository
implements TodoRepository {

    public MySQLTodoRepository() {
        initTable();
    }

    private void initTable() {

        String createDb =
            "CREATE DATABASE IF NOT EXISTS todo_db";

        String createTable =
            "CREATE TABLE IF NOT EXISTS todo_tasks (" +
            "id INT NOT NULL AUTO_INCREMENT," +
            "title VARCHAR(255) NOT NULL," +
            "status VARCHAR(50) NOT NULL," +
            "PRIMARY KEY (id)" +
            ")";

        try {

            Connection connNoDB =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/",
                    "root",
                    ""
                );

            connNoDB.createStatement()
                .executeUpdate(createDb);

            connNoDB.close();

            Connection conn =
                DatabaseConnection.getConnection();

            conn.createStatement()
                .executeUpdate(createTable);

        } catch (SQLException e) {

            throw new RuntimeException(
                "Gagal menginisialisasi tabel: "
                + e.getMessage(),
                e
            );
        }
    }

    @Override
    public List<TodoTask> getAll() {

        List<TodoTask> result =
            new ArrayList<>();

        String sql =
            "SELECT id, title, status " +
            "FROM todo_tasks ORDER BY id ASC";

        try (
            Connection conn =
                DatabaseConnection.getConnection();

            Statement stmt =
                conn.createStatement();

            ResultSet rs =
                stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                    new TodoTask(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status")
                    )
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public TodoTask getById(int id) {

        String sql =
            "SELECT id, title, status " +
            "FROM todo_tasks WHERE id = ?";

        try (
            Connection conn =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs =
                ps.executeQuery()) {

                if (rs.next()) {

                    return new TodoTask(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("status")
                    );
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean insert(
        InsertTodoDTO insertTodoDTO
    ) {

        String sql =
            "INSERT INTO todo_tasks " +
            "(title, status) VALUES (?, ?)";

        try (
            Connection conn =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setString(
                1,
                insertTodoDTO.getTitle()
            );

            ps.setString(
                2,
                insertTodoDTO.getStatus()
            );

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    @Override
    public Boolean update(TodoTask todoTask) {

        String sql =
            "UPDATE todo_tasks " +
            "SET title = ?, status = ? " +
            "WHERE id = ?";

        try (
            Connection conn =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setString(
                1,
                todoTask.getTitle()
            );

            ps.setString(
                2,
                todoTask.getStatus()
            );

            ps.setInt(
                3,
                todoTask.getId()
            );

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    @Override
    public Boolean deleteById(int id) {

        String sql =
            "DELETE FROM todo_tasks " +
            "WHERE id = ?";

        try (
            Connection conn =
                DatabaseConnection.getConnection();

            PreparedStatement ps =
                conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }
}