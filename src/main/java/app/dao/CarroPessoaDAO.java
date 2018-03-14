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
@Repository("CarroPessoaDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface CarroPessoaDAO extends JpaRepository<CarroPessoa, java.lang.String> {

  /**
   * Obtém a instância de CarroPessoa utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM CarroPessoa entity WHERE entity.id = :id")
  public CarroPessoa findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de CarroPessoa utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM CarroPessoa entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select cp from CarroPessoa cp")
  public Page<CarroPessoa> list(Pageable pageable);
  


  /**
   * Foreign Key carro
   * @generated
   */
  @Query("SELECT entity FROM CarroPessoa entity WHERE entity.carro.id = :id")
  public Page<CarroPessoa> findCarroPessoasByCarro(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key pessoa
   * @generated
   */
  @Query("SELECT entity FROM CarroPessoa entity WHERE entity.pessoa.id = :id")
  public Page<CarroPessoa> findCarroPessoasByPessoa(@Param(value="id") java.lang.String id, Pageable pageable);

}
