package com.qf.pansidong.pojo.vo;

import java.util.List;

public class PageVo<T> {
    //当前页
    private int currentPage;
    //每页的条数
    private int pageSize;
    //信息总数
    private int totalNum;
    //总页数
    private int totalPage;
    //每页的信息
    private List<T> listData;
    //偏移量
    private int offset;

    public int getOffset() {
        return (currentPage-1)*pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return (totalNum+pageSize-1)/pageSize;
}

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
