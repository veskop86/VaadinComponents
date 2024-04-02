package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
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

@Route(value = "", layout = MainLayout.class)
public class FirstView extends VerticalLayout {
    FirstView(){
        add(
                title(),
                getBasicSwitchButton(),
                getRoundedSwitchButton(),
                getDisabledSwitchButton(),
                getButtonWithOnOff(),
                getButtonWithBothStatesVisible(),
                getButtonWithSomeValues(),
                buttonWithIcons(),
                contrastLumoVariantTheme(),
                successThemeVariantButton(),
                textFieldwithButton(),
                switchButtonTextFieldWithLabels(),
                fieldAndButtonWithLabel(),
                switchAndTextFieldWithoutLabels(),
                switchAndFieldWithLabel(),
                switchButtonAndTextField(),
                smallButton()
        );
    }

    private Component smallButton() {
        SwitchButton small = new SwitchButton();
        small.addThemeVariants(ButtonVariant.LUMO_SMALL);
        small.setRoundness("round");
        SwitchButton large = new SwitchButton();
        large.setRoundness("round");
        large.addThemeVariants(ButtonVariant.LUMO_LARGE);
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("round");
        return  new HorizontalLayout( large ,switchButton, small);
    }

    private Component switchAndFieldWithLabel() {
            return new HorizontalLayout(new TextField("Label"), new SwitchButton());
    }


    private Component switchAndTextFieldWithoutLabels() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("round");
        return new HorizontalLayout(new TextField(), switchButton);
    }

    private Component switchButtonTextFieldWithLabels() {
        TextField textField = new TextField();
        textField.setLabel("Test");
        SwitchButton switchButton = new SwitchButton();
        switchButton.setLabel("Test");
        switchButton.setRoundness("round");

        H3 title = new H3("TextField and Button with labels - Positioning");
        return new HorizontalLayout(textField, switchButton);
    }
    private Component switchButtonAndTextField(){
        TextField textField = new TextField();
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("round");
        return new HorizontalLayout(textField, switchButton);
    }

    private Component fieldAndButtonWithLabel() {
        return new HorizontalLayout(new Button("Text"), new TextField("Text"));
    }

    private Component textFieldwithButton() {
        TextField textField = new TextField();
        Button button = new Button("button");
        return new HorizontalLayout(button, textField);
    }


    private Component successThemeVariantButton() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        switchButton.setRoundness("round");
        switchButton.setLabel("Label");
        return switchButton;
    }

    private Component contrastLumoVariantTheme(){
        SwitchButton switchButton = new SwitchButton();
        switchButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        switchButton.setRoundness("round");
        return switchButton;
    }


    private Component buttonWithIcons() {
            SwitchButton buttonWithIcons = new SwitchButton();
            buttonWithIcons.setFirstComponent(VaadinIcon.ALARM.create());
            buttonWithIcons.setSecondComponent(VaadinIcon.CTRL.create());
            return buttonWithIcons;
    }


    private Component title() {
        return new H2("Examples of Switch Buttons:");
    }



    private Component getButtonWithOnOff() {
        SwitchButton onOffButton = new SwitchButton();
        onOffButton.setFirstComponent("On");
        onOffButton.setSecondComponent("Off");
        Button enableDisable = new Button("Enable/Disable" ,event -> onOffButton.setEnabled(!onOffButton.isEnabled()));
        return new HorizontalLayout(onOffButton, enableDisable);
    }

    private Component getButtonWithSomeValues() {
        SwitchButton buttonWithDollarAndPercentage = new SwitchButton();
        buttonWithDollarAndPercentage.setFirstComponent("€");
        buttonWithDollarAndPercentage.setSecondComponent("%");
        buttonWithDollarAndPercentage.setBothStatesVisible();
        Button enableDisable = new Button("Enable/Disable" ,event -> buttonWithDollarAndPercentage.setEnabled(!buttonWithDollarAndPercentage.isEnabled()));
        return new HorizontalLayout(buttonWithDollarAndPercentage, enableDisable);
    }

    private Component getButtonWithBothStatesVisible() {
        SwitchButton bothStatesVisible = new SwitchButton();
        bothStatesVisible.setBothStatesVisible();
        Button enableDisable = new Button("Enable/Disable" ,event -> bothStatesVisible.setEnabled(!bothStatesVisible.isEnabled()));
        bothStatesVisible.setBothStatesVisible();
        return new HorizontalLayout(bothStatesVisible, enableDisable);
    }

    private HorizontalLayout getDisabledSwitchButton() {
        SwitchButton disabledSwitchButton = new SwitchButton();
        disabledSwitchButton.setEnabled(false);
        Button enableDisable = new Button("Enable/Disable" ,event -> disabledSwitchButton.setEnabled(!disabledSwitchButton.isEnabled()));
        return new HorizontalLayout(disabledSwitchButton, enableDisable);
    }

    private HorizontalLayout getRoundedSwitchButton() {
        SwitchButton roundedSwitchButton = new SwitchButton();
        roundedSwitchButton.setRoundness("round");
        Button enableDisable = new Button("Enable/Disable" ,event -> roundedSwitchButton.setEnabled(!roundedSwitchButton.isEnabled()));
        return new HorizontalLayout(roundedSwitchButton, enableDisable);
    }

    private HorizontalLayout getBasicSwitchButton() {
        SwitchButton basicSwitchButton = new SwitchButton();
        Button enableDisable = new Button("Enable/Disable" ,event -> basicSwitchButton.setEnabled(!basicSwitchButton.isEnabled()));
        return new HorizontalLayout(basicSwitchButton, enableDisable);
    }
}
