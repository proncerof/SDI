package uo.sdi.persistence.util;

import java.util.List;

import uo.sdi.business.exception.BusinessException;

/**
 * Generic interface for all types of Dao
 * 
 * @author alb
 * 
 * @param <T>, the type of the object sent or retrieved from a row in a table
 * @param <K>, the type of the key in the table (may be composed)
 */
public interface GenericDao<T, K> {

	/**
	 * Saves a DTO to a table row and returns the generated key, if any
	 * 
	 * @param dto
	 * @return The persisted dto
	 */
	T save(T dto);

	/**
	 * Updates a table row with data from a DTO
	 * 
	 * @param dto
	 * @return The persisted dto
	 */
	T update(T dto);

	/**
	 * Deletes a table row with the K id key
	 * 
	 * @param K
	 *            key in the table
	 * @return The removed dto
	 * @throws BusinessException 
	 */
	T delete(K id) throws BusinessException;

	T findById(K id);

	List<T> findAll();

}
