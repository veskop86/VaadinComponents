package com.example.vaadincomponents.views;

import com.example.vaadincomponents.model.Person;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route(value = "personForm", layout = MainLayout.class)
public class FormPersonView extends VerticalLayout {
    FormPersonView(){

        add(
                getTitle(),
                getForm()
        );
    }

    private Component getForm() {
        FormLayout formLayout = new FormLayout();
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        EmailField emailField = new EmailField("Email");
        DatePicker dateOfBirth =  new DatePicker("Date of birth");
        Button savePerson = new Button("Save");
        formLayout.add(firstName, lastName, emailField, dateOfBirth, savePerson);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName)
                .bind(
                        Person::getFirstName,
                        Person::setFirstName
                );
        binder.forField(lastName)
                .bind(
                        Person::getLastName,
                        Person::setLastName
                );
        binder.forField(emailField).bind(
                Person::getEmailAddress,
                Person::setEmailAddress
        );
        binder.forField(dateOfBirth)
                .bind(Person::getDateOfBirth, Person::setDateOfBirth);

        return formLayout;
    }

    private Component getTitle() {
       return  new H2("Person form");
    }
}