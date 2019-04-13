package UI;

import Domain.Movie;
import Service.MovieService;
import Service.CardService;
import Service.ReservationService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class MainController {
    public TableView tblMovies;
    public TableColumn colMovieId;
    public TableColumn colMovieTitle;
    public TableColumn colMovieYear;
    public TableColumn colMoviePrice;
    public TableColumn colMovieInProgram;
    public TextField txtMovieId;
    public CheckBox chkMovieInProgram;
    public TextField txtMovieTitle;
    public TextField txtMovieYear;
    public TextField txtMoviePrice;
    public Button btnAddMovie;

    private MovieService movieService;
    private CardService cardService;
    private ReservationService reservationService;

    private ObservableList<Movie> movies = FXCollections.observableArrayList();

    public void setServices(MovieService movieService, CardService cardService, ReservationService reservationService) {
        this.movieService = movieService;
        this.cardService = cardService;
        this.reservationService = reservationService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            movies.addAll(movieService.getAll());
            tblMovies.setItems(movies);
        });
    }

    public void btnAddMovieClick(ActionEvent actionEvent) {
        try {
            String id = txtMovieId.getText();
            String title = txtMovieTitle.getText();
            String year = txtMovieYear.getText();
            double price = Double.parseDouble(txtMoviePrice.getText());
            boolean inProgram = chkMovieInProgram.isSelected();

            movieService.addOrUpdate(id,title,year,price,inProgram);

            movies.clear();
            movies.addAll(movieService.getAll());
        } catch ( RuntimeException rex ){
            Common.showValidationError(rex.getMessage());
        }
    }
}