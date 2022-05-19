package com.example.flowpane;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;



import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private ImageView imageView;
    @FXML private TextField textField;
    @FXML private ScrollBar ScrollBar1;
    @FXML private Spinner Spinner1;
    @FXML private Button Button2;
    @FXML private Canvas cnv;
    @FXML private Canvas cnv2;
    @FXML private GraphicsContext kakto ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //GraphicsContext kakto = cnv.getGraphicsContext2D();
       // drawShapes();

        ScrollBar1.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            textField.setText("Scrollbar value changed from " + old_val + " to " + new_val);
        });
        textField.setText("ttt");

        Button2.setOnAction(this::onClick);
        Spinner1.setOnScroll  (this::onScroll);
    }

    private void onScroll(MouseEvent mouseEvent) {
        textField.setText( "pppppp");
    }


    @FXML
    protected void onScroll(ScrollEvent scrollEvent) {
        //String s = Double.toString(((ScrollBar)scrollEvent.getSource()).getValue());
        //textField.setText(Double.toString(ScrollBar1.getValue()))  ;
        textField.setText( "sss");
        //scrollEvent.consume();
    }

    @FXML
    protected void onButton1Clicked() {
        double value = imageView.getRotate();
        imageView.setRotate(value + 30);

    }
    @FXML
    protected void onRadioButtonClick(ActionEvent event){

        String s = ((RadioButton)event.getSource()).getText();
        textField.setText( s);
    }

    @FXML
    protected void onClick(ActionEvent event){
        //drawStar(50,50,25);
        GraphicsContext gct = cnv2.getGraphicsContext2D();
        gct.setFill(Color.BLUEVIOLET);
        gct.fillOval(70 , 70,40,40);
        textField.setText( "Button2 clicked");

    }

    private void drawShapes() {
        GraphicsContext kakto = cnv.getGraphicsContext2D();
        kakto.setFill(Color.BLUEVIOLET);
        kakto.setStroke(Color.CYAN);
        kakto.setLineWidth(12.5);

        kakto.fillPolygon(new double[]{50, 100, 150, 100}, new double[] {100, 20, 100, 100}, 4);
        kakto.setFill(Color.YELLOW);
        kakto.fillRect(55, 100, 90, 90);
    }
    private void drawStar(double x0,double y0,double r) {

        double a=18, x,y,R;
        double[] xPoints = {0,0,0,0,0,0,0,0,0,0,0,0} ;
        double[] yPoints= {0,0,0,0,0,0,0,0,0,0,0,0};
        int nPoints;
        for (int i=0; i<12; i++) {
            if (i%2!=0) R=r/2; else R=r;
            x = x0 + R * Math.cos(Math.toRadians(a));
            y = y0 - R * Math.sin(Math.toRadians(a));
            xPoints[i] = x;
            yPoints[i] = y;
            a+=36;
        }

        GraphicsContext kakto = cnv.getGraphicsContext2D();
        kakto.setFill(Color.BLUEVIOLET);
        kakto.setStroke(Color.BLUEVIOLET);
        kakto.fillPolygon(xPoints, yPoints, 11);
        //kakto.strokePolygon(xPoints, yPoints, 11);


    }
    @FXML
    protected void onMouseClick(MouseEvent event){
        //drawStar(event.getX() , event.getY(),40);
        GraphicsContext kakto = cnv.getGraphicsContext2D();
        kakto.setFill(Color.BLUEVIOLET);
        kakto.fillOval(event.getX()-20 , event.getY()-20,40,40);
    }
    boolean painting = false;
    double x1=0, y1=0;
    @FXML
    protected void onMousePressed(MouseEvent event){
        painting=true;
        x1=event.getX();y1=event.getY();

    }
    @FXML
    protected void onMouseReleased(MouseEvent event){
        painting=false;
    }
    @FXML
    protected void onMouseDragged(MouseEvent event){
        GraphicsContext gct = cnv2.getGraphicsContext2D();
        gct.setStroke(Color.BLUEVIOLET);
        double x2 = event.getX();
        double y2 = event.getY();
        if (painting){
        gct.strokeLine(x1,y1,x2,y2);
        x1=x2;y1=y2;}
    }
}
