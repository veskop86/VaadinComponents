package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value= "switchableBackgroundColor", layout = MainLayout.class)
public class ButtonWithVariableBackgroundColor extends VerticalLayout {

    ButtonWithVariableBackgroundColor(){
        add(
                switchButton(),
                backgroundColorPicker()
        );
    }
    
    private Component backgroundColorPicker() {
        return new H2("Color picker");
    }

    private Component switchButton() {
        return new SwitchButton();
    }
}