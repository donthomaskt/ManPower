/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.manpower.vo;

import java.io.Serializable;

/**
 *
 * @author DON THOMAS
 */
public class PageObject implements Serializable{
    private String page;
    private  String strResId;

    /**
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * @return the strResId
     */
    public String getStrResId() {
        return strResId;
    }

    /**
     * @param strResId the strResId to set
     */
    public void setStrResId(String strResId) {
        this.strResId = strResId;
    }
    
}
