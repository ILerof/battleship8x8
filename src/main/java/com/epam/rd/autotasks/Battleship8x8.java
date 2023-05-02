package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int n = 63 - get(shot);
        BigInteger shipMap = new BigInteger(String.valueOf(ships));
        System.out.println(shipMap);
        BigInteger shootMap = new BigInteger(String.valueOf(shots));
        shots = shootMap.setBit(n).longValue();
        return shipMap.testBit(n);
    }

    public String state() {
        String string = "";
        BigInteger shipMap = new BigInteger(String.valueOf(ships));
        BigInteger shootMap = new BigInteger(String.valueOf(shots));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (shipMap.testBit(63-i*8-j) && shootMap.testBit(63-i*8-j)){string+="☒";}
                if (shipMap.testBit(63-i*8-j) && !shootMap.testBit(63-i*8-j)){string+="☐";}
                if (!shipMap.testBit(63-i*8-j) && shootMap.testBit(63-i*8-j)){string+="×";}
                if (!shipMap.testBit(63-i*8-j) && !shootMap.testBit(63-i*8-j)){string+=".";}
            }
            string+="\n";
        }
        return string;
    }

    public int get(String shot) {
        int nRow = Integer.parseInt(shot.substring(1))-1;
        int nColumn = 0;
        int i = 0;
        for (char c = 'A'; i < 8; c++, i++) {
            if (c == shot.charAt(0)){
                nColumn = i;
                break;
            }
        }
        return nRow*8+nColumn;
    }

}
