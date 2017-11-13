package com.yu.study.common.web;

/**
 * 分页数据
 */
public class Page{
	private int pageNo = 1;			//页码，默认是第一页
    private int pageSize = 3;		//每页显示的记录数，默认是10
    private int totalRecord;		//总记录数
    private int totalPage;			//总页数
 
    public int getPageNo() {
       return pageNo;
    }
 
    public void setPageNo(int pageNo) {
       this.pageNo = pageNo;
    }
 
    public int getPageSize() {
       return pageSize;
    }
 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
    }
 
    public int getTotalRecord() {
       return totalRecord;
    }
 
    public void setTotalRecord(int totalRecord) {
       this.totalRecord = totalRecord;
       //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
       this.setTotalPage(totalPage);
    }
 
    public int getTotalPage() {
       return totalPage;
    }
 
    public void setTotalPage(int totalPage) {
       this.totalPage = totalPage;
    }
 
	/* 页面链接 */
	public String pageLinks(String url) {
		int endPage = this.totalRecord/pageSize +1;
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append("<input type=\"hidden\" name=\"pageNo\" value=\"").append(this.pageNo).append("\">");		//分页参数：当前页隐藏域
		
		sBuf.append("<span class=\"noprint\" style=\"padding:5px;\">");

		sBuf.append("&nbsp;第").append(this.pageNo).append("页 / 共").append(endPage).append("页&nbsp;");
		sBuf.append("&nbsp;总共").append(this.totalRecord).append("条记录 每页").append(this.pageSize).append("条记录&nbsp;");
		
		sBuf.append("<a href=\"").append(url).append("?pageNo=1");
		sBuf.append("\">[首页]");
		sBuf.append("</a>&nbsp;");
		
		sBuf.append("<a href=\"").append(url).append("?pageNo=");
		if(pageNo<=1){
			sBuf.append(1);
		}else{
			sBuf.append(pageNo-1);
		}	
		sBuf.append("\">[上一页]");
		sBuf.append("</a>&nbsp;");
			
		
		sBuf.append("<a href=\"").append(url).append("?pageNo=");
		if(pageNo>=endPage){
			sBuf.append(endPage);
		}else{
			sBuf.append(pageNo+1);
		}	
		sBuf.append("\">[下一页]");
		sBuf.append("</a>&nbsp;");
			
		sBuf.append("<a href=\"").append(url).append("?pageNo=").append(endPage);
		sBuf.append("\">[末页]");
		sBuf.append("</a>&nbsp;");

		sBuf.append("</span>");
		
		return sBuf.toString();
	}

}