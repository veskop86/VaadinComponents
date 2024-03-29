package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.ComponentSwitchButton;
import com.example.vaadincomponents.components.MyGreeting;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.text.CollationKey;

@Route(value = "", layout = MainLayout.class)
public class FirstView extends VerticalLayout {
    FirstView(){
        add(
                addTitle(),
                getBasicSwitchButton(),
                getRoundedSwitchButton(),
                getDisabledSwitchButton(),
                getButtonWithOnOff(),
                getButtonWithBothStatesVisible(),
                getButtonWithSomeValues(),
                getButtonWithIcons(),
                getRedGrinSwitchButton(),
                getContrastButton(),
                getSuccessThemeVariantButton(),
                getGreetingAndButton(),
                getTextFieldwithButton(),
                getTextFieldwithButton2(),
                getSwitchButtonTextFieldWithLabels(),
                getTextFieldwithButton2()
        );
    }

    private Component getSwitchButtonTextFieldWithLabels() {
        TextField textField = new TextField();
        textField.setLabel("Test");
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.setLabel("Test");
        componentSwitchButton.setRoundness("round");

        H3 title = new H3("TextField and Button with labels - Positioning");
        return new HorizontalLayout(textField, componentSwitchButton);
    }
    private Component getSwitchButtonAndTextField(){
        TextField textField = new TextField();
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.setRoundness("round");
        return new HorizontalLayout(textField, componentSwitchButton);
    }

    private Component getTextFieldwithButton2() {
        TextField textField = new TextField("test");
        Button button = new Button("button");
        return new HorizontalLayout(button, textField);
    }

    private Component getTextFieldwithButton() {
        TextField textField = new TextField();
        Button button = new Button("button");
        return new HorizontalLayout(button, textField);
    }


    private Component getGreetingAndButton() {
        MyGreeting myGreeting = new MyGreeting();
        Button button = new Button("test");
        return new HorizontalLayout(button, myGreeting);

    }

    private Component getSuccessThemeVariantButton() {
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        componentSwitchButton.setRoundness("round");
        componentSwitchButton.setLabel("Label");
        return componentSwitchButton;
    }

    private Component getContrastButton(){
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        componentSwitchButton.setRoundness("round");
        return componentSwitchButton;
    }

    private Component getRedGrinSwitchButton() {
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.setRedGreenTheme();
        componentSwitchButton.setRoundness("round");
        return componentSwitchButton;
    }

    private Component getButtonWithIcons() {
            ComponentSwitchButton buttonWithIcons = new ComponentSwitchButton();
            buttonWithIcons.setFirstComponent(VaadinIcon.ALARM.create());
            buttonWithIcons.setSecondComponent(VaadinIcon.CTRL.create());
            return buttonWithIcons;
    }


    private Component addTitle() {
        return new H2("Examples of Switch Buttons:");
    }



    private Component getButtonWithOnOff() {
        ComponentSwitchButton onOffButton = new ComponentSwitchButton();
        onOffButton.setFirstComponent("On");
        onOffButton.setSecondComponent("Off");
        Button enableDisable = new Button("Enable/Disable" ,event -> onOffButton.setEnabled(!onOffButton.isEnabled()));
        return new HorizontalLayout(onOffButton, enableDisable);
    }

    private Component getButtonWithSomeValues() {
        ComponentSwitchButton buttonWithDollarAndPercentage = new ComponentSwitchButton();
        buttonWithDollarAndPercentage.setFirstComponent("€");
        buttonWithDollarAndPercentage.setSecondComponent("%");
        buttonWithDollarAndPercentage.setBothStatesVisible();
        Button enableDisable = new Button("Enable/Disable" ,event -> buttonWithDollarAndPercentage.setEnabled(!buttonWithDollarAndPercentage.isEnabled()));
        return new HorizontalLayout(buttonWithDollarAndPercentage, enableDisable);
    }

    private Component getButtonWithBothStatesVisible() {
        ComponentSwitchButton bothStatesVisible = new ComponentSwitchButton();
        bothStatesVisible.setBothStatesVisible();
        Button enableDisable = new Button("Enable/Disable" ,event -> bothStatesVisible.setEnabled(!bothStatesVisible.isEnabled()));
        bothStatesVisible.setBothStatesVisible();
        return new HorizontalLayout(bothStatesVisible, enableDisable);
    }

    private HorizontalLayout getDisabledSwitchButton() {
        ComponentSwitchButton disabledSwitchButton = new ComponentSwitchButton();
        disabledSwitchButton.setEnabled(false);
        Button enableDisable = new Button("Enable/Disable" ,event -> disabledSwitchButton.setEnabled(!disabledSwitchButton.isEnabled()));
        return new HorizontalLayout(disabledSwitchButton, enableDisable);
    }

    private HorizontalLayout getRoundedSwitchButton() {
        ComponentSwitchButton roundedSwitchButton = new ComponentSwitchButton();
        roundedSwitchButton.setRoundness("round");
        Button enableDisable = new Button("Enable/Disable" ,event -> roundedSwitchButton.setEnabled(!roundedSwitchButton.isEnabled()));
        return new HorizontalLayout(roundedSwitchButton, enableDisable);
    }

    private HorizontalLayout getBasicSwitchButton() {
        ComponentSwitchButton basicSwitchButton = new ComponentSwitchButton();
        Button enableDisable = new Button("Enable/Disable" ,event -> basicSwitchButton.setEnabled(!basicSwitchButton.isEnabled()));
        return new HorizontalLayout(basicSwitchButton, enableDisable);
    }
}
