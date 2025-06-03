import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FenetreConnexion extends GridPane{
    private Button bouton;
    private TextField textId;
    private TextField textMdp;
    
    public FenetreConnexion(Button bouton){
        super();
        this.bouton = bouton; //new Button("Connexion")
        this.textId = new TextField();
        this.textMdp = new TextField();
        //this.setPadding(new Insets(10));
        this.add(new Label("Entrez votre identifiant et votre mot de passe"), 0, 0, 2, 1);
        this.add(new Label("Identifiant : "), 0, 1);
        this.add(new Label("Mot de passe : "), 0, 2);
        this.add(this.textId, 1, 1);
        this.add(this.textMdp, 1, 2);
        this.add(this.bouton, 1, 3);
        this.setVgap(10);
        this.setHgap(30);
        this.setPadding(new Insets(30, 80, 30, 80));
        //this.setTop(this.enHaut());
        //this.setLeft(this.bouton);       
        //this.setCenter(this.uneVBox());
        //this.setRight(new ImageView(new Image("https://publicdomainvectors.org/photos/Calculator-Icon.png")));
    }
    
    /*private Pane enHaut(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20,20,20,10));        
        Text title = new Text("Fenêtre 1 (borderPane)");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        hbox.getChildren().add(title);
        hbox.setStyle("-fx-background-color: #7fffd4;");
        return hbox;
    }

    private VBox uneVBox() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(new Text("Tables de multiplication"));
        for (int i=0; i<10; i++){
            vbox.getChildren().add(new Text(i+" * 5 = " +(i*5)));
        }
        vbox.setStyle("-fx-background-color: #98fb98;");        
        return vbox;
    }*/
}
