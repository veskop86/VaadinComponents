package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "switchListener", layout = MainLayout.class)
public class TestSwitchButtonListener extends VerticalLayout {

    TestSwitchButtonListener(){

        add(
                getTitle(),
                getSwitchButton()
        );
    }

    private Component getSwitchButton() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.setRoundness("round");
        switchButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        switchButton.addValueChangeListener(event -> {
            Notification.show("Value of switch button" + switchButton.getValue());
        });
        return new Div(switchButton);
    }

    private Component getTitle() {
        return new H2("View for testing switch button value listener");
    }


}
