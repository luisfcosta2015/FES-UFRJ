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
public class Permissoes {
    public boolean canNewReport;
    public boolean canWriteReport;
    public boolean canWriteSchool;
    public boolean canSeeReport;
    public boolean canSeeSchool;
    public boolean canWritePermit;
    public boolean canAddUser;
    
    /*public Permissoes(boolean newReport, boolean writeReport, boolean writeSchool,
            boolean seeReport, boolean seeSchool, boolean writePermit, boolean addUser){*/
    public Permissoes(){
        canNewReport = true;
        canWriteReport = true;
        canSeeReport = true;
        canWriteSchool = false;
        canSeeSchool = true;
        canWritePermit = false;  
        canAddUser =false;
    }
    
    public void canNewReport(boolean m){
        canNewReport = m;
    }
    
    public void canWriteReport(boolean m){
        canWriteReport = m;
    }
    
    public void canSeeReport(boolean m){
        canSeeReport = m;
    }
    
    public void canWriteSchool(boolean m){
        canWriteSchool = m;
    }
    
    public void canSeeSchool(boolean m){
        canSeeSchool = m;
    }
    
    public void canWritePermit(boolean m){
        canWritePermit = m;
    }
    
    public void canAddUser(boolean m){
        canAddUser = m;
    }
}
