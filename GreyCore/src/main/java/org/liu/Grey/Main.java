package org.liu.Grey;

import org.liu.Grey.core.ColorChanger;


public class Main {

    public static void main(String[] args) {

        ColorChanger cc = new ColorChanger();
        cc.setColor("GRAY");

        if(cc.changeTo()) System.out.println("SUC");
    }
}