/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pbo.latres;

import com.pbo.latres.model.MySQLTodoRepository;
import com.pbo.latres.model.TodoRepository;
import com.pbo.latres.controller.TodoController;
import com.pbo.latres.view.TodoView;

/**
 *
 * @author Lenovo
 */
public class Latres {

    public static void main(String[] args) {
        TodoRepository repository = new MySQLTodoRepository();
        TodoView view = new TodoView();
        new TodoController(repository, view);
    }
}