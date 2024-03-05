package view;


import controller.IKontrolleriForM;
import controller.IKontrolleriForV;
import javafx.fxml.FXML;
import simu.framework.IMoottori;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Kontrolleri implements IKontrolleriForM, IKontrolleriForV {
    @FXML
    private Label ControlText;

    @FXML
    private Text LaakariText;

    @FXML
    private Button LaakariminusButton;

    @FXML
    private Button LaakariplusButton;

    @FXML
    private Button MaksuminusButton;

    @FXML
    private Button MaksuplusButton;

    @FXML
    private Button vastaanottominusButton;

    @FXML
    private Button vastaanottoplusButton;

    @FXML
    private Text MriText;

    @FXML
    private Button MRIminusButton;

    @FXML
    private Button MRIplusButton;

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
    private ImageView KassaImage1;

    @FXML
    private ImageView KassaImage2;

    @FXML
    private ImageView Laakari1Image;

    @FXML
    private ImageView Laakari2Image;

    @FXML
    private ImageView kuvaus1Image;

    @FXML
    private ImageView kuvaus2Image;

    @FXML
    private Button nopeutaText;

    @FXML
    private Pane paneText;

    @FXML
    private ImageView reception1Image;

    @FXML
    private ImageView reception2Image;

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
    private Button vastanottominusButton;

    @FXML
    private Button vastanottoplusButton;

    @FXML
    private ImageView vhair4Text;

    @FXML
    private Button vuoronmrominusText;

    @FXML
    private Text vuoronumerText;

    @FXML
    private ImageView VuoronumeroImage;

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
    
    int kassa = 2;
    int vastaanotto = 2;
    int laakari = 2;
    int mri = 2;
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


    public synchronized void buttonMinusMaksu() {
        MaksuminusButton.setOnAction(e -> {
            switch (kassa) {
                case 1:
                    KassaImage1.setVisible(false);
                    System.out.println("Kassa minus button pressed " + kassa);
                    break;
                case 2:
                    KassaImage2.setVisible(false);
                    System.out.println("Kassa minus button pressed " + kassa);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (kassa > 0) {
                kassa--;
            }
        });
    }

    public synchronized void buttonPlusMaksu() {
        MaksuplusButton.setOnAction(e -> {
            switch (kassa) {
                case 1:
                    KassaImage1.setVisible(true);
                    System.out.println("Kassa plus button pressed " + kassa);
                    break;
                case 2:
                    KassaImage2.setVisible(true);
                    System.out.println("Kassa plus button pressed " + kassa);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (kassa < 3) {
                kassa++;
            }
        });
    }

    public synchronized void buttonMinusMri() {
        MRIminusButton.setOnAction(e -> {
            switch (mri) {
                case 1:
                    kuvaus1Image.setVisible(false);
                    System.out.println("Kassa minus button pressed " + mri);
                    break;
                case 2:
                    kuvaus2Image.setVisible(false);
                    System.out.println("Kassa minus button pressed " + mri);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (mri > 0) {
                mri--;
            }
        });
    }

    public synchronized void buttonPlusMri() {
        MRIplusButton.setOnAction(e -> {
            switch (mri) {
                case 1:
                    kuvaus1Image.setVisible(true);
                    System.out.println("Kassa plus button pressed " + mri);
                    break;
                case 2:
                    kuvaus2Image.setVisible(true);
                    System.out.println("Kassa plus button pressed " + mri);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (mri < 3) {
                mri++;
            }
        });
    }

    public synchronized void buttonMinusLaakari() {
        LaakariminusButton.setOnAction(e -> {
            switch (laakari) {
                case 1:
                    Laakari1Image.setVisible(false);
                    System.out.println("Reception minus button pressed " + laakari);
                    break;
                case 2:
                    Laakari2Image.setVisible(false);
                    System.out.println("Reception minus button pressed " + laakari);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (laakari > 0) {
                laakari--;
            }
        });
    }

    public synchronized void buttonPlusLaakari() {
        LaakariplusButton.setOnAction(e -> {
            switch (laakari) {
                case 1:
                    Laakari1Image.setVisible(true);
                    System.out.println("Reception plus button pressed " + laakari);
                    break;
                case 2:
                    Laakari2Image.setVisible(true);
                    System.out.println("Reception plus button pressed " + laakari);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (laakari < 3) {
                laakari++;
            }
        });
    }

    public synchronized void buttonMinusVataanotto() {
        vastaanottominusButton.setOnAction(e -> {
            switch (vastaanotto) {
                case 1:
                    reception1Image.setVisible(false);
                    System.out.println("Reception minus button pressed " + vastaanotto);
                    break;
                case 2:
                    reception2Image.setVisible(false);
                    System.out.println("Reception minus button pressed " + vastaanotto);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (vastaanotto > 0) {
                vastaanotto--;
            }
        });
    }

    public synchronized void buttonPlusVastaanotto() {
        vastaanottoplusButton.setOnAction(e -> {
            switch (vastaanotto) {
                case 1:
                    reception1Image.setVisible(true);
                    System.out.println("Reception plus button pressed " + vastaanotto);
                    break;
                case 2:
                    reception2Image.setVisible(true);
                    System.out.println("Reception plus button pressed " + vastaanotto);
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
            if (vastaanotto < 3) {
                vastaanotto++;
            }
        });
    }

    }

