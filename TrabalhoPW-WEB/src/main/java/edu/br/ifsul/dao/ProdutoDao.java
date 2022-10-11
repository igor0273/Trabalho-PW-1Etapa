/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.br.ifsul.dao;

import br.edu.ifsul.model.Funcionario;
import br.edu.ifsul.model.Produto;
import edu.br.ifsul.converters.ConverterOrdem;
import java.io.Serializable;

/**
 *
 * @author igor.rocha
 */
public class ProdutoDao <TIPO> extends DaoGenerico<Produto> implements Serializable{

    public ProdutoDao(){
        super();
        classePersistente = Produto.class;
        
     listaOrdem.add(new Ordem("id", "ID","=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
             //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}