package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.example.vaadincomponents.components.SwitchButtonVariant;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "buttonWithIcons", layout = MainLayout.class)
public class SwitchButtonWithIcons extends VerticalLayout {

    SwitchButtonWithIcons(){
        add(
                normalButtonsWithIcons(),
                roundedButtonsWithIcons()
        );
    }

    private Component roundedButtonsWithIcons() {
        SwitchButton smallSwitchButton = getSwitchButton();
        smallSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        getRoundedButton(smallSwitchButton);

        SwitchButton normalSwitchButton = getSwitchButton();
        getRoundedButton(normalSwitchButton);

        SwitchButton largeSwitchButton = getSwitchButton();
        getRoundedButton(largeSwitchButton);
        largeSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_LARGE
        );

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(
                new VerticalLayout(
                    new H4("Rounded buttons with icons"),
                    new HorizontalLayout(smallSwitchButton, normalSwitchButton, largeSwitchButton)
        ));
        return hl;
    }

    private static void getRoundedButton(SwitchButton switchButton) {
        switchButton.setRoundness("rounded");
    }

    private Component normalButtonsWithIcons() {
        SwitchButton smallSwitchButton = getSwitchButton();
        smallSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_SMALL);
        smallSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_SUCCESS);

        SwitchButton normalSwitchButton = getSwitchButton();

        SwitchButton largeSwitchButton = getSwitchButton();
        largeSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_LARGE);
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(
                new VerticalLayout(
                    new H4("Button with icons"),
                    new HorizontalLayout(smallSwitchButton, normalSwitchButton, largeSwitchButton)
                ));
        return hl;
    }

    private static SwitchButton getSwitchButton() {
        SwitchButton switchButton = new SwitchButton();
        switchButton.setLeftValue(VaadinIcon.CAMERA.create());
        switchButton.setRightValue(VaadinIcon.ADD_DOCK.create());
        return switchButton;
    }
}