/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author estherntumba
 */

//This class implements the Product interface and contains the calculations.

public class ProductSales implements Product{
    

    @Override
    public int TotalSales(int[] productSales) {
        int total = 0;

        for (int sales : productSales) {
            total += sales;
        }

        return total;
    }

    @Override
    public double AverageSales(int[] productSales) {
        int total = TotalSales(productSales);

        return (double) total / productSales.length;
    }

    @Override
    public int MaxSale(int[] productSales) {
        int maximum = productSales[0];

        for (int sales : productSales) {
            if (sales > maximum) {
                maximum = sales;
            }
        }

        return maximum;
    }

    @Override
    public int MinSale(int[] productSales) {
        int minimum = productSales[0];

        for (int sales : productSales) {
            if (sales < minimum) {
                minimum = sales;
            }
        }

        return minimum;
    }
}

