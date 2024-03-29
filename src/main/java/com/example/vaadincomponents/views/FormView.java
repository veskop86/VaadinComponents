package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.MyGreeting;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

@Route(layout = MainLayout.class)
public class FormView extends VerticalLayout{
    FormView(){
        add(
                getTitle(),
                getForm1(),
                getForm2(),
                getForm3(),
                getForm4(),
                getForm5(),
                getForm6()
        );

    }

    private Component getForm6() {
        FormLayout formLayout = new FormLayout();
        TextField firstName =  new TextField();
        TextField lastName = new TextField();
        formLayout.addFormItem(new Div(firstName, lastName), "User Info");
        return new Div(new H2("Multiple fields") ,formLayout);
    }

    private Component getForm5() {
        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(new Input(), "native input");
        return  new Div(new H2("FormItem with nativeInput"), formLayout);

    }

    private Component getForm4() {
        TextField revenue = new TextField();
        revenue.setSuffixComponent(new Span("Eur"));

        TextField expanses = new TextField();
        expanses.setSuffixComponent(new Span("Eur"));

        TextField invoices = new TextField();
        invoices.setSuffixComponent(new Span("Eur"));

        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(revenue, "Revenue");
        formLayout.addFormItem(expanses, "Expanses");
        formLayout.addFormItem(invoices, "Invoices");

        return new Div(new H2("Label positioning"), formLayout);
    }

    private Component getForm3() {
        TextField title = new TextField("Title");
        DatePicker date = new DatePicker("Date");
        TimePicker from = new TimePicker("From");
        TimePicker to  = new TimePicker("To");

        FormLayout formLayout = new FormLayout();
        formLayout.add(title, date, from, to);
        formLayout.setColspan(title, 3);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0",1),
                new FormLayout.ResponsiveStep("500px", 3)
                );
        return new Div(new H2("Forms colspan"), formLayout);
    }

    private Component getForm2() {
        FormLayout formLayout = new FormLayout();
        TextField userName = new TextField("username");
        TextField lastName = new TextField("Last name");
        EmailField emailField = new EmailField("Email");
        formLayout.add(userName, lastName, emailField);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("440px",2),
                new FormLayout.ResponsiveStep("550px", 3)
        );
        return new VerticalLayout(new H2("Second form"), formLayout);
    }

    private Component getForm1() {
        FormLayout formLayout = new FormLayout();

        TextField firstName = new TextField("First name");
        TextField lastName = new TextField();
        lastName.setLabel("Last Name");

        TextField userName = new TextField("User name");
        PasswordField passwordField = new PasswordField("Enter password");
        PasswordField confirmPassword = new PasswordField("Repeat password");

        /* */
       TextField textField = new TextField("test");
        MyGreeting myGreeting = new MyGreeting();
        /* */
        formLayout.add(firstName, lastName,userName ,passwordField, confirmPassword, textField);
        formLayout.addFormItem(myGreeting, "test");
        // Forma po defaultu ima dvije kolone. Kada se smanji sirina onda ima jednu kolonu

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("500px", 2));


        formLayout.setColspan(userName, 2);

        return  new VerticalLayout(new H2("First form"), formLayout);
    }

    private Component getTitle() {
        return new H1("Forms");
    }

}