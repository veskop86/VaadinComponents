import { LitElement, html } from "lit";
import { customElement, property } from "lit/decorators.js";
import { switchbuttonstyles } from "./style";

@customElement("switch-button")
export class SwitchButton extends LitElement{

//checked property represents value of switch button
    @property({type: Boolean, reflect: true,
        hasChanged(value:boolean, oldValue:boolean ) {
            return value !== oldValue;
        }
    })
    checked: boolean = true;

    @property({type: Boolean, reflect: true})
    bothVisible: boolean = true;

    static get styles(){
        return switchbuttonstyles;
    }

    _changeCheckedState = (event: Event) =>{
        this.checked = (event.target as HTMLInputElement).checked;
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
                    <input id="switchButtonCheck"  @change=${this._changeCheckedState} type="checkbox" .checked="${this.checked}">
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