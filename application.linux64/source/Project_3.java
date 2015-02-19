import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import org.gicentre.utils.stat.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Project_3 extends PApplet {



BarChart barChart;
BarChart barChart1;
BarChart barChart2;
BarChart barChart3;
BarChart barChart4;
BarChart barChart5;
BarChart barChart6;
BarChart barChart7;
BarChart barChart8;
BarChart barChart9;
BarChart barChart10;
XYChart scatterplot;
Table table;
int x = 0;

int xaxis = 10;
int yaxis = 10;
int barwidth = 100;
int barheight = 100;
int benignCount = 0;
int malignantCount = 0;
float[] clumpThicknessNum = new float[10];
float[] cellSizeNum = new float[10];
float[] cellShapeNum = new float[10];
float[] marginalAdhesionNum = new float[10];
float[] singleCellSizeNum = new float[10];
float[] bareNucleiNum = new float[10];
float[] blandChromatinNum = new float[10];
float[] normalNucleoliNum = new float[10];
float[] mitosesNum = new float[10];
float[] classTumorNum = new float[2];
public void setup() {
  size(1000, 800);
  table = loadTable("breast-cancer-wisconsin.csv", "header");
  textFont(createFont("Arial", 10), 10);

  //scatterplot = new XYChart(this);
  barChart = new BarChart(this);
  barChart1 = new BarChart(this);
  barChart2 = new BarChart(this);
  barChart3 = new BarChart(this);
  barChart4 = new BarChart(this);
  barChart5 = new BarChart(this);
  barChart6 = new BarChart(this);
  barChart7 = new BarChart(this);
  barChart8 = new BarChart(this);
  barChart9 = new BarChart(this);
  barChart10 = new BarChart(this);



  float[] ID = new float[table.getRowCount()];
  float[] clumpThickness = new float[table.getRowCount()];
  float[] cellSize = new float[table.getRowCount()];
  float[] cellShape = new float[table.getRowCount()];
  float[] marginalAdhesion = new float[table.getRowCount()];
  float[] singleCellSize = new float[table.getRowCount()];
  float[] bareNuclei = new float[table.getRowCount()];
  float[] blandChromatin = new float[table.getRowCount()];
  float[] normalNucleoli = new float[table.getRowCount()];
  float[] mitoses = new float[table.getRowCount()];
  float[] classTumor = new float[table.getRowCount()];
  for (TableRow row : table.rows ()) {
    ID[x] = row.getFloat("Sample Code Number");
    clumpThickness[x] = row.getFloat("Clump Thickness");
    cellSize[x] = row.getFloat("Uniformity of Cell Size");
    cellShape[x] = row.getFloat("Uniformity of Cell Shape");
    marginalAdhesion[x] = row.getFloat("Marginal Adhesion");
    singleCellSize[x] = row.getFloat("Single Epithelial Cell Size");
    bareNuclei[x] = row.getFloat("Bare Nuclei");
    blandChromatin[x] = row.getFloat("Bland Chromatin");
    normalNucleoli[x] = row.getFloat("Normal Nucleoli");
    mitoses[x] = row.getFloat("Mitoses");
    classTumor[x] = row.getFloat("Class");

    x+=1;
  }

  for (int a = 1; a< clumpThicknessNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < clumpThickness.length; b++) {
      if (clumpThickness[b] == a) {
        count+= 1;
      }
    }
    clumpThicknessNum[a-1] = count;
  }
  for (int a = 1; a< cellSizeNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < cellSize.length; b++) {
      if (cellSize[b] == a) {
        count+= 1;
      }
    }
    cellSizeNum[a-1] = count;
  }
  for (int a = 1; a< cellShapeNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < cellShape.length; b++) {
      if (cellShape[b] == a) {
        count+= 1;
      }
    }
    cellShapeNum[a-1] = count;
  }
  for (int a = 1; a< marginalAdhesionNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < marginalAdhesion.length; b++) {
      if (marginalAdhesion[b] == a) {
        count+= 1;
      }
    }
    marginalAdhesionNum[a-1] = count;
  }
  for (int a = 1; a< singleCellSizeNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < singleCellSize.length; b++) {
      if (singleCellSize[b] == a) {
        count+= 1;
      }
    }
    singleCellSizeNum[a-1] = count;
  }
  for (int a = 1; a< bareNucleiNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < bareNuclei.length; b++) {
      if (bareNuclei[b] == a) {
        count+= 1;
      }
    }
    bareNucleiNum[a-1] = count;
  }
  for (int a = 1; a< blandChromatinNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < blandChromatin.length; b++) {
      if (blandChromatin[b] == a) {
        count+= 1;
      }
    }
    blandChromatinNum[a-1] = count;
  }
  for (int a = 1; a< normalNucleoliNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < normalNucleoli.length; b++) {
      if (normalNucleoli[b] == a) {
        count+= 1;
      }
    }
    normalNucleoliNum[a-1] = count;
  }
  for (int a = 1; a< mitosesNum.length + 1; a++) {
    int count = 0;
    for (int b = 0; b < mitoses.length; b++) {
      if (mitoses[b] == a) {
        count+= 1;
      }
    }
    mitosesNum[a-1] = count;
  }

  for (int b = 0; b < classTumor.length; b++) {
    if (classTumor[b] == 2) {
      benignCount += 1;
    } else {
      malignantCount +=1;
    }
  }
  classTumorNum[0] = benignCount;
  classTumorNum[1] = malignantCount;
}

public void draw() {
  background(255);
  barChart1.setCategoryAxisLabel("");
  barChart2.setCategoryAxisLabel("");
  barChart3.setCategoryAxisLabel("");
  barChart4.setCategoryAxisLabel("");
  barChart5.setCategoryAxisLabel("");
  barChart6.setCategoryAxisLabel("");
  barChart7.setCategoryAxisLabel("");
  barChart8.setCategoryAxisLabel("");
  barChart9.setCategoryAxisLabel("");
  barChart10.setCategoryAxisLabel("");


  barChart1 = setBarChart(clumpThicknessNum);
  barChart1.setCategoryAxisLabel("Clump Thickness");
  barChart1.draw(xaxis, yaxis, barwidth, barheight);
  if (mouseX > xaxis-barwidth && mouseX < xaxis+barwidth && mouseY > yaxis-barheight && mouseY < yaxis+barheight) {
    /* barChart1.setCategoryAxisLabel("Clump Thickness");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel(""); */
    barChart1.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Clump Thickness!");
  }
  barChart9.setCategoryAxisLabel("");
  barChart2 = setBarChart(cellSizeNum);
  barChart2.setCategoryAxisLabel("Cell Size");
  barChart2.draw(xaxis*20+1, yaxis, barwidth, barheight);
  if (mouseX > xaxis*20+1-barwidth && mouseX < xaxis*20+barwidth && mouseY > yaxis-barheight && mouseY < yaxis+barheight) {
   /* barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("Cell Size");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel(""); */
    barChart2.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Cell Size");
  }
  barChart8.setCategoryAxisLabel("");
  barChart3 = setBarChart(cellShapeNum);
  barChart3.setCategoryAxisLabel("Cell Shape");
  barChart3.draw(xaxis*40+1, yaxis, barwidth, barheight);
  if (mouseX > xaxis*40+1-barwidth && mouseX < xaxis*40+barwidth && mouseY > yaxis-barheight && mouseY < yaxis+barheight) {
   /* barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("Cell Shape");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel(""); */
    barChart3.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Cell Shape");
  }
  barChart7.setCategoryAxisLabel("");
  barChart4 = setBarChart(marginalAdhesionNum);
  barChart4.setCategoryAxisLabel("Marginal Adhesion");
  barChart4.draw(xaxis*60+1, yaxis, barwidth, barheight);
  if (mouseX > xaxis*60+1-barwidth && mouseX < xaxis*60+barwidth && mouseY > yaxis-barheight && mouseY < yaxis+barheight) {
   /* barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("Marginal Adhesion");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel(""); */
    barChart4.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
   // println("Marginal Adhesion");
  }
  barChart6.setCategoryAxisLabel("");
  barChart5 = setBarChart(singleCellSizeNum);
  barChart5.setCategoryAxisLabel("Single Cell Size");
  barChart5.draw(xaxis*80+1, yaxis, barwidth, barheight);
  if (mouseX > xaxis*80+1-barwidth && mouseX < xaxis*80+barwidth && mouseY > yaxis-barheight && mouseY < yaxis+barheight) {
   /* barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("Single Cell Size");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel(""); */
    barChart5.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
   // println("Single Cell Size");
  }
  barChart5.setCategoryAxisLabel("");
  barChart6 = setBarChart(bareNucleiNum);
  barChart6.setCategoryAxisLabel("Bare Nuclei");
  barChart6.draw(xaxis, yaxis*15+1, barwidth, barheight);
  if (mouseX > xaxis-barwidth && mouseX < xaxis+barwidth && mouseY > yaxis*20+1-barheight && mouseY < yaxis*15+1+barheight) {
   /* barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("Bare Nuclei");
    barChart7.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel("");*/
    barChart6.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Bare Nuclei");
  }
  barChart4.setCategoryAxisLabel("");
  barChart7 = setBarChart(blandChromatinNum);
  barChart7.setCategoryAxisLabel("Bland Chromatin");
  barChart7.draw(xaxis*20+1, yaxis*15+1, barwidth, barheight);
  if (mouseX > xaxis*20+1-barwidth && mouseX < xaxis*20+1+barwidth && mouseY > yaxis*20+1-barheight && mouseY < yaxis*15+1+barheight) {
    /*barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart7.setCategoryAxisLabel("Bland Chromatin");
    barChart8.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart10.setCategoryAxisLabel("");*/
    barChart7.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Bland Chromatin");
  }

  barChart8 = setBarChart(normalNucleoliNum);
  barChart8.setCategoryAxisLabel("Normal Nucleoli");
  barChart8.draw(xaxis*40+1, yaxis*15+1, barwidth, barheight);
  if (mouseX > xaxis*40+1-barwidth && mouseX < xaxis*40+barwidth && mouseY > yaxis*20+1-barheight && mouseY < yaxis*15+1+barheight) {
    barChart1.setCategoryAxisLabel("");
    barChart2.setCategoryAxisLabel("");
    barChart3.setCategoryAxisLabel("");
    barChart4.setCategoryAxisLabel("");
    barChart5.setCategoryAxisLabel("");
    barChart6.setCategoryAxisLabel("");
    barChart9.setCategoryAxisLabel("");
    barChart8.setCategoryAxisLabel("Normal Nucleoli");
    barChart8.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
    //println("Normal Nucleoli");
  }

  barChart9 = setBarChart(mitosesNum);
  barChart9.setCategoryAxisLabel("Mitoses");
  barChart9.draw(xaxis*60+1, yaxis*15+1, barwidth, barheight);
  if (mouseX > xaxis*60+1-barwidth && mouseX < xaxis*60+1+barwidth && mouseY > yaxis*20+1-barheight && mouseY < yaxis*15+1+barheight) {
    
    barChart9.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
   // println("Mitoses");
  }

  barChart10 = setBarChart(classTumorNum);
  barChart10.setCategoryAxisLabel("Class Tumor");
  barChart10.draw(xaxis*80+1, yaxis*15+1, barwidth, barheight);
  if (mouseX > xaxis*80+1-barwidth && mouseX < xaxis*80+1+barwidth && mouseY > yaxis*20+1-barheight && mouseY < yaxis*20+1+barheight) {

    barChart10.draw(xaxis*25, yaxis*25, barwidth*5, barwidth*5);
   // println("Class Tumor");
  }
}

public BarChart setBarChart(float[] attribute) { 
  //barChart = new BarChart(this);
  barChart.setData(attribute);
  //scatterplot.setData(clumpThickness, cellSize);

  barChart.setMinValue(0);
  //barChart.setMaxValue(200);

  barChart.showValueAxis(true);
  barChart.showCategoryAxis(true);
  barChart.setValueAxisLabel("Number of Instances");
  // barChart.setCategoryAxisLabel("marginal Adhesion");

  return barChart;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Project_3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
