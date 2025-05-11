package com.hospital_mis.repository;

import com.hospital_mis.exception.ORMException;
import com.hospital_mis.exception.RecordNotFoundException;

import java.util.List;

public interface Repository<D> {
  /**
   * Retrieve entity identifiable by the provided @param~id
   * @param id - unique identifier for each entity in the database
   * @return <D> - returns a generic entity type inferred from class implementation
   */
  D findById(int id) throws ORMException, RecordNotFoundException;

  /**
   * Retrieves only available entities using the given @param~page as a slope to the offset func `f(page) = <system_limit> * (page -1) <=> page >= 1`.
   * System query load limit is set/read in/from the .env
   * @param page - it used to calculate query offset, i.e: how many items to skip before picking
   * @return List<D> - returns an immutable list of generic type inferred from class implementation
   */
  List<D> findAllByPage(int page) throws ORMException;

  /**
   * Retrieves all available entities
   * @return List<D> - returns an immutable list of generic type inferred from class implementation
   */
  List<D> findAll() throws ORMException;

  /**
   * @return a total number of contained entities
   */
  int count() throws ORMException;

  /**
   * It updates an existing entity record in the database
   * @param entity - an object with `id` as reference to an existing record to update and data changes to apply
   */
  boolean update(D entity) throws ORMException;

  /**
   * It deletes an existing entity record in the database
   * @param id - Reference to an existing entity record in the database
   */
  boolean destroy(int id) throws ORMException;

  /**
   * It creates a new entity record in the database & returns its unique identifier
   * @param entity - Holds with which to create a new entity, but not the `id` as it is automatically signed by db
   * @return unique identifier of the newly created entity record
   */
  int create(D entity) throws ORMException;
}
