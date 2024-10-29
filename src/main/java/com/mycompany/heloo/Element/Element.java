package com.mycompany.heloo.Element;

public class Element {
    private int atomicNumber;      // Số thứ tự
    private String name;           // Tên nguyên tố
    private String symbol;         // Ký hiệu hóa học
    private double molarMass;      // Khối lượng mol

    public Element(int atomicNumber, String name, String symbol, double molarMass) {
        this.atomicNumber = atomicNumber;
        this.name = name;
        this.symbol = symbol;
        this.molarMass = molarMass;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMolarMass() {
        return molarMass;
    }
}
