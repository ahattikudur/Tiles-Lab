//Adit Hattikudur
//D Block Post-AP Computer Science: Data Structures
//Tile Lab - Raise, lower, delete, and shuffle tiles 
//within a graphical interface
import java.util.*;
import java.awt.*;
public class TileManager {
   private ArrayList<Tile> tilesList;
   //The constructor method initializes the ArrayList
   //of tiles
   public TileManager() {
       tilesList = new ArrayList<Tile>();
   }   
   //The method "addTile" adds tiles to the ArrayList of tiles
   public void addTile(Tile rect) {
      tilesList.add(rect); 
   }
   //The method "drawAll" draws tiles onto graphical interface
   public void drawAll(Graphics g) { 
      for (Tile select : tilesList) {
         select.draw(g);
      }
   }
   //The "highest" helper method returns the last placed tile with 
   //the clicked x-y coordinates within its area. The method takes in the x-y
   //coordinates of the mouse-click
   public Tile highest(int x, int y) {
      Tile noClick = new Tile(-1, -1, -1, -1, Color.BLACK);
      int x_interval_low;
      int x_interval_high;
      int y_interval_high; 
      int y_interval_low;
      int counter = 0;
      Tile highest = tilesList.get(0);
      //This for-loop goes through the list of tiles and assigns
      //tiles with the mouse-click in its area to the highest Tile object. 
      //As the program goes down the list, the Tiles become higher
      //and the last "highest" tile assigned will be that at the
      //top of the click. 
      for (Tile select : tilesList) {
         //These variables set the boundaries for the x-y 
         //coordinates to fall into
         x_interval_low = select.getX();
         x_interval_high = select.getX() + select.getWidth();
         y_interval_high = select.getY(); 
         y_interval_low = select.getY() + select.getHeight();
         //These if-statements determine whether the mouse-click
         //x-y coordinates fall within the boundaries of the tile area
         if ((x_interval_low < x) && (x < x_interval_high)) {
            if  ((y_interval_low > y) && (y > y_interval_high)){
               highest = select;
               counter++;                
            }
         }
      }  
      //The counter is used to determine whether a Tile was clicked
      //on at all
      if (counter == 0) {
         highest = noClick;
      }
      return highest;
   }
   //The "highest" method finds the highest tile with an 
   //area including the x-y coordinates and places it above
   //all the other tiles
   public void raise(int x, int y) {
      Tile select = highest(x, y);
      //This if-statement ensures that the action occurs only
      //if the mouse clicked on a tile
      if (select.getX() != -1) {
         tilesList.remove(select);
         tilesList.add(select);
      }
   }
   //The "lower" method finds the highest tile with an 
   //area including the x-y coordinates and places it below
   //all the other tiles
   public void lower(int x, int y) {
      Tile select = highest(x, y);
      //This if-statement ensures that the action occurs only
      //if the mouse clicked on a tile
      if (select.getX() != -1) {
         tilesList.remove(select);
         tilesList.add(0, select);  
      }              
   }
   //The "delete" method removes the highest tile
   //with its area encapsulating the x-y coordinates
   public void delete(int x, int y) {
      Tile select = highest(x, y);
      //This if-statement ensures that the action occurs only
      //if the mouse clicked on a tile
      if (select.getX() != -1) {
         tilesList.remove(select);
      }   
   }
   //The "deleteAll" method deletes all tiles under 
   //a mouse-click, regardless of whether its the highest 
   //tile or not 
   public void deleteAll(int x, int y) {
      int x_interval_low;
      int x_interval_high;
      int y_interval_high; 
      int y_interval_low;
      Tile select = tilesList.get(0);
      //The for-loop identifies which tiles have the
      //x-y coordinates within their area
      for (int i = 0; i < tilesList.size(); i++) {
         select = tilesList.get(i);
         //These variables set the boundaries for the x-y 
         //coordinates to fall into
         x_interval_low = select.getX();
         x_interval_high = select.getX() + select.getWidth();
         y_interval_high = select.getY(); 
         y_interval_low = select.getY() + select.getHeight();
         //These if statements remove each tile from the list
         //if their area includes the mouse-click x-y coordinates
         if ((x_interval_low < x) && (x < x_interval_high)) {
            if  ((y_interval_low > y) && (y > y_interval_high)){
               tilesList.remove(select);
               i--;               
            }
         }
      }        
   }
   //The "shuffle" method shuffles the order of the list of tiles
   //and location of each tile.
   public void shuffle(int width, int height) {
      //This shuffles within the list of tiles
      Collections.shuffle(tilesList);
      //This for-loop goes through the list of tiles 
      for (Tile choose : tilesList) {
         //Sets the top-left corner of each tile to a random location 
         //while taking into account the tiles height and width so as to only
         //place it within the graphical interface
         choose.setX((int) (Math.random() * (width - choose.getWidth() + 1)));
         choose.setY((int) (Math.random() * (height - choose.getHeight() + 1)));
      }  
   }
}