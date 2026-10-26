/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesreport;

/**
 *
 * @author estherntumba
 */

//Main Class

public class ProductSalesReport {

    public static void main(String[] args) {
        

    

        // Two-dimensional array: years and quarters
        int[][] sales = {
            {300, 250},
            {150, 200},
            {700, 600}
        };

        // Single-dimensional array for calculations
        int[] productSales = new int[6];
        int index = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                productSales[index] = sales[i][j];
                index++;
            }
        }

        // Create ProductSales object
        ProductSales report = new ProductSales();

        // Display the report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------");

        System.out.println("Total sales: "
                + report.TotalSales(productSales));

        System.out.printf("Average sales: %.0f%n",
                report.AverageSales(productSales));

        System.out.println("Maximum sale: "
                + report.MaxSale(productSales));

        System.out.println("Minimum sale: "
                + report.MinSale(productSales));
    }
}
            

