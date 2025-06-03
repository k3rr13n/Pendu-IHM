import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Priority;

public class FenetreAnalyste extends BorderPane{
    private TextField tf1;
    private Button button1;
    private TextField tf2;
    private ComboBox kombo;
    private PieChart pieChat;
    private Button button2;
    private Button button3;
    private ImageView im1;
    private ImageView im2;
    private ImageView im3;
    private ImageView im4;
    private ImageView im5;
    private ImageView im6;
    private ImageView im7;

    public FenetreAnalyste(Button button1){
        super();
        this.button1 = button1;

        BorderPane border = new BorderPane();
        this.setTop(border);
        VBox vBox = new VBox();
        this.setCenter(vBox);
        TilePane tile = new TilePane();
        this.setRight(tile);

        Label txt1 = new Label("JAKJ");
        border.setLeft(txt1);
        border.setRight(button1);

        Label txt2 = new Label("Farine");
        ComboBox<Rectangle> combo = new ComboBox<Rectangle>();
        PieChart chart = new PieChart () ;
    chart.setTitle("Que lisez - vous au petit déjeuner ?");
    chart.getData().setAll(
    new PieChart.Data("Le journal", 21),
    new PieChart.Data("Un livre", 3),
    new PieChart.Data("Le courier", 7),
    new PieChart.Data("La boîte de céréales", 75));
    chart.setLegendSide(Side.LEFT); // pour mettre la légende à gauche
        HBox hBox = new HBox();
        Button button2 = new Button("question precedente");
        /*Image img2 = new Image(getClass().getResourceAsStream("./../graphics/back.png"));
        ImageView imgV2 = new ImageView(img2);
        button2.setGraphic(imgV2);*/
        Button button3 = new Button("question suivante");  
       // Image img3 = new Image(getClass().getResourceAsStream("./../graphics/next.png"));
       // ImageView imgV3 = new ImageView(img3);
        //button3.setGraphic(imgV3);
        hBox.getChildren().addAll(button2, button3);
            vBox.getChildren().addAll(txt2, combo, chart, hBox);


        //"file:graphics/chart_1.png"
            
        ImageView ig1 = new ImageView(new Image("file:graphics/chart_1.png"));
        ImageView ig2 = new ImageView(new Image("file:graphics/chart_2.png"));
        ImageView ig3 = new ImageView(new Image("file:graphics/chart_3.png"));
        ImageView ig4 = new ImageView(new Image("file:graphics/chart_4.png"));
        ImageView ig5 = new ImageView(new Image("file:graphics/chart_5.png"));
        ImageView ig6 = new ImageView(new Image("file:graphics/chart_6.png"));
        ImageView ig7 = new ImageView(new Image("file:graphics/chart_7.png"));
        ImageView ig8 = new ImageView(new Image("file:graphics/chart_8.png"));
        tile.setPrefColumns(2);
        tile.setPrefColumns(4);
        tile.getChildren().addAll(ig1, ig2, ig3, ig4, ig5, ig6, ig7, ig8);
        /*for(int i = 1;i<9;i++){
               tile.getChildren().add(new ImageView(new Image("file:graphics/chart_"+i+".png")));
            }*/

    }
}