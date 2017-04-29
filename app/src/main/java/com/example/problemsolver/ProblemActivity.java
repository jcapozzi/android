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

    private CheckedTextView stateText;
    private EditText message;
    private FarmerMover mover =  new FarmerMover();
    private FarmerProblem problem = new FarmerProblem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        stateText = (CheckedTextView) findViewById(R.id.stateText);
        stateText.setText( problem.getCurrentState().toString() );
        message = (EditText) findViewById(R.id.message);
    }

    private void tryMove( String moveName ) {
        FarmerState state = mover.doMove( moveName, problem.getCurrentState() );
        message.setText( "" );
        if ( state != null ) {
            problem.setCurrentState( state );
            stateText.setText( state.toString() );
            if ( problem.success() ) {
                message.setText( "Congrats you did it!" );
            }
        } else {
            message.setText( "Invalid move, try again" );
        }

    }

    public void moveFarmer( View view ) {
        tryMove( FarmerMover.FARMER );
    }

    public void moveWolf( View view ) {
        tryMove( FarmerMover.WOLF );
    }

    public void moveGoat( View view ) {
       tryMove( FarmerMover.GOAT );
    }

    public void moveCabbage( View view ) {
        tryMove( FarmerMover.CABBAGE );
    }
}
