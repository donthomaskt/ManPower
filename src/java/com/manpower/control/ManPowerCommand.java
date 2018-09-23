/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.manpower.control;

import com.manpower.vo.PageObject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DON THOMAS
 */
public abstract  class ManPowerCommand {
    
    public abstract PageObject execute(HttpServletRequest request);
    
}
