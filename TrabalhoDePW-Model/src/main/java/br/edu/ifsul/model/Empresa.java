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
import org.hibernate.validator.constraints.Length;

/**
 *  Classe entidade da tabela empressa
 * @author igor.rocha
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{
    
     @Id
    @SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_empresa", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotBlank(message = "É obrigadorio informar o nome")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "razaosocial")
    private String razaoSocial;
    
    @Length(min = 14, max = 14, message = "O cnpj teve ter 14 digitos")
    @NotBlank(message = "É obrigatorio informar o CNPJ")
    @Column(name = "cnpj", nullable = false,length = 14)
    private String cnpj;

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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}
