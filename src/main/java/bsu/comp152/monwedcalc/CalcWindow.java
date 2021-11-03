package bsu.comp152.monwedcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcWindow {
    private long firstNumber;
    private OperatorType operation;

    @FXML
    private TextField numberField;

    @FXML
    public void numberButtonPressed(ActionEvent event){
        var pressedButton=(Button)event.getSource();
        var buttonText=pressedButton.getText();
        var currentNumberText=numberField.getText();
        numberField.setText(currentNumberText+buttonText);
    }

    @FXML
    public void clearButtonPressed(){
        numberField.clear();
    }

    @FXML
    public void plusPressed(){
        processNumber();
        operation=OperatorType.Add;

    }

    @FXML
    public void minusPressed(){
        processNumber();
        operation=OperatorType.Subtract;
    }

    @FXML
    public void multPressed(){
        processNumber();
        operation=OperatorType.Multiply;
    }

    @FXML
    public void divPressed(){
        processNumber();
        operation=OperatorType.Divide;
    }

    @FXML
    public void equalPressed(){
        var secondNumberText=numberField.getText();
        var secondNumber=Long.parseLong(secondNumberText);
        var result = 0.0;
        switch (operation){
            case Add -> result=firstNumber+secondNumber;
            case Subtract -> result=firstNumber-secondNumber;
            case Multiply -> result=firstNumber*secondNumber;
            case Divide -> result=(double) firstNumber/secondNumber;//sets up to force convert from long to double since decimals can result from division

        }
        numberField.setText(""+result); //as long as empty string is first, it converts rest to string
    }

    private void processNumber(){
        var numberAsText=numberField.getText();
        firstNumber=Long.parseLong(numberAsText);
        numberField.setText("");
    }
}
