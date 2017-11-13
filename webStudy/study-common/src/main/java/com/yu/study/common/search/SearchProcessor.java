package com.yu.study.common.search;

public interface SearchProcessor {
	/**根据条件查找,如果忽略无效的查询条件，则该无效条件不参与查询,如果不忽略,则抛出异常
	 * @param searchWrapper
	 * @param ignoreNoEffectCondition 是否忽略无效的查询条件
	 * @return 
	 */
//	public SearchWrapper searchByConditions(SearchWrapper searchWrapper,boolean ignoreNoEffectCondition);
	/**根据条件查找
	 * @param searchWrapper
	 * @return 
	 */
	public SearchWrapper searchByConditions(SearchWrapper searchWrapper,String orderByCondition);
	/**根据条件删除
	 * @param searchWrapper
	 */
	public void deleteByConditions(SearchWrapper searchWrapper);
}
