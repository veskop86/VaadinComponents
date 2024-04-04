package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.shared.ThemeVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
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
                errorThemeVariantSwitchButton(),
                textFieldwithButton(),
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
                disbledButtonithLabel(),
                smallDisabledButtonWithLabel(),
                threeNormalButtons()
        );
    }

    private Component errorThemeVariantSwitchButton() {
        SwitchButton errorSwitchButton = new SwitchButton();
        errorSwitchButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        return errorSwitchButton;
    }

    private Component threeNormalButtons() {
        SwitchButton small = new SwitchButton();
        small.addThemeVariants(ButtonVariant.LUMO_SMALL);
        SwitchButton large = new SwitchButton();
        large.addThemeVariants(ButtonVariant.LUMO_LARGE);
        SwitchButton switchButton = new SwitchButton();
        return  new HorizontalLayout( large ,switchButton, small);
    }

    private Component smallDisabledButtonWithLabel() {
        SwitchButton switchButton = getDisabledButton();
        switchButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        TextField textField = getDisabledTextField();
        textField.addThemeVariants(TextFieldVariant.LUMO_SMALL);

        return new HorizontalLayout(textField, switchButton);
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


    public Component disbledButtonithLabel(){
        SwitchButton switchButton = getDisabledButton();

        TextField textField = getDisabledTextField();
        return new HorizontalLayout(textField, switchButton);

    }

    private Component largeRoundedButtonWithIcon() {
        SwitchButton largeRoundedWithIcons = new SwitchButton();
        largeRoundedWithIcons.addThemeVariants(ButtonVariant.LUMO_LARGE);
        largeRoundedWithIcons.setFirstComponent(VaadinIcon.ALARM.create());
        largeRoundedWithIcons.setSecondComponent(VaadinIcon.CAMERA.create());
        largeRoundedWithIcons.setRoundness("round");
        return new VerticalLayout(new H3("Large rounded button with icons"), largeRoundedWithIcons);
        
    }

    private Component smallRoundedButton() {
        SwitchButton smallRoundedIconWithIcon = new SwitchButton();
        smallRoundedIconWithIcon.addThemeVariants(ButtonVariant.LUMO_SMALL);
        smallRoundedIconWithIcon.setFirstComponent(VaadinIcon.ALARM.create());
        smallRoundedIconWithIcon.setSecondComponent(VaadinIcon.CAMERA.create());
        smallRoundedIconWithIcon.setRoundness("round");
        return new VerticalLayout(new H3("Small rounded button with icon"), smallRoundedIconWithIcon);
    }

    private Component largeIcongWithIcon() {
        SwitchButton largeButton = new SwitchButton();
        largeButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
        largeButton.setFirstComponent(VaadinIcon.SUN_RISE.create());
        return new VerticalLayout(new H3("Large button with icon"), largeButton);
    }

    private Component smallSwtichWithIcon() {
        SwitchButton smallSwitch = new SwitchButton();
        smallSwitch.addThemeVariants(ButtonVariant.LUMO_SMALL);
        smallSwitch.setFirstComponent(VaadinIcon.ALARM.create());
        return new VerticalLayout(new H3("Small button  with icon"),  smallSwitch );
    }

    private Component badgeAndButton() {
        Span pending1 = new Span(createIcon(VaadinIcon.CLOCK),
                new Span("Pending"));
        pending1.getElement().getThemeList().add("badge");

        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("round");
        return new HorizontalLayout(switchButton, pending1);
    }
    private Icon createIcon(VaadinIcon vaadinIcon) {
        Icon icon = vaadinIcon.create();
        icon.getStyle().set("padding", "var(--lumo-space-xs)");
        return icon;
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
