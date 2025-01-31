package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.example.vaadincomponents.components.SwitchButtonVariant;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class SwitchButtonExamples extends VerticalLayout {
    SwitchButtonExamples(){
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
                errorThemeVariantSwitchButton(),
                textFieldWithButton(),
                switchButtonTextFieldWithLabels(),
                fieldAndButtonWithLabel(),
                switchAndTextFieldWithoutLabels(),
                switchAndFieldWithLabel(),
                switchButtonAndTextField(),
                smallButton(),
                badgeAndButton(),
                smallSwtichWithIcon(),
                largeIcongWithIcon(),
                smallRoundedButton(),
                largeRoundedButtonWithIcon(),
                disabledButtonWithLabel(),
                smallDisabledButtonWithLabel(),
                threeNormalButtons(),
                smallErrorButton()
        );
    }

    private Component smallErrorButton() {
        SwitchButton error = new SwitchButton();
        error.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        error.addThemeVariants(SwitchButtonVariant.LUMO_CONTRAST);
        return new VerticalLayout(new H3("Small contrast variant theme button"), error);
    }

    private Component errorThemeVariantSwitchButton() {
        SwitchButton errorSwitchButton = new SwitchButton();
        errorSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_ERROR);
        return new VerticalLayout(new H3("Error lumo variant switch button"), errorSwitchButton);
    }

    private Component threeNormalButtons() {
        SwitchButton smallSwitchButton = new SwitchButton();
        smallSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        SwitchButton large = new SwitchButton();
        large.addThemeVariants(SwitchButtonVariant.LUMO_LARGE);
        SwitchButton switchButton = new SwitchButton();
        return  new VerticalLayout(new H3("Three types of button: large, normal and small"), new HorizontalLayout(large ,switchButton, smallSwitchButton));
    }

    private Component smallDisabledButtonWithLabel() {
        SwitchButton switchButton = getDisabledButton();
        switchButton.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);

        TextField textField = getDisabledTextField();
        textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);

        return new VerticalLayout(new H3("Disabled text field and switch button: "), new HorizontalLayout(textField, switchButton));
    }

    private static TextField getDisabledTextField() {
        TextField textField = new TextField("Label");
        textField.setEnabled(false);
        return textField;
    }

    private static SwitchButton getDisabledButton() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.setLabel("Label");
        switchButton.setEnabled(false);
        return switchButton;
    }


    public Component disabledButtonWithLabel(){
        SwitchButton switchButton = getDisabledButton();
        TextField textField = getDisabledTextField();
        return new HorizontalLayout(textField, switchButton);

    }

    private Component largeRoundedButtonWithIcon() {
        SwitchButton largeRoundedWithIcons = new SwitchButton();
        largeRoundedWithIcons.addThemeVariants(SwitchButtonVariant.LUMO_LARGE);
        largeRoundedWithIcons.setLeftValue(VaadinIcon.ALARM.create());
        largeRoundedWithIcons.setRightValue(VaadinIcon.CAMERA.create());
        largeRoundedWithIcons.setRoundness("rounded");
        return new VerticalLayout(new H3("Large rounded button with icons"), largeRoundedWithIcons);
    }

    private Component smallRoundedButton() {
        SwitchButton smallRoundedIconWithIcon = new SwitchButton();
        smallRoundedIconWithIcon.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        smallRoundedIconWithIcon.setLeftValue(VaadinIcon.ALARM.create());
        smallRoundedIconWithIcon.setRightValue(VaadinIcon.CAMERA.create());
        smallRoundedIconWithIcon.setRoundness("rounded");
        return new VerticalLayout(new H3("Small rounded button with icon"), smallRoundedIconWithIcon);
    }

    private Component largeIcongWithIcon() {
        SwitchButton largeButton = new SwitchButton();
        largeButton.addThemeVariants(SwitchButtonVariant.LUMO_LARGE);
        largeButton.setLeftValue(VaadinIcon.SUN_RISE.create());
        return new VerticalLayout(new H3("Large button with icon"), largeButton);
    }

    private Component smallSwtichWithIcon() {
        SwitchButton smallSwitch = new SwitchButton();
        smallSwitch.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        smallSwitch.setLeftValue(VaadinIcon.ALARM.create());
        return new VerticalLayout(new H3("Small button with icon"),  smallSwitch );
    }

    private Component badgeAndButton() {
        Span pending1 = new Span(createIcon(VaadinIcon.CLOCK),
                new Span("Pending"));
        pending1.getElement().getThemeList().add("badge");

        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");
        return new VerticalLayout(new H3("Badge and switch button"), new HorizontalLayout(switchButton, pending1));
    }
    private Icon createIcon(VaadinIcon vaadinIcon) {
        Icon icon = vaadinIcon.create();
        icon.getStyle().set("padding", "var(--lumo-space-xs)");
        return icon;
    }
    private Component smallButton() {
        SwitchButton small = new SwitchButton();
        small.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        small.setRoundness("rounded");
        SwitchButton large = new SwitchButton();
        large.setRoundness("rounded");
        large.addThemeVariants(SwitchButtonVariant.LUMO_LARGE);
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");
        return new VerticalLayout(new H3("Three rounded buttons"),new  HorizontalLayout( large ,switchButton, small));
    }

    private Component switchAndFieldWithLabel() {
            return new VerticalLayout(new H3("Comparing switch button with text field"),new HorizontalLayout(new TextField("Label"), new SwitchButton()));
    }


    private Component switchAndTextFieldWithoutLabels() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");
        return new VerticalLayout(new H2("Rounded switch button"), new HorizontalLayout(new TextField(), switchButton));
    }

    private Component switchButtonTextFieldWithLabels() {
        TextField textField = new TextField();
        textField.setLabel("Test");
        SwitchButton switchButton = new SwitchButton();
        switchButton.setLabel("Test");
        switchButton.setRoundness("rounded");

        H3 title = new H3("TextField and Button with labels - Positioning");
        return new VerticalLayout(title ,new HorizontalLayout(textField, switchButton));
    }

    private Component switchButtonAndTextField(){
        TextField textField = new TextField();
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("rounded");
        return new VerticalLayout(new H3("Switch button and text-field"), new HorizontalLayout(textField, switchButton));
    }

    private Component fieldAndButtonWithLabel() {
        return new HorizontalLayout(new Button("Text"), new TextField("Text"));
    }

    private Component textFieldWithButton() {
        TextField textField = new TextField();
        Button button = new Button("button");
        return new HorizontalLayout(button, textField);
    }


    private Component successThemeVariantButton() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.addThemeVariants(SwitchButtonVariant.LUMO_SUCCESS);
        switchButton.setRoundness("rounded");
        switchButton.setLabel("Label");
        return new VerticalLayout(new H3("Success switch button"), switchButton);
    }

    private Component contrastLumoVariantTheme(){
        SwitchButton switchButton = new SwitchButton();
        switchButton.addThemeVariants(SwitchButtonVariant.LUMO_CONTRAST);
        switchButton.setRoundness("rounded");
        return new VerticalLayout(new H3("Contrast theme switch button"), switchButton);
    }


    private Component buttonWithIcons() {
            SwitchButton buttonWithIcons = new SwitchButton();
            buttonWithIcons.setLeftValue(VaadinIcon.ALARM.create());
            buttonWithIcons.setRightValue(VaadinIcon.CTRL.create());
            return buttonWithIcons;
    }

    private Component title() {
        return new H2("Examples of Switch Buttons:");
    }

    private Component getButtonWithOnOff() {
        SwitchButton onOffButton = new SwitchButton();
        onOffButton.setLeftValue("On");
        onOffButton.setRightValue("Off");
        Button enableDisable = new Button("Enable/Disable" ,event -> onOffButton.setEnabled(!onOffButton.isEnabled()));
        return new HorizontalLayout(onOffButton, enableDisable);
    }
    
    private Component getButtonWithSomeValues() {
        SwitchButton buttonWithDollarAndPercentage = new SwitchButton();
        buttonWithDollarAndPercentage.setRightValue("€");
        buttonWithDollarAndPercentage.setLeftValue("%");
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
        roundedSwitchButton.setRoundness("rounded");
        Button enableDisable = new Button("Enable/Disable" ,event -> roundedSwitchButton.setEnabled(!roundedSwitchButton.isEnabled()));
        return new HorizontalLayout(roundedSwitchButton, enableDisable);
    }

    private HorizontalLayout getBasicSwitchButton() {
        SwitchButton basicSwitchButton = new SwitchButton();
        Button enableDisable = new Button("Enable/Disable" ,event -> basicSwitchButton.setEnabled(!basicSwitchButton.isEnabled()));
        return new HorizontalLayout(basicSwitchButton, enableDisable);
    }
}