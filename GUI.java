package chap1416JavaFX;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;




public class CourseScore extends Application {
	//to hold the text fields values
	private TextField score1= new TextField();
	private TextField score2= new TextField();
	private TextField score3= new TextField();
	private TextField score4= new TextField();
	private TextField score5= new TextField();
	private TextField score6= new TextField();
	private TextField total=new TextField();
	private TextField finalScore= new TextField();
	private TextField finalGrade= new TextField();
	private TextField maxScore1= new TextField();
	private TextField maxScore2= new TextField();
	private TextField maxScore3= new TextField();
	private TextField maxScore4= new TextField();
	private TextField maxScore5= new TextField();
	private TextField maxScore6= new TextField();
	private TextField maxTotal= new TextField();
	public void start(Stage Stage) throws Exception {
		
	
		GridPane pane= new GridPane();//new Grid Pane 		
		pane.setAlignment(Pos.CENTER);//set the alignment to the center		
		pane.setStyle("-fx-background-color:AliceBlue;");//background color		
		pane.setPadding(new Insets(10,15,10,15));//padding		
		pane.setHgap(10);// Horizontal gap 
		pane.setVgap(14);//vertical gap 
		
		Button B1=new Button("Calculate");//the first button		
		B1.setFont(Font.font("Papyrus",14));//font style and size 
		B1.setTextFill(Color.WHITE);//text color
		B1.setStyle("-fx-background-color:Maroon;");//button color
		
		Button B2=new Button("Start Over");//2nd button
		B2.setFont(Font.font("Papyrus",12));
		B2.setTextFill(Color.YELLOW);
		B2.setStyle("-fx-background-color:MidnightBlue;");
		GridPane.setHalignment(B1, HPos.RIGHT);//button 1 and 2 positions 
		GridPane.setHalignment(B2, HPos.RIGHT);
		
		
		
		Label label1=new Label("Earned Score");//making the top labels
		Label label2=new Label("Max Possible");
		label1.setStyle("-fx-font-size: 12pt");//font size for the top labels
		label2.setStyle("-fx-font-size: 12pt");		
		GridPane.setHalignment(label1, HPos.CENTER);//positing of the labels
		GridPane.setHalignment(label2, HPos.CENTER);
		
		
		total.setEditable(false);//set not editable  
		total.setVisible(false);//set not visible
		total.setStyle("-fx-background-color:Gainsboro;");//setting color
		
		
		maxTotal.setEditable(false);//set not editable  
		maxTotal.setVisible(false);
		maxTotal.setStyle("-fx-background-color:Gainsboro;");//color
		finalScore.setEditable(false);
		finalScore.setVisible(false);
		finalScore.setStyle("-fx-background-color:Gainsboro;");
		finalGrade.setEditable(false);
		finalGrade.setVisible(false);
		finalGrade.setStyle("-fx-background-color:Gainsboro;");
		
		Text text=new Text("Perfect score!");//setting the Perfect score text line 
		text.setFont(Font.font("Cambria", 18));
		text.setVisible(false);
		text.setFill(Color.DODGERBLUE);
		text.setStyle("-fx-font-size: 12pt");
		
		Label totalLabel=new Label ("TOTAL:");
		
		totalLabel.setVisible(false);
		
		Label finalScoreLabel=new Label ("FINAL SCORE:");
		
		finalScoreLabel.setVisible(false);
		
		
		Label finalGradeLabel=new Label ("FINAL GRADE:");
		
		finalGradeLabel.setVisible(false);
		
		//adding all the children to the pane
	
		pane.add(label1,1,0);		
		pane.add(label2,2,0);		
		pane.add(new Label("Score #1:"), 0, 1);
		pane.add(score1, 1, 1);
		pane.add(maxScore1, 2, 1);
		pane.add(new Label("Score #2:"), 0, 2);
		pane.add(score2, 1, 2);
		pane.add(maxScore2, 2, 2);
		pane.add(new Label("Score #3:"), 0, 3);
		pane.add(score3, 1, 3);
		pane.add(maxScore3, 2, 3);
		pane.add(new Label("Score #4:"), 0, 4);
		pane.add(score4, 1, 4);
		pane.add(maxScore4, 2, 4);
		pane.add(new Label("Score #5:"), 0, 5);
		pane.add(score5, 1, 5);
		pane.add(maxScore5, 2, 5);
		pane.add(new Label("Score #6:"), 0, 6);
		pane.add(score6, 1, 6);
		pane.add(maxScore6, 2, 6);	
		pane.add(totalLabel, 0, 8);
		pane.add(total, 1, 8);
		pane.add(maxTotal, 2, 8);
		pane.add(finalScoreLabel, 0, 9);
		pane.add(finalScore, 1, 9);
		pane.add(finalGradeLabel, 0, 10);
		pane.add(finalGrade, 1, 10);
		pane.add(text,1,11);
		pane.add(B1, 2, 11);
		pane.add(B2, 2, 12);
		
		// calling the event handlers in case of button 1 pressed to calculate
		B1.setOnAction(e ->	calculate(totalLabel,finalScoreLabel,finalGradeLabel,text));
		
		
		// calling the event handlers in case of button 2 pressed to start over
		B2.setOnAction(e ->{
			startOver(totalLabel,finalScoreLabel,finalGradeLabel,text);
		});
		 
		// adding the pane to the scene 
		Scene scene=new Scene(pane);		
		Stage.setResizable(false);//setting the stage 
		Stage.setScene(scene);
		Stage.setTitle("Calculate Course Score");
		Stage.show();//displaying the stage
		
		// calling the event handler in case of the key Enter is pressed
		scene.setOnKeyPressed(e ->{
			if (e.getCode()==KeyCode.ENTER);{
				calculate(totalLabel,finalScoreLabel,finalGradeLabel,text);
			}
			
		});
	}
	// the calculate button method that takes care of calculating the scores and showing the results
	public  void calculate (Label totalLabel,Label finalScoreLabel,Label finalGradeLabel,Text text) {
		//setting the labels to visible
		maxTotal.setVisible(true);
		total.setVisible(true);
		totalLabel.setVisible(true);
		finalScore.setVisible(true);
		finalScoreLabel.setVisible(true);
		finalGrade.setVisible(true);
		finalGradeLabel.setVisible(true);
		
		// getting the double values from the textfields 
		double firstScore =Double.parseDouble(score1.getText());
		double secoundScore =Double.parseDouble(score2.getText());
		double thirdScore =Double.parseDouble(score3.getText());
		double forthScore =Double.parseDouble(score4.getText());;
		double fifthScore =Double.parseDouble(score5.getText());;
		double sixScore =Double.parseDouble(score6.getText());;
		double maxFirstScore =Double.parseDouble(maxScore1.getText());
		double MaxSecoundScore =Double.parseDouble(maxScore2.getText());
		double MaxThirdScore =Double.parseDouble(maxScore3.getText());
		double MaxForthScore =Double.parseDouble(maxScore4.getText());;
		double MaxFifthScore =Double.parseDouble(maxScore5.getText());;
		double MaxSixScore =Double.parseDouble(maxScore6.getText());;
		// calculating the total score
		double totalLine=firstScore+secoundScore+thirdScore+
				forthScore+fifthScore+sixScore;
		//calculating the max possible score 
		double maxPossilpleTotal=maxFirstScore+MaxSecoundScore+MaxThirdScore+
				MaxForthScore+MaxFifthScore+MaxSixScore;
		
		//setting the text fields
		 total.setText(String.valueOf(totalLine));
		 
		 maxTotal.setText(String.valueOf(maxPossilpleTotal));
		
	
		 finalScore.setText(String.valueOf(totalLine/maxPossilpleTotal*100));
		 
		 // to hold the value of the final score in double after calculating
		 double fscroe=Double.parseDouble(finalScore.getText());
		 
		 // Evaluating the conditions of the grades earned
		 if (fscroe==100) {
			 
			 text.setVisible(true);
			 finalGrade.setText("A");
			 finalGrade.setStyle("-fx-background-color:DodgerBlue");
		 }
		 else if  (fscroe>=90) {
			 finalGrade.setText("A");
			 text.setVisible(false);
			 finalGrade.setStyle("-fx-background-color:Gainsboro;");
		 }
		 else if (fscroe>80 
				 && fscroe<89.999999) {
			 finalGrade.setText("B");
			 text.setVisible(false);
			 finalGrade.setStyle("-fx-background-color:Gainsboro;");
		 }
		   else if (fscroe>70 
				 && fscroe< 79.999999) {
			   finalGrade.setText("C");
			   text.setVisible(false);
			   finalGrade.setStyle("-fx-background-color:Gainsboro;");
		 }

		   else if (fscroe>60 
				 && fscroe< 69.999999) {
			   finalGrade.setText("D");
			   text.setVisible(false);
			   finalGrade.setStyle("-fx-background-color:Gainsboro;");
		 }
		   else {
			   finalGrade.setText("F");
			   text.setVisible(false);
			   finalGrade.setStyle("-fx-background-color:Gainsboro;");
		   }
		 
		 // setting the format for the final score
		 DecimalFormat df = new DecimalFormat("###.###%");
		 
		 finalScore.setText(String.valueOf(df.format(totalLine/maxPossilpleTotal)));
		 
		 
		
	}
	// the start over method 
	private void startOver(Label totalLabel,Label finalScoreLabel,Label finalGradeLabel,Text text) {
		
		// clearing the text fields and setting the totals to not visible
		total.setVisible(false);
		totalLabel.setVisible(false);
		maxTotal.setVisible(false);
		finalScore.setVisible(false);
		finalScoreLabel.setVisible(false);
		finalGrade.setVisible(false);
		finalGradeLabel.setVisible(false);
		text.setVisible(false);
		finalGrade.setStyle("-fx-background-color:Gainsboro;");
		total.clear();
		score1.clear();
		score2.clear();
		score3.clear();
		score4.clear();
		score5.clear();
		score6.clear();
		maxTotal.clear();
		maxScore1.clear();
		maxScore2.clear();
		maxScore3.clear();
		maxScore4.clear();
		maxScore5.clear();
		maxScore6.clear();
		finalScore.clear();
		finalGrade.clear();
		
		
	}
	// main method with launch
	public static void main(String[] args) {
		launch(args);

	}
	

}





