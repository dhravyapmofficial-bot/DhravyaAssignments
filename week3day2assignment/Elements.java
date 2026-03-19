package org.testleaf.week3day2assignment;

public class Elements{

    public static void main(String[] args) {
        
        //Button object
        Button btn = new Button();
        btn.click();
        btn.setText("Click Me");
        btn.submit();
        System.out.println("----------------------");

        //TextField object
        TextField txt =  new TextField();
        txt.click();
        txt.setText("Hello");
        txt.getText();
        System.out.println("----------------------");

        //CheckBoxButton object
        CheckBoxButton cb =  new CheckBoxButton();
        cb.click();
        cb.setText("Checkbox");
        cb.submit();
        cb.clickCheckButton();
        System.out.println("----------------------");

        //RadioButton object
        RadioButton rb =  new RadioButton();
        rb.click();
        rb.setText("Radiobutton");
        rb.submit();
        rb.selectRadioButton();
        System.out.println("----------------------");

    }

}
