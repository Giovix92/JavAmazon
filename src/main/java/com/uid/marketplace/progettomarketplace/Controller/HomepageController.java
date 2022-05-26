package com.uid.marketplace.progettomarketplace.Controller;

import com.uid.marketplace.progettomarketplace.AlertMessages;
import com.uid.marketplace.progettomarketplace.MarketPlaceApplication;
import com.uid.marketplace.progettomarketplace.View.SceneHandler;
import com.uid.marketplace.progettomarketplace.client.Client;
import com.uid.marketplace.progettomarketplace.client.ConnectionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class HomepageController {

    @FXML
    private TextField SearchBar;
        //BARRA DI RICERCA DEI PRODOTTI

    @FXML
    private MenuItem AccessButton;

    @FXML
    private MenuItem RegisterButton;

    @FXML
    private MenuItem BalanceButton;

    @FXML
    private MenuItem ChangeMailButton;

    @FXML
    private MenuItem ChangePasswordButton;

    @FXML
    private MenuItem ExitButton;

    @FXML
    private ImageView HomePageButton;

    @FXML
    private MenuButton CategoriesButton;

    @FXML
    void AccessAction(ActionEvent event) throws Exception {
        if(Client.getInstance().getEmail() == null) SceneHandler.getInstance().setAccessScene();
    }

    @FXML
    void RegisterAction(ActionEvent event) throws Exception {
        SceneHandler.getInstance().setRegistrationScene();
    }

    @FXML
    void BalanceAction(ActionEvent event) {
        //saldo
    }

    @FXML
    void ChangeMailAction(ActionEvent event) {
        SceneHandler.getInstance().createAlert("contatti", "contatti");
    }

    @FXML
    void ChangePasswordAction(ActionEvent event) throws Exception {
        SceneHandler.getInstance().setChangePasswordScene();
    }

    @FXML
    void ExitAction(ActionEvent event) throws Exception {
        try {
            if(Client.getInstance().logout()){
                System.out.println(Client.getInstance().getEmail());
                SceneHandler.getInstance().setHomePageScene();
            }
            else{
                SceneHandler.getInstance().createError("errore", "errore");
            }
        } catch (Exception e){
            if(!SceneHandler.getInstance().createErrorWithContacts(
                    AlertMessages.CONNECTION_ERROR_MSG,
                    AlertMessages.CONNECTION_ERROR_TITLE)) {
                SceneHandler.getInstance().createAlert("Contatti", "Contatti");
            }
        }
    }

    @FXML
    void CartAction(ActionEvent event) throws Exception {
        if(Client.getInstance().getEmail() == null) SceneHandler.getInstance().setAccessScene();
        //else aprire pagina carrello
    }

    @FXML
    void ConditionAction(ActionEvent event) {
        SceneHandler.getInstance().createAlert("DA COMPLETARE", "Condizioni generali di vendita");
    }

    @FXML
    void HomeAction(MouseEvent event) throws Exception {
        SceneHandler.getInstance().setHomePageScene();
    }

    @FXML
    void OrderAction(ActionEvent event) throws Exception {
        if(Client.getInstance().getEmail() == null) SceneHandler.getInstance().setAccessScene();
        //else aprire pagina ordini
    }

    @FXML
    void PrivacyAction(ActionEvent event) {
        SceneHandler.getInstance().createAlert( "DA COMPLETARE", "Informativa sulla privacy");

    }

    @FXML
    void SearchAction(ActionEvent event) {
        //LENTE DI INGRANDIMENTO PER LA BARRA DI RICERCA
    }

    @FXML
    void SocietyAction(ActionEvent event) {
        SceneHandler.getInstance().createAlert( "DA COMPLETARE", "La nostra società");

    }

    @FXML
    void BooksAction(ActionEvent event) {
        CategoriesButton.setText("Libri");
    }

    @FXML
    void ClothesAction(ActionEvent event) {
        CategoriesButton.setText("Abbigliamento");

    }

    @FXML
    void ElectronicsAction(ActionEvent event) {
        CategoriesButton.setText("Elettronica e Informatica");
    }

    @FXML
    void HealthAction(ActionEvent event) {
        CategoriesButton.setText("Salute e Benessere");
    }

    @FXML
    void HouseAction(ActionEvent event) {
        CategoriesButton.setText("Casa e Giardino");
    }

    @FXML
    void MusicAction(ActionEvent event) {
        CategoriesButton.setText("Musica, Film e TV");
    }

    @FXML
    void OurAction(ActionEvent event) {
        CategoriesButton.setText("Scelti da noi");
    }

    @FXML
    void ShoesAction(ActionEvent event) {
        CategoriesButton.setText("Scarpe");
    }

    @FXML
    void SportAction(ActionEvent event) {
        CategoriesButton.setText("Sport e Tempo Libero");
    }

    @FXML
    void VideogamesAction(ActionEvent event) {
        CategoriesButton.setText("Videogiochi e Console");
    }

    @FXML
    void kidsAction(ActionEvent event) {
        CategoriesButton.setText("Per bambini");
    }

    @FXML
    void initialize() {
        Image image = new Image(Objects.requireNonNull(MarketPlaceApplication.class.getResourceAsStream("images/logo.png")));
        HomePageButton.setImage(image);

        if (Client.getInstance().getEmail() != null){
            AccessButton.setVisible(false);
            RegisterButton.setVisible(false);
            ChangeMailButton.setVisible(true);
            ChangePasswordButton.setVisible(true);
            BalanceButton.setVisible(true);
            ExitButton.setVisible(true);
        }
        else {
            AccessButton.setVisible(true);
            RegisterButton.setVisible(true);
            ChangeMailButton.setVisible(false);
            ChangePasswordButton.setVisible(false);
            BalanceButton.setVisible(false);
            ExitButton.setVisible(false);
        }
    }

}
