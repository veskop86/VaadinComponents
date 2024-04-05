import { LitElement, css, html } from "lit";
import { customElement, property } from "lit/decorators.js";
import {ElementMixin} from "@vaadin/component-base";
import {PolylitMixin} from "@vaadin/component-base/src/polylit-mixin";
import {} from '../color.js';
import {} from '../sizing.js';
import {} from '../spacing.js';
import {} from '../typography';
import {} from '../style';

import {SwitchButtonMixin} from './switch-button-mixin';

@customElement("switch-button")
export class SwitchButton extends LitElement{

   static get is(){
       return 'switch-button';

   }

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
              --highlight-width: .3rem;    
        --lumo-primary-color-50pct: hsla(0, 0%, 100%, 0.64);
        --lumo-primary-text-color: hsl(214, 100%, 43%);
              --lumo-size-m: 2.25rem;
              --lumo-size-l: 2.75rem;
              --lumo-size-s: 1.875rem;
              --lumo-space-xs: 0.25rem;
              --button-size: var(--lumo-size-m);
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
              
        --text-height: calc(var(--button-size) / 1.5);
        --text-width: calc(var(--button-size) / 1.5);
            
        /* Slider padding mora biti paran.To je ovo oko teksta */
        /* slider-padding:4px */
        --slider-padding:  calc(var(--button-size) / 9);
        --slider--height: calc(var(--text-height) + var(--slider-padding));
        --slider-width: var(--slider--height);
     /* --button-height: calc(var(--slider--height) + 8px ); */
        --button-height: calc(var(--slider--height) + 2 * var(--slider-padding));
        /* Length of slider translation is text-width + slider-padding */
        
    /*  --button-width: calc(var(--text-height) * 2 + 16px); */
        --button-width: calc( 2 * var(--slider-width) +  3 * var(--slider-padding));
              --slider-transitionx-length: calc(var(--slider-width) + var(--slider-padding)) ;
              --transition-duration: .4s;
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
              padding: var(--lumo-space-xs) 0;
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
                padding-top: 0.25em;
                margin-top: -0.25em;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
                position: relative;
                max-width: 100%;
                box-sizing: border-box;
            }
            /* If component has label styling */
            :host([has-label])::before {
                margin-top: calc(var(--lumo-font-size-s) * 1.5);
            }
            
            :host([has-label]) {
                padding-top: var(--lumo-space-m);
            }
            :host(:not([has-label])) [part='label'] {
                     display: none; 
            }
            /*  Hidden attribute  */
            :host([hidden]) {
                display: none !important;
            }
                
            .container{
                display:inline-block;
                position: relative;
                bottom: 4px;
            }
            
            .label{
                color: var(--vaadin-input-field-value-color, var(--lumo-body-text-color));
                font-size: var(--vaadin-input-field-value-font-size, var(--lumo-font-size-m));
                font-weight: var(--vaadin-input-field-value-font-weight, 400);
                color: hsla(214, 42%, 18%, 0.69);
            }
            
     .switch {
        position: relative;
        display: inline-block;
        width: var(--button-width);
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
          -webkit-transition: var(--transition-duration);
          transition: var(--transition-duration);
          border-radius: var(--lumo-border-radius-m);
          box-sizing: border-box;
         }

      .slider::before {
        position: absolute;
        content: "";
        height: var(--slider--height);
        width: var(--slider-width);
        left: calc( var(--slider-padding));
        bottom: var(--slider-padding);
        top: var(--slider-padding);    
        background-color: white;
        -webkit-transition: var(--transition-duration);
        transition: var(--transition-duration);
        border-radius: calc( var(--lumo-border-radius-m) / 2);
        z-index: 1;
          box-sizing: border-box;
      }
    
input:checked + .slider {
    background-color: var(--lumo-primary-color);
    
            }
           
input:checked + .slider:before {
       -webkit-transform: translateX(var(--slider-transitionx-length));
       -ms-transform: translateX(var(--slider-transitionx-length));
       transform: translateX(var(--slider-transitionx-length));
        box-sizing: border-box;
}
            
.text-container{
        position: absolute;
        bottom: calc(var(--slider-padding));
        width: calc(var(--button-width));
        z-index: 1;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-sizing: border-box;
        height: var(--slider--height);
        cursor: pointer;
        padding-left: calc(var(--slider-padding) * 1.5);
        padding-right: calc(var(--slider-padding) * 1.5);
        
            }
                
            .text{
                position: relative;
                display: flex;
                justify-content: center;
                align-items: center;
                
                box-sizing: border-box;
      /*             top: calc( 0.5 *  var(--slider-padding));   */
                height: calc(var(--text-height));
                width: calc(var(--text-width));
                text-align: center;
              
                overflow: hidden;
                cursor: pointer;
        /*         border: 1px solid yellow;    */
            }
            
 input ~ .text-container > .left {
     /*     visibility: hidden;  */
     /*     opacity: 0; */
          transition: all var(--transition-duration);
            }

 input ~ .text-container > .right{
        visibilty: visible;
     /*   opacity:1; */
        transition: all var(--transition-duration);
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
                   border-radius: calc(var(--button-size) / 2);
            }
                
           :host([roundness~='round']) input + .slider {
                 border-radius: calc(var(--button-size) / 2);
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
                box-sizing: border-box;
                }
        :host([theme~='small']) [part]::slotted(vaadin-icon){
            display: inline-block;
            width: var(--lumo-icon-size-s);
            height: var(--lumo-icon-size-s);
            box-sizing: border-box;
           
        }    
            
        :host([flatRaised~='flat']) [part]::slotted(vaadin-icon){
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
        
        :host([focus-ring]) > .container{
            box-shadow: 0 0 0 2px red;
                }
        :host([theme~='primary'][focus-ring]) {
            box-shadow: 0 0 0 1px var(--lumo-base-color), 0 0 0 3px var(--lumo-primary-color-50pct);
        }
         
         /* Hover state  */  
            
            
          label:hover .slider:before{
            box-shadow: 0 0 0 var(--highlight-width) var(--highlight-color);
            }
            
        :host([theme~='error']) input:checked + .slider{
            background-color: var(--lumo-error-color);
            }
            
       :host([theme~='contrast'])  input:checked + .slider{
            background-color: var(--lumo-shade);     
            }
            
            :host([theme~='success'])  .slider{
                background-color: #ccc;
            }
            :host([theme~='success']) input:checked + .slider{
                    background-color:  var(--lumo-success-color);
            }
            :host([theme~='success']) .slider:before{
                --highlight-color: hsl(0, 0%, 100%, 0.47);
            }
            
            :host([theme~='small'])  {
                --button-size: var(--lumo-size-s);
                 }
                
            :host([theme~='small']:not([roundness='round']))  .slider:before)  {
                --highlight-width: .28rem;   
            } 
              
            :host([theme~='small']) [part='label'] {
                font-size: var(--lumo-font-size-xs);
            }
                  
            :host([theme~='large']){
                --button-size: var(--lumo-size-l);
                --highlight-width: .33rem;
            }
            :host([theme~='large']:not([roundness='round']))  .slider:before{
                border-radius: calc( var(--lumo-border-radius-m) / 4);     
            }
            
            :host([focused]:not([readonly])) [part="label"] {
                color: var(--lumo-primary-text-color);
            }
            
            :host(:hover:not([readonly]):not([focused])) [part="label"]
           {
                color:  hsla(214, 40%, 16%, 0.94);
            }
            :host([disabled]) [part='label']
           {
                color: var(--lumo-disabled-text-color);
                -webkit-text-fill-color: var(--lumo-disabled-text-color);
            }
            :host([theme~='small']) [part='label'] {
                font-size: var(--lumo-font-size-xs);
            }

            :host:focus  .container    .switch  {
                box-shadow: 0 0 0 2px red;
            }
            
            :host([disabled]) [part='label']
             {
                color: var(--lumo-disabled-text-color);
                -webkit-text-fill-color: var(--lumo-disabled-text-color);
            }

            :host([focus-ring]) .slider  {
                box-shadow: 0 0 0 var(--_focus-ring-width) var(--_focus-ring-color);
            }
             
        `;}


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