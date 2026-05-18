package com.pbo.latres.presenter;

import com.pbo.latres.dto.InsertTodoDTO;
import com.pbo.latres.model.TodoRepository;
import com.pbo.latres.model.TodoTask;
import com.pbo.latres.view.TodoView;

public class TodoPresenter {

    private final TodoRepository repository;
    private final TodoView view;

    public TodoPresenter(
        TodoRepository repository,
        TodoView view
    ) {

        this.repository = repository;
        this.view = view;

        bindEvents();
        refreshTable();
    }

    private void bindEvents() {

        view.onAdd(e -> {

            String title = view.getTitleInput();
            String status = view.getStatusInput();

            if (title.isEmpty()) {

                view.showMessage(
                    "Task tidak boleh kosong"
                );

                return;
            }

            repository.insert(
                new InsertTodoDTO(title, status)
            );

            refreshTable();
            view.clearForm();
        });

        view.onUpdate(e -> {

            int selectedId =
                view.getSelectedTodoId();

            if (selectedId == -1) {

                view.showMessage(
                    "Pilih data terlebih dahulu"
                );

                return;
            }

            TodoTask task = new TodoTask(
                selectedId,
                view.getTitleInput(),
                view.getStatusInput()
            );

            repository.update(task);

            refreshTable();
            view.clearForm();
        });

        view.onDelete(e -> {

            int selectedId =
                view.getSelectedTodoId();

            if (selectedId == -1) {

                view.showMessage(
                    "Pilih data terlebih dahulu"
                );

                return;
            }

            repository.deleteById(selectedId);

            refreshTable();
            view.clearForm();
        });

        view.onClear(e ->
            view.clearForm()
        );

        view.onTableSelect(e -> {

            int selectedId =
                view.getSelectedTodoId();

            if (selectedId == -1) {
                return;
            }

            TodoTask task =
                repository.getById(selectedId);

            if (task != null) {
                view.setForm(task);
            }
        });
    }

    private void refreshTable() {
        view.showTodos(repository.getAll());
    }
}