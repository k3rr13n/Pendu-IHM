import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonConvertirC implements EventHandler<ActionEvent>{ 

    private Temperature temperature;
    private AppliConverter appli;
    
    public ControleurBoutonConvertirC (Temperature temperature, AppliConverter appli){
        this.temperature = temperature;
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent e) {
        double value;
            try{
                value = this.appli.getValueCelcius();
                this.temperature.setvaleurCelcius(value);
                this.appli.majTF();                
            }
            catch (NumberFormatException exp) {
                this.appli.effaceTF();
            }
    }
          
}