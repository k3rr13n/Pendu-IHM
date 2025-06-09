import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle ;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Génère la vue d'un clavier et associe le contrôleur aux touches
 * le choix ici est d'un faire un héritié d'un TilePane
 */
public class Clavier extends TilePane{
    /**
     * il est conseillé de stocker les touches dans un ArrayList
     */
    private List<Button> clavier;

    /**
     * constructeur du clavier
     * @param touches une chaine de caractères qui contient les lettres à mettre sur les touches
     * @param actionTouches le contrôleur des touches
     * @param tailleLigne nombre de touches par ligne
     */
    public Clavier(String touches, EventHandler<ActionEvent> actionTouches, int tailleLigne) {
        this.clavier = new ArrayList<>();
        for (int i=0; i<touches.length(); i++){
            if (i<touches.length()-1)
                this.clavier.add(new Button(touches.substring(i, i+1)));
            else 
                this.clavier.add(new Button(touches.substring(i)));
        }
        for (Button btns : this.clavier){
            btns.setOnAction(actionTouches);
            this.getChildren().add(btns);
        }
    }
    // Le nombre de touches par lignes n'a pas été implémenté

    /**
     * permet de désactiver certaines touches du clavier (et active les autres)
     * @param touchesDesactivees une chaine de caractères contenant la liste des touches désactivées
     */
    public void desactiveTouches(Set<String> touchesDesactivees){
        for (Node node : this.getChildren()){
            if (node instanceof Button){
                Button btn = (Button) node;
                if (touchesDesactivees.contains(btn.getText()))
                    btn.setDisable(true);
                else
                    btn.setDisable(false);
            }
        }
    }
}
