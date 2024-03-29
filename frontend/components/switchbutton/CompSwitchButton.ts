import { LitElement, css, html } from "lit";
import { customElement, property } from "lit/decorators.js";


@customElement("switch-button-test")
export class SwitchButtonTest extends LitElement{

//checked property represents state of switch button.
    @property({type: Boolean, reflect: true,
        hasChanged(value:boolean, oldValue:boolean ) {
            return value !== oldValue;
        }
    })
    checked: boolean = true;

    // Default state for both visible is false;
    @property({type: Boolean, reflect: true})
    bothVisible: boolean = true;

  /*  @property({})
    value1?: String;

    @property({})
    value2?: String;*/


    static get styles(){
        return css`
          :host{
        --lumo-success-color: hsl(145, 72%, 30%);
        --lumo-shade: hsl(214, 35%, 15%);   
        --lumo-error-color: hsl(3, 85%, 48%);
        --highlight-color: hsl(0, 0%, 100%, 0.29);
        --lumo-primary-color-50pct: hsla(0, 0%, 100%, 0.64);
        --lumo-primary-text-color: hsl(214, 100%, 43%);
        --lumo-size-m: 2.25rem;
        
        --lumo-space-xs: 0.25rem;
        --lumo-base-color: #fff;
        --lumo-font-family: -apple-system, BlinkMacSystemFont, 'Roboto', 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';
        --lumo-tint-90pct: hsla(214, 96%, 96%, 0.9);
        --lumo-contrast-90pct: var(--lumo-tint-90pct);
        --_lumo-button-text-color: var(--vaadin-button-text-color, var(--lumo-primary-text-color));
        --lumo-body-text-color: var(--lumo-contrast-90pct);
        --lumo-primary-color: hsl(214, 100%, 48%);
        --vaadin-focus-ring-color: var(--lumo-primary-color-50pct);
        --vaadin-focus-ring-width: 2px;
        --vaadin-button-font-weight: 500;

        --_focus-ring-color: var(--vaadin-focus-ring-color, var(--lumo-primary-color-50pct));
        --_focus-ring-width: var(--vaadin-focus-ring-width, 2px);
        --border-radius: 1.5rem;
              --button-size: var(--lumo-size-m);
              /*   --text-height: 1.625rem; */
        --text-height: calc(var(--button-size) / 1.5);    
     /*   --text-width: 1.625rem; */
        --text-width: calc(var(--button-size) / 1.5);
              
                 
            
        /* Slider padding mora biti paran.To je ovo oko teksta */
        /* slider-padding:4px */
        --slider-padding:  calc(1rem / 4);
        --slider--height: calc(var(--text-height) + var(--slider-padding));
        --slider-width: var(--slider--height);
     /* --button-height: calc(var(--slider--height) + 8px ); */
        --button-height: calc(var(--slider--height) + 2 * var(--slider-padding));
        /* Length of slider translation is text-width + slider-padding */
        --slider-transitionx-length: calc(var(--slider-width) + var(--slider-padding)) ;
    /*  --button-width: calc(var(--text-height) * 2 + 16px); */
        --button-width: calc( 2 * var(--slider-width) +  3 * var(--slider-padding));
        --margin: var(--lumo-space-xs);
        font-family: var(--lumo-font-family);
        font-weight: var(--vaadin-button-font-weight, 500);
        color: var(--lumo-body-text-color);
        /* User can't select. Important when text exists */
        -webkit-touch-callout: none;
        -webkit-user-select: none;
        -khtml-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
              user-select: none;   
              margin: var(--vaadin-button-margin, var(--lumo-space-xs) 0);
        
          }
            [part='label'] {
                align-self: flex-start;
                color: var(--vaadin-input-field-label-color, var(--lumo-secondary-text-color));
                font-weight: var(--vaadin-input-field-label-font-weight, 500);
                font-size: var(--vaadin-input-field-label-font-size, var(--lumo-font-size-s));
                margin-left: calc(var(--lumo-border-radius-m) / 4);
                transition: color 0.2s;
                line-height: 1;
                padding-right: 1em;
                padding-bottom: 0.5em;
                /* As a workaround for diacritics being cut off, add a top padding and a
                negative margin to compensate */
                padding-top: 0.25em;
                margin-top: -0.25em;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
                position: relative;
                max-width: 100%;
                box-sizing: border-box;
            }
            
            :host([has-label])::before {
                margin-top: calc(var(--lumo-font-size-s) * 1.5);
            }


            :host([has-label]) {
                padding-top: var(--lumo-space-m);
            }
            
            
            .container{
                display:inline-block;
                position: relative;
                padding: var(--lumo-space-xs) 0;
                bottom: 4px;
            }

            .label{
                color: var(--vaadin-input-field-value-color, var(--lumo-body-text-color));
                font-size: var(--vaadin-input-field-value-font-size, var(--lumo-font-size-m));
                font-weight: var(--vaadin-input-field-value-font-weight, 400);
                color: hsla(214, 42%, 18%, 0.69);
                
            }
            .container:hover > .label{
                color:hsla(214, 40%, 16%, 0.94);
            }
         
        
     .switch {
        position: relative;
        display: inline-block;
        width: var(--button-width); 
      /*  width: 4.25rem; */
        height: var(--button-height);         
            }
      .switch input {
        opacity: 0;
        width: 0;
        height: 0;
        
                }
      .slider {
        position: absolute;
        display:inline-block;    
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
        border-radius: var(--lumo-border-radius-m);
         }

      .slider:before {
        position: absolute;
        content: "";
        height: var(--slider--height);
        width: var(--slider-width);
        left: calc(var(--slider-padding));
        bottom: var(--slider-padding);
        top: var(--slider-padding);    
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
        border-radius: var(--lumo-border-radius-m);
        z-index: 3;
        box-sizing: border-box;
}

input:checked + .slider {
        background-color: var(--lumo-primary-color);
            }

 :host([focus-ring]) .slider{
      box-shadow: 0 0 0 2px red;
  }
            
           
input:checked + .slider:before {
       -webkit-transform: translateX(var(--slider-transitionx-length));
       -ms-transform: translateX(var(--slider-transitionx-length));
       transform: translateX(var(--slider-transitionx-length));
}

.text{
        position: relative;
        display: inline-block;
        box-sizing: border-box;
        top: calc( 0.5 *  var(--slider-padding));
        height: calc(var(--text-height));
        width: calc(var(--text-width));
        box-sizing: border-box;
        text-align: center;
        /* Hide text */
        overflow: hidden;
        cursor: pointer;
}

  .left{
        left: calc(var(--slider-padding) );
            }
  .right{
        right: calc( -1 * var(--slider-padding));
            }

.text-container{
        position: absolute;
        bottom: calc(var(--slider-padding) );
        width: calc(var(--button-width) - var(--slider-padding));
   left: calc(var(--slider-padding) /2);
  z-index: 1;
  box-sizing: border-box;
  height: var(--slider--height);
  cursor: pointer;
            }
            
:host([hidden]) {
    display: none !important;
  }

 input ~ .text-container > .left {
     /*     visibility: hidden;  */
     /*     opacity: 0; */
          transition: all .7s;
            }

 input ~ .text-container > .right{
        visibilty: visible;
     /*   opacity:1; */
        transition: all .7s;
           }
 input:checked ~ .text-container > .left{
        visibility: visible;
        opacity:1;
            }

input:checked ~ .text-container > .right{
      /*      visibility: hidden;   */
     /*        opacity: 0;   */
            }

           /* Button theming */
             :host([theme~='primary']) {
                
              }

            :host([theme~='tertiary']) {

                }

            :host([theme~='tertiary-inline']) {

              }


            :host([roundness~='round'])  .slider:before {
                   border-radius: calc(var(--lumo-size-m) / 2);
            }

           :host([roundness~='round']) input + .slider {
                 border-radius: calc(var(--lumo-size-m) / 2);
            }

           :host([flatRaised~='flat']) input:checked + .slider {
            --lumo-tint-5pct: hsla(214, 65%, 85%, 0.06);
            --lumo-shade-5pct: hsla(214, 0%, 0%, 0.07);
            }

          /* Atributte for both visible */
          :host([statesVisible~='both']) input:checked + .slider{
              background-color: #ccc;
            }
            
            :host([statesVisible~='both']) .slider:before {
              z-index: 1;
            }
          :host([statesVisible~='both']) input ~ .text-container > .left{
              visibility: visible;
              opacity: 1;
              color:black;
              transition: none;
            }

        :host([statesVisible~='both']) input ~ input:checked ~ .text-container > .left{
               visibility: visible;
                transition: none;
                opacity: 1;
                color: black;
            }

        :host([statesVisible~='both'])  input ~ .text-container > .right{
              color: black;
              z-index:10;
              visibility: visible;
              opacity: 1;
              transition: none;
            }

        :host([statesVisible~='both'])  input:checked ~ .text-container > .right {
                visibility: visible;
                opacity: 1;
                z-index:10;
                transition: none;
            }

        :host([flatRaised~='flat']){
              color:black;
            }

        [part]::slotted(vaadin-icon) {
                display: inline-block;
                width: var(--lumo-icon-size-m);
                height: var(--lumo-icon-size-m);
              /*  padding: 0.25em; */
                }

        :host([flatRaised~='flat']){
              color:black;
            }

        :host([disabled]) {
              pointer-events: none;

              color: var(--lumo-disabled-text-color);
          }
        /* TODO  Change colors for disabled state   */
        :host([disabled]) input + .slider {
              background-color: gray;
              cursor: not-allowed;
              opacity: 0.7;
          }
        :host([disabled]) input:checked + .slider{
            background-color:gray;
}

        :host([focus-ring]) {
            box-shadow: 0 0 0 var(--_focus-ring-width) var(--_focus-ring-color);
                }
        :host([theme~='primary'][focus-ring]) {
            box-shadow: 0 0 0 1px var(--lumo-base-color), 0 0 0 3px var(--lumo-primary-color-50pct);
        }
         
         /* Hover state  */  
                  
          label:hover .slider:before{
            box-shadow: 0 0 0 .3rem var(--highlight-color);
            }
            
            
       :host([theme~='redGreen'])  .slider{
           background-color: #ff0000; 
            }    
      :host([theme~='redGreen'])  input:checked + .slider{
            background-color: #00ff00;
            
            }
       :host([theme~='redGreen']) .slider:before{
             --highlight-color: hsl(0, 0%, 100%, 0.47);
            }
      
        :host([theme~='error']) input:checked + .slider{
            background-color: var(--lumo-error-color);
            }
            
       :host([theme~='contrast'])  input:checked + .slider{
            background-color: var(--lumo-shade);     
            }   
                 
       :host([theme~='success']) input:checked + .slider{
            background-color: var(--lumo-success-color);
            }
       :host([theme~='small'])  {
           
       }   
   
            `;}


    _changeCheckedState = (event: Event) =>{
        this.checked = (event.target as HTMLInputElement).checked;
        console.log("test");
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