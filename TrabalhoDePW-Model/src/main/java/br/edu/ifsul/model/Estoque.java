/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsul.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor.rocha
 */
@Entity
@Table(name = "estoque")
public class Estoque implements Serializable{

     @Id
    @SequenceGenerator(name = "seq_estoque", sequenceName = "seq_estoque_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_estoque", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotNull(message = "Informe a quantidade do produto") 
    @Column(name = "quantidade", nullable = false) 
    private BigDecimal quantidade;
    
    @NotNull(message = "Informe o produto que sera armazenado")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
    private Produto produto;
    
    @NotNull(message = "Informe o local que sera armazenado o produto")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almoxarifado", referencedColumnName = "id", nullable = false)
    private Almoxarifado almoxarifado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Estoque other = (Estoque) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
