/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver;

import com.example.framework.problem.Problem;

/**
 *
 * @author Tyler
 */
public class FarmerProblem extends Problem<FarmerState> {
    
    public FarmerProblem() {
            super();
            super.setName("Farmer, Wolf, Goat, and Cabbage");
            super.setIntroduction(INTRO);
            super.setMover(new FarmerMover());
            
            super.setInitialState(new FarmerState("WEST", "WEST", "WEST", "WEST"));
            super.setCurrentState(super.getInitialState());
            super.setFinalState(new FarmerState("EAST","EAST","EAST","EAST"));
        }
        private static final String INTRO = 
                "A farmer and his wolf, goat, and cabbage come to the edge of a river they wish to cross. "
                + "There is a boat at the river's edge that only the farmer can row. The farmer can take at "
                + "most one other object besides himself on a crossing, but if the wolf is ever left with the "
                + "goat, the wolf will eat the goat; similarly, if the goat is left with the cabbage, the goat "
                + "will eat the cabbage. Devise a sequence of crossings of the river so that all four characters "
                + "arrive safely on the other side.";

}
