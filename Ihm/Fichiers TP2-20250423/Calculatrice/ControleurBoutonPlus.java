import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurBoutonPlus implements EventHandler<ActionEvent>{
    private AppliCalculatrice appli;
    
    public ControleurBoutonPlus(AppliCalculatrice appli){
        this.appli = appli;
    }
    
    public void handle(ActionEvent e){
        System.out.println("Addition");
        this.appli.addition();
    }
}