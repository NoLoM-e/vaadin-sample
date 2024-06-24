package com.example.demo.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Route("todo")
public class TodoView extends VerticalLayout {

    public TodoView() {

        addClassName("centered-content");

        var todoList = new VerticalLayout();
        var taskTextField = new TextField();
        var addButton = new Button("add", e -> {
            if (taskTextField.getValue().equals(StringUtils.EMPTY) || Objects.isNull(taskTextField.getValue())) {
                var emptyNotification = new Notification("Task cannot be empty");
                emptyNotification.setDuration(5 * 1000);
                emptyNotification.setPosition(Notification.Position.TOP_CENTER);
                emptyNotification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                emptyNotification.open();
            } else {
                var task = new Checkbox();
                task.setLabel(taskTextField.getValue());
                todoList.add(task);
                taskTextField.clear();
            }
        });
        addButton.addClickShortcut(Key.ENTER);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(
            new H1("Sample Todo List"),
            todoList,
            new HorizontalLayout(
                taskTextField,
                addButton
            )
        );
    }
}
