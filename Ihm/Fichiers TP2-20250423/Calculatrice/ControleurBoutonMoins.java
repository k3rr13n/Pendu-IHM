import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurBoutonMoins implements EventHandler<ActionEvent>{
    private AppliCalculatrice appli;
    
    public ControleurBoutonMoins(AppliCalculatrice appli){
        this.appli = appli;
    }
    
    public void handle(ActionEvent e){
        System.out.println("Soustraction");
        this.appli.soustraction();
    }
}