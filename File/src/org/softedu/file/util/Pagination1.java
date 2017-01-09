package org.softedu.file.util;

public class Pagination1 {
	 public Pagination1() {
	  }

	  public static String getPaginationScript1(int currPage,int pageNum,int recordNum,String url,String flag){

	    StringBuffer sb = new StringBuffer();

	    int RecordNum = recordNum;                       //总记录数
	    int StartRecord = 0;                             //开始的记录数
	    int EndRecord = 0;                               //结束的记录数
	    int PagesNum = 0;                                //总页数
	    int LineNum = pageNum;                           //每页显示的记录数
	    int CurrentPage = currPage;                      //当前页

	    if(RecordNum > 0){
	      PagesNum = (int) (RecordNum / LineNum);
	      if ( (RecordNum % LineNum) != 0)
	        PagesNum++;
	    }
	    StartRecord = CurrentPage * LineNum;
	    EndRecord = StartRecord + LineNum;
	    if(EndRecord > RecordNum)
	      EndRecord = RecordNum;

	    sb.append("共<font color=\"#3366CC\">"+(recordNum-1)+"</font>条记录");
	    sb.append("本页显示<font color=\"#3366CC\">"+((recordNum > 0) ? (StartRecord+1) : 0)+" - " + (EndRecord) + "</font>条");
	    sb.append("第<font color=\"#3333CC\">"+((recordNum > 0) ? (CurrentPage+1) : 0)+" / "+PagesNum+"</font>页");
	    if(CurrentPage == 0)
	    {
	      sb.append(" | 首页  上一页 ");
	    }
	    else
	    {
	      sb.append(
	          "|<a href="+url+"?flag="+flag+"&pages=0>首页 </a>");
	      sb.append("<a href="+url+"?flag="+flag+"&pages="+(CurrentPage-1)+"> 上一页 </a>");
	    }

	    if((CurrentPage+1) >= PagesNum)
	    {
	      sb.append(" 下一页  末页 |");
	    }
	    else
	    {
	      sb.append("<a href="+url+"?flag="+flag+"&pages="+ (CurrentPage+1)
	                 + ">下一页 </a>");
	      sb.append(
	          "<a href="+url+"?flag="+flag+"&pages="+(PagesNum-1)+ "> 末页 </a>|");
	    }


	    return sb.toString();
	  }

}