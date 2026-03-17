package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.MenuModel;
import fr.univpoitiers.backrooms.model.TextModel;
import fr.univpoitiers.backrooms.view.MenuView;
import fr.univpoitiers.backrooms.view.MyImageView;
import fr.univpoitiers.backrooms.view.TextView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.Model;

import java.util.Objects;

public class MenuController extends Controller {
    /// Initialise complètement l'instance
    public static MenuController create() {
        MenuController controller = new MenuController();
        controller.init();
        return controller;
    }

    /// Constructeur privé
    private MenuController() {
        super(new MenuModel(), new MenuView());
    }

    /// Initialise le contenu (création et liaison des sous-contrôleurs)
    private void init() {
        // On récupère la vue du menu qu'on a créée dans super()
        MenuView menuView = (MenuView) super.getView();
        MenuModel menuModel = (MenuModel) this.getModel();

        menuModel.setVideoPath("/video/menu_backrooms.mp4");
        menuModel.setTitlePath("/images/title_backrooms.png");

        MyImageView myImageView = new MyImageView(menuModel.getTitlePath());

        ImageView titleView = myImageView.getImageView();

        // --- 1. CRÉATION DES SOUS-CONTRÔLEURS ---

        // On utilise la classe du prof pour le bouton Quitter
        QuitController quitController = QuitController.create();
        ButtonController buttonTextGame = ButtonController.create("Game Text");
        ButtonController buttonWorldGame =  ButtonController.create("World Game");

        Button btnText = (Button) buttonTextGame.getView();
        Button btnWorld = (Button) buttonWorldGame.getView();

        menuView.setupVideoBackground(menuModel.getVideoPath());

        btnText.setOnAction(event -> {
            switchToGameText();
        });

        // --- 2. AJOUT À LA LISTE DES SOUS-CONTRÔLEURS ---
        this.subControllers.add(quitController);
        this.subControllers.add(buttonTextGame);
        this.subControllers.add(buttonWorldGame);


        // --- 3. AJOUT DES VUES DANS LA VUE PRINCIPALE ---

        // On met le bouton quitter pour qu'il apparaisse en bas
        menuView.addComponentHBox((Node) buttonWorldGame.getView());
        menuView.addComponentHBox((Node) buttonTextGame.getView());
        menuView.addComponentCenter(titleView);
        menuView.addComponentCenter(menuView.getButtonContainerCenter());
        menuView.addComponentBottom((Node) quitController.getView());
    }

    public void switchToGameText(){
        Node currentView = (Node) this.getView();

        Stage stage =  (Stage) currentView.getScene().getWindow();

        TextController textController = TextController.create();
        this.subControllers.add(textController);
        textController.startTextMode();
        stage.getScene().setRoot((Parent) textController.getView());
    }

    public void switchToGameWorld(){
        Node currentView = (Node) this.getView();

        Stage stage = (Stage) currentView.getScene().getWindow();

        WorldController worldController =
     }
}
