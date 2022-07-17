package com.example.cyberpunkcombattracker;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SubController {

    @FXML
    private AnchorPane subPane;

    @FXML
    private TextField hpText;
    @FXML
    private TextField armorBodyText;
    @FXML
    private TextField armorHeadText;
    @FXML
    private TextField ammoText;
    @FXML
    private TextArea notesText;
    @FXML
    private TextField damageText;

    @FXML
    private Label hpMax;
    @FXML
    private Label ammoMax;
    @FXML
    private Label panelNumberText;


    @FXML
    private CheckBox meleeCheck;
    @FXML
    private CheckBox apCheck;
    @FXML
    private CheckBox bodyDamageCheck;
    @FXML
    private CheckBox headDamageCheck;



    private int actorBodyArmor = 0;
    private int actorHeadArmor = 0;
    private int actorHealth = 0;
    private int actorMaxHealth = 0;
    private int actorAmmo = 0;
    private int actorMaxAmmo = 0;

    public static int tryParse(String text)
    {
        try
        {
            return Integer.parseInt(text);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public void updateHP()
    {
        actorHealth = tryParse(hpText.getText());
        healthCheck();
    }
    public void updateArmor()
    {
        actorBodyArmor = tryParse(armorBodyText.getText());
        actorHeadArmor = tryParse(armorHeadText.getText());
    }
    public void updateAmmo()
    {
        actorAmmo = tryParse(ammoText.getText());
    }


    public void hpAdder()
    {
        actorHealth += 1;

        hpText.setText(Integer.toString(actorHealth));
        healthCheck();

    }
    public void hpSubber()
    {
        actorHealth -= 1;

        hpText.setText(Integer.toString(actorHealth));
        healthCheck();
    }
    public void setHPMax()
    {
        actorMaxHealth = actorHealth;
        hpMax.setText(Integer.toString(actorMaxHealth));
    }


    public void armorBodyAdder()
    {
        actorBodyArmor += 1;

        armorBodyText.setText(Integer.toString(actorBodyArmor));

    }
    public void armorBodySubber()
    {
        actorBodyArmor -= 1;

        armorBodyText.setText(Integer.toString(actorBodyArmor));
    }

    public void armorHeadAdder()
    {
        actorHeadArmor += 1;

        armorHeadText.setText(Integer.toString(actorHeadArmor));

    }
    public void armorHeadSubber()
    {
        actorHeadArmor -= 1;

        armorHeadText.setText(Integer.toString(actorHeadArmor));
    }


    public void ammoAdder()
    {
        actorAmmo += 1;

        ammoText.setText(Integer.toString(actorAmmo));

    }

    public void ammoSubber()
    {
        actorAmmo -= 1;

        ammoText.setText(Integer.toString(actorAmmo));
    }

    public void setAmmoMax()
    {
        actorMaxAmmo = actorAmmo;

        ammoMax.setText(Integer.toString(actorMaxAmmo));
    }


    public void healthCheck()
    {
        if (actorHealth <= (actorMaxHealth/2) && actorHealth > 0)
        {
            subPane.setStyle("-fx-background-color: RED;");
        }
        else  if (actorHealth < 1)
        {
            subPane.setStyle("-fx-background-color: BLACK;");
        }
        else
        {
            subPane.setStyle("-fx-background-color: LIGHTGREY;");
        }
    }

    public void armorCheck()
    {
        if (actorBodyArmor < 0 ){actorBodyArmor = 0;}
        if (actorHeadArmor < 0 ){actorHeadArmor = 0;}
    }


    public void reload()
    {
        actorAmmo = actorMaxAmmo;

        ammoText.setText(Integer.toString(actorAmmo));
    }


    public void dealDamage()
    {
        int damage = tryParse(damageText.getText());

        boolean isMelee = meleeCheck.isSelected();
        boolean isBody = bodyDamageCheck.isSelected();
        boolean isHead = headDamageCheck.isSelected();

        if (!isBody && !isHead){isBody = true;}

        if (isBody && (damage > actorBodyArmor || (isMelee && damage > (actorBodyArmor / 2))))
        {

            if (isMelee) {actorHealth -= damage - actorBodyArmor/2;}
            else {actorHealth -= damage - actorBodyArmor;}

            hpText.setText(Integer.toString(actorHealth));
            healthCheck();

            actorBodyArmor -= 1;
            if (apCheck.isSelected()){actorBodyArmor -= 1;}
            armorCheck();
            armorBodyText.setText(Integer.toString(actorBodyArmor));
        }

        else if (isHead && (damage > actorHeadArmor || (isMelee && damage > (actorHeadArmor / 2))))
        {

            if (isMelee) {actorHealth -= 2 * (damage - actorHeadArmor/2);}
            else {actorHealth -= 2 * (damage - actorHeadArmor);}

            hpText.setText(Integer.toString(actorHealth));
            healthCheck();

            actorHeadArmor -= 1;
            if (apCheck.isSelected()){actorHeadArmor -= 1;}
            armorCheck();
            armorHeadText.setText(Integer.toString(actorHeadArmor));
        }
    }

    public void setStates(String health, String armorBody, String armorHead, String ammo, String notes)
    {
        actorHealth = tryParse(health);
        actorBodyArmor = tryParse(armorBody);
        actorHeadArmor = tryParse(armorHead);
        actorAmmo = tryParse(ammo);

        hpText.setText(Integer.toString(actorHealth));
        armorBodyText.setText(Integer.toString(actorBodyArmor));
        armorHeadText.setText(Integer.toString(actorHeadArmor));
        ammoText.setText(Integer.toString(actorAmmo));
        notesText.setText(notes);

        this.setHPMax();
        this.setAmmoMax();
    }
    public String[] getStates()
    {

        return new String[]{Integer.toString(actorHealth), Integer.toString(actorMaxHealth), Integer.toString(actorHeadArmor),
                Integer.toString(actorBodyArmor), Integer.toString(actorAmmo), Integer.toString(actorMaxAmmo),
                notesText.getText()};
    }




    public void numberPanel(int panelNumber)
    {
        panelNumberText.setText(Integer.toString(panelNumber));
    }


}