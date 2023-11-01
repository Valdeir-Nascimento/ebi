package br.edu.ufra.novo.ebi.service;


import java.util.List;

/**
 * Interface génerica para um serviço de CRUD (Create, Read, Update, Delete)
 *
 * @param <S> O tipo de DTO usado para criar ou atualizar a entidade (Request).
 * @param <R> O tipo de DTO usado para representar a entidade em respostas (Response).
 */
public interface IBaseService<S, R> {

    /**
     * Lista todas as entidades do tipo T.
     *
     * @return Uma lista de DTOs que representam as entidades.
     */
    List<R> listarTodos();

    /**
     * Encontra uma entidade do tipo T por ID.
     *
     * @param id O ID da entidade a ser encontrada.
     * @return Um DTO que representa a entidade encontrada, se existir.
     */
    R buscarPorId(Integer id);

    /**
     * Cria uma nova entidade do tipo T com base no DTO de solicitação.
     *
     * @param request O DTO de solicitação que contém os dados da nova entidade.
     * @return Um DTO que representa a nova entidade criada.
     */
    R cadastrar(S request);

    /**
     * Atualiza uma entidade do tipo T com base no ID e no DTO de solicitação.
     *
     * @param id      O ID da entidade a ser atualizada.
     * @param request O DTO de solicitação que contém os dados atualizados.
     * @return Um DTO que representa a entidade atualizada, se a atualização for bem-sucedida.
     */
    R editar(Integer id, S request);

    /**
     * Exclui uma entidade do tipo T com base no ID.
     *
     * @param id O ID da entidade a ser excluída.
     */
    void excluir(Integer id);

}
