import java.util.HashSet;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

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
        char lettre = lettreATrouver.charAt(0);

        System.out.println(mot);

        this.modelePendu.essaiLettre(lettre);
        this.vuePendu.majAffichage();
        this.ensemble.add(lettreATrouver);
        this.vuePendu.getClavier().desactiveTouches(ensemble);
        System.out.println("Il reste "+this.modelePendu.getNbErreursRestants()+" erreurs");
        System.out.println("Il manque "+this.modelePendu.getNbLettresRestantes()+" lettres");

        if (this.modelePendu.perdu()){
            Optional<ButtonType> reponseL = this.vuePendu.popUpMessagePerdu().showAndWait();
                if (reponseL.isPresent() && reponseL.get().equals(ButtonType.CLOSE)){
                    this.vuePendu.modeAccueil();
                }
                else{
                    this.vuePendu.lancePartie();
                }
        }

        if (this.modelePendu.gagne()){
            Optional<ButtonType> reponseW = this.vuePendu.popUpMessageGagne().showAndWait();
                if (reponseW.isPresent() && reponseW.get().equals(ButtonType.CLOSE)){
                    this.vuePendu.modeAccueil();
                }
                else{
                    this.vuePendu.lancePartie();
                }
        }    
    }
}
