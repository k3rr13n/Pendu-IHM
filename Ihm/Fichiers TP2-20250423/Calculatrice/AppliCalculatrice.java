import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class AppliCalculatrice extends Application {
    
    private Label resultat;
    private TextField tf1;
    private TextField tf2;

//===

    @Override
    public void init(){
        // cette méthode est utilisée pour initialiser les éléments 
        // non graphiques et événetuellement graphiques autres que la Scène et le Stage
        this.tf1 = new TextField();
        this.tf2 = new TextField();
        this.resultat = new Label("");        
    }

    private GridPane gridPane(){
        GridPane pane = new GridPane();
        pane.add(new Label("Nombre 1"), 0, 0);
        pane.add(new Label("Nombre 2"), 0, 1);
        pane.add(new Label("Résultat : "), 0, 2);        
        pane.add(tf1, 1, 0);
        pane.add(tf2, 1, 1);
        pane.add(resultat, 1, 2);   
        pane.setHgap(50);
        pane.setVgap(20);        
        return pane;
    }

    private HBox hbox(){
        HBox pane =new HBox(50);
        Button boutonPlus =new Button("+");
        Button boutonMoins =new Button("-");        
        pane.getChildren().addAll(boutonPlus, boutonMoins);
        pane.setAlignment(Pos.CENTER);  
        boutonPlus.setOnAction(new ControleurBoutonPlus(this));
        boutonMoins.setOnAction(new ControleurBoutonMoins(this));
        return pane;
    }

    private HBox root(){ // Scène
        HBox pane = new HBox(10);
        VBox vbox = new VBox(50);
        vbox.getChildren().addAll(gridPane(), hbox());
        vbox.setPrefWidth(400);
        HBox.setMargin(vbox, new Insets(30));
        pane.getChildren().add(vbox);
        return pane;
    }
    
    @Override
    public void start(Stage stage){              
        Scene scene =new Scene(root());
        stage.setTitle("Calculatrice");
        stage.setScene(scene);
        stage.show();
    }

    public double getValueTF1() throws NumberFormatException{
        return Double.parseDouble(tf1.getText());
    }
    public double getValueTF2() throws NumberFormatException{
        return Double.parseDouble(tf2.getText());
    }
    public void addition(){
        this.resultat.setText(Double.toString(getValueTF1() + getValueTF2()));
    }
    public void soustraction(){
        this.resultat.setText(Double.toString(getValueTF1() - getValueTF2()));
    }

}