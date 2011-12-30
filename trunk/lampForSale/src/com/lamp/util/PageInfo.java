package com.lamp.util;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * �����ƣ�     PageInfo   
 * ��������    ͨ�÷�ҳ��Ϣ�࣬���ڳ��ط�ҳ��Ϣ
 *
 */
@DataTransferObject(javascript="PageInfo")
public class PageInfo {
	
	/**
	  * ��ҳ��
	  */
	 private int totalPage = 1;

	 /**
	  * ǰһҳ
	  */
	 private int prePage = 1;

	 /**
	  * ��һҳ
	  */
	 private int nextPage = 1;

	 /**
	  * �ܼ�¼��
	  */
	 private int totalRec = 0;

	 /**
	  * Ĭ��ÿҳ��¼��
	  */
	 private final int defaultPageSize = 9;

	 /**
	  * ÿҳ��¼��
	  */
	 private int pageSize = defaultPageSize;

	 /**
	  * ��ǰҳ��
	  */
	 private int pageIndex = 1;

	 /**
	  * ȫ��ҳ�룬��1��ʼ
	  */
	 private int[] pageNumbers;

	 public int getPageIndex() {
	  return pageIndex;
	 }

	 public void setPageIndex(int pageIndex) {
	  this.pageIndex = pageIndex > 0 ? pageIndex : 1;
	 }

	 public int getNextPage() {
	  return nextPage;
	 }

	 public void setNextPage(int nextPage) {
	  this.nextPage = nextPage > this.totalPage ? this.totalPage : nextPage;
	 }

	 public int getPageSize() {
	  return pageSize;
	 }

	 public void setPageSize(int pageSize) {
	  this.pageSize = pageSize > 0 ? pageSize : 9;
	 }

	 public int getPrePage() {
	  return prePage;
	 }

	 public void setPrePage(int prePage) {
	  this.prePage = prePage < 1 ? 1 : prePage;
	 }

	 public int getTotalPage() {
	  return totalPage;
	 }

	 public void setTotalPage(int totalPage) {
	  this.totalPage = totalPage > 0 ? totalPage : 1;
	 }

	 public int getTotalRec() {
	  return totalRec;
	 }

	 public void setTotalRec(int totalRec) {
	  this.totalRec = totalRec > -1 ? totalRec : 0;
	 }

	 public int[] getPageNumbers() {
	  return pageNumbers;
	 }

	 public void setPageNumbers(int[] pageNumbers) {
	  this.pageNumbers = pageNumbers;
	 }

}