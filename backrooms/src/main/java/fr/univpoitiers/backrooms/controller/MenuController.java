package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.MenuModel;
import fr.univpoitiers.backrooms.view.MenuWindow;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import mvc.Controller;

public class MenuController extends Controller {
    /// Initialise complètement l'instance
    public static MenuController create() {
        MenuController controller = new MenuController();
        controller.init();
        return controller;
    }

    /// Constructeur privé
    private MenuController() {
        super(new MenuModel(), new MenuWindow());
    }

    /// Initialise le contenu (création et liaison des sous-contrôleurs)
    private void init() {
        // On récupère la vue du menu qu'on a créée dans super()
        MenuWindow mainMenuView = (MenuWindow) super.getView();

        // --- 1. CRÉATION DES SOUS-CONTRÔLEURS ---

        // On utilise la classe du prof pour le bouton Quitter
        QuitController quitController = QuitController.create();

        // Bientôt, vous ferez la même chose pour vos jeux :
        // GraphicGameController graphicGameCtrl = GraphicGameController.create();
        // TextualGameController textGameCtrl = TextualGameController.create();


        // --- 2. AJOUT À LA LISTE DES SOUS-CONTRÔLEURS ---

        // On les stocke dans la liste "subControllers" héritée de mvc.Controller
        // this.subControllers.add(graphicGameCtrl);
        // this.subControllers.add(textGameCtrl);
        this.subControllers.add(quitController);


        // --- 3. AJOUT DES VUES DANS LA VUE PRINCIPALE ---

        // On récupère les vues de chaque sous-contrôleur et on les injecte
        // dans la VBox qui flotte au-dessus de votre vidéo.
        // (On doit "caster" en Node car addComponent attend un élément JavaFX)

        // mainMenuView.addComponent((Node) graphicGameCtrl.getView());
        // mainMenuView.addComponent((Node) textGameCtrl.getView());

        // On met le bouton quitter en dernier pour qu'il apparaisse en bas
        mainMenuView.addComponent((Node) quitController.getView());
    }
}
/*    public void setVideoBackground(StackPane root, String videoPath) {
        var resource = getClass().getResource(videoPath);

        if (resource == null) {
            System.err.println("Erreur : Le fichier vidéo est introuvable dans resources !");
            return;
        }
        // 1. Charger la vidéo
        String path = resource.toExternalForm();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // 2. Paramétrer la vidéo
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);// Boucle infini
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

        // 3. Ajuster la taille (pour que ça remplisse la fenêtre)
        mediaView.fitWidthProperty().bind(root.widthProperty());
        mediaView.fitHeightProperty().bind(root.heightProperty());
        mediaView.setPreserveRatio(false); // Force le remplissage

        // 4. L'ajouter au début du StackPane (en dessous de tout le reste)
        root.getChildren().add(0,mediaView);
    }
}
*/