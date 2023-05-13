# Image-to-ASCII-art
A java algorithm, which takes images as inputs and converts them into ASCII art.
<br>
<br>
Important! You will need to manually decrease the resolution of your input image, preferrable something in the range of 40 by 40 pixels (does not have to be a square), as you might not have enough console space to output the art.
<br>
<br>
To run the code, you need Processing IDE installed or the same library. You can download it on the official website of the Processing library https://processing.org/.
<br>
<br>
To summarise how the code works:
<br>
1) User inputs an image
2) Every pixel is scanned, brightness values are collected into a 2D array
4) Brightness values are matched to ASCII characters in a predefined array, based on how much space they take on a display (this is done by associating each character with an interval of brightness values, the intervals are 9 in size in this code)
5) Corresponding ASCII characters are printed into the console
6) Line breaks are added to create rows via a counter, which triggers line breaks once reaches the value of the width of the input image
<br>
I am not a professional programmer, so it is very likely that the code is badly optimized and not written too well, but I hope you can find it helpful for your projects :). Feel free to use it for your own needs, no mentions of the author are needed or any license.
<br>
<br>
You can find an example ASCII art in "Example.java". It is not a piece of code, but just ASCII art, since the art would get distorted if I were to put it in this file, because it is not using the Courier New font, where each character takes an identical amount of space. Java files, however, are using this font, so I decided to put it there. And yes, it is an ASCII art of Gottfried Wilhelm Leibniz. Find the original image in "Leibniz.jpg" file.
