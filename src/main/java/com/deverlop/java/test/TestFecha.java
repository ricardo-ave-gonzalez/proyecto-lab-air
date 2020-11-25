/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deverlop.java.test;

import java.util.Date;

/**
 *
 * @author richie
 */
public class TestFecha {
    
    public static void main(String[] args) {
        Date fecha=new Date("2020/10/03");
        System.out.println(fecha);
        String fecha2=(fecha.getYear()+1900)+"-"+(fecha.getMonth()+1)+"-"+(fecha.getDay()-3);
        System.out.println(fecha2);
    }
}
