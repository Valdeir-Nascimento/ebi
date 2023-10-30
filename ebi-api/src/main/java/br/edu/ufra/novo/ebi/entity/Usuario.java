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


@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome", nullable = false)
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email", nullable = false)
    private String email;


    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "celular", nullable = false)
    private String celular;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senha", nullable = false)
    private String senha;

}
