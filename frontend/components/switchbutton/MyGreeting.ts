import { LitElement, css, html } from "lit";
import { customElement, property } from "lit/decorators.js";

@customElement("my-greeting")
export class MyGreeting extends LitElement{
    
   static get styles(){
     return css`
         :host{
             position: relative;
             border: 2px solid black;
             padding: 0;
             margin: 0;
             height: min-content;
         }
         div{
             display:inline-block;
             padding: 0;
         }
         `;
   }
 
   render(){
        return html`
            <div>
              <p style='border:2px solid black;'>Test</p>
            </div>
            `;    
            
       }
}