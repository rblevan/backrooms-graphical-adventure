package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.MenuModel;
import fr.univpoitiers.backrooms.view.MenuView;
import javafx.scene.Node;
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
        super(new MenuModel(), new MenuView());
    }

    /// Initialise le contenu (création et liaison des sous-contrôleurs)
    private void init() {
        // On récupère la vue du menu qu'on a créée dans super()
        MenuView mainMenuView = (MenuView) super.getView();
        MenuModel model = (MenuModel) this.getModel();

        model.setVideoPath("/video/menu_backrooms.mp4");

        // --- 1. CRÉATION DES SOUS-CONTRÔLEURS ---

        // On utilise la classe du prof pour le bouton Quitter
        QuitController quitController = QuitController.create();

        mainMenuView.setupVideoBackground(model.getVideoPath());

        // --- 2. AJOUT À LA LISTE DES SOUS-CONTRÔLEURS ---
        this.subControllers.add(quitController);


        // --- 3. AJOUT DES VUES DANS LA VUE PRINCIPALE ---

        // On met le bouton quitter pour qu'il apparaisse en bas
        mainMenuView.addComponentBottom((Node) quitController.getView());
    }
}
