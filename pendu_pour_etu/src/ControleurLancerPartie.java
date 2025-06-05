import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton rejouer ou Lancer une partie
 */
public class ControleurLancerPartie implements EventHandler<ActionEvent> {
    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    /**
     * vue du jeu
     **/
    private Pendu vuePendu;

    /**
     * @param modelePendu modèle du jeu
     * @param p vue du jeu
     */
    public ControleurLancerPartie(MotMystere modelePendu, Pendu vuePendu) {
        this.modelePendu = modelePendu;
        this.vuePendu = vuePendu;
    }

    /**
     * L'action consiste à recommencer une partie. Il faut vérifier qu'il n'y a pas une partie en cours
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) (actionEvent.getSource());
        Optional<ButtonType> reponse = this.vuePendu.popUpPartieEnCours().showAndWait(); // on lance la fenêtre popup et on attends la réponse
        if (button.getText().contains("Lancer une partie"))
            // si la réponse est oui
            if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)){
                System.out.println("Ok !");
                this.vuePendu.lancePartie();
            }
            else{
                System.out.println("D'ac !");
            }  
    }
}







/*        Button button = (Button) (actionEvent.getSource());
        if (button.getText().contains("Lancer une partie"))
            this.vuePendu.lancePartie();
        else
            this.vuePendu.fenetreAccueil();
        // A implémenter
        Optional<ButtonType> reponse = this.vuePendu.popUpPartieEnCours().showAndWait(); // on lance la fenêtre popup et on attends la réponse
        // si la réponse est oui
        if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)){
            System.out.println("Ok !");
        }
        else{
            System.out.println("D'ac !");
        }
        
*/