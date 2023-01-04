/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package movieLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author rdash
 */
public class MovieLibraryController implements Initializable {

    // FXML Variables
    @FXML
    private ChoiceBox<String> genreChoiceBox;
    @FXML
    private ChoiceBox<String> ratingChoiceBox;
    @FXML
    private Button updateMoviesButton;
    @FXML
    private TableView<Movie> movieTableView; // = new TableView<>();
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn genreColumn;
    @FXML
    private TableColumn ratingColumn;
    @FXML
    private TableColumn avgRatingColumn;
    @FXML
    private TextField titleTextField;
    @FXML
    private ChoiceBox<String> newGenreChoiceBox;
    @FXML
    private Slider ratingSlider;
    @FXML
    private Label newRatingLabel;
    @FXML
    private Button newMovieButton;
    @FXML
    private Slider plotSlider;
    @FXML
    private Slider visualsSlider;
    @FXML
    private Slider themeSlider;
    @FXML
    private Slider soundSlider;
    @FXML
    private Slider actingSlider;
    @FXML
    private Slider cinematographySlider;
    @FXML
    private Pane polygonPane;
    @FXML
    private TextField plotDisplay;
    @FXML
    private TextField visualsDisplay;
    @FXML
    private TextField themeDisplay;
    @FXML
    private TextField soundDisplay;
    @FXML
    private TextField actingDisplay;
    @FXML
    private TextField cinemaDisplay;
    
    // Class Variables
    ArrayList<Movie> allMovies = new ArrayList<>();
    public static int movieCount = 0;
    private final String fileName = "saveFile.ser";
    
    Polygon ratingPolygon = new Polygon();
    Polygon ratingHex150 = new Polygon();
    Polygon ratingHex1125 = new Polygon();
    Polygon ratingHex75 = new Polygon();
    Polygon ratingHex325 = new Polygon();

    
    // Adjusting FXML Variable
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        avgRatingColumn.setCellValueFactory(new PropertyValueFactory<>("averageRating"));
        
        createRatingPolygon();
        createAllRatingHexagons();
        
        fileOpen();
        if (allMovies != null) {
            movieCount = allMovies.size();
        }
        setChoiceBoxValues();
        updateButtonsAndSliders();
        updateMovieList("All", "All");
    }
    
    // Alters UI
    public void setChoiceBoxValues() {
        // Sets Drop Down Menu Values For Update Movies
        genreChoiceBox.setItems(FXCollections.observableArrayList(
            "All", "Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery", "Romance", "Thriller",
                    "Documentary", "Animated", "Adventure", "Sci-Fi")
        );
        genreChoiceBox.setValue("All");
        ratingChoiceBox.setItems(FXCollections.observableArrayList(
            "All", "90-100", "80-90", "70-80", "60-70", "50-60", "40-50",
                    "30-40", "20-30", "10-20", "0-10")
        );
        ratingChoiceBox.setValue("All");
        // Sets Drop Down Menu Values For New Movie
        newGenreChoiceBox.setItems(FXCollections.observableArrayList(
            "Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery", "Romance", "Thriller",
                    "Documentary", "Animated", "Adventure", "Sci-Fi")
        );
        newGenreChoiceBox.setValue("Select a Genre");
        
    }
    
    // Alters UI
    public void updateButtonsAndSliders() {
        // When Update Movies Button is Pressed
        updateMoviesButton.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
//                testText.setText("Updated");
                updateMovieList(genreChoiceBox.getValue(), ratingChoiceBox.getValue());
            }
        });
        // When New Movie Button is Pressed
        newMovieButton.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                getNewMovie(titleTextField.getText(), newGenreChoiceBox.getValue(), (int)ratingSlider.getValue(), (int)plotSlider.getValue(), (int)themeSlider.getValue(), (int)visualsSlider.getValue(), (int)actingSlider.getValue(), (int)soundSlider.getValue(), (int)cinematographySlider.getValue());
            }
        });
        // When New Movie Rating Slider is Moved
        ratingSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                Integer sliderVal = (int)ratingSlider.getValue();
                newRatingLabel.setText(sliderVal.toString());
                // Update Slider Track Gradient
                String style = String.format("-fx-background-color: linear-gradient(to right, #34cdf7 %d%%, lightgrey %d%%);",
                        sliderVal, sliderVal);
                ratingSlider.lookup(".track").setStyle(style);
                
            }
        });
        ratingSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                Integer sliderVal = (int)ratingSlider.getValue();
                newRatingLabel.setText(sliderVal.toString());
                // Update Slider Track Gradient
                String style = String.format("-fx-background-color: linear-gradient(to right, #34cdf7 %d%%, lightgrey %d%%);",
                        sliderVal, sliderVal);
                ratingSlider.lookup(".track").setStyle(style);
            }
        });
        
        // Delete Movie from MovieTable on Double Click
        movieTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    deleteMovieOnDoubleClick(movieTableView.getSelectionModel().getSelectedItem().getTitle());
                }
            }
        });
        
        // Specific Ratings Sliders
        // Plot
        plotSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                // Update Slider Track Gradient
//                String style = String.format("-fx-background-color: linear-gradient(to top, #34cdf7 %d%%, transparent %d%%);",
//                        sliderVal, sliderVal);
//                plotSlider.lookup(".track").setStyle(style);
                updateRatingPolygon();
                plotDisplay.setText(String.valueOf((int)plotSlider.getValue()));
            }
        });
        plotSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                plotDisplay.setText(String.valueOf((int)plotSlider.getValue()));
            }
        });
        // Visuals
        visualsSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                visualsDisplay.setText(String.valueOf((int)visualsSlider.getValue()));
            }
        });
        visualsSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                visualsDisplay.setText(String.valueOf((int)visualsSlider.getValue()));
            }
        });
        // Theme
        themeSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                themeDisplay.setText(String.valueOf((int)themeSlider.getValue()));
            }
        });
        themeSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                themeDisplay.setText(String.valueOf((int)themeSlider.getValue()));
            }
        });
        // Sound
        soundSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                soundDisplay.setText(String.valueOf((int)soundSlider.getValue()));
            }
        });
        soundSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                soundDisplay.setText(String.valueOf((int)soundSlider.getValue()));
            }
        });
        // Cinematography
        cinematographySlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                cinemaDisplay.setText(String.valueOf((int)cinematographySlider.getValue()));
            }
        });
        cinematographySlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                cinemaDisplay.setText(String.valueOf((int)cinematographySlider.getValue()));
            }
        });
        // Acting
        actingSlider.setOnMouseDragged(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                actingDisplay.setText(String.valueOf((int)actingSlider.getValue()));
            }
        });
        actingSlider.setOnMousePressed(new EventHandler () {
            @Override
            public void handle(Event t) {
                updateRatingPolygon();
                actingDisplay.setText(String.valueOf((int)actingSlider.getValue()));
            }
        });
        
        themeDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = themeDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            themeSlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            themeDisplay.setText("50");
                            themeSlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    themeDisplay.setText("50");
                    themeSlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
        plotDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = plotDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            plotSlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            plotDisplay.setText("50");
                            plotSlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    plotDisplay.setText("50");
                    plotSlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
        visualsDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = visualsDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            visualsSlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            visualsDisplay.setText("50");
                            visualsSlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    visualsDisplay.setText("50");
                    visualsSlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
        actingDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = actingDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            actingSlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            actingDisplay.setText("50");
                            actingSlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    actingDisplay.setText("50");
                    actingSlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
        soundDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = soundDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            soundSlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            soundDisplay.setText("50");
                            soundSlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    soundDisplay.setText("50");
                    soundSlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
        cinemaDisplay.setOnAction(new EventHandler () {
            @Override
            public void handle(Event t) {
                String val = cinemaDisplay.getText();
                try 
		{ 
			Integer.parseInt(val); 
                        if (Integer.valueOf(val) >= 0 && Integer.valueOf(val) <= 100) {
                            cinematographySlider.setValue(Integer.valueOf(val));
                            updateRatingPolygon();
                        }
                        else {
                            showAlert("Must enter an integer 0-100");
                            cinemaDisplay.setText("50");
                            cinematographySlider.setValue(50);
                            updateRatingPolygon();
                        }
		}  
		catch (NumberFormatException e)  
		{ 
                    showAlert("Must enter an integer 0-100");
                    cinemaDisplay.setText("50");
                    cinematographySlider.setValue(50);
                    updateRatingPolygon();
		} 
            }    
        });
        
    }
    
    // Alters UI
    public void createRatingPolygon() {
        ratingPolygon.setFill(Color.rgb(0x34, 0xcd, 0xf7, 0.5));
        ratingPolygon.setStroke(Color.rgb(0x34, 0xcd, 0xf7));
        ratingPolygon.setStrokeWidth(2);
        ObservableList<Double> list = ratingPolygon.getPoints();

        double centerX = 200;
        double centerY = 200;
        double radius = 75;
        double degX = radius * (Math.sqrt(3)/2);
        double degY = radius / 2;

        // Ceniematography
        list.add(centerX + degX);
        list.add(centerY + degY);
        // Visuals
        list.add(centerX + degX);
        list.add(centerY - degY);       
        // Plot
        list.add(centerX);
        list.add(centerY - radius);       
        // Theme
        list.add(centerX - degX);
        list.add(centerY - degY);       
        // Acting
        list.add(centerX - degX);
        list.add(centerY + degY);       
        // Sound
        list.add(centerX);
        list.add(centerY + radius);
        
        polygonPane.getChildren().add(ratingPolygon);
    }
    
    // Alters UI
    public void createRatingHexagon(double radius, Polygon hexagon) {  
        hexagon.setFill(Color.TRANSPARENT);
        hexagon.setStroke(Color.rgb(0x34, 0xcd, 0xf7));
        ObservableList<Double> list = hexagon.getPoints();
        double centerX = 200;
        double centerY = 200;
//        double intRadius = 75;
        double intX = radius * (Math.sqrt(3)/2);
        double intY = radius / 2;
        
        list.add(centerX + intX);
        list.add(centerY + intY);
        list.add(centerX + intX);
        list.add(centerY - intY);       
        list.add(centerX);
        list.add(centerY - radius);       
        list.add(centerX - intX);
        list.add(centerY - intY);       
        list.add(centerX - intX);
        list.add(centerY + intY);       
        list.add(centerX);
        list.add(centerY + radius);
        
        polygonPane.getChildren().add(hexagon);
    }
    
    public void createAllRatingHexagons() {
        createRatingHexagon(150, ratingHex150);
        createRatingHexagon(112.5, ratingHex1125);
        createRatingHexagon(75, ratingHex75);
        createRatingHexagon(32.5, ratingHex325);   
    }
    
    // Alters UI
    public void updateRatingPolygon() {
        polygonPane.getChildren().remove(ratingPolygon);
        ObservableList<Double> list = ratingPolygon.getPoints();
        list.clear();

        double centerX = 200;
        double centerY = 200;
        double cinemaRadius = cinematographySlider.getValue() * 1.5;
        double visualsRadius = visualsSlider.getValue() * 1.5;
        double plotRadius = plotSlider.getValue() * 1.5;
        double themeRadius = themeSlider.getValue() * 1.5;
        double actingRadius = actingSlider.getValue() * 1.5;
        double soundRadius = soundSlider.getValue() * 1.5;
        
        // Ceniematography
        list.add(centerX + getXOffset(cinemaRadius));
        list.add(centerY + getYOffset(cinemaRadius));
        // Visuals
        list.add(centerX + getXOffset(visualsRadius));
        list.add(centerY - getYOffset(visualsRadius));        
        // Plot
        list.add(centerX);
        list.add(centerY - plotRadius);       
        // Theme
        list.add(centerX - getXOffset(themeRadius));
        list.add(centerY - getYOffset(themeRadius));        
        // Acting
        list.add(centerX - getXOffset(actingRadius));
        list.add(centerY + getYOffset(actingRadius));        
        // Sound
        list.add(centerX);
        list.add(centerY + soundRadius);
        
        polygonPane.getChildren().add(ratingPolygon);
    }
    
    public Double getXOffset(Double radius) {
        return radius * (Math.sqrt(3)/2);
    }
    public Double getYOffset(Double radius) {
        return radius / 2;
    }
    
    public void getNewMovie(String title, String genre, int rating, int plotRating, int themeRating, int visualsRating, int actingRating, int soundRating, int cinemaRating) {
        Movie movie = new Movie();
        
        if (title.equals("")) {
            showAlert("Must enter a Movie Title");
        }
        else if (genre.equals("Select a Genre")) {
            showAlert("Must enter a Movie Genre");
        }
        else {
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setRating(rating);
            movie.setPlotRating(plotRating);
            movie.setThemeRating(themeRating);
            movie.setVisualsRating(visualsRating);
            movie.setActingRating(actingRating);
            movie.setSoundRating(soundRating);
            movie.setCinemaRating(cinemaRating);
            movie.setAverageRating();
            
            allMovies.add(movie);
            movieCount++;
            
            fileSave();
            
            updateMovieList("All", "All");
            
            // *** Reset Inputs ***
            clearNewMovieInputs();
        }
    }
    
    // Alters UI
    // Updates the movie list
    public void updateMovieList(String selectedGenre, String selectedRating) {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
               
        movieTableView.setEditable(true);

        if (selectedGenre.equals("All") && selectedRating.equals("All")) {
            movies.addAll(allMovies);
            movieTableView.setItems(movies);
        }
        else {
            for (int i = 0; i < movieCount; i++) {
                if (allMovies.get(i).isInRatingRange(selectedRating)) {
                    if (selectedGenre.equals(allMovies.get(i).getGenre()) || selectedGenre.equals("All")) {
                        movies.add(allMovies.get(i));
                    }
                }
            }

            movieTableView.setItems(movies);
        }     
    }
    
    public void deleteMovieOnDoubleClick(String title) {
        for (int i = 0; i < movieCount; i++) {
            if (title.equals(allMovies.get(i).getTitle())) {
                if (confirmContinueOnDeletion(title)) {
                    allMovies.remove(i);
                    movieCount--;
                    updateMovieList(genreChoiceBox.getValue(), ratingChoiceBox.getValue());
                    fileSave();
                }
            }
        }
    }
    
    // Saving Movie Data
    public void fileOpen() {        
        File file = new File(fileName);
        
        FileInputStream fileIn;
        
        try {
            fileIn = new FileInputStream(file.getPath());
            ObjectInputStream in = new ObjectInputStream(fileIn);

            allMovies = (ArrayList) in.readObject();
            
            in.close();
            fileIn.close();            
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOEXception with fileOpen" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }
    
    public void fileSave() {
        if (allMovies == null) {
            return;
        }
        
        FileOutputStream fileOut;
        
        try {
            fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(allMovies);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
    
    // Alters UI
    // Clears Inputs for New Movie Survey
    public void clearNewMovieInputs() {
        titleTextField.setText("");
        newGenreChoiceBox.setValue("");
        ratingSlider.setValue(50);
        ratingSlider.lookup(".track").setStyle("-fx-background-color: linear-gradient(to right, #34cdf7 50%, lightgrey 50%);");
        newRatingLabel.setText("50");
    }
    
    // Alters UI
    // Displays alert with passed string
    public void showAlert(String contentText) {
        Alert mainAlert = new Alert(Alert.AlertType.ERROR);
        mainAlert.setContentText(contentText);
        mainAlert.show();
    }
    
    // Alters UI
    private boolean confirmContinueOnDeletion(String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Movie");
        alert.setHeaderText("Delete " + title);
        alert.setContentText("Are you sure you would like to delete this movie?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        }
        else {
            return false;
        }
    }
}
