package org.softedu.file.util;

import java.util.ArrayList;
import java.util.List;

import org.softedu.file.bean.User;

public class CurrentPage {
	
	private List<User> totalList;
	private int pageRows = 2;//ҳ����������
	private int totalRows;//��������
	private int currentPage;//��ǰҳ
	private int totalPages;//ҳ������
	private boolean hasPreviousPage;//�Ƿ�����һҳ
	private boolean hasNextPage;//�Ƿ�����һҳ
	private int pageStartRow;//��ʼ��
	private int pageEndRow;//������
	
	public void initPageBean(List<User> totalList, int pageRows) {
		this.totalList=totalList;
        this.pageRows=pageRows;
        this.totalRows=totalList.size();
        this.currentPage=1;
        if(totalRows%pageRows == 0) {
        	totalPages = totalRows/pageRows;
        	if(this.totalRows == 0) {
        		this.pageRows = 0;
        	}
        } else {
        	totalPages = totalRows/pageRows + 1;
        }
        
        /**
         * 
         * */
        this.hasPreviousPage = false;
        if(currentPage  == totalPages) {
        	hasNextPage = false;
        } else {
        	hasNextPage = true;
        }
        this.pageStartRow = 1;
        if(totalRows < pageRows) {
        	this.pageEndRow = totalRows;
        } else {
        	this.pageEndRow = pageRows;
        }
	}
	
	//��ǰҳ
	public List<User> getCurrentPageList() {
		
		
		if(currentPage * pageRows < totalRows) {
			pageEndRow = currentPage * pageRows;
			pageStartRow = pageEndRow - pageRows;
		} else {
			pageEndRow = totalRows;
			pageStartRow = pageRows * (totalPages - 1);
		}
		List<User> pageList = new ArrayList<User>(pageEndRow - pageStartRow +1);//����һ������ָ�����ȵĿ��б�
		if(totalRows != 0) {
			for(int i=pageStartRow; i<pageEndRow; i++) {
				pageList.add(totalList.get(i));
			}
		}
		return pageList;
	}
	//��һҳ
	public List<User> getPreviousPageList() {
		currentPage = currentPage - 1;
		if(currentPage < 1) {
			currentPage = 1;
		}
		if(currentPage >= totalPages) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		} 
		if(currentPage > 1) {
			hasPreviousPage = true;
		} else {
			hasPreviousPage = false;
		}
		List<User> pageList = this.getCurrentPageList();
		return pageList;
	}
	
	//��һҳ
	public List<User> getNextPageList() {
		currentPage = currentPage +1;
		if(currentPage > totalPages) {
			currentPage = totalPages;
		}
		if(currentPage > 1) {
			hasPreviousPage = true;
		} else {
			hasPreviousPage = false;
		}
		if(currentPage >= totalPages) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}
		List<User> pageList = this.getCurrentPageList();
		return pageList;
	}

	public List<User> getTotalList() {
		return totalList;
	}

	public int getPageRows() {
		return pageRows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public int getPageStartRow() {
		return pageStartRow;
	}

	public int getPageEndRow() {
		return pageEndRow;
	}
	
}
