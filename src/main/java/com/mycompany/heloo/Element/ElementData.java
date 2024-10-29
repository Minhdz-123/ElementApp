package com.mycompany.heloo.Element;

import java.util.ArrayList;
import java.util.List;

public class ElementData {
    private List<Element> elements;

    public ElementData() {
        elements = new ArrayList<>();

        // Khởi tạo danh sách nguyên tố từ 1 đến 89
        elements.add(new Element(1, "Hydrogen", "H", 1.008));
        elements.add(new Element(2, "Helium", "He", 4.0026));
        elements.add(new Element(3, "Lithium", "Li", 6.94));
        elements.add(new Element(4, "Beryllium", "Be", 9.0122));
        elements.add(new Element(5, "Boron", "B", 10.81));
        elements.add(new Element(6, "Carbon", "C", 12.011));
        elements.add(new Element(7, "Nitrogen", "N", 14.007));
        elements.add(new Element(8, "Oxygen", "O", 15.999));
        elements.add(new Element(9, "Fluorine", "F", 18.998));
        elements.add(new Element(10, "Neon", "Ne", 20.180));
        elements.add(new Element(11, "Sodium", "Na", 22.990));
        elements.add(new Element(12, "Magnesium", "Mg", 24.305));
        elements.add(new Element(13, "Aluminum", "Al", 26.982));
        elements.add(new Element(14, "Silicon", "Si", 28.085));
        elements.add(new Element(15, "Phosphorus", "P", 30.974));
        elements.add(new Element(16, "Sulfur", "S", 32.06));
        elements.add(new Element(17, "Chlorine", "Cl", 35.45));
        elements.add(new Element(18, "Argon", "Ar", 39.948));
        elements.add(new Element(19, "Potassium", "K", 39.098));
        elements.add(new Element(20, "Calcium", "Ca", 40.078));
        elements.add(new Element(21, "Scandium", "Sc", 44.956));
        elements.add(new Element(22, "Titanium", "Ti", 47.867));
        elements.add(new Element(23, "Vanadium", "V", 50.941));
        elements.add(new Element(24, "Chromium", "Cr", 51.996));
        elements.add(new Element(25, "Manganese", "Mn", 54.938));
        elements.add(new Element(26, "Iron", "Fe", 55.845));
        elements.add(new Element(27, "Cobalt", "Co", 58.933));
        elements.add(new Element(28, "Nickel", "Ni", 58.693));
        elements.add(new Element(29, "Copper", "Cu", 63.546));
        elements.add(new Element(30, "Zinc", "Zn", 65.38));
        elements.add(new Element(31, "Gallium", "Ga", 69.723));
        elements.add(new Element(32, "Germanium", "Ge", 72.63));
        elements.add(new Element(33, "Arsenic", "As", 74.922));
        elements.add(new Element(34, "Selenium", "Se", 78.971));
        elements.add(new Element(35, "Bromine", "Br", 79.904));
        elements.add(new Element(36, "Krypton", "Kr", 83.798));
        elements.add(new Element(37, "Rubidium", "Rb", 85.468));
        elements.add(new Element(38, "Strontium", "Sr", 87.62));
        elements.add(new Element(39, "Yttrium", "Y", 88.906));
        elements.add(new Element(40, "Zirconium", "Zr", 91.224));
        elements.add(new Element(41, "Niobium", "Nb", 92.906));
        elements.add(new Element(42, "Molybdenum", "Mo", 95.95));
        elements.add(new Element(43, "Technetium", "Tc", 98));
        elements.add(new Element(44, "Ruthenium", "Ru", 101.07));
        elements.add(new Element(45, "Rhodium", "Rh", 102.91));
        elements.add(new Element(46, "Palladium", "Pd", 106.42));
        elements.add(new Element(47, "Silver", "Ag", 107.87));
        elements.add(new Element(48, "Cadmium", "Cd", 112.41));
        elements.add(new Element(49, "Indium", "In", 114.82));
        elements.add(new Element(50, "Tin", "Sn", 118.71));
        elements.add(new Element(51, "Antimony", "Sb", 121.76));
        elements.add(new Element(52, "Tellurium", "Te", 127.60));
        elements.add(new Element(53, "Iodine", "I", 126.90));
        elements.add(new Element(54, "Xenon", "Xe", 131.29));
        elements.add(new Element(55, "Cesium", "Cs", 132.91));
        elements.add(new Element(56, "Barium", "Ba", 137.33));
        elements.add(new Element(57, "Lanthanum", "La", 138.91));
        elements.add(new Element(58, "Cerium", "Ce", 140.12));
        elements.add(new Element(59, "Praseodymium", "Pr", 140.91));
        elements.add(new Element(60, "Neodymium", "Nd", 144.24));
        elements.add(new Element(61, "Promethium", "Pm", 145));
        elements.add(new Element(62, "Samarium", "Sm", 150.36));
        elements.add(new Element(63, "Europium", "Eu", 151.96));
        elements.add(new Element(64, "Gadolinium", "Gd", 157.25));
        elements.add(new Element(65, "Terbium", "Tb", 158.93));
        elements.add(new Element(66, "Dysprosium", "Dy", 162.50));
        elements.add(new Element(67, "Holmium", "Ho", 164.93));
        elements.add(new Element(68, "Erbium", "Er", 167.26));
        elements.add(new Element(69, "Thulium", "Tm", 168.93));
        elements.add(new Element(70, "Ytterbium", "Yb", 173.04));
        elements.add(new Element(71, "Lutetium", "Lu", 174.97));
        elements.add(new Element(72, "Hafnium", "Hf", 178.49));
        elements.add(new Element(73, "Tantalum", "Ta", 180.95));
        elements.add(new Element(74, "Tungsten", "W", 183.84));
        elements.add(new Element(75, "Rhenium", "Re", 186.21));
        elements.add(new Element(76, "Osmium", "Os", 190.23));
        elements.add(new Element(77, "Iridium", "Ir", 192.22));
        elements.add(new Element(78, "Platinum", "Pt", 195.08));
        elements.add(new Element(79, "Gold", "Au", 196.97));
        elements.add(new Element(80, "Mercury", "Hg", 200.59));
        elements.add(new Element(81, "Thallium", "Tl", 204.38));
        elements.add(new Element(82, "Lead", "Pb", 11.34));
        elements.add(new Element(82, "Lead", "Pb", 207.2));
        elements.add(new Element(83, "Bismuth", "Bi", 208.98));
        elements.add(new Element(84, "Polonium", "Po", 209));
        elements.add(new Element(85, "Astatine", "At", 210));
        elements.add(new Element(86, "Radon", "Rn", 222));
        elements.add(new Element(87, "Francium", "Fr", 223));
        elements.add(new Element(88, "Radium", "Ra", 226));
        elements.add(new Element(89, "Actinium", "Ac", 227));
    }

    public Element getElementByAtomicNumber(int atomicNumber) {
        if (atomicNumber >= 1 && atomicNumber <= elements.size()) {
            return elements.get(atomicNumber - 1);
        } else {
            return null;  // Trả về null nếu số nguyên tử không hợp lệ
        }
    }
}
