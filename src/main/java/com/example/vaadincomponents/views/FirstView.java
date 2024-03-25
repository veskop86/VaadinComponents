package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.ComponentSwitchButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


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
                getSuccessThemeVariantButton()
        );
    }

    private Component getSuccessThemeVariantButton() {
        ComponentSwitchButton componentSwitchButton = new ComponentSwitchButton();
        componentSwitchButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        componentSwitchButton.setRoundness("round");
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
        onOffButton.setFirstString("off");
        onOffButton.setSecondString("on");
        Button enableDisable = new Button("Enable/Disable" ,event -> onOffButton.setEnabled(!onOffButton.isEnabled()));
        return new HorizontalLayout(onOffButton, enableDisable);
    }

    private Component getButtonWithSomeValues() {
        ComponentSwitchButton buttonWithDollarAndPercentage = new ComponentSwitchButton();
        buttonWithDollarAndPercentage.setFirstString("€");
        buttonWithDollarAndPercentage.setSecondString("%");
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
