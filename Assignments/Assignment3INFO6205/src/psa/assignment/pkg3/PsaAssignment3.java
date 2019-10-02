/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psa.assignment.pkg3;

import Business.ImprovedStrassenMatrixMultiplication;
import Business.StrassensMatrixMul;
import Business.TraditionalMatrixMultiplication;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Kinnar
 */
public class PsaAssignment3 extends ApplicationFrame{

    private static final long serialVersionUID = 1L;  
    private static int n;
    private static long[][] result;
    private static int[] samples;
    private static String[] methods = {"Traditional", "Strassen Divide and Conquer", "Improved Strassen"};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //input number of samples and get each n for matrix multiplication
        System.out.print("Enter number of samples you want to take (n): ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        result = new long[3][n];
        
        if(n <= 0 || n >= 10000){
            System.out.println("Please enter value between 1 and 10000 and power of 2");
            System.exit(0);
        }
        
        samples = new int[n];
        System.out.print("Enter each value of n samples (separated by whitespace or new line and should be power of 2): ");
        for(int i = 0; i < n; i++){
            samples[i] = in.nextInt();
            if((int)(Math.ceil((Math.log(samples[i]) / Math.log(2)))) != (int)(Math.floor(((Math.log(samples[i]) / Math.log(2)))))){
                System.out.println("Please enter a value which is power of 2");
                System.exit(0);
            }
        }
        
        for(int i = 0; i < methods.length; i++){
            for(int j = 0; j < n; j++){
                switch(i){
                    case 0: 
                        result[i][j] = new TraditionalMatrixMultiplication().traditional(samples[j]);
                        break;
                    case 1:
                        result[i][j] = new StrassensMatrixMul().strassens(samples[j]);
                        break;
                    case 2:
                        result[i][j] = new ImprovedStrassenMatrixMultiplication().improvedStrassen(samples[j]);
                        break;
                }                
            }
        }
        
        String s = "Matrix multiplication analysis using different algorithms";   
        PsaAssignment3 combinedcategoryplotdemo2 = new PsaAssignment3(s);   
        combinedcategoryplotdemo2.pack();   
        RefineryUtilities.centerFrameOnScreen(combinedcategoryplotdemo2);   
        combinedcategoryplotdemo2.setVisible(true); 
    }
    
    public static JPanel createDemoPanel()   
    {   
        JFreeChart jfreechart = createChart();   
        return new ChartPanel(jfreechart);   
    }
    
    private static JFreeChart createChart()   
    {   
        CategoryDataset categorydataset = createDataset1();   
        CategoryAxis categoryaxis = new CategoryAxis("Matrix multiplication methods");   
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);   
        categoryaxis.setMaximumCategoryLabelWidthRatio(5F);   
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();   
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());   
        CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis, null, lineandshaperenderer);   
        categoryplot.setDomainGridlinesVisible(true);   
        NumberAxis numberaxis = new NumberAxis("Time (Seconds)");   
        CombinedRangeCategoryPlot combinedrangecategoryplot = new CombinedRangeCategoryPlot(numberaxis);   
        combinedrangecategoryplot.add(categoryplot, 3);   
        combinedrangecategoryplot.setOrientation(PlotOrientation.VERTICAL);   
        JFreeChart jfreechart = new JFreeChart("Matrix multiplication analysis", new Font("SansSerif", 1, 14), combinedrangecategoryplot, true);   
        return jfreechart;   
    }
    
     

    public PsaAssignment3(String title) {
        super(title);   
        ChartPanel chartpanel = new ChartPanel(createChart());   
        chartpanel.setPreferredSize(new Dimension(800, 480));   
        setContentPane(chartpanel);
    }         
   
    public static CategoryDataset createDataset1()   
    {   
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();   
//        String s = "Traditional";   
//        String s1 = "Strassen Divide and Conquer";
//        String s12 = "Strassen Improved";
//        
//        
//        String s2 = "128";   
//        String s3 = "256";   
//        String s4 = "384";   
//        String s5 = "512";   
//        String s6 = "786";   
//        String s7 = "1024";   
//        String s8 = "2048";   
//        String s9 = "4096";
        
        
        
        for(int i = 0; i < methods.length; i++){
            for(int j = 0; j < n; j++){
                defaultcategorydataset.addValue(result[i][j]/1000000000.0, methods[i], samples[j]+"");        
            }
        }
//        defaultcategorydataset.addValue(1.0D, s, s2);   
//        defaultcategorydataset.addValue(4D, s, s3);   
//        defaultcategorydataset.addValue(3D, s, s4);   
//        defaultcategorydataset.addValue(5D, s, s5);   
//        defaultcategorydataset.addValue(5D, s, s6);   
//        defaultcategorydataset.addValue(7D, s, s7);   
//        defaultcategorydataset.addValue(7D, s, s8);   
//        defaultcategorydataset.addValue(8D, s, s9);
//        
//        defaultcategorydataset.addValue(5D, s1, s2);   
//        defaultcategorydataset.addValue(7D, s1, s3);   
//        defaultcategorydataset.addValue(6D, s1, s4);   
//        defaultcategorydataset.addValue(8D, s1, s5);   
//        defaultcategorydataset.addValue(4D, s1, s6);   
//        defaultcategorydataset.addValue(4D, s1, s7);   
//        defaultcategorydataset.addValue(2D, s1, s8);   
//        defaultcategorydataset.addValue(1.0D, s1, s9);
//        
//        defaultcategorydataset.addValue(3D, s12, s2);   
//        defaultcategorydataset.addValue(6D, s12, s3);   
//        defaultcategorydataset.addValue(8D, s12, s4);   
//        defaultcategorydataset.addValue(2D, s12, s5);   
//        defaultcategorydataset.addValue(3D, s12, s6);   
//        defaultcategorydataset.addValue(3D, s12, s7);   
//        defaultcategorydataset.addValue(5D, s12, s8);   
//        defaultcategorydataset.addValue(4D, s12, s9);               
        
        return defaultcategorydataset;   
    }
    
}
