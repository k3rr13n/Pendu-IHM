import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControleurTFC implements EventHandler<KeyEvent>{ 

    private Temperature temperature;
    private AppliConverter appli;
    
    public ControleurTFC(Temperature temperature, AppliConverter appli){
        this.temperature = temperature;
        this.appli = appli;
    }

    @Override
    public void handle(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)){
            double value;
            try{
                value = this.appli.getValueFahrenheit();
                this.temperature.setvaleurFahrenheit(value);
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
