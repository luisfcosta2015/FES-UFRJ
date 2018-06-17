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
        setPermissoesAdm(true, true, true, true, true, true, true);
        setPermissoesLeitor(false, false, true, false, true, false, false);
        setPermissoesDir(true, true, true, false, true, false, false);
    }
    
    public void setPermissoesAdm(boolean nr, boolean wr, boolean sr, boolean ws, 
            boolean ss, boolean wp, boolean au){
        adm.canNewReport(nr);
        adm.canWriteReport(wr);
        adm.canSeeReport(sr);
        adm.canWriteSchool(ws);
        adm.canSeeSchool(ss);
        adm.canWritePermit(wp);
        adm.canAddUser(au);       
    }
    
    public Permissoes getAdmPermits(){
        return adm;
    }
    
    public void setPermissoesLeitor(boolean nr, boolean wr, boolean sr, boolean ws, 
            boolean ss, boolean wp, boolean au){
        leitor.canNewReport(nr);
        leitor.canWriteReport(wr);
        leitor.canSeeReport(sr);
        leitor.canWriteSchool(ws);
        leitor.canSeeSchool(ss);
        leitor.canWritePermit(wp);  
        leitor.canAddUser(au);
    }
    
    public Permissoes getLeitorPermits(){
        return leitor;
    }
    
    public void setPermissoesDir(boolean nr, boolean wr, boolean sr, boolean ws, 
            boolean ss, boolean wp, boolean au){
        dir.canNewReport(nr);
        dir.canWriteReport(wr);
        dir.canSeeReport(sr);
        dir.canWriteSchool(ws);
        dir.canSeeSchool(ss);
        dir.canWritePermit(wp);  
        dir.canAddUser(au);
    }
    
    public Permissoes getDirPermits(){
        return dir;
    }
}
