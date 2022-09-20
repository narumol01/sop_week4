package com.example.sop_week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private TextField t1,t2,t3;
    private Button bPlus, bMinus, bMul, bMod, bMax, bDi;
    public MathView(){
        t1 = new TextField("Number 1");
        t2 = new TextField("Number 2");
        t3 = new TextField("Answer");
        bPlus = new Button("+");
        bMinus = new Button("-");
        bMul = new Button("x");
        bDi = new Button("/");
        bMod = new Button("Mod");
        bMax = new Button("Max");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(bPlus, bMinus, bMul,bDi, bMod, bMax);
        add(t1, t2, h1, t3);
         bPlus.addClickListener(event ->{
            double number1 = Double.parseDouble(t1.getValue());
            double number2 = Double.parseDouble(t2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/add/"+number1+"/"+number2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
             t3.setValue(out);

         });
        bMinus.addClickListener(event ->{
            double number1 = Double.parseDouble(t1.getValue());
            double number2 = Double.parseDouble(t2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+number1+"/"+number2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);

        });
        bMul.addClickListener(event ->{
            double number1 = Double.parseDouble(t1.getValue());
            double number2 = Double.parseDouble(t2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multiply/"+number1+"/"+number2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);

        });
        bDi.addClickListener(event ->{
            double number1 = Double.parseDouble(t1.getValue());
            double number2 = Double.parseDouble(t2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+number1+"/"+number2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);

        });
        bMod.addClickListener(event ->{
            double number1 = Double.parseDouble(t1.getValue());
            double number2 = Double.parseDouble(t2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+number1+"/"+number2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);

        });

        bMax.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", t1.getValue());
            formData.add("n2", t2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            t3.setValue(out);
        });
    }
}
