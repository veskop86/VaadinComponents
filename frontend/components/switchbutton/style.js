    import {css} from 'lit';
    import {} from '../color.js';
    import {} from '../sizing.js';
    import {} from '../spacing.js';
    import {} from '../typography';
    import {} from '../style';

    export  const switchbuttonstyles = css`
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

            --slider-padding:  calc(var(--button-size) / 9);
            --slider--height: calc(var(--text-height) + var(--slider-padding));
            --slider-width: var(--slider--height);--button-height: calc(var(--slider--height) + 2 * var(--slider-padding));

            --button-width: calc( 2 * var(--slider-width) +  3 * var(--slider-padding));
            --slider-transitionx-length: calc(var(--slider-width) + var(--slider-padding)) ;
            --transition-duration: .4s;
            --margin: var(--lumo-space-xs);
            --unchecked-slider-color: #ccc;
            --label-color:  hsla(214, 42%, 18%, 0.69);

            font-family: var(--lumo-font-family);
            font-weight: var(--vaadin-button-font-weight, 500);
            color: var(--lumo-body-text-color);
            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -khtml-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            margin: var(--vaadin-button-margin, var(--lumo-space-xs) 0);
            padding: var(--lumo-space-xs) 0;
            --text-container-padding: calc(var(--slider-padding) * 1.5);
            --disabled-background-color: gray;
            --label-hover-color: hsla(214, 40%, 16%, 0.94);
        }


        .container{
            display:inline-block;
            position: relative;
            bottom: 4px;
        }
//        .label{
//            color: var(--vaadin-input-field-value-color, var(--lumo-body-text-color));
//            font-size: var(--vaadin-input-field-value-font-size, var(--lumo-font-size-m));
//            font-weight: var(--vaadin-input-field-value-font-weight, 400);
//            color: var(--label-color);
//        }
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
            background-color: var(--unchecked-slider-color);
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
            padding-left: calc(var(--text-container-padding));
            padding-right: calc(var(--text-container-padding));
        }
        .text{
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
            box-sizing: border-box;
            height: calc(var(--text-height));
            width: calc(var(--text-width));
            text-align: center;
            overflow: hidden;
            cursor: pointer;
        }

        input ~ .text-container > .left {
            visibility: hidden;
            opacity: 0;
            transition: all var(--transition-duration);
        }

        input ~ .text-container > .right{
            visibility: visible;
            opacity:1;
            transition: all var(--transition-duration);
        }
        input:checked ~ .text-container > .left{
            visibility: visible;
            opacity:1;
        }
        input:checked ~ .text-container > .right {
            visibility: hidden;
            opacity: 0;
        }
        // Component can have label, positioned above, like text field, and other vaadin field components

        /* If label is added, padding-top must be added. Other vaadin field components(text field, email field, password field)
           have same padding, if set label  */

         :host([has-label]) {
             padding-top: var(--lumo-space-m);
         }

        :host([has-label])::before {
                    margin-top: calc(var(--lumo-font-size-s) * 1.5);
        }

        //
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


        :host(:not([has-label])) [part='label'] {
            display: none;
        }

        // Component can be hidden

       /* Style for hidden component */
        :host([hidden]) {
           display: none !important;
         }

        // Normal component looks like rectangle with rounded corners with small border radius.

        /* Roundness attribute defines rounded component with bigger border radius  */

        :host([roundness~='rounded'])  .slider:before {
            border-radius: calc(var(--button-size) / 2);
        }
        :host([roundness~='rounded']) input + .slider {
            border-radius: calc(var(--button-size) / 2);
        }

        // Component can have both values visible. Attribute statesVisible defines that state.

        /*  Style for both states visible.  */
        :host([statesVisible~='both']) input:checked + .slider{
            background-color: var(--unchecked-slider-color);
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
         /*   z-index: 10; */
            visibility: visible;
            opacity: 1;
            transition: none;
        }
        :host([statesVisible~='both'])  input:checked ~ .text-container > .right {
            visibility: visible;
            opacity: 1;
        /*    z-index: 10;   */
            transition: none;
        }
        // Component can have multiple attributes theme  with different states of theme attribute
        // For example component could be small and error.

        /* Themes primary,secondary and tertiary.  */
        :host([theme~='primary']) {
           }
        :host([theme~='tertiary']) {
          }

        :host([theme~='tertiary-inline']) {
        }

        /* Themes error, succeess, contrast */
        :host([theme~='error']) input:checked + .slider{
            background-color: var(--lumo-error-color);
        }

        :host([theme~='success'])  .slider{
            background-color: var(--disabled-background-color);
        }

        :host([theme~='contrast'])  input:checked + .slider{
                  background-color: var(--lumo-shade);
                }

        :host([theme~='success']) input:checked + .slider{
            background-color:  var(--lumo-success-color);
        }

        :host([theme~='success']) .slider:before{
            --highlight-color: hsl(0, 0%, 100%, 0.47);
        }

       /* Themes small, normal, large */
        :host([theme~='small'])  {
            --button-size: var(--lumo-size-s);
        }
       :host([theme~='small']) [part='label'] {
                    font-size: var(--lumo-font-size-xs);
        }
        :host([theme~='small']:not([roundness='rounded']))  .slider:before  {
               --highlight-width: .28rem;
        }
        host([theme~='small']) [part='label'] {
            font-size: var(--lumo-font-size-xs);
        }
        :host([theme~='large']){
            --button-size: var(--lumo-size-l);
            --highlight-width: .33rem;
        }
        :host([theme~='large']:not([roundness='rounded']))  .slider:before{
            border-radius: calc( var(--lumo-border-radius-m) / 4);
        }
        /* Focused part label */
        :host([focused]:not([readonly])) [part="label"] {
            color: var(--lumo-primary-text-color);
        }

        /* Hovered button labels color changes  */
        :host(:hover:not([readonly]):not([focused])) [part="label"] {
            color:  var(--label-hover-color);
        }

        /* Hovered  */
        label:hover .slider:before{
            box-shadow: 0 0 0 var(--highlight-width) var(--highlight-color);
         }

        /* Disabled button  */
        :host([disabled]) [part='label'] {
            color: var(--lumo-disabled-text-color);
            -webkit-text-fill-color: var(--lumo-disabled-text-color);
        }

        :host([disabled]) [part='label'] {
            color: var(--lumo-disabled-text-color);
            -webkit-text-fill-color: var(--lumo-disabled-text-color);
        }
        :host([disabled]) {
            pointer-events: none;
            color: var(--lumo-disabled-text-color);
        }

        :host([disabled]) input + .slider {
            background-color: gray;
            cursor: not-allowed;
            opacity: 0.7;
        }

        :host([disabled]) input:checked + .slider{
                    background-color:var(--disabled-background-color);
         }

        /* Focus keyboard  on component */
        :host([focus-ring]) .slider  {
            box-shadow: 0 0 0 var(--_focus-ring-width) var(--_focus-ring-color);
        }

        :host([focus-ring]) > .container{
           box-shadow: 0 0 0 2px red;
          }

        :host([theme~='primary'][focus-ring]) {
            box-shadow: 0 0 0 1px var(--lumo-base-color), 0 0 0 3px var(--lumo-primary-color-50pct);
            }

       /*   */
       [part]::slotted(vaadin-icon) {
             display: inline-block;
             width: var(--lumo-icon-size-m);
             height: var(--lumo-icon-size-m);
             box-sizing: border-box;
        }

        host([theme~='small']) [part]::slotted(vaadin-icon){
             display: inline-block;
             width: var(--lumo-icon-size-s);
             height: var(--lumo-icon-size-s);
             box-sizing: border-box;
        }
    `;