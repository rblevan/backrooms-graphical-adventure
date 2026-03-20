package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.WorldModel;
import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.Position;
import fr.univpoitiers.backrooms.model.world.WorldBuilder;
import fr.univpoitiers.backrooms.view.WorldView;
import javafx.scene.image.Image;
import mvc.Controller;

import java.util.Objects;

public class WorldController extends Controller {

    public static WorldController create(){
        WorldController worldController = new WorldController();
        return worldController;
    }

    public WorldController() {
        super(new WorldModel(), new WorldView());
    }

    public void startWorldGame() {
        WorldModel model = (WorldModel) getModel();
        WorldView view = (WorldView) getView();

        createHero(model);

        Hero player = model.getPlayer();

        model.setMapPath("/images/levels/level1.png");

        // 2. Initialisation de la vue
        view.updateDisplay(model.getMapPath(),player);
    }

    private void createHero(WorldModel model) {
        // 1. Demander le nom au joueur (Logique d'entrée)
        String playerName = Hero.askPlayerName();

        // 2. Configuration du sac à dos (Modèle)
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);

        // 3. Description et Statistiques
        String playerDesc = "An ordinary person lost in the depths of the Backrooms...";
        int initialHealth = 100;
        int initialStamina = 20;

        // 4. Chargement de l'image (Ressource pour la Vue)
        // Note : On charge l'image ici pour l'associer au modèle Hero
        String pathImage = Objects.requireNonNull(getClass().getResource("/images/downHero.png")).toExternalForm();
        Image imageHero = new Image(pathImage);

        // 5. Position de départ (Modèle)
        // On place le joueur à (100, 100) par défaut sur la grille/pixels
        Position startPosition = new Position(100, 100);

        // 6. Localisation initiale (Monde)
        // On récupère le niveau par défaut via le WorldBuilder (déjà initialisé dans init())
        WorldBuilder worldBuilder = new WorldBuilder();
        // Ici, adapte selon ton worldBuilder pour récupérer la "Location" de départ
        Locations startLocation = worldBuilder.getLocation("/images/levels/level1.png");

        // 7. Instanciation finale
        model.setPlayer(new Hero(
                playerName,
                initialHealth,
                playerName, // Identifiant ou pseudo
                initialStamina,
                playerDesc,
                backpack,
                startLocation,
                imageHero,
                startPosition
        ));
    }
}
   /* public static WorldController create(){
        WorldController worldController = new WorldController();
        worldController.init();
        return worldController;
    }

    public WorldController() {
        super(new WorldModel(), new WorldView());
    }

    public void init() {
        // 1. Initialisation du monde
        WorldBuilder worldBuilder = new WorldBuilder();

        //a revoir
        String startLevelPath = worldBuilder.getLocations().keySet().stream()
                .filter(path -> path.contains("/images/levels/level1.png"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No start map found"));
        Locations startLocation = worldBuilder.getLocation(startLevelPath);

        // 2. Création du joueur via Dialog
        String playerName = askPlayerName();
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);
        String playerDesc = "an ordinary person who has lived a quiet, unremarkable life...";

        //l'image du hero
        String pathImage = Objects.requireNonNull(getClass().getResource("/images/downHero.png")).toExternalForm();
        Image imageHero = new Image(pathImage);
        this.player = new Hero(playerName, 100, playerName, 20, playerDesc, backpack, startLocation, imageHero, new Position(100,100));
    }

    public void startWorldMode() {
        prepareWorld();
        new BackroomsAnimation(primaryStage, () -> {
            // Ce code s'exécute UNIQUEMENT quand l'animation est terminée
            Commands commandProcessor = new Commands(player, player.getLocation());
            WorldView worldWindow = new WorldView(primaryStage, this, commandProcessor);
        });
    }

    private String askPlayerName() {
        TextInputDialog dialog = new TextInputDialog("Anonymous");
        dialog.setTitle("Backrooms - Character Creation");
        dialog.setHeaderText("Welcome to the Backrooms");
        dialog.setContentText("Enter your name:");

        Optional<String> result = dialog.showAndWait();

        if(result.orElse("Anonymous").trim().isEmpty()){
            return "Anonymous";
        }
        return result.get();
    }

    public Hero getPlayer() {
        return this.player;
    }
}*/
