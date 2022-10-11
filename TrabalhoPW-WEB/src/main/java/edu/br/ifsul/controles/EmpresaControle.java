/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.br.ifsul.controles;

import br.edu.ifsul.model.Empresa;
import edu.br.ifsul.dao.EmpresaDao;
import edu.br.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author igor.rocha
 */
@Named(value = "empresaControle")
@ViewScoped
public class EmpresaControle implements Serializable{

    @EJB
    private EmpresaDao<Empresa> dao;
    private Empresa objeto;
    
    public String listar(){
        return "/privado/empresa/listar?faces-redirect=true";
    }
   public void novo() {
        objeto = new Empresa();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "
                    + Util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "
                    + Util.getMensagemErro(e));
        }
    } 
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + 
                    Util.getMensagemErro(e));
        }
    }

    public EmpresaDao<Empresa> getDao() {
        return dao;
    }

    public void setDao(EmpresaDao<Empresa> dao) {
        this.dao = dao;
    }

    public Empresa getObjeto() {
        return objeto;
    }

    public void setObjeto(Empresa objeto) {
        this.objeto = objeto;
    }
    
}
