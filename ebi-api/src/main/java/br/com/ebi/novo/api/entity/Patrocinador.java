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


@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "patrocinador")
public class Patrocinador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "site", nullable = false)
    private String site;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "logomarca", nullable = false)
    private String logomarca;

    @JoinColumn(name = "categoria_patrocinador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriaPatrocinador categoriaPatrocinador;

}
