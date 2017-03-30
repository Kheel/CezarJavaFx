/**
 * Sample Skeleton for 'MainScreen.fxml' Controller Class
 */

package cezarcode.javafx.controller;

import cezarcode.javafx.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="label1"
    private Label label1; // Value injected by FXMLLoader

    @FXML // fx:id="textarea1"
    private TextArea textarea1; // Value injected by FXMLLoader

    @FXML // fx:id="textarea2"
    private TextArea textarea2; // Value injected by FXMLLoader
    
    @FXML // fx:id="textarea2"
    private TextField textfield1; // Value injected by FXMLLoader

    @FXML
    void onActionButton1(ActionEvent event) {
    	
    	int number=0;
    	try
    	{
        number = Integer.parseInt(textfield1.getText()); // pobranie text z texfield1 (pobieranie przesuniecia) i nastepnie zrzutowanie go na typ Int
		number= Math.abs(number); // przesuniecie w prawo , przesuniecie w lewo bedzie testowane w nowszych wersjach 
		number = number %26; // modulo 26 -- > 30 % 26 = 4 --> przesuniecie o 4 pozycje w prawo
  		label1.setText(""); // etykieta z bledami ustawiona jako pusta 
    	}
    	catch (Exception e)
    	{
    		System.err.println("Blad " + e);
    		label1.setText("Error - "+e.getMessage()); // nadpisanie etykiety wiadomoscia z otrzymanym wyjatkiem
    	}
    	
        finally
        {
        	textarea2.setText(Main.Encode(textarea1.getText(),number)); // ustawienie zakodowanego textu z textarea1 w textarea2
        }
    	

    }

    @FXML
    void onActionButton2(ActionEvent event) {
    	int number=0;
    	try
    	{
        number = Integer.parseInt(textfield1.getText());
		number= Math.abs(number);
		number = number %26;
  		label1.setText(""); 
    	}
    	catch (Exception e)
    	{
    		System.err.println("Blad " + e);
    		label1.setText("Error - "+e.getMessage());
    	}
        
    	finally
    	
    	{
    		textarea2.setText(Main.Decode(textarea1.getText(),number)); // ustawienie odkodowanego textu z textarea1 w textarea2
    	}

    }

}
