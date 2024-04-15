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
        //default value za boolean je uvijek false, zbog toga default value za switch button treba da bude false
        super("checked",  true, true);
    }

    //Da li i ovo može da bude themeVariant?
    //Recimo da se umjesto poziva ove metode pozove
    //switchButton.addThemeVariant(SwitchButtonVariant.BOTH_STATES_VISIBLE)
    public void setBothStatesVisible() {
        getElement().setAttribute("statesVisible", "both");
    }

    public void setLabel(String label) {
        Element span =  ElementFactory.createSpan(label);
        span.setAttribute("slot", "label");
        getElement().setAttribute("has-label", "");
        getElement().appendChild(span);
    }

    //Nazivi ovih metoda ne treba da sadrže riječ "value"
    //Obzirom da switch button ima samo jednu vrijednost, neki boolean
    //ovi nazivi su pogresni, jer upućuju na to da može biti više vrijednosti
    //Primjeri kako bi metode mogle da se zovu su:
    // setLeftComponent(Icon icon)
    // setLeftIcon(Icon icon)
    // setLeftLabel(String string)
    // setLeftText(String string)
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


    //Ovdje bi trebalo iskoristiti "boolean" umjesto "Boolean" ukoliko je to moguće
    //"Boolean" je objekat koji "wrapuje" primitivni tip "boolean". To "wrapovanje"
    //se u kontekstu jave naziva boxing i unosi neki overhead. Praksa je da se koristi
    //boolean gdje god je to moguće
    public void setChecked(Boolean checked){
        getElement().setProperty("checked", checked);
        //Nisam siguran da li treba - Slobo
        //Treba da imamo mogućnost da detektujemo promjenu na switch button komponenti, tako da ovo treba da se uključi - Vesko
    /*    fireEvent(new ComponentSwitchButton.SwitchStateChanged(this,false, this.getChecked()));  */
    }

    public Boolean getChecked() {
        //default value treba da bude false
        //ako u javi napravimo klasu tipa 
        // class Test {
        //   boolean a;
        //
        //   public static void main(String[] args){
        //      System.out.println(new Test().a)
        //   }   
        // }
        // u konzoli će biti ispisano false
        return getElement().getProperty("checked", true);
    }


    //Argument ove metode ne treba da bude tipa String, nego vjerovatno neki Enum
    //Ako mora da bude string onda ovdje treba napisati javadoc(provjeri šta je javadoc) komentar koje vrijednosti argument može da ima
    //Neko ko bude koristio komponentu može da napiše recimo
    //
    // switchButton.setRoundness("Kung fu panda 4 dio :)")
    //
    //Zbog toga je bolje da argument bude neki enum, pa da onaj ko piše kod radi sledeće:
    //
    // switchButton.setRoundness(SwitchButtonRoundness.ROUNDED_LARGE) 
    // switchButton.setRoundness(SwitchButtonRoundness.ROUNDED_MEDIUM)
    // switchButton.setRoundness(SwitchButtonRoundness.ROUNDED_SMALL)
    // switchButton.setRoundness(SwitchButtonRoundness.SQUARE)
    public void setRoundness(String roundness) {
        getElement().setAttribute("roundness", roundness);
    }


    @Override
    public String getVariantName() {
        return null;
    }

    //Rekli smo da ovo treba da se omogući tako da se može otkomentaristi

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
