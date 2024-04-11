package com.example.vaadincomponents.views;

import com.example.vaadincomponents.components.SwitchButton;
import com.example.vaadincomponents.components.SwitchButtonVariant;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;

@Route(layout = MainLayout.class)
public class ThemeChangeView extends VerticalLayout {
    SwitchButton changeThemeSwitchButton;

    ThemeChangeView(){
        add(
           changeThemeSwitchButton()
        );   
    }
    
    private Component changeThemeSwitchButton() {
        changeThemeSwitchButton = new SwitchButton();
        changeThemeSwitchButton.addThemeVariants(SwitchButtonVariant.LUMO_CONTRAST);
        changeThemeSwitchButton.setRoundness("rounded");
        changeThemeSwitchButton.setChecked(false);

        changeThemeSwitchButton.addValueChangeListener(event -> {
            Notification.show("Button value - "  + event.getValue());
            setTheme(event.getValue());
        });
        return new VerticalLayout(new H2("Change application theme using switch button"), changeThemeSwitchButton);
    }  

    private void setTheme(boolean dark) {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
            
    }
}