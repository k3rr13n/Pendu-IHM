import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControleurTFDroite implements EventHandler<KeyEvent>{ 

    private AppliCalculatrice appli;
    
    public ControleurTFC(AppliCalculatrice appli){
        this.appli = appli;
    }

    @Override
    public void handle(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)){
            double value;
            try{
                value = this.appli.getValueFahrenheit();
                this.appli.boutonCF();                
            }
            catch (NumberFormatException exp) {
                this.appli.effaceTF();
            }
          } else{
              //nothing
          }
    }
          
}
