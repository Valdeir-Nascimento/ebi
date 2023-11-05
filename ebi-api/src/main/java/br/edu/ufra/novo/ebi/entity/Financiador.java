
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
@Table(name = "financiador")
public class Financiador implements Serializable {

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

    @JoinTable(name = "financiador_trabalho", joinColumns = {
            @JoinColumn(name = "financiador_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "trabalho_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Trabalho> trabalhoList;

    public Financiador(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Financiador(String nome) {
        this.nome = nome;
    }

}
