package view;


import controller.IKontrolleriForM;
import controller.IKontrolleriForV;
import javafx.fxml.FXML;
import simu.framework.IMoottori;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class Kontrolleri implements IKontrolleriForM, IKontrolleriForV {
    @FXML
    private Label ControlText;

    @FXML
    private Text LaakariText;

    @FXML
    private Button LaakariminusText;

    @FXML
    private Button LaakariplusText;

    @FXML
    private Button MaksuminusText;

    @FXML
    private Button MaksuplusText;

    @FXML
    private Text MriText;

    @FXML
    private Button MriminusText;

    @FXML
    private Button MriplusText;

    @FXML
    private Text ServiceText;

    @FXML
    private Text aikaText;

    @FXML
    private TextField aikaboxText;

    @FXML
    private ImageView backwall1Text;

    @FXML
    private ImageView backwall2Text;

    @FXML
    private ImageView backwall4Text;

    @FXML
    private ImageView bed11Text;

    @FXML
    private ImageView bed1Text;

    @FXML
    private ImageView bed22Text;

    @FXML
    private ImageView bed2Text;

    @FXML
    private ImageView bed3Text;

    @FXML
    private ImageView chair10Text;

    @FXML
    private ImageView chair11Text;

    @FXML
    private ImageView chair1Text;

    @FXML
    private ImageView chair2Text;

    @FXML
    private ImageView chair3Text;

    @FXML
    private ImageView chair5Text;

    @FXML
    private ImageView chair6Text;

    @FXML
    private ImageView chair7Text;

    @FXML
    private ImageView chair8Text;

    @FXML
    private ImageView chair9Text;

    @FXML
    private Label detailsText;

    @FXML
    private ImageView doc11Text;

    @FXML
    private ImageView docdeskText;

    @FXML
    private AnchorPane firstcolumText;

    @FXML
    private ImageView fullimageText;

    @FXML
    private Text guideText;

    @FXML
    private Button hidastaText;

    @FXML
    private ImageView idewall3Text;

    @FXML
    private Text maksuText;

    @FXML
    private ImageView mriaproText;

    @FXML
    private Button nopeutaText;

    @FXML
    private Pane paneText;

    @FXML
    private ImageView reception1Text;

    @FXML
    private ImageView reception2Text;

    @FXML
    private ImageView sidewall1Text;

    @FXML
    private ImageView sidewall2Text;

    @FXML
    private ImageView sokeriText;

    @FXML
    private Text syotaText;

    @FXML
    private TextField syotoboxText;

    @FXML
    private Text vastanottoText;

    @FXML
    private Button vastanottominusText;

    @FXML
    private Button vastanottoplusText;

    @FXML
    private ImageView vhair4Text;

    @FXML
    private Button vuoronmrominusText;

    @FXML
    private Text vuoronumerText;

    @FXML
    private ImageView vuoronumeroText;

    @FXML
    private Button vuoronumeroplusText;

    @FXML
    private ImageView wall1Text;

    @FXML
    private ImageView wall2Text;

    @FXML
    private ImageView wall3Text;

    @FXML
    private ImageView wall4Text;

    @FXML
    private ImageView wallllText;

    @FXML
    private ImageView waterText;

    @FXML
    private Font x1;

    @FXML
    private Font x11;

    @FXML
    private Color x2;

    @FXML
    private Color x21;
    private Visualisointi visualisointi;

    private IMoottori moottori;

    private ISimulaattorinUI ui;

    private IKontrolleriForV kontrolleri;
    
    int kassa = 0;
    @Override
    public void kaynnistaSimulointi() {

    }

    @Override
    public void nopeuta() {

    }

    @Override
    public void hidasta() {

    }

    @Override
    public void naytaLoppuaika(double aika) {

    }

    @Override
    public void visualisoiAsiakas() {

    }

    @FXML
    public synchronized void buttonPlusMaksu() {
        kassa++;
        switch (kassa) {
            case 1:
                vuoronumeroText.setVisible(false);
                System.out.println("Maksu minus button pressed" + kassa);
                kassa = 1;
                break;
        }

        MaksuplusText.setOnAction(e -> {
            if (kassa > 0) {
                kassa--;
            }
        });
    }

    }

