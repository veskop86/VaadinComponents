package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.example.vaadincomponents.components.SwitchButtonVariant;
import com.example.vaadincomponents.model.Person;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

@Route(value = "personForm", layout = MainLayout.class)
public class FormPersonView extends VerticalLayout {
    Person person = new Person("Marko", "Markovic","marko@hotmail.com", true);
    Binder<Person> binderForData = new Binder<>(Person.class);
    FormPersonView(){

        add(
                getTitle(),
                getForm(),
                getFormData()
        );
    }

    private Component getFormData() {
        FormLayout formLayout = new FormLayout();

        TextField firstName = new TextField();
        firstName.setReadOnly(true);
        TextField lastName = new TextField();
        lastName.setReadOnly(true);
        EmailField emailField = new EmailField();
        emailField.setReadOnly(true);
        SwitchButton isStudent = new SwitchButton();
        isStudent.setRoundness("rounded");
        isStudent.setEnabled(false);
        DatePicker datePicker = new DatePicker("Date of birth");

        formLayout.addFormItem(firstName, "First name:");
        formLayout.addFormItem(lastName, "Last name:");
        formLayout.addFormItem(emailField, "Email address:");
        formLayout.addFormItem(isStudent, "Is student:");
        formLayout.addFormItem(datePicker, "Date of birth");
        formLayout.setEnabled(false);

        binderForData = new Binder<>(Person.class);
        binderForData.forField(firstName)
                .bind(Person::getFirstName, Person::setFirstName);
        binderForData.forField(lastName)
                .bind(Person::getLastName, Person::setLastName);
        binderForData.forField(emailField).bind(Person::getEmailAddress, Person::setEmailAddress);
        binderForData.forField(isStudent).bind(Person::getStudent, Person::setStudent);
        binderForData.forField(datePicker).bind(Person::getDateOfBirth, Person::setDateOfBirth);
        binderForData.readBean(person);

        return new Div(new H3("Person data:"), formLayout);
    }


    private Component getForm() {
        FormLayout formLayout = new FormLayout();

        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");

        EmailField emailField = new EmailField("Email");

        DatePicker dateOfBirth =  new DatePicker("Date of birth");

        SwitchButton isStudent = new SwitchButton();
        isStudent.setRoundness("rounded");
        isStudent.setLabel("Student?");
        isStudent.addThemeVariants(SwitchButtonVariant.LUMO_ERROR);

        SwitchButton rigthSideButton = new SwitchButton();
        rigthSideButton.setRoundness("rounded");
        rigthSideButton.getStyle().setTextAlign(Style.TextAlign.RIGHT);
        rigthSideButton.setLabel("Student?");

        Button savePerson = new Button("Save");
        savePerson.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button resetData = new Button("Reset");
        formLayout.add(firstName, lastName, emailField, isStudent, dateOfBirth, rigthSideButton);

        Binder<Person> binder = new Binder<>(Person.class);
        binder.forField(firstName).withValidator(name -> name.matches("[A-Z]+[a-z]+"), "Not good name")
                .bind(Person::getFirstName, Person::setFirstName);
        binder.forField(lastName).
                bind(Person::getLastName, Person::setLastName);

        binder.forField(emailField).withValidator(new EmailValidator("Not looks like email"))
                .bind(
                Person::getEmailAddress,
                Person::setEmailAddress
        );

        binder.forField(dateOfBirth)
                .bind(Person::getDateOfBirth, Person::setDateOfBirth);

        binder.forField(isStudent).bind(Person::getStudent, Person::setStudent);

        binder.readBean(person);

        isStudent.addValueChangeListener(event -> {
            try {
                binder.writeBean(person);
                binderForData.readBean(person);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }

        });

        savePerson.addClickListener(event -> {
            try {
                binder.writeBean(person);
                binderForData.readBean(person);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });

        resetData.addClickListener(event -> {
            binder.readBean(person);
            binderForData.readBean(person);
        });
        return new Div(new H2("Sava data to see changes"), formLayout, savePerson, resetData);
    }

    private Component getTitle() {
       return  new Div(new H2("Person form"));
    }
}