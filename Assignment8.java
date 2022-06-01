import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Assignment8 extends Application{

	Scene scene; 
	Button button;
	Label label;
	
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		launch(args); 
	}
	public void start(Stage stage) {

		//following two lines create the window's title and a header at the top of the app
		stage.setTitle("Assignment 8");
		Label header = new Label("Enter data for each row (0 if not applicable)");
		
		//the next 8 blocks of code set a TextField for each needed input
		Label label1 = new Label("# of Days on Trip:");
		TextField textField1 = new TextField ();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(textField1, label1);
		hb1.setSpacing(10);
		
		Label label2 = new Label("Cost of airfare");
		TextField textField2 = new TextField ();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(textField2, label2);
		hb2.setSpacing(10);
		
		Label label3 = new Label("Cost of rental fees");
		TextField textField3 = new TextField ();
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(textField3, label3);
		hb3.setSpacing(10);
		
		Label label4 = new Label("# of miles driven");
		TextField textField4 = new TextField ();
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(textField4, label4);
		hb4.setSpacing(10);
		
		Label label5 = new Label("Cost of Parking Fees");
		TextField textField5 = new TextField ();
		HBox hb5 = new HBox();
		hb5.getChildren().addAll(textField5, label5);
		hb5.setSpacing(10);
		
		Label label6 = new Label("Cost of Taxi Charges");
		TextField textField6 = new TextField ();
		HBox hb6 = new HBox();
		hb6.getChildren().addAll(textField6, label6);
		hb6.setSpacing(10);
		
		Label label7 = new Label("Cost of Registration Fees");
		TextField textField7 = new TextField ();
		HBox hb7 = new HBox();
		hb7.getChildren().addAll(textField7, label7);
		hb7.setSpacing(10);
		
		Label label8 = new Label("Lodging Fees");
		TextField textField8 = new TextField ();
		HBox hb8 = new HBox();
		hb8.getChildren().addAll(textField8, label8);
		hb8.setSpacing(10);
		
		Button button = new Button(); //these two lines create the button to calculate
		button.setText("Enter");
		
		Label l1 = new Label();
		Label l2 = new Label();
		Label l3 = new Label();
		
		VBox layout = new VBox (10); //finalizes the layout
		layout.setPadding(new Insets (20, 20, 20, 20));
		layout.getChildren().addAll(header,hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8,button,l1,l2,l3);
		
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { //this is the code that runs after pressing the button
            public void handle(ActionEvent e)
            {
            	final double meals_day = 47; //the next 5 lines are final variables to put into calculations
            	final double park_day = 20;
            	final double taxi_day = 40;
            	final double lodge_day = 195;
            	final double drive_day = 0.42;
            	double days_on_trip = Double.parseDouble(textField1.getText()); //this line and 7 following it retrieve inputs
            	double air_fare = Double.parseDouble(textField2.getText());
            	double car_rentals = Double.parseDouble(textField3.getText());
            	double miles_driven = Double.parseDouble(textField4.getText());
            	double parking_fees = Double.parseDouble(textField5.getText());
            	double taxi_fees = Double.parseDouble(textField6.getText());
            	double registration_fees = Double.parseDouble(textField7.getText());
            	double lodging_fees = Double.parseDouble(textField8.getText());
            	
            	double per_day_expense = (lodging_fees*days_on_trip); //does the per-day calculation for their expenses
            	double total_expenses = (air_fare+car_rentals+parking_fees+taxi_fees+registration_fees+per_day_expense); //total expenses calculated
            	String total = Double.toString(total_expenses);
            	
                l1.setText("$"+total + " Total Expenses"); //sets label 1 to total expenses
                
                //the following 3 lines add up the allowed expenses per day and displays it to the second label
                double allowed_expense = ((meals_day*days_on_trip)+(park_day*days_on_trip)+(taxi_day*days_on_trip)+(lodge_day*days_on_trip)+(drive_day*miles_driven));
            	String allowed = Double.toString(allowed_expense);

                l2.setText("$"+allowed + " Allowed Expenses");
                
                //this if statement displays the third label based on if the person went over their allowed limit
                if (allowed_expense < total_expenses) {
                	double difference_amount = (total_expenses-allowed_expense);
                	String difference = Double.toString(difference_amount);
                    l3.setText("$"+difference + " Excess to be paid");
                } else {
                	double difference_amount = (allowed_expense-total_expenses);
                	String difference = Double.toString(difference_amount);
                    l3.setText("$"+difference + " Dollars saved");
                }
            }
        };
  
        button.setOnAction(event);//this allows the button to trigger the calculation event
  
		scene = new Scene(layout, 400, 550);  //following code sets scene and shows it to the user
		stage.setScene(scene);
		stage.show();
		
		
		
	}

}
