package com.hniu.entity.wrap;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页包装类
 */
public class PageWrap {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页的数量
     */
    private int pageSize;
    /**
     *当前页的数量
     */
    private int size;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 是否有前一页
     */
    private boolean hasPreviousPage;
    /**
     *是否有下一页
     */
    private boolean hasNextPage;
    /**
     * 数据
     */
    private List<Object> list;


    public PageWrap(PageInfo pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.pages = pageInfo.getPages();
        this.hasPreviousPage = pageInfo.isHasPreviousPage();
        this.hasNextPage = pageInfo.isHasNextPage();
        this.list = pageInfo.getList();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
