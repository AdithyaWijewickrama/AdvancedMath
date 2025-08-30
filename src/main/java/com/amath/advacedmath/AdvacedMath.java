package com.amath.advacedmath;

import java.math.BigDecimal;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

import com.amath.advacedmath.calculate.NumberFormat;
import com.amath.advacedmath.gui.views.MathFront;
import com.amath.advacedmath.programmer.WordSize;

public class AdvacedMath {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch(Exception ex){
            System.err.println("Failed to initialize LaF");
        }
        MathFront mf=new MathFront();
        mf.setVisible(true);
    }
}
