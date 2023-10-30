/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.novo.ebi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "autor")
public class Autor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Size(max = 50)
    @Column(name = "abreviado")
    private String abreviado;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instituicao", nullable = false)
    private String instituicao;

    @JoinTable(name = "trabalho_autor", joinColumns = {
            @JoinColumn(name = "autor_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "trabalho_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Trabalho> trabalhoList;


}
