package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.ComponentSwitchButton;
import com.example.vaadincomponents.components.MyGreeting;
import com.example.vaadincomponents.model.Person;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.Route;

@Route(value = "personForm", layout = MainLayout.class)
public class FormPersonView extends VerticalLayout {
    FormPersonView(){

        add(
                getTitle(),
                getForm(),
                getTwoFields()
        );
    }

    private Component getTwoFields() {
        MyGreeting myGreeting = new MyGreeting();

        return new Div(myGreeting);
    }

    private Component getForm() {
        FormLayout formLayout = new FormLayout();
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        EmailField emailField = new EmailField("Email");
        DatePicker dateOfBirth =  new DatePicker("Date of birth");
        ComponentSwitchButton isStudent = new ComponentSwitchButton();
        isStudent.setRoundness("round");
        isStudent.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button savePerson = new Button("Save");
        savePerson.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button resetData = new Button("Reset");
        formLayout.add(firstName, lastName, emailField,isStudent, dateOfBirth,savePerson, resetData);


        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName).withValidator(name -> name.matches("[A-Z]+[a-z]+"), "Not good name")
                .bind(
                        Person::getFirstName,
                        Person::setFirstName
                );
        binder.forField(lastName)
                .bind(
                        Person::getLastName,
                        Person::setLastName
                );

        binder.forField(emailField).withValidator(new EmailValidator("Not looks like email"))
                .bind(
                Person::getEmailAddress,
                Person::setEmailAddress
        );

        binder.forField(dateOfBirth)
                .bind(Person::getDateOfBirth, Person::setDateOfBirth);
        Person person = new Person("Marko", "Markovic","marko@hotmail.com", true);

        binder.forField(isStudent).bind(Person::getStudent, Person::setStudent);

        binder.readBean(person);

        savePerson.addClickListener(event -> {
            try {
                binder.writeBean(person);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });
        resetData.addClickListener(event -> {
            binder.readBean(person);
        });
        return formLayout;
    }

    private Component getTitle() {
       return  new H2("Person form");
    }
}