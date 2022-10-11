/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.br.ifsul.controles;

import br.edu.ifsul.model.Empresa;
import br.edu.ifsul.model.Funcionario;
import edu.br.ifsul.dao.EmpresaDao;
import edu.br.ifsul.dao.FuncionarioDao;
import edu.br.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author igor.rocha
 */
@Named(value = "funcionarioControle")
@ViewScoped
public class FuncionarioControle implements Serializable{

    @EJB
    private FuncionarioDao<Funcionario> dao;
    private Funcionario objeto;
    
   @EJB
    private EmpresaDao<Empresa> daoEmpresa;
    
    public String listar(){
        return "/privado/funcionario/listar?faces-redirect=true";
    }
   public void novo() {
        objeto = new Funcionario();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: ");
        }
    }
    
    public void remover(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: ");
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
            Util.mensagemErro("Erro ao persistir objeto: ");
        }
    }

    public FuncionarioDao<Funcionario> getDao() {
        return dao;
    }

    public void setDao(FuncionarioDao<Funcionario> dao) {
        this.dao = dao;
    }

    public Funcionario getObjeto() {
        return objeto;
    }

    public void setObjeto(Funcionario objeto) {
        this.objeto = objeto;
    }

    public EmpresaDao<Empresa> getDaoEmpresa() {
        return daoEmpresa;
    }

    public void setDaoEmpresa(EmpresaDao<Empresa> daoEmpresa) {
        this.daoEmpresa = daoEmpresa;
    }
    
    
    
}
