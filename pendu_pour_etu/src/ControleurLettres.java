import java.util.HashSet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.util.Set;

/**
 * Controleur du clavier
 */
public class ControleurLettres implements EventHandler<ActionEvent> {

    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    /**
     * vue du jeu
     */
    private Pendu vuePendu;

    private Set<String> ensemble;

    /**
     * @param modelePendu modèle du jeu
     * @param vuePendu vue du jeu
     */
    ControleurLettres(MotMystere modelePendu, Pendu vuePendu){
        this.modelePendu = modelePendu;
        this.vuePendu = vuePendu;
        this.ensemble = new HashSet<>();
    }

    /**
     * Actions à effectuer lors du clic sur une touche du clavier
     * Il faut donc: Essayer la lettre, mettre à jour l'affichage et vérifier si la partie est finie
     * @param actionEvent l'événement
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button button = (Button) (actionEvent.getSource());
        String lettreATrouver = button.getText();
        String mot = this.modelePendu.getMotATrouve();
        Boolean dansLeMot = false;

    System.out.println(mot);

        for (char lettre : mot.toCharArray()){
            if (("" + lettre).equals(lettreATrouver)){
                this.modelePendu.essaiLettre(lettre);
                System.out.println("oui");
                dansLeMot = true;
                this.vuePendu.majAffichage();
            }
        this.ensemble.add(lettreATrouver);
        this.vuePendu.getClavier().desactiveTouches(ensemble);
        // A implémenter
        //verifier si la partie est finie
        }
        if (dansLeMot == false){
            System.out.println("non");
            this.vuePendu.majAffichage();
            for (char lettre : lettreATrouver.toCharArray())
                this.modelePendu.essaiLettre(lettre);
        }
    }
}
