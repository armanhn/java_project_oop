/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatingtouroperatorsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arman
 */
public class TourGuideViewAppointmentSceneController implements Initializable {

    @FXML
    private TextArea traveltext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         File f1 = new File("Queries.bin");
         ObjectInputStream in= null;
        try {  
            in = new ObjectInputStream(new FileInputStream(f1));
             Queries s=null;
        String str = "";
        try{
          
            while( (s = (Queries) in.readObject() ) != null )
            {
                if(s.getType().equals("Travel"))
                {
                   str =  str  + s.getCustomerEmail() + "," +s.getSubject() + "," + s.getMessage() + "\n";

                }

    
            }
            
         
        }
        catch(Exception e1)
        {
        }
        in.close();  
        traveltext.setText(str);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccounantRefundQueriesSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccounantRefundQueriesSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("TourGuideDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }
    
}
