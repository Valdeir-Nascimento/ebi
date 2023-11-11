
package br.com.ebi.novo.api.entity;

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
@Table(name = "trabalho")
public class Trabalho implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "resumo", nullable = false)
    private String resumo;

    @Size(max = 150)
    @Column(name = "palavrasChave")
    private String palavrasChave;

    @JoinColumn(name = "atividade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Atividade atividade;

    @ManyToMany(mappedBy = "trabalhoList")
    private List<Financiador> financiadorList;

    @ManyToMany(mappedBy = "trabalhoList")
    private List<Autor> autorList;

}
