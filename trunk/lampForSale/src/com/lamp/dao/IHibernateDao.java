package com.lamp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.lamp.util.PageInfo;


public interface IHibernateDao {

	/**
	 * ���棨�־û���һ������
	 * 
	 * @param object
	 *            Ҫ����Ķ���
	 */
	public void save(Object object) throws DataAccessException;

	/**
	 * ����һ������
	 * 
	 * @param object
	 *            Ҫ�޸ĵĶ���
	 */
	public void update(Object object) throws DataAccessException;

	/**
	 * �������¼�¼
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @param parameters
	 *            ����
	 */
	public void updateByQuery(final String queryString,
			final Object[] parameters) throws DataAccessException;

	/**
	 * ɾ��һ������
	 * 
	 * @param object
	 *            Ҫɾ���Ķ���
	 */
	public void delete(Object object) throws DataAccessException;

	/**
	 * �������ͺͶ���idɾ��һ������
	 * 
	 * @param clazz
	 *            ����
	 * @param id
	 *            ����id
	 */
	public void delete(Class clazz, Serializable id) throws DataAccessException;

	/**
	 * ��������ɾ��ȫ������
	 * 
	 * @param clazz
	 *            ����
	 * @return Integer
	 */
	public Integer deleteAll(final Class clazz) throws DataAccessException;

	/**
	 * ���ݲ�ѯ�Ͳ���ɾ��ȫ������
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @param parameters
	 *            ����
	 * @return Integer
	 */
	public Integer deleteByQuery(final String queryString,
			final Object[] parameters) throws DataAccessException;

	/**
	 * ���ĳ�����͵�ȫ�������б�
	 * 
	 * @param clazz
	 *            ����
	 * @return ���󼯺�
	 */
	public List findAll(Class clazz) throws DataAccessException;

	/**
	 * �������ͺͶ���id����һ������
	 * 
	 * @param clazz
	 *            ����
	 * @param id
	 *            ����id
	 * @return Ŀ�����
	 */
	public Object load(Class clazz, Serializable id) throws DataAccessException;

	/**
	 * �������ͺͶ���id�����ݿ�ȡ��һ������
	 * 
	 * @param clazz
	 *            ��
	 * @param id
	 *            ����id
	 * @return Ŀ�����
	 */
	public Object get(Class clazz, Serializable id) throws DataAccessException;

	/**
	 * ���ݲ�ѯ���Ͳ�ѯ���������ݿ�ȡ��һ������
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @param parameters
	 *            ����
	 * @return Object ��������
	 */
	public Object get(final String queryString, final Object[] parameters)
			throws DataAccessException;

	/**
	 * ������ѯ
	 * 
	 * @param queryName
	 *            ������ѯ���
	 * @return �����б�
	 */
	public List findByNamedQuery(final String queryName)
			throws DataAccessException;

	/**
	 * ���ݵ���������������ѯ
	 * 
	 * @param query
	 *            ������ѯ���
	 * @param parameter
	 *            ������ѯ����
	 * @return �����б�
	 */
	public List findByNamedQuery(final String queryString,
			final Object parameter) throws DataAccessException;

	/**
	 * ���ݲ���������������ѯ
	 * 
	 * @param query
	 *            ������ѯ���
	 * @param parameters
	 *            ��ѯ��������
	 * @return �����б�
	 */
	public List findByNamedQuery(final String queryString,
			final Object[] parameters) throws DataAccessException;

	/**
	 * ��ѯȫ��
	 * 
	 * @param query
	 *            ��ѯ���
	 * @return �����б�
	 */
	public List find(final String queryString) throws DataAccessException;

	/**
	 * ��������ѯȫ��
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @param parameters
	 *            ��ѯ����
	 * @return �����б�
	 */
	public List find(final String queryString, final Object[] parameters)
			throws DataAccessException;

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param queryString
	 *            ��ѯ���
	 * @param parameters
	 *            ����
	 * @param pageInfo
	 *            ��ҳ��Ϣ
	 * @return List �����б�
	 */
	public List findPageByQuery(final String queryString,
			final Object[] parameters, final PageInfo pageInfo)
			throws DataAccessException;

}
