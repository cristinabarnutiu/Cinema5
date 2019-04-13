import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MovieService;
import Service.CardService;
import Service.ReservationService;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Movie> movieValidator = new MovieValidator();
        IValidator<Card> cardValidator = new CardValidator();
        IValidator<Reservation> reservationValidator = new ReservationValidator();

        IRepository<Movie> movieRepository = new InMemoryRepository<>(movieValidator);
        IRepository<Card> cardRepository = new InMemoryRepository<>(cardValidator);
        IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        movieService.addOrUpdate("1", "Titanic 1", "1997", 10, true);
        movieService.addOrUpdate("2", "Superman", "2000", 20, false);
        movieService.addOrUpdate("3", "Terminator", "1987", 30, true);

        CardService cardService = new CardService(cardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, movieRepository);

        MainController mainController =  fxmlLoader.getController();
        mainController.setServices(movieService, cardService, reservationService);

        primaryStage.setTitle("Movie manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}



