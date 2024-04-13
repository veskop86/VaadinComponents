package com.example.vaadincomponents.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(layout = MainLayout.class)
public class VaadinButtonsView extends VerticalLayout {

    VaadinButtonsView(){
        add(
                allThemeVariantsButtons(),
                checkbox()

        );
    }

    private Component checkbox() {
        Checkbox checkbox =  new Checkbox();
        return  checkbox;
    }

    private Component allThemeVariantsButtons() {
        Button primaryButton = new Button("test");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button tertiary = new Button("test");
        tertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Button error = new Button("Test");
        error.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        error.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button success = new Button("Test");
        success.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        success.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button contrast = new Button("Test");
        contrast.addThemeVariants(ButtonVariant.LUMO_PRIMARY);  
        contrast.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

        return  new VerticalLayout(new H3("Different vaadin buttons"), new HorizontalLayout(primaryButton, tertiary, error, success, contrast));
    }
}
