//Adit Hattikudur
//Post-AP Computer Science: Data Structures
//Tile Lab
import java.util.*;
import java.awt.*;
public class TileManager {
   private ArrayList<Tile> tilesList = new ArrayList<Tile>();
   
   public TileManager() {
      
   }
   public static void main(String[] args) {
      Tile one = new Tile(
   }
   
   public void addTile(Tile rect) {
      tilesList.add(rect); 
   }
   
   public void drawAll(Graphics g) { 
      for (Tile select : tilesList) {
         select.draw(Graphics g);
      }
   }
   /*
   public void raise(int x, int y) {
   
   }
   
   public void lower(int x, int y) {
   
   }
   
   public void delete(int x, int y) {
   
   }
   
   public void deleteAll(int x, int y) {
   
   }
   
   public void shuffle(int width, int height) {
   
   }
   */
   
}