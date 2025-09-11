package com.jobhellper.backend.views;
import org.springframework.beans.factory.annotation.Autowired;

import com.jobhellper.backedn.NumberServices;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
@Route("")

public class HomeView extends VerticalLayout {
    public HomeView(@Autowired NumberServices numberSevices){
    NumberField numberField = new NumberField("Number");
    Button button = new Button("Check");

    Paragraph result = new Paragraph();

button.addClickListener(
    click -> {
        if (numberField.getValue() != null) {
                int processedNumber=numberSevices.processedNumber(numberField.getValue().intValue());
                result.setText("Processed Number : "+String.valueOf(processedNumber));
            } else {
                result.setText("Please enter a number");
            }
    }
);

}
}
// import com.vaadin.flow.component.html.H1;
// import com.vaadin.flow.component.html.Paragraph;
// import com.vaadin.flow.component.orderedlayout.VerticalLayout;
// import com.vaadin.flow.router.Route;


// @Route("")
// public class HomeView extends VerticalLayout {

//     public HomeView() {

//         add(new H1("Welcome to your new application"));
//         add(new Paragraph("This is the home view"));

//         add(new Paragraph("You can edit this view in src\\main\\java\\com\\JobHellper\\BackEnd\\views\\HomeView.java"));

//     }
// }
