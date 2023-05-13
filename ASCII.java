import java.lang.Math;

public class ASCII extends PApplet{
  PImage img;
  
  char[] ASCII = {'Ñ', '@', '&', '#', 'W', '$', '9', '8', '7', '6', '5', '4', '3', '2', '1', '0', '?', '!', 'a', 'b', 'c', ';', ':', '+', '=', '-', ',', '.', '_'};
  //29 characters
  
  int lowerBound = 0;
  int upperBound = 9;
  
  int counter = 0;
  
  public static void printArray(int[][] array) {
    for (int i = 0; i <= array.length - 1; i = i + 1) { //Rows
      for (int j = 0; j <= array[0].length - 1; j = j + 1) { //Columns
          System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
  
  public void settings(){
    size(600, 600);
  }
  public void setup(){
    img = loadImage("/Users/mikhailshageev/Documents/Processing/ASCII/data/Leibniz.jpg");
    img.loadPixels();
    int[][] brightnessArr = new int[img.height][img.width]; //Row, column
    for (int x = 0; x <= img.width - 1; x = x + 1) {
      for (int y = 0; y <= img.height - 1; y = y + 1) {
        int place = x + y*img.width;
        float red = red(img.pixels[place]);
        float green = green(img.pixels[place]);
        float blue = blue(img.pixels[place]);
        int brightness = (int)(red + green + blue) / 3;
        brightnessArr[y][x] = brightness;
      }
    }
    img.updatePixels();
    //printArray(brightnessArr);
    for (int i = 0; i <= img.height - 1; i = i + 1) {
      for (int p = 0; p <= img.width - 1; p = p + 1) {
        for (int j = ASCII.length - 1; j >= 0; j = j - 1) {
          if (brightnessArr[i][p] >= lowerBound && brightnessArr[i][p] <= upperBound) {
            System.out.print(ASCII[j] + " ");
            counter = counter + 1;
            break;
          }
          lowerBound = lowerBound + 9; //lowerBound = 0;
          upperBound = upperBound + 9; //upperBound = 9;
        }
        lowerBound = 0;
        upperBound = 9;
        if (counter == img.width) {
          System.out.println();
          counter = 0;
        }
      }
    }
  }
  public void draw(){
    background(255);
    image(img, 0, 0);
    img.resize(600, 600);
  }  
  public static void main(String[] args){
      PApplet.main("ASCII");
  }
}
