import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonConvertirF implements EventHandler<ActionEvent>{ 

    private Temperature temperature;
    private AppliConverter appli;
    
    public ControleurBoutonConvertirF (Temperature temperature, AppliConverter appli){
        this.temperature = temperature;
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent e) {
        double value;
            try{
                value = this.appli.getValueFahrenheit();
                this.temperature.setvaleurFahrenheit(value);
                this.appli.majTF();                
            }
            catch (NumberFormatException exp) {
                this.appli.effaceTF();
            }
    }
}