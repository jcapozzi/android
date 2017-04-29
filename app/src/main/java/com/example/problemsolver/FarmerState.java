/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver;

import com.example.framework.problem.State;

/**
 *
 * @author Tyler
 */
public class FarmerState implements State {
    
        private final Pos FARMER_POS;
        private final Pos WOLF_POS;
        private final Pos GOAT_POS;
        private final Pos CABBAGE_POS;
       

        public FarmerState(Pos farmer, Pos wolf, Pos goat, Pos cabbage) {
          this.FARMER_POS = farmer;
          this.WOLF_POS = wolf;
          this.GOAT_POS = goat;
          this.CABBAGE_POS = cabbage;
        }

        public FarmerState(String farmer, String wolf, String goat, String cabbage) {
          this(toPos(farmer), toPos(wolf), toPos(goat), toPos(cabbage));
        }

        public Pos getFarmer() {
          return this.FARMER_POS;
        }

        public Pos getWolf() {
          return this.WOLF_POS;
        }

        public Pos getGoat() {
          return this.GOAT_POS;
        }

        public Pos getCabbage() {
          return this.CABBAGE_POS;
        }

        public boolean equals(Object other) {
          if (this == other) {
            return true;
          }
          if (other == null) {
            return false;
          }
          if (getClass() != other.getClass()) {
            return false;
          }
          FarmerState state = (FarmerState)other;
          return (this.FARMER_POS == state.FARMER_POS) && 
                  (this.WOLF_POS == state.WOLF_POS) && 
                  (this.GOAT_POS == state.GOAT_POS) && 
                  (this.CABBAGE_POS == state.CABBAGE_POS);
        }

        public String toString() {
          StringBuilder buf = new StringBuilder();

          String start = "   |  |   \n";
          String fWest = " F |  |   \n";
          String fEast = "   |  | F \n";
          String wWest = " W |  |   \n";
          String wEast = "   |  | W \n";
          String gWest = " G |  |   \n";
          String gEast = "   |  | G \n";
          String cWest = " C |  |   \n";
          String cEast = "   |  | C \n";
          String end = "   |  |   ";

          buf.append(start);

          buf.append(this.FARMER_POS == Pos.WEST ? fWest : fEast);
          buf.append(this.WOLF_POS == Pos.WEST ? wWest : wEast);
          buf.append(this.GOAT_POS == Pos.WEST ? gWest : gEast);
          buf.append(this.CABBAGE_POS == Pos.WEST ? cWest : cEast);

          buf.append(end);
   
          return buf.toString();
        }

        private static Pos toPos(String s) {
          if (s.equalsIgnoreCase("west")) {
            return Pos.WEST;
          }
          if (s.equalsIgnoreCase("east")) {
            return Pos.EAST;
          }
          throw new RuntimeException("Bad side: " + s);
        }
      

}

enum Pos {
    WEST,  EAST;
}

