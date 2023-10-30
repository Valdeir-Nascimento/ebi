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
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "atividade")
public class Atividade implements Serializable {

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
    @Size(min = 1, max = 500)
    @Column(name = "resumo", nullable = false)
    private String resumo;

    @NotNull
    @Column(name = "inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;

    @NotNull
    @Column(name = "fim", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;

    @JoinColumn(name = "tipo_atividade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAtividade tipoAtividade;

    @JoinColumn(name = "sala", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sala sala;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade")
    private List<Trabalho> trabalhoList;

}
