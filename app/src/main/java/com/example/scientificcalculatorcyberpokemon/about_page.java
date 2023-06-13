package com.example.scientificcalculatorcyberpokemon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class about_page extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout cal1,cal2,cal3,about,exit;
    TextView t1,link,version;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        setupUiViows();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(about_page.this, MainActivity.class);
            }
        });

        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(about_page.this, programable2_calculator.class);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recreate();
                closeDrawer(drawerLayout);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        String des="THIS IS A CALCULATOR \n THIS APP CONTAIN 2 TYPES OF CALCULATOR NAMELY STANDARD AND PROGRAMMABLE";
        t1.setText(des);

        link.setMovementMethod(LinkMovementMethod.getInstance());

        link.setLinkTextColor(Color.BLUE);


    }

    public static void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }
    public static void redirectActivity(Activity activity, Class secondActivity)
    {
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(about_page.this);
        alertdialog.setTitle("EXIT APP");
        alertdialog.setMessage("Do you want to exit the app?");
        alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });

        alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertdialog.show();
    }

    void setupUiViows()
    {
        drawerLayout=findViewById(R.id.drawerlayout);
        menu=findViewById(R.id.menu);
        cal1=findViewById(R.id.standardcalculator);
        //cal2=findViewById(R.id.scientificcalculator);
        cal3=findViewById(R.id.programmer2calculator);
        about=findViewById(R.id.about);
        exit=findViewById(R.id.exit);
        t1=findViewById(R.id.textView3);
        link=findViewById(R.id.textView8);

        version=findViewById(R.id.textView6);
        version.setText("VERSION - 1.0 [STABLE]");



    }
}