/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.br.ifsul.dao;

import br.edu.ifsul.model.Empresa;
import edu.br.ifsul.converters.ConverterOrdem;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author igor.rocha
 */
@Stateful
public class EmpresaDao<TIPO> extends DaoGenerico<Empresa> implements Serializable{

    public EmpresaDao(){
        super();
        classePersistente = Empresa.class;
        
     listaOrdem.add(new Ordem("id", "ID","=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
             //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
