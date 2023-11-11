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
@Table(name = "categoria_patrocinador")
public class CategoriaPatrocinador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "icone", nullable = false)
    private String icone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaPatrocinador")
    private List<Patrocinador> patrocinadorList;

    
}
