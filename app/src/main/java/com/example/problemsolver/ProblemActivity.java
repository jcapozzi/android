package com.example.problemsolver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.view.View;

/**
 * Created by Tyler on 4/27/2017.
 */

public class ProblemActivity extends AppCompatActivity {

    private FarmerState state;
    private CheckedTextView stateText;
    private EditText message;
    private FarmerState finalState = new FarmerState( Pos.EAST, Pos.EAST, Pos.EAST, Pos.EAST );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        state = new FarmerState( Pos.WEST, Pos.WEST, Pos.WEST, Pos.WEST );
        stateText = (CheckedTextView) findViewById(R.id.stateText);
        stateText.setText( state.toString() );
        message = (EditText) findViewById(R.id.message);
    }

    private void checkDone( FarmerState state ) {
        if ( finalState.equals( state ) ) {
            message.setText( "You Solved it!" );
        }
    }

    public void moveFarmer( View view ) {
        Pos farmerPos = state.getFarmer();
        if ((state.getCabbage() != state.getGoat()) && (state.getGoat() != state.getWolf())) {
            if ( farmerPos == Pos.EAST ) {
                farmerPos = Pos.WEST;
            } else {
                farmerPos = Pos.EAST;
            }
            state = new FarmerState( farmerPos, state.getWolf(), state.getGoat(), state.getCabbage() );
            stateText.setText( state.toString() );
            message.setText( "" );
            checkDone( state );
        } else {
            message.setText( "Invalid Move" );
        }
    }

    public void moveWolf( View view ) {
        Pos wolfPos = state.getWolf();
        if ((wolfPos == state.getFarmer()) && (state.getGoat() != state.getCabbage())) {
            if ( wolfPos == Pos.EAST ) {
                wolfPos = Pos.WEST;
            } else {
                wolfPos = Pos.EAST;
            }
            state = new FarmerState( wolfPos, wolfPos, state.getGoat(), state.getCabbage() );
            stateText.setText( state.toString() );
            message.setText( "" );
            checkDone( state );
        }
        else {
            message.setText( "Invalid Move" );
        }
    }

    public void moveGoat( View view ) {
        Pos goatPos = state.getGoat();
        if (goatPos == state.getFarmer()) {
            if ( goatPos == Pos.EAST ) {
                goatPos = Pos.WEST;
            } else {
                goatPos = Pos.EAST;
            }
            state = new FarmerState(goatPos, state.getWolf(), goatPos, state.getCabbage() );
            stateText.setText( state.toString() );
            message.setText( "" );
            checkDone( state );
        }
        else {
            message.setText( "Invalid Move" );
        }
    }

    public void moveCabbage( View view ) {
        Pos cabbagePos = state.getCabbage();
        if ((cabbagePos == state.getFarmer()) && (state.getWolf() != state.getGoat())) {
            if ( cabbagePos == Pos.EAST ) {
                cabbagePos = Pos.WEST;
            } else {
                cabbagePos = Pos.EAST;
            }
            state = new FarmerState(cabbagePos, state.getWolf(), state.getGoat(), cabbagePos );
            stateText.setText( state.toString() );
            message.setText( "" );
            checkDone( state );
        }
        else {
            message.setText( "Invalid Move" );
        }
    }
}
