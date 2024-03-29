package com.example.vaadincomponents.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.shared.HasThemeVariant;
import com.vaadin.flow.component.shared.ThemeVariant;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

@Tag("switch-button-test")
@JsModule("./components/switchbutton/CompSwitchButton.ts")
public class ComponentSwitchButton extends AbstractSinglePropertyField<ComponentSwitchButton, Boolean> implements HasTheme, HasThemeVariant<ComponentSwitchButton>,ThemeVariant {
    public ComponentSwitchButton() {
        super("checked",true, true);
    }

    public void setBothStatesVisible(){
        getElement().setAttribute("statesVisible","both");
    }

    public void setFirstComponent(Icon icon){
        icon.getElement().setAttribute("slot", "firstPart");
        getElement().appendChild(icon.getElement());
    }

    public void setFirstComponent(String string){
        Element span =  ElementFactory.createSpan(string);
        span.setAttribute("slot", "firstPart");
        getElement().appendChild(span);
    }

    public void setSecondComponent(String string){
        Element span = ElementFactory.createSpan(string);
        span.setAttribute("slot", "secondPart");
        getElement().appendChild(span);
    }

    public void setSecondComponent(Icon icon){
        icon.getElement().setAttribute("slot", "secondPart");
        getElement().appendChild(icon.getElement());
    }

    public void removeSecondComponent(){
        getElement().removeAttribute("secondPart");
    }

    public void setLabel(String label){
        Element labelSpan =  ElementFactory.createSpan(label);
        labelSpan.setAttribute("slot", "");
        getElement().appendChild(labelSpan);
    }

    public void setChecked(Boolean checked){
        getElement().setProperty("checked", checked);
        //Nisam siguran da li treba
    /*    fireEvent(new ComponentSwitchButton.SwitchStateChanged(this,false, this.getChecked()));  */
    }

    public Boolean getChecked(){
        return getElement().getProperty("checked",true);
    }

   public void setRedGreenTheme(){
        getElement().setAttribute("theme","redGreen");
   }

    public void setRoundness(String roundness){
        getElement().setAttribute("roundness", roundness);
    }

    @Override
    public String getVariantName() {
        return null;
    }

    public void addThemeVariants(ButtonVariant buttonVariant) {
            getElement().setAttribute("theme", buttonVariant.getVariantName());
    }

/*    @DomEvent("switch-state-change")
    public static class SwitchStateChanged extends ComponentEvent<ComponentSwitchButton>{
        private Boolean value;
        public SwitchStateChanged(ComponentSwitchButton source, boolean fromClient, @EventData("event.detail.value") Boolean checked) {
            super(source, fromClient);
            this.value = checked;
        }
        public Boolean getValue(){
            return this.value;
        }
    }*/

   /* public Registration addValueChangeListener(ComponentEventListener<ComponentSwitchButton.SwitchStateChanged> listener){
        return addListener(ComponentSwitchButton.SwitchStateChanged.class, listener);
    }*/
}
