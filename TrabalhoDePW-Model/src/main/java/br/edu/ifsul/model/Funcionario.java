/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author igor.rocha
 * @since 01/10/2022
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_funcionario", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @NotBlank(message = "Informe o nome")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Length(min = 11, message = "O cpf teve ter {min} digitos")
    @NotBlank(message = "Informe o cpf")
    @Column(name = "cpf",nullable = false,length = 11)
    private String cpf;
    
    @Length(min = 8,max = 8, message = "O RG teve der {min} digitos ")
    @NotBlank(message = "Informe o RG")
    @Column(name = "rg",length = 8, nullable = false)
    private String rg;
    
    @Temporal(TemporalType.DATE)	
    @Column(name = "nascimento")
    private Calendar dataNascimento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa",referencedColumnName = "id")
    private Empresa empresa;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
