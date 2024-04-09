package com.example.vaadincomponents.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.shared.HasThemeVariant;
import com.vaadin.flow.component.shared.ThemeVariant;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

@Tag("switch-button")
@JsModule("./components/switchbutton/SwitchButton.ts")
public class SwitchButton extends AbstractSinglePropertyField<SwitchButton, Boolean> implements HasThemeVariant<SwitchButtonVariant>,ThemeVariant, HasLabel {
    public SwitchButton() {
        super("checked", false, true);
    }

    public void setBothStatesVisible(){
        getElement().setAttribute("statesVisible","both");
    }
    public void setLabel(String label){
        Element span =  ElementFactory.createSpan(label);
        span.setAttribute("slot","label");
        getElement().setAttribute("has-label","");
        getElement().appendChild(span);
    }

    public void setLeftValue(Icon icon){
        icon.getElement().setAttribute("slot", "firstPart");
        getElement().appendChild(icon.getElement());
    }
    public void setLeftValue(String string){
        Element span =  ElementFactory.createSpan(string);
        span.setAttribute("slot", "firstPart");
        getElement().appendChild(span);
    }

    public void setRightValue(String string){
        Element span = ElementFactory.createSpan(string);
        span.setAttribute("slot", "secondPart");
        getElement().appendChild(span);
    }

    public void setRightValue(Icon icon){
        icon.getElement().setAttribute("slot", "secondPart");
        getElement().appendChild(icon.getElement());
    }


    public void setChecked(Boolean checked){
        getElement().setProperty("checked", checked);
        //Nisam siguran da li treba
    /*    fireEvent(new ComponentSwitchButton.SwitchStateChanged(this,false, this.getChecked()));  */
    }

    public Boolean getChecked(){
        return getElement().getProperty("checked",true);
    }

    public void setRoundness(String roundness){
        getElement().setAttribute("roundness", roundness);
    }
    @Override
    public String getVariantName() {
        return null;
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
