package com.example.celebrarbase;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import ja.burhanrashid52.photoeditor.PhotoEditor;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

public class EditImage extends AppCompatActivity implements AddFrameListner {
PhotoEditorView photoEditorView;
PhotoEditor photoEditor;
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);
        photoEditorView= findViewById(R.id.photoeditorview);
        photoEditorView.getSource().setImageURI(getIntent().getData());
        photoEditor = new PhotoEditor.Builder(this, photoEditorView)
                .setPinchTextScalable(true)
                .build();
        Button addframe= findViewById(R.id.addframe);
        Button saveimage= findViewById(R.id.saveimage);
        addframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            FrameFragment frameFragment = FrameFragment.getInstance();
            frameFragment.setListner(EditImage.this);
            frameFragment.show(getSupportFragmentManager(),frameFragment.getTag());
            }
        });
    }

    @Override
    public void onAddFrame(int frame) {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),frame);
        photoEditor.addImage(bitmap);

    }
}