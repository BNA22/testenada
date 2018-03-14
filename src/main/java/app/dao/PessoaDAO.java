package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("PessoaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PessoaDAO extends JpaRepository<Pessoa, java.lang.String> {

  /**
   * Obtém a instância de Pessoa utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Pessoa entity WHERE entity.id = :id")
  public Pessoa findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Pessoa utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Pessoa entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM CarroPessoa entity WHERE entity.pessoa.id = :id")
  public Page<CarroPessoa> findCarroPessoa(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.carro FROM CarroPessoa entity WHERE entity.pessoa.id = :id")
  public Page<Carro> listCarro(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM CarroPessoa entity WHERE entity.pessoa.id = :instanceId AND entity.carro.id = :relationId")
  public int deleteCarro(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

}
