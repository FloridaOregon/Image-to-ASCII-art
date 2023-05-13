import java.lang.Math;

public class ASCII extends PApplet{
  PImage img;
  
  char[] ASCII = {'Ñ', '@', '&', '#', 'W', '$', '9', '8', '7', '6', '5', '4', '3', '2', '1', '0', '?', '!', 'a', 'b', 'c', ';', ':', '+', '=', '-', ',', '.', '_'};
  //ASCII characters, corresponding to different brighntess values, 29 characters total
  
  int lowerBound = 0;
  int upperBound = 9;
  
  int counter = 0;
  
  public void setup(){
    img = loadImage("file.png"); //Enter the directory to your file
    
    img.loadPixels(); //Extracts brightness values from every pixel
    int[][] brightnessArr = new int[img.height][img.width];
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
    
    for (int i = 0; i <= img.height - 1; i = i + 1) {
      for (int p = 0; p <= img.width - 1; p = p + 1) {
        for (int j = ASCII.length - 1; j >= 0; j = j - 1) { //Matches the brightness values of each pixel to a corresponding ASCII character
          if (brightnessArr[i][p] >= lowerBound && brightnessArr[i][p] <= upperBound) {
            System.out.print(ASCII[j] + " "); //Prints the ASCII art
            counter = counter + 1;
            break;
          }
          lowerBound = lowerBound + 9;
          upperBound = upperBound + 9;
        }
        
        lowerBound = 0;
        upperBound = 9;
        
        if (counter == img.width) { //Adds rows to the ASCII output
          System.out.println();
          counter = 0;
        }
      }
    }
  } 
  public static void main(String[] args){
      PApplet.main("ASCII");
  }
}
