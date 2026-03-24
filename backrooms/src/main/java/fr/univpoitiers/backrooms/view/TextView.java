package fr.univpoitiers.backrooms.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Duration;
import mvc.View;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class TextView extends BorderPane implements View {

    private final TextArea textArea;
    private final TextField inputField;

    private Timeline typewriterTimeline;
    private boolean instantTextEnabled = false;
    private final Queue<String> textQueue = new LinkedList<>();
    private String currentTextToType;
    private int charIndex;

    private Consumer<String> onCommandEntered;

    public TextView() {
        // --- UI Components Setup ---
        this.setStyle("-fx-background-color: black;");

        // Style commun pour la police mono
        String monoStyle = "-fx-font-family: 'Monospaced'; -fx-font-size: 14px; -fx-text-fill: white;";

        // Zone de texte (Sortie du jeu)
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        // Style CSS pour simuler le terminal
        textArea.setStyle("-fx-control-inner-background: black; " + monoStyle +
                "-fx-background-color: black; -fx-focus-color: transparent; -fx-display-caret: true;");

        ScrollPane scrollPane = new ScrollPane(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: black; -fx-border-color: black;");
        this.setCenter(scrollPane);

        // Zone de saisie (Bas de fenêtre)
        HBox inputPanel = new HBox();
        inputPanel.setPadding(new Insets(5, 10, 5, 10));
        inputPanel.setStyle("-fx-border-color: #333333; -fx-border-width: 1 0 0 0;");

        Label promptLabel = new Label("> ");
        promptLabel.setStyle(monoStyle);

        inputField = new TextField();
        inputField.setStyle("-fx-background-color: black; -fx-text-fill: white;" + monoStyle + "-fx-prompt-text-fill: #555;");
        inputField.setBorder(null);
        HBox.setHgrow(inputField, Priority.ALWAYS);

        inputPanel.getChildren().addAll(promptLabel, inputField);
        this.setBottom(inputPanel);

        // --- Logic & Events ---
        setupEvents();
        setupTypewriter();

        inputField.requestFocus();
    }
    public void disableInput() {
        this.inputField.setDisable(true);
        this.inputField.setEditable(false); // Optionnel : pour bien montrer que c'est bloqué
    }
    public void setOnCommandEntered(Consumer<String> onCommandEntered) {
        this.onCommandEntered = onCommandEntered;
    }

    private void setupEvents() {
        // Action lors de l'appui sur Entrée
        inputField.setOnAction(e -> {
            String command = inputField.getText();
            if (!command.trim().isEmpty()) {
                appendText("> " + command + "\n");
                inputField.clear();

                if (onCommandEntered != null) {
                    onCommandEntered.accept(command);
                }

            }
        });

        // Toggle Instant Text avec 'M'
        inputField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.M) {
                instantTextEnabled = !instantTextEnabled;

                if (instantTextEnabled && typewriterTimeline.getStatus() == Timeline.Status.RUNNING) {
                    typewriterTimeline.stop();
                    // Finir le texte en cours
                    if (currentTextToType != null && charIndex < currentTextToType.length()) {
                        textArea.appendText(currentTextToType.substring(charIndex));
                    }
                    // Vider la file
                    while (!textQueue.isEmpty()) {
                        textArea.appendText(textQueue.poll());
                    }
                    inputField.setEditable(true);
                }
            }
        });
    }

    private void setupTypewriter() {
        typewriterTimeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            if (currentTextToType == null || charIndex >= currentTextToType.length()) {
                currentTextToType = textQueue.poll();
                charIndex = 0;

                if (currentTextToType == null) {
                    typewriterTimeline.stop();
                    inputField.setEditable(true);
                    return;
                }
            }

            textArea.appendText(String.valueOf(currentTextToType.charAt(charIndex)));
            charIndex++;
            textArea.selectEnd(); // Scroll automatique
            textArea.deselect();
        }));
        typewriterTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void appendText(final String text) {
        if (text == null || text.isEmpty()) return;

        if (instantTextEnabled) {
            textArea.appendText(text);
        } else {
            textQueue.add(text);
            if (typewriterTimeline.getStatus() != Timeline.Status.RUNNING) {
                inputField.setEditable(false);
                typewriterTimeline.play();
            }
        }
    }
}