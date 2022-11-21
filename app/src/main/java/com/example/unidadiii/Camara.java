package com.example.unidadiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camara extends AppCompatActivity {

    private Button btnCamara;

    // Define the pic id
    private static final int pic_id = 123;
    ImageView click_image_id;

    Bitmap photo;
    boolean photoTook = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        btnCamara = findViewById(R.id.btn_tomar_foto);

        click_image_id = findViewById(R.id.imagen_camara);

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        btnCamara.setOnClickListener(v -> {
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, pic_id);
        });
    }


    // This method will help to retrieve the image
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display

            click_image_id.setImageBitmap(photo);
        }
    }
}