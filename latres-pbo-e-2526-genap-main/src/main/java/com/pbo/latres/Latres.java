/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pbo.latres;

import com.pbo.latres.model.MySQLTodoRepository;
import com.pbo.latres.model.TodoRepository;
import com.pbo.latres.presenter.TodoPresenter;
import com.pbo.latres.view.TodoView;

/**
 *
 * @author Lenovo
 */
public class Latres {

    public static void main(String[] args) {

        TodoRepository repository = (TodoRepository) new MySQLTodoRepository();

        TodoView view = new TodoView();

        new TodoPresenter(repository, view);
    }
}