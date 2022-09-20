package com.example.sop_week4;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField t1,t2,t3,t4,t5,t6,t7,t8;
    private Button b;
     public CashierView(){
         t1 = new TextField("เงินทอน");
         b = new Button("คิดเงินทอน");
         t2 = new TextField();
         t3 = new TextField();
         t4 = new TextField();
         t5 = new TextField();
         t6 = new TextField();
         t7 = new TextField();
         t8 = new TextField();

         t1.setPrefixComponent(new Div(new Text("$")));
         t2.setPrefixComponent(new Div(new Text("$1000:")));
         t3.setPrefixComponent(new Div(new Text("$500:")));
         t4.setPrefixComponent(new Div(new Text("$100:")));
         t5.setPrefixComponent(new Div(new Text("$20:")));
         t6.setPrefixComponent(new Div(new Text("$10:")));
         t7.setPrefixComponent(new Div(new Text("$5:")));
         t8.setPrefixComponent(new Div(new Text("$1:")));

         add(t1,b,t2,t3,t4,t5,t6,t7,t8);

         b.addClickListener(event ->{
             Change result = WebClient
                     .create()
                     .get()
                     .uri("http://localhost:8080/getChange/"+t1.getValue())
                     .retrieve()
                     .bodyToMono(Change.class)
                     .block();
             t2.setValue(result.getB1000()+"");
             t3.setValue(result.getB500()+"");
             t4.setValue(result.getB100()+"");
             t5.setValue(result.getB20()+"");
             t6.setValue(result.getB10()+"");
             t7.setValue(result.getB5()+"");
             t8.setValue(result.getB1()+"");
         });

     }
}
