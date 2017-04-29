/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver;

import com.example.framework.problem.Mover;
import com.example.framework.problem.State;

/**
 *
 * @author Tyler
 */
public class FarmerMover extends Mover<FarmerState> {
    
    public FarmerMover() {
            super.addMove(FARMER,  s -> tryFarmer(s));
            super.addMove(WOLF, s -> tryWolf(s));
            super.addMove(GOAT, s -> tryGoat(s));
            super.addMove(CABBAGE, s -> tryCabbage(s));
    }
    
    /*@Override
    public State doMove(String moveName, State state) {
        //maybe we put the logic here to prevent certain moves
        
//        and return null if they are bad moves
        if ( moveName.equalsIgnoreCase( 'farmer' ))
        State newState = super.doMove(moveName, state);
        return newState;
    }
    */
    
    private FarmerState tryFarmer(FarmerState state) {
        Pos farmerPos = state.getFarmer();
    if ((state.getCabbage() != state.getGoat()) && (state.getGoat() != state.getWolf())) {
        if ( farmerPos == Pos.EAST ) {
            farmerPos = Pos.WEST;
        } else {
            farmerPos = Pos.EAST;
        }
        state = new FarmerState( farmerPos, state.getWolf(), state.getGoat(), state.getCabbage() );
    }    
    else {
        return null;
    }
    return state;
    }
    
    private FarmerState tryWolf(FarmerState state) {
        Pos wolfPos = state.getWolf();
    if ((wolfPos == state.getFarmer()) && (state.getGoat() != state.getCabbage())) {
        if ( wolfPos == Pos.EAST ) {
            wolfPos = Pos.WEST;
        } else {
            wolfPos = Pos.EAST;
        }
        state = new FarmerState( wolfPos, wolfPos, state.getGoat(), state.getCabbage() );
    }
    else {
        return null;
    }
    return state;
    }
    
    private FarmerState tryGoat(FarmerState state) {
        Pos goatPos = state.getGoat();
    if (goatPos == state.getFarmer()) {
        if ( goatPos == Pos.EAST ) {
            goatPos = Pos.WEST;
        } else {
            goatPos = Pos.EAST;
        }
        state = new FarmerState(goatPos, state.getWolf(), goatPos, state.getCabbage() );
    }
    else {
        return null;
    }
    return state;
    }

    private FarmerState tryCabbage(FarmerState state) {
        Pos cabbagePos = state.getCabbage();
    if ((cabbagePos == state.getFarmer()) && (state.getWolf() != state.getGoat())) {
        if ( cabbagePos == Pos.EAST ) {
            cabbagePos = Pos.WEST;
        } else {
            cabbagePos = Pos.EAST;
        }
        state = new FarmerState(cabbagePos, state.getWolf(), state.getGoat(), cabbagePos );
    }
    else {
        return null;
    }
    return state;
    }
        public static final String FARMER = "Farmer goes alone";
        public static final String WOLF = "Farmer brings wolf";
        public static final String GOAT = "Farmer brings goat";
        public static final String CABBAGE = "Farmer brings cabbage";
    
}
