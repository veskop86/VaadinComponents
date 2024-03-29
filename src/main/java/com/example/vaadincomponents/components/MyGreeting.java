package com.example.vaadincomponents.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("my-greeting")
@JsModule("./components/switchbutton/MyGreeting.ts")
public class MyGreeting extends LitTemplate {

}