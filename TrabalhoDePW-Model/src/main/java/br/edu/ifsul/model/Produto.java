/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author igor.rocha
 */

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    
     @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotBlank(message = "Informe o nome")
    @Column(name ="nome",nullable = false)
    private String nome;
    
    @NotBlank(message = "Informe o preco de custo")
    @Column(name="precocusto",nullable = false)
    private String precoCusto;
    
    @NotBlank(message = "Informe o preco de venda")
    @Column(name = "precovenda", nullable = false)
    private String precoVenda;
    
    @Length(min = 5, max = 10, message = "O codigo de barra deve der no minimo {min} digitos e no maximo {max} digitos")
    @NotBlank(message = "Informe o codigo de barra do produto")
    @Column(name = "codigoDeBarra", length = 10)
    private String codigoDeBarra;

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(String precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
