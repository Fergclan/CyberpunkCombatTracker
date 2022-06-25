package com.example.cyberpunkcombattracker;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;


public class MainController {

    @FXML
    private AnchorPane mainScene;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField getNumber;
    @FXML
    private TextField getAddNumber;
    @FXML
    private TextField getRemoveLocation;
    @FXML
    private TextField getHealth;
    @FXML
    private TextField getBodyArmor;
    @FXML
    private TextField getHeadArmor;
    @FXML
    private TextField getAmmo;
    @FXML
    private TextArea getNotes;


    private ArrayList<Parent> subScene = new ArrayList<>();

    public void makeScene() throws IOException {
        System.out.println(mainScene.getChildren().size());

        sceneCleanup();

        int amt;
        try
        {
            amt = Integer.parseInt(getNumber.getText());
        }
        catch(Exception e)
        {
            amt = 0;
        }

        for(int i = 0; i < amt; i++) // Creates subPanels at location 0,0.
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("subScene-view.fxml")); //Creates new panel loader
            Parent temp = loader.load(); //panel is loaded
            SubController subCon = loader.getController(); //temporary copy of controller made to run the pane initialization
            subCon.setStates(getHealth.getText(), getBodyArmor.getText(), getHeadArmor.getText(), getAmmo.getText(), getNotes.getText());
            subCon.numberPanel(i+1);
            //values are added to the panel
            subScene.add(temp); //panels are stored in an array for further editing.
        }

        fixResolution(mainScene.getWidth());

        mainScene.getChildren().addAll(subScene);
    }

    public void addToScene() throws IOException
    {
        int amt;
        try
        {
            amt = Integer.parseInt(getAddNumber.getText());
        }
        catch(Exception e)
        {
            amt = 0;
        }
        for(int i = 0; i < amt; i++) // Creates subPanels at location 0,0.
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("subScene-view.fxml")); //Creates new panel loader
            Parent temp = loader.load(); //panel is loaded
            SubController subCon = loader.getController(); //temporary copy of controller made to run the pane initialization
            subCon.setStates(getHealth.getText(), getBodyArmor.getText(), getHeadArmor.getText(), getAmmo.getText(), getNotes.getText());
            subCon.numberPanel(subScene.size()+1);

            //values are added to the panel
            subScene.add(temp); //panels are stored in an array for further editing.

            mainScene.getChildren().add(subScene.get(subScene.size()-1));
        }
        fixResolution(mainScene.getWidth());

    }


    private void sceneCleanup() //deletes all previous subPanes when user creates a new batch of panes.
    {
        subScene.clear();

        mainScene.getChildren().remove(18,mainScene.getChildren().size()); //Need to make this a non-static value.
    }

    public void fixResolution(double newWindow)
    {
        int subSceneXScale;
        int subSceneYScale;
        double newSceneX = newWindow; //mainScene.getWidth();

        mainScene.setMaxWidth(newWindow);

        int spacingX = 20;
        int spacingY = 20;
        try
        {
            subScene.get(0); // Check if any have been created
            subSceneXScale = 230;
            subSceneYScale = 225;
        }
        catch (Exception e)
        {
            return;
        }

        int numSubScenes = subScene.size();

        int numColumns = (int) ((newSceneX - subSceneXScale -  spacingX - 10) / (subSceneXScale));
        int numRows;

        if (numColumns == 0){numRows = numSubScenes / (numColumns+1);}
        else{numRows = numSubScenes / numColumns;}

        mainScene.setPrefHeight((subSceneYScale+spacingY) * numRows);


        int i = 0;
        for(int r = 0; r <= numRows; r++)
        {
            for (int c = 0; c <= numColumns; c++)
            {
                if (i < numSubScenes)
                {
                    subScene.get(i).setLayoutX((c * subSceneXScale)  + spacingX);
                    subScene.get(i).setLayoutY((r * subSceneYScale) + (r * spacingY) + 55);
                    //System.out.println("X:Y  - " + subScene.get(i).getLayoutX() + ":" + subScene.get(i).getLayoutY());
                }
                else{scrollPane.setPrefHeight(mainScene.getHeight()); return;}
                i ++;
            }
        }
        scrollPane.setPrefHeight(mainScene.getHeight());

    }

    public void removePanel()
    {
        int testInt;
        try {
            testInt = Integer.parseInt(getRemoveLocation.getText());
        }
        catch (Exception e)
        {
            return;
        }
        Parent temp;

        try
        {
            temp = subScene.get(testInt - 1);
        }
        catch (Exception e)
        {
            return;
        }

        mainScene.getChildren().remove(temp);
        subScene.remove(temp);
        temp = null;
        fixResolution(mainScene.getWidth());

    }




}