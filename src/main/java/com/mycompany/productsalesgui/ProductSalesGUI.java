/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesgui;

/**
 *
 * @author estherntumba
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesGUI extends JFrame {

    private JTextArea txtSales;
    private JLabel lblYearsProcessed;
    private JButton btnLoad;
    private JButton btnSave;

    private ProductSales sales = new ProductSales();

    public ProductSalesGUI() {

        setTitle("Product Sales Management");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Create the text area
        txtSales = new JTextArea();
        txtSales.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtSales);
        add(scrollPane, BorderLayout.CENTER);

        // Create the buttons
        btnLoad = new JButton("Load Product Data");
        btnSave = new JButton("Save Product Data");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        // Create the years processed label
        lblYearsProcessed = new JLabel("Years Processed: ");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(lblYearsProcessed, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button events
        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());

        // Menu events use the same methods as the buttons
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());

        clearItem.addActionListener(e -> {
            txtSales.setText("");
            lblYearsProcessed.setText("Years Processed: ");
        });

        exitItem.addActionListener(e -> System.exit(0));
    }

    // Load data and display the report
    private void loadProductData() {

        int[][] data = sales.GetProductSales();

        StringBuilder report = new StringBuilder();

        report.append("PRODUCT SALES REPORT\n");
        report.append("====================\n\n");

        report.append(String.format("%-15s %-10s %-10s%n",
                "Product", "Year 1", "Year 2"));

        report.append("-------------------------------------\n");

        String[] products = {
            "Microphone", "Speakers", "Mixing Desk"
        };

        for (int i = 0; i < data.length; i++) {
            report.append(String.format("%-15s %-10d %-10d%n",
                    products[i], data[i][0], data[i][1]));
        }

        report.append("\nTotal Sales: ")
              .append(sales.GetTotalSales());

        report.append(String.format("%nAverage Sales: %.2f",
                sales.GetAverageSales()));

        report.append("\nSales Over Limit: ")
              .append(sales.GetSalesOverLimit());

        report.append("\nSales Under Limit: ")
              .append(sales.GetSalesUnderLimit());

        txtSales.setText(report.toString());

        // Two years of sales data have been processed
        lblYearsProcessed.setText("Years Processed: 2");
    }

    // Save the text area contents to data.txt
    private void saveProductData() {

        try (FileWriter writer = new FileWriter("data.txt")) {

            writer.write(txtSales.getText());

            JOptionPane.showMessageDialog(this,
                    "Product data saved to data.txt");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ProductSalesGUI gui = new ProductSalesGUI();
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
        });
    }
}

    
    

