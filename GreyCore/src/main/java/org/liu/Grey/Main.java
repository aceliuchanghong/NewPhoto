package org.liu.Grey;

import org.liu.Grey.tools.FileDeal;
import org.liu.Grey.tools.FileDealer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileDealer fileDealer = new FileDealer();
        System.out.println(fileDealer.listFile());
    }
}