
package edu.br.ifsul.dao;


import br.edu.ifsul.model.Funcionario;
import edu.br.ifsul.converters.ConverterOrdem;
import java.io.Serializable;

/**
 *
 * @author igor.rocha
 */
public class FuncionarioDao<TIPO> extends DaoGenerico<Funcionario> implements Serializable{

    public FuncionarioDao(){
        super();
        classePersistente = Funcionario.class;
        
     listaOrdem.add(new Ordem("id", "ID","=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
             //definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}