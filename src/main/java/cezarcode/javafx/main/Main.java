package cezarcode.javafx.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application 
{
	
public static void main (String[] args) {
launch(args); // komenda do uruchomienia
}

@Override
public void start(Stage primaryStage) throws Exception {
	
	FXMLLoader  loader = new FXMLLoader();
	loader.setLocation(this.getClass().getResource("/fxml/MainScreen.fxml")); // ustawienie pliku fxml MainScreen
	StackPane stackPane = loader.load(); // zaladowanie strumienia ustawionego pliku  do stackPane
	
	Scene scene = new Scene(stackPane); // nowa scena
	
	primaryStage.setScene(scene);
	
	
	primaryStage.setTitle("Cezar Code"); // ustawienie tytulu
	primaryStage.show(); 
	
}

public static String Encode(String str, int number)
{
	str=str.toUpperCase(); // zamiana na wielkie litery
	StringBuilder builder = new StringBuilder();
	
for (int i = 0; i < str.length(); i++) {
	
	if(str.charAt(i)==32)
	{
		builder.append(" ");
	}
	
	if ((str.charAt(i) + number <= 90) && (str.charAt(i) + number >= 65)) {
	
	
		builder.append((char)(str.charAt(i)+number));
		//System.out.println(i+" "+builder);
	
	}

	else if ((str.charAt(i) - 26 + number >= 65) && (str.charAt(i) - 26 + number <= 90)) {
	
		builder.append((char)(str.charAt(i)+number-26));
		//System.out.println(i+" "+builder);
	
	}
}



return builder.toString();
}

public static String Decode(String str, int number)
{
	str=str.toUpperCase(); // zamiana na wielkie litery
	StringBuilder builder2 = new StringBuilder();
	

for (int i = 0; i < str.length(); i++) {
	
	if(str.charAt(i)==32)
	{
		builder2.append(" ");
	}
	
	if (((str.charAt(i) - number + 26) >= 65) && (str.charAt(i) - number + 26 <= 90)) {
		
		builder2.append((char)(str.charAt(i)-number+26));
		//System.out.println(i+" "+builder2);
		

	}

	else if ((str.charAt(i) - number >= 65) && (str.charAt(i) - number <= 90)) {

		builder2.append((char)(str.charAt(i)-number));
		//System.out.println(i+" "+builder2);
		
	}
}
return builder2.toString();

}

}
 