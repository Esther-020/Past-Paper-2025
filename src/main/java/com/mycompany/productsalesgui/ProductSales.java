/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesgui;

/**
 *
 * @author estherntumba
 */

public class ProductSales implements IProductSales {

    private int[][] productSales = {
        {300, 250},
        {150, 200},
        {700, 600}
    };

    private final int SALES_LIMIT = 500;

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;

        for (int[] product : productSales) {
            for (int sales : product) {
                total += sales;
            }
        }

        return total;
    }

    @Override
    public double GetAverageSales() {
        return (double) GetTotalSales()
                / (productSales.length * productSales[0].length);
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;

        for (int[] product : productSales) {
            for (int sales : product) {
                if (sales > SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;

        for (int[] product : productSales) {
            for (int sales : product) {
                if (sales < SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }
}



