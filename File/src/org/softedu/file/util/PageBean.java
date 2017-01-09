package org.softedu.file.util;

public class PageBean {


	int currPage;  //当前页
	int pageNum;  //每页数量
	static int recordNum;  //总数

    public PageBean() {
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int sample) {
        this.currPage = sample;
    }


	 public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int sample) {
        this.pageNum = sample;
    }

     public static int getRecordNum() {
        return recordNum;
    }

    public static void setRecordNum(int sample) {
        recordNum = sample;
    }

}
