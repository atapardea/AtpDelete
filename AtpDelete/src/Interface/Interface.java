package Interface;

import java.io.File;

import BackEnd.DeleteLogic;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Interface extends Application {

	public static boolean isDeleteRunning=false;
	private File selectedDirectory;
	private DirectoryChooser dirChoose;

	public static void main (String args[]){
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {





		BorderPane pane = new BorderPane();
		GridPane grid = new GridPane();

		pane.setCenter(grid);

		// Label
		Label label = new Label();
		label.setText("Choose folder from the Choose button or enter it's path");
		GridPane.setConstraints(label, 0, 0);

		// Textfield
		TextField textfield = new TextField();
		textfield.setDisable(true);
		GridPane.setConstraints(textfield, 0, 1);

		// Choose button
		Button choose = new Button();
		choose.setText("Choose");
		GridPane.setConstraints(choose, 1, 1);



		// Start button
		Button action = new Button();
		action.setText("Start");
		//GridPane.setConstraints(action, 0, 3);

		// Cancel button
		Button cancel = new Button();
		cancel.setText("Stop");
		cancel.setDisable(true);
		//GridPane.setConstraints(cancel,1,3);

		// HBOX
		HBox hbox = new HBox();
		GridPane.setConstraints(hbox, 0, 3);
		hbox.getChildren().addAll(action,cancel);


		//FileChooser directoryChoose = new FileChooser();
		//DirectoryChooser dch = new DirectoryChooser();
		grid.getChildren().addAll(label, textfield, choose, hbox);


		Scene scene=new Scene (pane, 600, 500);
		stage.setScene(scene);
		stage.setTitle("AtpDelete");
		stage.setAlwaysOnTop(false);
		stage.setResizable(true);
		stage.show();


		/// Choose button behaviour
		choose.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dirChoose = new DirectoryChooser();
				selectedDirectory = dirChoose.showDialog(stage);
				textfield.setText(selectedDirectory.toString());

			}
		});

		/// Start button behaviour
		action.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (textfield.getText() != null && (selectedDirectory!= null)) {
						isDeleteRunning=true;
						action.setDisable(true);
						System.out.println( action.isDisabled());
						cancel.setDisable(false);
						System.out.println( cancel.isDisabled());
						choose.setDisable(true);
						System.out.println( choose.isDisabled());

						DeleteLogic.deleteFolder(selectedDirectory);

				}

			}
		});

		cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				isDeleteRunning=false;
				action.setDisable(false);
				cancel.setDisable(true);

			}
		});
	}




}
