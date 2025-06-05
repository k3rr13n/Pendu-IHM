import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class Pendu extends Application {
    /**
     * modèle du jeu
     **/
    private MotMystere modelePendu;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */    
    public List<String> niveaux;

    // les différents contrôles qui seront mis à jour ou consultés pour l'affichage
    /**
     * le dessin du pendu
     */
    private ImageView dessin;
    /**
     * le mot à trouver avec les lettres déjà trouvé
     */
    private Text motCrypte;
    /**
     * la barre de progression qui indique le nombre de tentatives
     */
    private ProgressBar pg;
    /**
     * le clavier qui sera géré par une classe à implémenter
     */
    private Clavier clavier;
    /**
     * le text qui indique le niveau de difficulté
     */
    private Text leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;
    /**
     * le bouton qui permet de (lancer ou relancer une partie)
     */ 
    private Button bJouer;
    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        this.modelePendu = new MotMystere("/usr/share/dict/french", 3, 10, MotMystere.FACILE, 10);
        //this.modelePendu = new MotMystere("CAMEMBERT", 3, 10);  
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("./img");
        this.panelCentral = new BorderPane();
        this.panelCentral.setCenter(this.fenetreAccueil());
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private BorderPane titre(){
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        Label jeuxLabel = new Label("Jeu du Pendu");
        jeuxLabel.setPadding(new Insets(30, 80, 30, 10));
        jeuxLabel.setStyle("-fx-font-size : 30px;");

        this.chargerImages("./pendu_pour_etu/img");

        ImageView home = new ImageView(new Image("file:./pendu_pour_etu/img/home.png"));
        home.setFitHeight(50);
        home.setFitWidth(50);
        this.boutonMaison = new Button();
        this.boutonMaison.setGraphic(home);
        ImageView info = new ImageView(new Image("file:./pendu_pour_etu/img/info.png"));
        info.setFitHeight(50);
        info.setFitWidth(50);
        Button boutonInfo = new Button();
        boutonInfo.setGraphic(info);
        ImageView parametres = new ImageView(new Image("file:./pendu_pour_etu/img/parametres.png"));
        parametres.setFitHeight(50);
        parametres.setFitWidth(50);
        this.boutonParametres = new Button();
        this.boutonParametres.setGraphic(parametres);
        hBox.getChildren().addAll(boutonMaison, boutonInfo, boutonParametres);
        hBox.setPadding(new Insets(20, 40, 20, 40));

        borderPane.setRight(hBox);
        borderPane.setLeft(jeuxLabel);
        borderPane.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));

        return borderPane;
    }

     /**
      * @return le panel du chronomètre
      */
     private TitledPane leChrono(){
        // A implementer
        TitledPane res = new TitledPane();
        return res;
     }

     /**
      * @return la fenêtre de jeu avec le mot crypté, l'image, la barre
      *         de progression et le clavier
      */
     private BorderPane fenetreJeu(){
        ControleurLettres controleurMot = new ControleurLettres(this.modelePendu, this);
        this.clavier = new Clavier("ABCDEFGHIJKLMNOPQRSTUVWXYZ-", controleurMot, 5); 

        BorderPane pane = new BorderPane();
        this.motCrypte = new Text(this.modelePendu.getMotCrypte());
        Label difficulte = new Label("????");
        this.dessin = new ImageView(new Image("file:./pendu_pour_etu/img/pendu0.png"));
        this.pg = new ProgressBar();
        VBox vBoxCentre = new VBox();
        VBox vBoxDroite = new VBox();

        vBoxCentre.getChildren().addAll(motCrypte, this.dessin, this.pg, this.clavier);
        vBoxDroite.getChildren().addAll(difficulte);

        pane.setCenter(vBoxCentre);
        pane.setRight(vBoxDroite);

        System.out.println(this.motCrypte);
        System.out.println(this.modelePendu);
        System.out.println(this.modelePendu.getMotATrouve());
        return pane;
     }

     /**
      * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
      */
     private BorderPane fenetreAccueil(){
        BorderPane accueil = new BorderPane();
        this.bJouer= new Button("Lancer une partie");
        VBox vBox = new VBox();
        VBox niveauDiff = new VBox();
        ToggleGroup group2 = new ToggleGroup();

        RadioButton facile = new RadioButton("Facile");
        facile.setToggleGroup(group2);
        RadioButton medium = new RadioButton("Medium");
        medium.setToggleGroup(group2);
        RadioButton difficile = new RadioButton("Difficile");
        difficile.setToggleGroup(group2);
        RadioButton expert = new RadioButton("Expert");
        expert.setToggleGroup(group2);
        niveauDiff.getChildren().addAll(facile, medium, difficile, expert);
        TitledPane difficultee = new TitledPane("Difficultée", niveauDiff);

        ControleurLancerPartie controleur = new ControleurLancerPartie(modelePendu, this);
        this.bJouer.setOnAction(controleur);
        difficultee.setPadding(new Insets(20, 40, 20, 0));
        vBox.getChildren().addAll(this.bJouer, difficultee);
        vBox.setPadding(new Insets(20, 40, 20, 40));
        accueil.setCenter(vBox); //vbox
        return accueil;
     }

    /**
     * charge les images à afficher en fonction des erreurs
     * @param repertoire répertoire où se trouvent les images
     */
    private void chargerImages(String repertoire){
        for (int i=0; i<this.modelePendu.getNbErreursMax()+1; i++){
            File file = new File(repertoire+"/pendu"+i+".png");
            System.out.println(file.toURI().toString());
            this.lesImages.add(new Image(file.toURI().toString()));
        }
    }

    public void modeAccueil(){
        this.panelCentral.setCenter(fenetreAccueil());
        this.modelePendu.setMotATrouver();
    }
    
    public void modeJeu(){
        this.panelCentral.setCenter(this.fenetreJeu());
    }
    
    public void modeParametres(){
        // A implémenter
    }

    /** lance une partie */
    public void lancePartie(){
        modeJeu();
        this.modelePendu.setMotATrouver();
        System.out.println(this.modelePendu.getMotATrouve());
        this.majAffichage();
        //majAffichage();
    }

    /**
     * 
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage(){
        this.motCrypte.setText(this.modelePendu.getMotCrypte());
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono(){
        // A implémenter
        return null; // A enlever
    }

    public Alert popUpPartieEnCours(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
        
    public Alert popUpReglesDuJeu(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }
    
    public Alert popUpMessageGagne(){
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez gagné!\nFélicitation...", ButtonType.CLOSE, ButtonType.NEXT);
        alert.setTitle("GG");       
        return alert;
    }
    
    public Alert popUpMessagePerdu(){
        // A implementer    
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez perdu!\nDommage...", ButtonType.CLOSE, ButtonType.NEXT);
        alert.setTitle("Perdu");
        return alert;
    }

    public Clavier getClavier(){
        return this.clavier;
    }

    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        stage.setScene(this.laScene());
        this.modeAccueil();
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
