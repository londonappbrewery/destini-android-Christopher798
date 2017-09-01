package com.londonappbrewery.destini;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 3 - Create 3 variables for views
    // TextView: a UI element that displays text to the user
    TextView myStoryTextView;
    Button myTopButton;
    Button myBottomButton;

    // TODO: Steps 4 & 8 - Declare member variables here:
    // Track app's state: multiple paths user can take
    int myStoryIndex = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // savedInstanceState = null when app is fired up from home screen
        if (savedInstanceState != null) {
            myStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        } else {
            myStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        // Step 4 - link the TextView and 2 buttons
        // T findViewById(int id): finds a view that was identified by the android:id XML attribute
        // Return: a view with given ID if found, or null otherwise
        // Casting a View to a Button
        myTopButton = (Button) findViewById(R.id.buttonTop);
        myBottomButton = (Button) findViewById(R.id.buttonBottom);
        myStoryTextView = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        // Button & TextView is a View
        // void setOnClickListener (View.OnClickListener l)
        // This registers a callback to be invoked
        myTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini", "Top button pressed!");
                // Toast makeText(Context context, CharSequence text, int duration): a view containing a quick little message for the user
                // context: the context to use, ususally your Application or Activity object
                // text: CharSequence: The text to show. Can be formatted text.
                // duration: int: How long to display the message (LENGTH_SHORT or LENGTH_LONG)
                Toast.makeText(getApplicationContext(), "Top Button Pressed!", Toast.LENGTH_SHORT).show();


                // Initially, T1_Story is on display
                // switch case statement to update when top button is pressed
                // TextView method: void setText(char[] text, int start, int len): display the specified slice of the specified char array
                switch (myStoryIndex) {
                    // when top button is pressed
                    case 1:
                        // update storyTextView state
                        myStoryIndex = 3;
                        // Display in TextView: void setText(int resid); void setText(CharSequence text)
                        myStoryTextView.setText(R.string.T3_Story);
                        myTopButton.setText(R.string.T3_Ans1);
                        myBottomButton.setText(R.string.T3_Ans2);
                        break;

                    case 2:
                        myStoryIndex = 3;
                        myStoryTextView.setText(R.string.T3_Story);
                        myTopButton.setText(R.string.T3_Ans1);
                        myBottomButton.setText(R.string.T3_Ans2);


                    case 3:
                        myStoryIndex = 6;
                        myStoryTextView.setText(R.string.T6_End);
                        // void setVisibility (int visibility): set the visibility state of the view
                        myTopButton.setVisibility(View.GONE);
                        myBottomButton.setVisibility(View.GONE);


                    default:
                        Toast quickMsg = Toast.makeText(getApplicationContext(), "Please Press A Button!!", Toast.LENGTH_SHORT);
                        quickMsg.show();

                }



            }

        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        myBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d(String tag, String msg)
                // String tag: Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
                Log.d("Destini", "Bottom button pressed!");

                // Toast: a view containing a quick little message for the user
                Toast.makeText(getApplicationContext(), "Bottom Button Pressed!", Toast.LENGTH_SHORT).show();



                // switch case statement to update
                switch (myStoryIndex) {
                    // when bottom button pressed
                    case 1:
                        myStoryIndex = 2;
                        myStoryTextView.setText(R.string.T2_Story);
                        myTopButton.setText(R.string.T2_Ans1);
                        myBottomButton.setText(R.string.T2_Ans2);
                        break;

                    case 2:
                        myStoryIndex = 4;
                        myStoryTextView.setText(R.string.T4_End);
                        myTopButton.setVisibility(View.INVISIBLE);
                        myBottomButton.setVisibility(View.INVISIBLE);



                    case 3:
                        myStoryIndex = 5;
                        myStoryTextView.setText(R.string.T5_End);
                        myTopButton.setVisibility(View.INVISIBLE);
                        myBottomButton.setVisibility(View.INVISIBLE);


                    default:
                        Toast quickMsg = Toast.makeText(getApplicationContext(), "Please Press A Button!!", Toast.LENGTH_SHORT);
                        quickMsg.show();

                }


            }
        });


    }

    @Override
    // Bundle: public final class Bundle extends BaseBundle implements Cloneable, Parcelable
    // Screen Rotation: onDestroy() -> onCreate(); onPause() -> onSaveInstanceState() -> onStop()
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // key-value pair: to store info in the Bundle
        // track app state: myStoryIndex
        outState.putInt("StoryIndexKey", myStoryIndex);
    }

}
