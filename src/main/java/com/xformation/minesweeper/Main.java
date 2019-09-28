package com.xformation.minesweeper;

import com.xformation.minesweeper.impl.MineSweeperImpl;

public class Main {
    public static void main(String[] args) {
        String mineField = "*...\n..*.\n....";
        MineSweeper ms = new MineSweeperImpl();
        ms.setMineField(mineField);
        System.out.println(ms.getHintField());
    }
}
