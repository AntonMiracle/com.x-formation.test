package com.xformation.minesweeper.impl;

import com.xformation.minesweeper.MineSweeper;

public class MineSweeperImpl implements MineSweeper {
    private byte[][] mineField;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        int lineLength = mineField.split("\\n", -1)[0].length();
        int lineCount = mineField.split("\\n", -1).length;
        this.mineField = new byte[lineCount][lineLength];

        int lineIndex = 0;
        int index = -1;
        for (char c : mineField.toCharArray()) {
            switch (c) {
                case '*':
                    this.mineField[lineIndex][++index] = 1;
                    break;
                case '.':
                    this.mineField[lineIndex][++index] = 0;
                    break;
                case '\n':
                    index = -1;
                    ++lineIndex;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String getHintField() throws IllegalStateException {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mineField.length; ++i) {
            for (int j = 0; j < mineField[i].length; ++j) {
                if (mineField[i][j] == 0) {
                    result.append(countNearMines(i, j));
                } else {
                    result.append("*");
                }
            }
            result.append("\\n");
        }
        return result.toString();
    }

    private int countNearMines(int line, int column) {
        int result = 0;
        if (line > 0) result += countMinesInLine(line - 1, column);
        result += countMinesInLine(line, column);
        if (line < mineField.length - 1) result += countMinesInLine(line + 1, column);
        return result;
    }

    private int countMinesInLine(int line, int column) {
        int result = 0;
        if (column > 0) result += mineField[line][column - 1];
        result += mineField[line][column];
        if (column < mineField[line].length - 1) result += mineField[line][column + 1];
        return result;
    }
}
