package com.example.puzzlesolver;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int pic_id = 123;

    // Define the button and imageview type variable
    Button camera_open_id;
    Button get_hint_id;
    Button get_solution_id;
    ImageView click_image_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // By ID we can get each component
        // which id is assigned in XML file
        // get Buttons and imageview.
        camera_open_id = (Button)findViewById(R.id.camera_button);
        click_image_id = (ImageView)findViewById(R.id.click_image);
        get_hint_id = (Button)findViewById(R.id.hint_button);
        get_solution_id = (Button)findViewById(R.id.solution_button);
        get_hint_id.setEnabled(false);
        get_solution_id.setEnabled(false);
        get_hint_id.setVisibility(View.GONE);
        get_solution_id.setVisibility(View.GONE);

        // Camera_open button is for open the camera
        // and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // Create the camera_intent ACTION_IMAGE_CAPTURE
                // it will open the camera for capture the image
                Intent camera_intent
                        = new Intent(MediaStore
                        .ACTION_IMAGE_CAPTURE);

                // Start the activity with camera_intent,
                // and request pic id
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }

    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        // Match the request 'pic id with requestCode
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            // BitMap is data structure of image file
            // which stor the image in memory
            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
            get_solution_id.setEnabled(true);
            get_hint_id.setEnabled(true);
            get_hint_id.setVisibility(View.VISIBLE);
            get_solution_id.setVisibility(View.VISIBLE);
        }
    }

}