
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


@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tipo_atividade")
public class TipoAtividade implements Serializable {

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
    @Column(name = "listar_palestrantes", nullable = false)
    private Boolean listarPalestrantes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAtividade")
    private List<Atividade> atividadeList;

    public TipoAtividade(Integer id, String nome, Boolean listarPalestrantes) {
        this.id = id;
        this.nome = nome;
        this.listarPalestrantes = listarPalestrantes;
    }

    public TipoAtividade(String nome, Boolean listarPalestrantes) {
        this.nome = nome;
        this.listarPalestrantes = listarPalestrantes;
    }

}
