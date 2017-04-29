/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.problemsolver;

import com.example.framework.problem.Mover;
import com.example.framework.problem.State;

import java.util.function.UnaryOperator;

/**
 *
 * @author Tyler
 */
public class FarmerMover extends Mover {
    
    public FarmerMover() {
            super.addMove(FARMER, new UnaryOperator<State>() {
                @Override
                public State apply(State state) {
                    return tryFarmer(state);
                }
            });
//            super.addMove(WOLF, s -> tryWolf(s));
//            super.addMove(GOAT, s -> tryGoat(s));
//            super.addMove(CABBAGE, s -> tryCabbage(s));
//    }
    
    /*@Override
    public State doMove(String moveName, State state) {
        //maybe we put the logic here to prevent certain moves
        
//        and return null if they are bad moves
        if ( moveName.equalsIgnoreCase( 'farmer' ))
        State newState = super.doMove(moveName, state);
        return newState;
    }
    */
    
    private State tryFarmer(State s) {
        FarmerState thing =(FarmerState)s;
        Pos farmerPos = thing.getFarmer();
    if ((thing.getCabbage() != thing.getGoat()) && (thing.getGoat() != thing.getWolf())) {
        if ( farmerPos == Pos.EAST ) {
            farmerPos = Pos.WEST;
        } else {
            farmerPos = Pos.EAST;
        }
        thing = new FarmerState( farmerPos, thing.getWolf(), thing.getGoat(), thing.getCabbage() );
    }    
    else {
        return null;
    }
    return thing;
    }
    
    private State tryWolf(State s) {
        FarmerState thing =(FarmerState)s;
        Pos wolfPos = thing.getWolf();
    if ((wolfPos == thing.getFarmer()) && (thing.getGoat() != thing.getCabbage())) {
        if ( wolfPos == Pos.EAST ) {
            wolfPos = Pos.WEST;
        } else {
            wolfPos = Pos.EAST;
        }
        thing = new FarmerState( wolfPos, wolfPos, thing.getGoat(), thing.getCabbage() );
    }
    else {
        return null;
    }
    return thing;
    }
    
    private State tryGoat(State s) {
        FarmerState thing =(FarmerState)s;
        Pos goatPos = thing.getGoat();
    if (goatPos == thing.getFarmer()) { 
        if ( goatPos == Pos.EAST ) {
            goatPos = Pos.WEST;
        } else {
            goatPos = Pos.EAST;
        }
        thing = new FarmerState(goatPos, thing.getWolf(), goatPos, thing.getCabbage() );
    }
    else {
        return null;
    }
    return thing;
    }

    private State tryCabbage(State s) {
        FarmerState thing =(FarmerState)s;
        Pos cabbagePos = thing.getCabbage();
    if ((cabbagePos == thing.getFarmer()) && (thing.getWolf() != thing.getGoat())) {
        if ( cabbagePos == Pos.EAST ) {
            cabbagePos = Pos.WEST;
        } else {
            cabbagePos = Pos.EAST;
        }
        thing = new FarmerState(cabbagePos, thing.getWolf(), thing.getGoat(), cabbagePos );
    }
    else {
        return null;
    }
    return thing;
    }
        public static final String FARMER = "Farmer goes alone";
        public static final String WOLF = "Farmer brings wolf";
        public static final String GOAT = "Farmer brings goat";
        public static final String CABBAGE = "Farmer brings cabbage";
    
}
