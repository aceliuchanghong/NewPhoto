package org.liu.Grey;

import org.liu.Grey.tools.FileDealer;


public class Main {
    public static void main(String[] args) {
        FileDealer fileDealer = new FileDealer();
        System.out.println(fileDealer.listFile().size());
    }
}