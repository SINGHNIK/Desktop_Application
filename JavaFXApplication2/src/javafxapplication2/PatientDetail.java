/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nikhil
 */
public class PatientDetail {

    private final StringProperty PID;
    private final StringProperty P_VDate;
    private final StringProperty P_Name;
    private final StringProperty P_ADDRESS;
    private final StringProperty P_GENDER;
    private final IntegerProperty P_AGE;
    private final StringProperty P_DR;
    private final StringProperty P_Mob;
    

    //Default Constructor
    public PatientDetail(String PID,String P_VDate, String P_Name,String P_Mob, String P_ADDRESS,String P_GENDER,Integer P_AGE,String P_DR) {
        this.PID =new SimpleStringProperty(PID);
        this.P_VDate = new SimpleStringProperty(P_VDate);
        this.P_Name = new SimpleStringProperty(P_Name);  
        this.P_ADDRESS = new SimpleStringProperty(P_ADDRESS);
        this.P_GENDER = new SimpleStringProperty(P_GENDER);
        this.P_AGE = new SimpleIntegerProperty(P_AGE);
        this.P_DR = new SimpleStringProperty(P_DR); 
        this.P_Mob = new SimpleStringProperty(P_Mob); 
    }

    //Getters
    
    
    
    public String getId(){
        return PID.get();
    }
    
        
    public String getDate() {
        return P_VDate.get();
    }
    
    public String getName() {
        return P_Name.get();
    }
     public String getMob() {
        return P_Mob.get();
    }

    public String getADDRESS() {
        return P_ADDRESS.get();
    }

    public String getGENDER() {
        return P_GENDER.get();
    }
     public Integer getAGE(){
        return P_AGE.get();
    }
      public String getDR(){
        return P_DR.get();
    }
    
    

    //Setters
    public void setPID(String value){
        PID.set(value);
    }
     public void setP_VDate(String value) {
        P_VDate.set(value);
    }
    public void setP_Name(String value) {
        P_Name.set(value);
    }
    
        public void setP_Mob(String value) {
        P_Mob.set(value);
    }

    public void setP_ADDRESS(String value) {
        P_ADDRESS.set(value);
    }

    public void setP_GENDER(String value) {
        P_GENDER.set(value);
    }
     public void setP_AGE(Integer value){
        P_AGE.set(value);
    }
    public void setP_DR(String value){
        P_DR.set(value);
    }
    
    //Property value
    
    public StringProperty PIDProperty(){
        return PID;
    }
    public StringProperty P_VDateProperty(){
        return P_VDate;
    }
    public StringProperty P_NameProperty(){
        return P_Name;
    }
      public StringProperty P_MobProperty(){
        return P_Mob;
    }
    public StringProperty P_ADDRESSProperty(){
        return P_ADDRESS;
    }
    public StringProperty P_GENDERProperty(){
        return P_GENDER;
    }
    public IntegerProperty P_AGEProperty(){
        return P_AGE;
    }
     public StringProperty P_DRProperty(){
        return P_DR;
    }
}
