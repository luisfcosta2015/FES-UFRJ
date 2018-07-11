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
public class TiposDeUsuario {
    
    private Permissoes dir;
    private Permissoes leitor;
    private Permissoes adm;
    
    public TiposDeUsuario(){
        //aqui tenho que usar o banco
        boolean canNewReport;
        boolean canWriteReport;
        boolean canSeeReport;
        boolean canWriteSchool;
        boolean canWritePermit;
        boolean canAddUser;
        boolean canSetPadrao;
        
        if( dir == null ) {
            dir = new Permissoes();
            canNewReport=BdManager.getPermissoes("Diretor", "canNewReport");
            canWriteReport = BdManager.getPermissoes("Diretor", "canWriteReport");
            canSeeReport = BdManager.getPermissoes("Diretor", "canSeeReport");
            canWriteSchool = BdManager.getPermissoes("Diretor", "canWriteSchool");
            canWritePermit = BdManager.getPermissoes("Diretor", "canWritePermit");
            canAddUser = BdManager.getPermissoes("Diretor", "canAddUser");
            canSetPadrao = BdManager.getPermissoes("Diretor", "canSetPadrao");
            
            setPermissoesDir(canNewReport, canWriteReport, canSeeReport, canWriteSchool, canWritePermit, canAddUser,canSetPadrao);
        }
        if( adm == null ) {
            adm = new Permissoes();
            canNewReport=BdManager.getPermissoes("Admin", "canNewReport");
            canWriteReport = BdManager.getPermissoes("Admin", "canWriteReport");
            canSeeReport = BdManager.getPermissoes("Admin", "canSeeReport");
            canWriteSchool = BdManager.getPermissoes("Admin", "canWriteSchool");
            canWritePermit = BdManager.getPermissoes("Admin", "canWritePermit");
            canAddUser = BdManager.getPermissoes("Admin", "canAddUser");
            canSetPadrao = BdManager.getPermissoes("Admin", "canSetPadrao");
            
            setPermissoesAdm(canNewReport, canWriteReport, canSeeReport, canWriteSchool, canWritePermit, canAddUser,canSetPadrao);
        }
        if( leitor == null ) {
            leitor = new Permissoes();
            canNewReport=BdManager.getPermissoes("Leitor", "canNewReport");
            canWriteReport = BdManager.getPermissoes("Leitor", "canWriteReport");
            canSeeReport = BdManager.getPermissoes("Leitor", "canSeeReport");
            canWriteSchool = BdManager.getPermissoes("Leitor", "canWriteSchool");
            canWritePermit = BdManager.getPermissoes("Leitor", "canWritePermit");
            canAddUser = BdManager.getPermissoes("Leitor", "canAddUser");
            canSetPadrao = BdManager.getPermissoes("Leitor", "canSetPadrao");
            
            setPermissoesLeitor(canNewReport, canWriteReport, canSeeReport, canWriteSchool, canWritePermit, canAddUser,canSetPadrao);
        } 
    }
    
    public void setPermissoesAdm(boolean newReport, boolean writeReport, boolean seeReport, boolean writeSchool, 
            boolean writePermit,boolean addUser, boolean setPadrao){
        adm.canNewReport(newReport);
        adm.canWriteReport(writeReport);
        adm.canSeeReport(seeReport);
        adm.canWriteSchool(writeSchool);
        adm.canWritePermit(writePermit);
        adm.canAddUser(addUser); 
        adm.canSetPadrao(setPadrao);
    }
    
    public Permissoes getAdmPermits(){
        return adm;
    }
    
    public void setPermissoesLeitor(boolean nr, boolean wr, boolean sr, boolean ws, 
            boolean wp, boolean au, boolean setPadrao){
        leitor.canNewReport(nr);
        leitor.canWriteReport(wr);
        leitor.canSeeReport(sr);
        leitor.canWriteSchool(ws);
        leitor.canWritePermit(wp);  
        leitor.canAddUser(au);
        leitor.canSetPadrao(setPadrao);
    }
    
    public Permissoes getLeitorPermits(){
        return leitor;
    }
    
    public void setPermissoesDir(boolean nr, boolean wr, boolean sr, boolean ws, 
            boolean wp, boolean au, boolean setPadrao){
        dir.canNewReport(nr);
        dir.canWriteReport(wr);
        dir.canSeeReport(sr);
        dir.canWriteSchool(ws);
        dir.canWritePermit(wp);  
        dir.canAddUser(au);
        dir.canSetPadrao(setPadrao);
    }
    
    public Permissoes getDirPermits(){
        return dir;
    }
}
