/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

/**
 *
 * @author gdsm
 */
public class UsuarioDir {
    
    boolean canNewReport;
    boolean canWriteReport;
    boolean canWriteSchool;
    boolean canSeeReport;
    boolean canSeeSchool;
    boolean canWritePermit;
    boolean canAddUser;
    
    UsuarioDir(){
        canNewReport = true;
        canWriteReport = true;
        canSeeReport = true;
        canWriteSchool = false;
        canSeeSchool = true;
        canWritePermit = false;  
      canAddUser =false;
    }
    
    public void setNR(boolean m){
        canNewReport = m;
    }
    
    public void setWR(boolean m){
        canWriteReport = m;
    }
    
    public void setSR(boolean m){
        canSeeReport = m;
    }
    
    public void setWS(boolean m){
        canWriteSchool = m;
    }
    
    public void setSS(boolean m){
        canSeeSchool = m;
    }
    
    public void setWP(boolean m){
        canWritePermit = m;
    }
    
    
}
