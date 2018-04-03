/**
 * 
 */
package com.z.m.ops.modules.common;

import java.util.List;

/**
 * @author sunff
 * @param <K>
 *
 */
public interface PageBaseDao<T, K> extends BaseDao<T, K> {
	
	List<T> findList(T invoice);
}
