/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 *
 * @author estherntumba
 */

//The interface specifies the four methods that the ProductSales class must implement.

public interface Product {
    

    int TotalSales(int[] productSales);

    double AverageSales(int[] productSales);

    int MaxSale(int[] productSales);

    int MinSale(int[] productSales);
}
    

