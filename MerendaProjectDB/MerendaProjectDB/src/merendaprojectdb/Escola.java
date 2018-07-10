/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

/**
 *
 * @author joycinha
 */
public class Escola {
    //header
    //private Image emblema ?????
    private String estado;
    private String prefeitura;
    private String distrito;
    private String secretaria; //ex secretaria municial de educacao
    private String subsecretaria;
    private String departamento;
    //dados
    private int INEP;
    private String diretoria;
    private String unidade;
    private String telefone;
    Escola(String estado, String prefeitura, String distrito, String secretaria, String subsecretaria, 
            String departamento, int INEP, String diretoria, String unidade, String telefone) {
        this.estado = estado;
        this.prefeitura = prefeitura;
        this.distrito = distrito;
        this.secretaria = secretaria;
        this.subsecretaria = subsecretaria;
        this.departamento = departamento;
        this.INEP = INEP;
        this.diretoria=diretoria;
        this.unidade = unidade;
        this.telefone = telefone;
    }
    public void changeEstado(String estado) {
        this.estado = estado;
    }
    public void changePrefeitura(String prefeitura) {
        this.prefeitura = prefeitura;
    }
    
    public void changeDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    public void changeSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }
    public void changeSubsecretaria(String subsecretaria) {
        this.subsecretaria = subsecretaria;
    }
    public void changeDepartamento(String departamento) {
        this.departamento = departamento;
    }  
    public void changeINEP(int inep) {
        this.INEP = inep;
    }
    
    public void changeDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }
    public void changeUnidade(String unidade) {
        this.unidade = unidade;
    }
    public void changeTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEstado() {
        return this.estado;
    }
    public String getPrefeitura() {
        return this.prefeitura;
    }
    public String getDistrito() {
        return this.distrito;
    }
    public String getSecretaria() {
        return this.secretaria;
    }
    public String getSubsecretaria() {
        return this.subsecretaria;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    public int getINEP() {
        return this.INEP;
    }
    public String getUnidade() {
        return this.unidade;
    }
    public String getDiretoria() {
        return this.diretoria;
    }
    public String getTelefone() {
        return this.telefone;
    }

}
