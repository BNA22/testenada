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
@Repository("CarroDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface CarroDAO extends JpaRepository<Carro, java.lang.String> {

  /**
   * Obtém a instância de Carro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Carro entity WHERE entity.id = :id")
  public Carro findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Carro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Carro entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM CarroPessoa entity WHERE entity.carro.id = :id")
  public Page<CarroPessoa> findCarroPessoa(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.pessoa FROM CarroPessoa entity WHERE entity.carro.id = :id")
  public Page<Pessoa> listPessoa(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM CarroPessoa entity WHERE entity.carro.id = :instanceId AND entity.pessoa.id = :relationId")
  public int deletePessoa(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

}
