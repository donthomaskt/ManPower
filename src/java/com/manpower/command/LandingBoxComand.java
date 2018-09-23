/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.manpower.command;

import com.manpower.control.ManPowerCommand;
import com.manpower.vo.PageObject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DON THOMAS
 */
public class LandingBoxComand extends ManPowerCommand{
   @Override
    public PageObject execute(HttpServletRequest request) {
        PageObject pageObj = null;
        try {
            pageObj = new PageObject();
            pageObj.setStrResId("200004");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageObj;
    }
}
