import { LitElement, html } from "lit";
import { customElement, property } from "lit/decorators.js";
import { ElementMixin } from '@vaadin/component-base/src/element-mixin.js';
import { PolylitMixin } from '@vaadin/component-base/src/polylit-mixin.js';
import { TooltipController } from '@vaadin/component-base/src/tooltip-controller.js';
import { ThemableMixin } from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';
import { switchbuttonstyles } from "./style";
import { SwitchButtonMixin } from './switch-button-mixin';
import { defineCustomElement } from '@vaadin/component-base/src/define.js';


class SwitchButton extends SwitchButtonMixin(ElementMixin(ThemableMixin(PolylitMixin(LitElement)))) {

static get is(){
    return 'switch-button';
}

static get properties() {
    return {
         tabindex: {
            type: Number,
            value: 0,
            reflectToAttribute: true,
          }, 
          
          checked:{ type: Boolean, reflect: true}     
    }    
}

constructor(){
    super();
    this.checked = true;
}

ready() {
    super.ready();
    this._tooltipController = new TooltipController(this);
    this.addController(this._tooltipController);
  }

static get styles(){
        return switchbuttonstyles;
 }
    _changeCheckedState = (event) =>{
        this.checked = event.target.checked;
        const e = new CustomEvent("checked-changed", {
            detail: {value: this.checked}, bubbles: true, composed: true
        });
        this.dispatchEvent(e);
    }

    render(){
        return html`
            <div class="container">
                <div part="label">
                    <slot name="label">
                    </slot>
                    <span part="required-indicator" aria-hidden="true" on-click="focus"></span>
                </div>
                <label class="switch">
                    <input tabindex="-1"  @change=${this._changeCheckedState} type="checkbox" .checked="${this.checked}">
                    <span class="slider"></span>
                    <div class="text-container">
                        <span  class='text left'>
                            <slot name="firstPart" ></slot>
                        </span>
                        <span  class='text right'>
                            <slot name="secondPart" ></slot>
                        </span>
                    </div>
                </label>
            </div>
        `;
    }
}

defineCustomElement(SwitchButton);

export{ SwitchButton };