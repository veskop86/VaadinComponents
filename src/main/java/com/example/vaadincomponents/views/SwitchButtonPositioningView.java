package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

@Route(value = "positioning",layout = MainLayout.class)
public class SwitchButtonPositioningView extends VerticalLayout {
    SwitchButtonPositioningView(){
        add(
                title(),
                form1(),
                formWithLabels(),
                formWithLabels2()
        );
    }

    private Component formWithLabels2() {
        FormLayout formLayout = new FormLayout();
        TextField textField = new TextField();
        TextField textField1 = new TextField();

        formLayout.addFormItem(textField, "username");
        formLayout.addFormItem(textField1 , "company");

        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");
        switchButton.getStyle().setTextAlign(Style.TextAlign.RIGHT);

        SwitchButton switchButton1 = new SwitchButton();
        switchButton1.setRoundness("rounded");
        switchButton1.getStyle().setTextAlign(Style.TextAlign.RIGHT);
        formLayout.addFormItem(switchButton, "label");
        formLayout.addFormItem(switchButton1, "label");

        return new Div(new H2("Form with buttons on right side"), formLayout);
    }
    
    private Component form1() {
        FormLayout formLayout = new FormLayout();

        TextField textField = new TextField("Name");
        EmailField emailField = new EmailField("email");

        SwitchButton switchButton = new SwitchButton();
        switchButton.setLabel("Left");
        switchButton.setRoundness("rounded");
        SwitchButton rightSideButton = new SwitchButton();
        rightSideButton.setLabel("Right");
        rightSideButton.getStyle().setTextAlign(Style.TextAlign.RIGHT);
        rightSideButton.setRoundness("rounded");

        PasswordField passwordField = new  PasswordField("Password");
        formLayout.setColspan(passwordField, 2);

        SwitchButton switchButtonCentered = new SwitchButton();
        switchButtonCentered.setLabel("center");
        switchButtonCentered.getStyle().setTextAlign(Style.TextAlign.CENTER);
        switchButtonCentered.setRoundness("rounded");
        formLayout.setColspan(switchButtonCentered, 2);


        TextField textField2 = new TextField();

        formLayout.add(textField,switchButton, emailField, rightSideButton, passwordField, switchButtonCentered, textField2);

        return new VerticalLayout(new H3("Left side, right side"), formLayout);

    }

    private Component formWithLabels(){
        FormLayout formLayout = new FormLayout();
        TextField textField = new TextField();

        TextField textField1 = new TextField();
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");

        SwitchButton switchButton1 = new SwitchButton();
        switchButton1.setRoundness("rounded");


        formLayout.addFormItem(textField, "First name");
        formLayout.addFormItem(textField1, "Last name");
        formLayout.addFormItem(switchButton, "button 1");
        formLayout.addFormItem(switchButton1, "button 2");


        return new Div(new H2("Forms with labels") , formLayout);

    }


    

    private Component title() {
        return new H2("Positioning button");
    }

}
