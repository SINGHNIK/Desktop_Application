package javafxapplication2;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import static javafxapplication2.DbConnection.Connect;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author nikhil
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<PatientDetail> tablefeedback;
    @FXML
    private TableView<PatientDetail> tablefeedback1;
    @FXML
    private TableColumn<PatientDetail, String> columnPID;
    @FXML
    private TableColumn<PatientDetail, String> columnP_VDate;
    @FXML
    private TableColumn<PatientDetail, String> columnP_NAME;
     @FXML
    private TableColumn<PatientDetail, String> columnP_Mob;
    @FXML
    private TableColumn<PatientDetail, String> columnP_ADDRESS;
    @FXML
    private TableColumn<PatientDetail, String> columnP_GENDER;
    @FXML
    private TableColumn<PatientDetail, Integer> columnP_AGE;
    @FXML
    private TableColumn<PatientDetail, String> columnP_PDR;
    private ObservableList<PatientDetail> data;
    private ObservableList<PatientDetail> data1;
    private DbConnection dc;

    
    //First List Generation
    @FXML
    public void loadDataFromDatabase(ActionEvent event) throws SQLException {
        try {

            data = FXCollections.observableArrayList();
            String date4 = ld1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM  feedback WHERE P_NextVisit='" + date4 +"' AND Q1 IS NULL");
            while (rs.next()) {
                data.add(new PatientDetail(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        columnPID.setCellValueFactory(new PropertyValueFactory<>("PID"));
        columnP_VDate.setCellValueFactory(new PropertyValueFactory<>("P_VDate"));
        columnP_NAME.setCellValueFactory(new PropertyValueFactory<>("P_Name"));
                columnP_Mob.setCellValueFactory(new PropertyValueFactory<>("P_Mob"));

        columnP_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("P_ADDRESS"));
        columnP_GENDER.setCellValueFactory(new PropertyValueFactory<>("P_GENDER"));
        columnP_AGE.setCellValueFactory(new PropertyValueFactory<>("P_AGE"));
        columnP_PDR.setCellValueFactory(new PropertyValueFactory<>("P_DR"));
        tablefeedback.setItems(null);
        tablefeedback.setItems(data);

    }
// Defination 
    public Connection conn = null;

    PreparedStatement pst = null;

    @FXML
    public DatePicker pvd, upvd, nxvd, ld1, dtsl, fr, to;
    @FXML
    public Button b1, b2, b3, b4, b5, b6, b8, b7, snp, snp3, snp1, snp2;
    @FXML
    public TextField pid, pname, pag,pmob, dr, rpid, rpname, rpag, rpgen, uid, upname, upadd, upag, dpid, moc, fpid, Q11, Q12, Q13, Q14, Q15, Q16, Q17, Q18,udr;
    @FXML
    public TextArea padd, pprob, rpadd, dptg,upr;
    @FXML
    public Label Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, lhi;
    @FXML
    public RadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9,
            radio10, radio11, radio12, radio13, radio14, radio15, radio16, radio17,
            radio18, radio19, radio20, radio21, radio22, radio23, radio24, radio25, radio26,
            radio27, radio28, radio29, radio30, radio31, radio32, radio33, radio34, radio35, radio36;
    public String radiov = null;
    public String radiov1 = null;
    public Integer radioq1 = null;
    public Integer radioq2 = null;
    public Integer radioq3 = null;
    public Integer radioq4 = null;
    public Integer radioq5 = null;
    public Integer radioq6 = null;
    public Integer radioq7 = null;
    public Integer radioq8 = null;
    public Integer radioq9 = null;
    public Hyperlink link; 
    public HostServicesDelegate hosted;

    // Initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn = DbConnection.Connect();

    }

    //Vertical Panal New Patient 
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("New Patient");
        app_stage.show();

    }
    
    //Vertical Panel Existing Patient

    @FXML
    private void handleButtonAction1(ActionEvent event) throws IOException {

       Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        
        app_stage.show();

    }

    //Vertical Panel Documentation
    
    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Doc.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
    //Vertical Panel list Generation

    @FXML
    private void handleButtonAction3(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("LG.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
     //Vertical Panel Feedback Generation

    @FXML
    private void handleButtonAction4(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Feedback.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

       /* Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String ins = "SELECT * FROM question";

        try {
            conn = Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ins);
            while (rs.next()) {

                String B1 = rs.getString("Q1");
                String B2 = rs.getString("Q2");
                String B3 = rs.getString("Q3");
                String B4 = rs.getString("Q4");
                String B5 = rs.getString("Q5");
                String B6 = rs.getString("Q6");
                String B7 = rs.getString("Q7");
                String B8 = rs.getString("Q8");

                Q1.setText(B1);
                Q2.setText(B2);
                Q3.setText(B3);
                Q4.setText(B4);
                Q5.setText(B5);
                Q6.setText(B6);
                Q7.setText(B7);
                Q8.setText(B8);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }*/
    }

    //Vertical Panel Lottery
        
    @FXML
    private void handleButtonAction5(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Lottery.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    
     //Vertical Panel Analysis

    @FXML
    private void handleButtonAction6(ActionEvent event) throws IOException {

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Analysis.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

     //Vertical Panel Admin
    
    @FXML
    private void handleButtonAction7(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void Question(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("QUESTION.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void List1(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void List2(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SL.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void FL(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FinalList.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void RST(ActionEvent event) throws IOException {

        pid.setText(null);
        pname.setText(null);
        padd.setText(null);
        pag.setText(null);
        pprob.setText(null);

    }

    @FXML
    private void SaveAndProceed1(ActionEvent event) throws SQLException, IOException {

        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String v = rpid.getText();

        String ins = "SELECT P_Name,P_ADDRESS,P_Age,P_GENDER FROM feedback WHERE PID ='" + v + "'";

        try {
            conn = Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ins);
            while (rs.next()) {

                String r1 = rs.getString("P_Name");
                String r2 = rs.getString("P_ADDRESS");
                String r3 = rs.getString("P_Age");
                String r4 = rs.getString("P_GENDER");

                rpname.setText(r1);
                rpadd.setText(r2);
                rpag.setText(r3);
                rpgen.setText(r4);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

    }

    @FXML
    private void up(ActionEvent event) throws SQLException, IOException {
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;

        String date1 = upvd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String v = rpid.getText();
        String v1 = upr.getText();
        String v2 = udr.getText();
        
        
        String insertTableSQL = " UPDATE feedback SET P_VDate = ? ,P_PROB = ?,P_Dr = ? WHERE PID='" + v + "'";

        try {
            conn = Connect();
            pstmt = conn.prepareStatement(insertTableSQL);

            pstmt.setString(1, date1);
            //  pstmt.setString(1,((TextField)pvd.getEditor()).getText());
            pstmt.setString(2,v1);
            pstmt.setString(3,v2);
            //pstmt.setString(3, v2);
            //pstmt.setInt(4, v3);
            //pstmt.setString(5, v4);
            pstmt.executeUpdate();
            System.out.println("Record is inserted into Feedback table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }
    }

    @FXML
    private void SaveAndProceed(ActionEvent event) throws SQLException, IOException {
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;

        String date = pvd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String v = pid.getText();
        String k = pmob.getText();
        String v1 = pname.getText();
        String v2 = padd.getText();
        Integer v3 = Integer.parseInt(pag.getText());
        String v4 = pprob.getText();
        if (radio1.isSelected()) {
            radiov = radio1.getText();
        }
        if (radio2.isSelected()) {
            radiov = radio2.getText();
        }
        String v5 = dr.getText();

        String insertTableSQL = "INSERT INTO feedback(PID,P_Name,P_Mob,P_ADDRESS,P_AGE,P_PROB,P_GENDER,P_Dr,P_VDate) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            conn = Connect();
            pstmt = conn.prepareStatement(insertTableSQL);
            pstmt.setString(1, v);
            pstmt.setString(2,v1);
            pstmt.setString(3, k);
            pstmt.setString(4, v2);
            pstmt.setInt(5, v3);
            pstmt.setString(6, v4);
            pstmt.setString(7, radiov);
            pstmt.setString(8, v5);
            pstmt.setString(9, date);
            pstmt.executeUpdate();

            System.out.println("Record is inserted into Feedback table!");
            
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }
    }

    @FXML
    private void SaveAndProceed3(ActionEvent event) throws SQLException, IOException {
        Statement stmtt = null;
        PreparedStatement pstmtt = null;

      
        String d1 = dpid.getText();
        String date2 = nxvd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String d2 = dptg.getText();

        //  if(radio3.isSelected()){
        //    radiov1 = radio3.getText();
        //}
        if (radio4.isSelected()) {
            radiov1 = radio4.getText();
        }

        String d3 = moc.getText();
        String insertTableSQL2 = " UPDATE feedback SET P_NextVisit=?, P_TREATMENT =?,P_FeedBackW=?,P_MC =? WHERE PID='" + d1 + "'";

        try {
            conn = Connect();
            pstmtt = conn.prepareStatement(insertTableSQL2);
            pstmtt.setString(1, date2);
            pstmtt.setString(2, d2);
            pstmtt.setString(3, radiov1);
            pstmtt.setString(4, d3);

            pstmtt.executeUpdate();

            System.out.println("Record is inserted into Feedback table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmtt != null) {
                pstmtt.close();
            }

            if (pstmtt != null) {
                pstmtt.close();
            }

        }
    }

    @FXML
    private void SAVEQ(ActionEvent event) throws SQLException, IOException {
        Statement stmtt = null;
        PreparedStatement pstmtt = null;

        // Integer vq = 1;
        //int vq = 1;
        //Integer v1 = Integer.parseInt(vq);
        String a0 = Q11.getText();
        String a1 = Q12.getText();
        String a2 = Q13.getText();
        String a3 = Q14.getText();
        String a4 = Q15.getText();
        String a5 = Q16.getText();
        String a6 = Q17.getText();
        String a7 = Q18.getText();

        String insertTableSQL3 = " UPDATE question SET Q1=?,Q2=?,Q3=?,Q4=?,Q5=?,Q6=?,Q7=?,Q8=?";

        try {
            conn = Connect();
            pstmtt = conn.prepareStatement(insertTableSQL3);
            pstmtt.setString(1, a0);
            pstmtt.setString(2, a1);
            pstmtt.setString(3, a2);
            pstmtt.setString(4, a3);
            pstmtt.setString(5, a4);
            pstmtt.setString(6, a5);
            pstmtt.setString(7, a6);
            pstmtt.setString(8, a7);
            pstmtt.executeUpdate();

            System.out.println("Record is inserted into Question table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmtt != null) {
                pstmtt.close();
            }

            if (pstmtt != null) {
                pstmtt.close();
            }

        }

    }

    @FXML
    private void qrf(ActionEvent event) throws SQLException, IOException {
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String ins = "SELECT * FROM question";

        try {
            conn = Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ins);
            while (rs.next()) {

                String B1 = rs.getString("Q1");
                String B2 = rs.getString("Q2");
                String B3 = rs.getString("Q3");
                String B4 = rs.getString("Q4");
                String B5 = rs.getString("Q5");
                String B6 = rs.getString("Q6");
                String B7 = rs.getString("Q7");
                String B8 = rs.getString("Q8");

                Q1.setText(B1);
                Q2.setText(B2);
                Q3.setText(B3);
                Q4.setText(B4);
                Q5.setText(B5);
                Q6.setText(B6);
                Q7.setText(B7);
                Q8.setText(B8);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

    }

    @FXML
    private void feedback(ActionEvent event) throws SQLException, IOException {
        Statement stmtt = null;
        PreparedStatement pstmtt = null;

        //Integer v6 = Integer.parseInt(fpid.getText());
        String v6 = fpid.getText();
        if (radio5.isSelected()) {
            radioq1 = 5;
        }
        if (radio6.isSelected()) {
            radioq1 = 4;
        }
        if (radio7.isSelected()) {
            radioq1 = 2;
        }
        if (radio8.isSelected()) {
            radioq1 = 1;
        }
        if (radio9.isSelected()) {
            radioq2 = 5;
        }
        if (radio10.isSelected()) {
            radioq2 = 4;
        }
        if (radio11.isSelected()) {
            radioq2 = 2;
        }
        if (radio12.isSelected()) {
            radioq2 = 1;
        }
        if (radio13.isSelected()) {
            radioq3 = 5;
        }
        if (radio14.isSelected()) {
            radioq3 = 4;
        }
        if (radio15.isSelected()) {
            radioq3 = 2;
        }
        if (radio16.isSelected()) {
            radioq3 = 1;
        }
        if (radio17.isSelected()) {
            radioq4 = 5;
        }
        if (radio18.isSelected()) {
            radioq4 = 4;
        }
        if (radio19.isSelected()) {
            radioq4 = 2;
        }
        if (radio20.isSelected()) {
            radioq4 = 1;
        }
        if (radio21.isSelected()) {
            radioq5 = 5;
        }
        if (radio22.isSelected()) {
            radioq5 = 4;
        }
        if (radio23.isSelected()) {
            radioq5 = 2;
        }
        if (radio24.isSelected()) {
            radioq5 = 1;
        }
        if (radio25.isSelected()) {
            radioq6 = 5;
        }
        if (radio26.isSelected()) {
            radioq6 = 4;
        }
        if (radio27.isSelected()) {
            radioq6 = 2;
        }
        if (radio28.isSelected()) {
            radioq6 = 1;
        }
        if (radio29.isSelected()) {
            radioq7 = 5;
        }
        if (radio30.isSelected()) {
            radioq7 = 4;
        }
        if (radio31.isSelected()) {
            radioq7 = 2;
        }
        if (radio32.isSelected()) {
            radioq7 = 1;
        }
        if (radio33.isSelected()) {
            radioq8 = 5;
        }
        if (radio34.isSelected()) {
            radioq8 = 4;
        }
        if (radio35.isSelected()) {
            radioq8 = 2;
        }
        if (radio36.isSelected()) {
            radioq8 = 1;
        }

        String insertTableSQL2 = " UPDATE feedback SET Q1=?,Q2=?,Q3=?,Q4=?,Q5=?,Q6=?,Q7=?,Q8=? WHERE PID='" + v6 + "'";

        try {
            conn = Connect();
            pstmtt = conn.prepareStatement(insertTableSQL2);
            pstmtt.setInt(1, radioq1);
            pstmtt.setInt(2, radioq2);
            pstmtt.setInt(3, radioq3);
            pstmtt.setInt(4, radioq4);
            pstmtt.setInt(5, radioq5);
            pstmtt.setInt(6, radioq6);
            pstmtt.setInt(7, radioq7);
            pstmtt.setInt(8, radioq8);

            pstmtt.executeUpdate();

            System.out.println("Record is inserted into Feedback table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (pstmtt != null) {
                pstmtt.close();
            }

            if (pstmtt != null) {
                pstmtt.close();
            }

        }

    }

    @FXML
    public void slb(ActionEvent event) throws IOException, SQLException {
        try {

            data = FXCollections.observableArrayList();
            String date4 = ld1.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM  feedback WHERE P_NextVisit='" + date4 +"' AND Q1 IS NOT NULL");
            while (rs.next()) {
                data.add(new PatientDetail(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        columnPID.setCellValueFactory(new PropertyValueFactory<>("PID"));
        columnP_VDate.setCellValueFactory(new PropertyValueFactory<>("P_VDate"));
        columnP_NAME.setCellValueFactory(new PropertyValueFactory<>("P_Name"));
        columnP_Mob.setCellValueFactory(new PropertyValueFactory<>("P_Mob"));
        columnP_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("P_ADDRESS"));
        columnP_GENDER.setCellValueFactory(new PropertyValueFactory<>("P_GENDER"));
        columnP_AGE.setCellValueFactory(new PropertyValueFactory<>("P_AGE"));
        columnP_PDR.setCellValueFactory(new PropertyValueFactory<>("P_DR"));
        tablefeedback.setItems(null);
        tablefeedback.setItems(data);

    }

    @FXML
    private void getlot(ActionEvent event) throws SQLException, IOException {

        Statement stmt = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String datef = fr.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String datet = to.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String ins = "SELECT PID FROM  feedback WHERE P_NextVisit BETWEEN '" + datef + "' AND '" + datet + "'AND Q1 IS NOT NULL ORDER BY RAND()";
        try {
            conn = Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ins);
            while (rs.next()) {

                String B1 = rs.getString("PID");
                lhi.setText(B1);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
           
            
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

        }

    }
   
    @FXML
    private void paytm(ActionEvent event) throws IOException{
        
        Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        
    }
}
    
    


