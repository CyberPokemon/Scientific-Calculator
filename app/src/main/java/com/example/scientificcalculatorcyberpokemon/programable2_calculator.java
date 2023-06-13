package com.example.scientificcalculatorcyberpokemon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class programable2_calculator extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout cal1,cal2,cal3,about,exit;
    TextView question,answer;
    Button bleftshift,brightshift,bunsignedrightshift,bANS,bequal,bbits,bnumbersystem,b7,b8,b9,bdel,bac,b4,b5,b6,ba,bb,b1,b2,b3,bc,bd,b0,bbracketopen,bbracketclose,be,bf,baddition,bsubstraction,bmultiplication,bdivision,bmod;
    String stackarr1[];
    long stackarr2[];
    int errorcode=-1;
    int bits=64;
    int base=10;
    String question1="",question2="";
    String finalanswer="0";
    int answerfound=0,answerdisplayed=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programable2_calculator);
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
                redirectActivity(programable2_calculator.this, MainActivity.class);
            }
        });

        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recreate();
                closeDrawer(drawerLayout);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(programable2_calculator.this, about_page.class);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerdisplayed==1)
                {
                    question1=""+"1";
                    question2=""+"1";
                    question.setText(question1);
                    answer.setText("");
                    answerdisplayed=0;
                    answerfound=0;
                }
                else if(checkbits(question2+"1",bits,base))
                {
                    question1 = question1 + "1";
                    question2 = question2 + "1";
                    question.setText(question1);
                    answer.setText("");
                }
                else
                {
                    Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"2";
                        question2=""+"2";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"2",bits,base))
                    {
                        question1 = question1 + "2";
                        question2 = question2 + "2";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"3";
                        question2=""+"3";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"3",bits,base)) {
                        question1 = question1 + "3";
                        question2 = question2 + "3";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"4";
                        question2=""+"4";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"4",bits,base)) {
                        question1 = question1 + "4";
                        question2 = question2 + "4";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"5";
                        question2=""+"5";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"5",bits,base))
                    {
                        question1 = question1 + "5";
                        question2 = question2 + "5";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"6";
                        question2=""+"6";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"6",bits,base))
                    {
                        question1 = question1 + "6";
                        question2 = question2 + "6";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>2)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"7";
                        question2=""+"7";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"7",bits,base))
                    {
                        question1 = question1 + "7";
                        question2 = question2 + "7";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>8)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"8";
                        question2=""+"8";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"8",bits,base))
                    {
                        question1 = question1 + "8";
                        question2 = question2 + "8";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>8)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"9";
                        question2=""+"9";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"9",bits,base))
                    {
                        question1 = question1 + "9";
                        question2 = question2 + "9";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerdisplayed==1)
                {
                    question1=""+"0";
                    question2=""+"0";
                    question.setText(question1);
                    answer.setText("");
                    answerdisplayed=0;
                    answerfound=0;
                }
                else if(checkbits(question2+"0",bits,base))
                {
                    question1 = question1 + "0";
                    question2 = question2 + "0";
                    question.setText(question1);
                    answer.setText("");
                }
                else
                {
                    Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                }

            }
        });
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"A";
                        question2=""+"A";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"A",bits,base))
                    {
                        question1 = question1 + "A";
                        question2 = question2 + "A";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"B";
                        question2=""+"B";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"B",bits,base))
                    {
                        question1 = question1 + "B";
                        question2 = question2 + "B";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"C";
                        question2=""+"C";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"C",bits,base)) {
                        question1 = question1 + "C";
                        question2 = question2 + "C";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"D";
                        question2=""+"D";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"D",bits,base)) {
                        question1 = question1 + "D";
                        question2 = question2 + "D";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"E";
                        question2=""+"E";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"E",bits,base))
                    {
                        question1 = question1 + "E";
                        question2 = question2 + "E";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(base>10)
                {
                    if(answerdisplayed==1)
                    {
                        question1=""+"F";
                        question2=""+"F";
                        question.setText(question1);
                        answer.setText("");
                        answerdisplayed=0;
                        answerfound=0;
                    }
                    else if(checkbits(question2+"F",bits,base)) {
                        question1 = question1 + "F";
                        question2 = question2 + "F";
                        question.setText(question1);
                        answer.setText("");
                    }
                    else
                    {
                        Toast.makeText(programable2_calculator.this, "BITS OVERFLOWED", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        baddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerfound==1)
                {
                    answerfound=0;
                    answerdisplayed=0;
                    question1=""+"ANS+";
                    question2=""+finalanswer+"+";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    question1=question1+"+";
                    question2=question2+"0+";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    question1=question1+"+";
                    question2=question2+"0+";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"+";
                    question2=question2.substring(0,question2.length()-1)+"+";
                    question.setText(question1);
                }
                else if(question1.length()>=4 && question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"+";
                    question2=question2.substring(0,question2.length()-3)+"+";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"+";
                    question2=question2.substring(0,question2.length()-2)+"+";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+"+";
                    question2=question2.substring(0,question2.length()-2)+"+";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='+')
                {
                    question1=question1+"+";
                    question2=question2+"+";
                    question.setText(question1);
                }

            }
        });
        bsubstraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerfound==1)
                {
                    answerfound=0;
                    answerdisplayed=0;
                    question1=""+"ANS-";
                    question2=""+finalanswer+"-";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    question1=question1+"-";
                    question2=question2+"0-";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    question1=question1+"-";
                    question2=question2+"0-";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"-";
                    question2=question2.substring(0,question2.length()-1)+"-";
                    question.setText(question1);
                }
                else if(question1.length()>=4 && question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"-";
                    question2=question2.substring(0,question2.length()-3)+"-";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"-";
                    question2=question2.substring(0,question2.length()-2)+"-";
                    question.setText(question1);
                }
                else if(question1.length()>=3 &&question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+"-";
                    question2=question2.substring(0,question2.length()-2)+"-";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='-')
                {
                    question1=question1+"-";
                    question2=question2+"-";
                    question.setText(question1);
                }
            }
        });
        bmultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerfound==1)
                {
                    answerfound=0;
                    answerdisplayed=0;
                    question1=""+"ANS*";
                    question2=""+finalanswer+"*";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:MULTIPLY CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:MULTIPLY CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"*";
                    question2=question2.substring(0,question2.length()-1)+"*";
                    question.setText(question1);
                }
                else if(question1.length()>=4 && question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"*";
                    question2=question2.substring(0,question2.length()-3)+"*";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"*";
                    question2=question2.substring(0,question2.length()-2)+"*";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+"*";
                    question2=question2.substring(0,question2.length()-2)+"*";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='*')
                {
                    question1=question1+"*";
                    question2=question2+"*";
                    question.setText(question1);
                }
            }
        });
        bdivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerfound==1)
                {
                    answerfound=0;
                    answerdisplayed=0;
                    question1=""+"ANS/";
                    question2=""+finalanswer+"/";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:DIVISION CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:DIVISION CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"/";
                    question2=question2.substring(0,question2.length()-1)+"/";
                    question.setText(question1);
                }
                else if(question1.length()>=4 && question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"/";
                    question2=question2.substring(0,question2.length()-3)+"/";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"/";
                    question2=question2.substring(0,question2.length()-2)+"/";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+"/";
                    question2=question2.substring(0,question2.length()-2)+"/";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='/')
                {
                    question1=question1+"/";
                    question2=question2+"/";
                    question.setText(question1);
                }

            }
        });
        bmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerfound==1)
                {
                    answerfound=0;
                    answerdisplayed=0;
                    question1=""+"ANS%";
                    question2=""+finalanswer+"%";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:MODULUS CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:MODULUS CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"%";
                    question2=question2.substring(0,question2.length()-1)+"%";
                    question.setText(question1);
                }
                else if(question1.length()>=4 && question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"%";
                    question2=question2.substring(0,question2.length()-3)+"%";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"%";
                    question2=question2.substring(0,question2.length()-2)+"%";
                    question.setText(question1);
                }
                else if(question1.length()>=3 && question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+"%";
                    question2=question2.substring(0,question2.length()-2)+"%";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='%')
                {
                    question1=question1+"%";
                    question2=question2+"%";
                    question.setText(question1);
                }

            }
        });
        bleftshift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:LEFTSHIFT CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:LEFTSHIFT CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"<<";
                    question2=question2.substring(0,question2.length()-1)+"<<";
                    question.setText(question1);
                }
                else if (question1.length()>=4 &&(question1.substring(question1.length()-3)).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3)+"<<";
                    question2=question2.substring(0,question2.length()-3)+"<<";
                    question.setText(question1);
                }
                else if (question1.length()>=3 &&(question1.substring(question1.length()-2)).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2)+"<<";
                    question2=question2.substring(0,question2.length()-2)+"<<";
                    question.setText(question1);

                }
                else if(question1.length()>=3 &&(question1.substring(question1.length()-2)).equals("<<")==false)
                {
                    question1=question1+"<<";
                    question2=question2+"<<";
                    question.setText(question1);
                }
                else if(question1.length()<3)
                {
                    question1=question1+"<<";
                    question2=question2+"<<";
                    question.setText(question1);
                }

            }
        });
        brightshift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:SIGNED RIGHT SHIFT CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:SIGNED RIGHT SHIFT CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+">>";
                    question2=question2.substring(0,question2.length()-1)+">>";
                    question.setText(question1);
                }
                else if (question1.length()>=3 && (question1.substring(question1.length()-3)).equals(">>>"))
                {//error need to be rectified
                    question1=question1.substring(0,question1.length()-3)+">>";
                    question2=question2.substring(0,question2.length()-3)+">>";
                    question.setText(question1);
                }
                else if (question1.length()>=3 &&(question1.substring(question1.length()-2)).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+">>";
                    question2=question2.substring(0,question2.length()-2)+">>";
                    question.setText(question1);

                }
                else if(question1.length()>=3 &&(question1.substring(question1.length()-2)).equals(">>")==false)
                {
                    question1=question1+">>";
                    question2=question2+">>";
                    question.setText(question1);
                }
                else if(question1.length()<3)
                {
                    question1=question1+">>";
                    question2=question2+">>";
                    question.setText(question1);
                }

            }
        });
        bunsignedrightshift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:UNSIGNED RIGHT SHIFT CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(programable2_calculator.this, "ERROR:UNSIGNED RIGHT SHIFT CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+">>>";
                    question2=question2.substring(0,question2.length()-1)+">>>";
                    question.setText(question1);
                }
                else if (question1.length()>=3 && (question1.substring(question1.length()-2)).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2)+">>>";
                    question2=question2.substring(0,question2.length()-2)+">>>";
                    question.setText(question1);
                }
                else if (question1.length()>=3 &&((question1.substring(question1.length()-3)).equals(">>>")==false) && (question1.substring(question1.length()-2).equals(">>")==true))
                {
                    question1=question1.substring(0,question1.length()-2)+">>>";
                    question2=question2.substring(0,question2.length()-2)+">>>";
                    question.setText(question1);
                }
                else if(question1.length()>=3 &&(question1.substring(question1.length()-3)).equals(">>>")==false)
                {
                    question1=question1+">>>";
                    question2=question2+">>>";
                    question.setText(question1);
                }
                else if(question1.length()<3)
                {
                    question1=question1+">>>";
                    question2=question2+">>>";
                    question.setText(question1);
                }
            }
        });
        bANS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question1=question1+"ANS";
                question2=question2+finalanswer;
                question.setText(question1);
                answer.setText("");
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR: EQUATION NOT ENTERED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    evaluate(question2,base);
                    if(errorcode==1)
                    {
                        answer.setText("BRACKET MISMATCH");
                        errorcode=-1;
                    }
                    else if (errorcode==2)
                    {
                        answer.setText("WRONG EXPRESSION");
                        errorcode=-1;

                    }
                    else if(errorcode==3)
                    {
                        answer.setText("DIVISION BY ZERO NOT POSSIBLE");
                        errorcode=-1;
                    }
                    else
                    {
                        answer.setText("="+finalanswer);
                        answerfound=1;
                        answerdisplayed=1;
                    }
                }

            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    Toast.makeText(programable2_calculator.this, "ERROR: NO TEXT TO BE ERASED", Toast.LENGTH_SHORT).show();
                }
                else if(question1.length()>=3 && question1.lastIndexOf("ANS")==question1.length()-3)
                {
                    question1=question1.substring(0,question1.length()-3);
                    question2=question2.substring(0,question2.length()-finalanswer.length());
                    question.setText(question1);
                    answer.setText("");
                }
                else if(Character.isDigit(question1.charAt(question1.length()-1)))
                {
                    question1=question1.substring(0,question1.length()-1);
                    question2=question2.substring(0,question2.length()-1);
                    question.setText(question1);
                    answer.setText("");
                }
                else if ("+-/*^%()".indexOf(question1.charAt(question1.length()-1)) >-1)
                {
                    question1=question1.substring(0,question1.length()-1);
                    question2=question2.substring(0,question2.length()-1);
                    question.setText(question1);
                    answer.setText("");
                }
                else if(question1.substring(question1.length()-3).equals(">>>"))
                {
                    question1=question1.substring(0,question1.length()-3);
                    question2=question2.substring(0,question2.length()-3);
                    question.setText(question1);
                    answer.setText("");
                }
                else if(question1.substring(question1.length()-2).equals(">>"))
                {
                    question1=question1.substring(0,question1.length()-2);
                    question2=question2.substring(0,question2.length()-2);
                    question.setText(question1);
                    answer.setText("");
                }
                else if(question1.substring(question1.length()-2).equals("<<"))
                {
                    question1=question1.substring(0,question1.length()-2);
                    question2=question2.substring(0,question2.length()-2);
                    question.setText(question1);
                    answer.setText("");
                }
            }
        });
        bdel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                question1="";
                question2="";
                question.setText(question1);
                return true;

            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question1="";
                question2="";
                answerfound=0;
                finalanswer="0";
                answer.setText("");
                question.setText("");

            }
        });
        bnumbersystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (base)
                {
                    case 2:base=8;
                        bnumbersystem.setText("OCT");
                        if(question1.equals("")==false)
                        {
                            question1=changequestionbase(question1,2);
                            question2=changequestionbase(question2,2);
                            question.setText(question1);
                        }
                        if(answerfound==1)
                        {
                            if(finalanswer.charAt(0)=='-')
                            {
                                System.out.println("STEP 8 NEGATIVE");
                                finalanswer=toActualBase2(Long.parseLong(toDecimal(finalanswer.substring(1),2)),base);
                                if(answerdisplayed==1)
                                {
                                    answer.setText("=-"+finalanswer);
                                }
                                finalanswer="-"+finalanswer;
                            }
                            else
                            {
                                System.out.println("STEP 8 POSITIVE");
                                finalanswer = toActualBase2(Long.parseLong(toDecimal(finalanswer, 2)), base);
                                System.out.println(finalanswer);
                                if (answerdisplayed == 1) {
                                    answer.setText("=" + finalanswer);
                                }
                            }
                        }
                        break;
                    case 8:base=10;
                        bnumbersystem.setText("DEC");
                        if(question1.equals("")==false)
                        {
                            question1=changequestionbase(question1,8);
                            question2=changequestionbase(question2,8);
                            question.setText(question1);
                        }
                        if(answerfound==1)
                        {
                            if(finalanswer.charAt(0)=='-')
                            {
                                System.out.println("STEP 10 NEGATIVE");
                                finalanswer=toActualBase2(Long.parseLong(toDecimal(finalanswer.substring(1),8)),base);
                                if(answerdisplayed==1)
                                {
                                    answer.setText("=-"+finalanswer);
                                }
                                finalanswer="-"+finalanswer;
                            }
                            else
                            {
                                System.out.println("STEP 10 POSITIVE");
                                finalanswer = toActualBase2(Long.parseLong(toDecimal(finalanswer, 8)), base);
                                System.out.println(finalanswer);
                                if (answerdisplayed == 1) {
                                    answer.setText("=" + finalanswer);
                                }
                            }
                        }
                        break;
                    case 10:base=16;
                        bnumbersystem.setText("HEX");
                        if(question1.equals("")==false)
                        {
                            question1=changequestionbase(question1,10);
                            question2=changequestionbase(question2,10);
                            question.setText(question1);
                        }
                        if(answerfound==1)
                        {
                            if(finalanswer.charAt(0)=='-')
                            {
                                System.out.println("STEP 16 NEGATIVE");
                                finalanswer=toActualBase2(Long.parseLong(toDecimal(finalanswer.substring(1),10)),base);
                                if(answerdisplayed==1)
                                {
                                    answer.setText("=-"+finalanswer);
                                }
                                finalanswer="-"+finalanswer;
                            }
                            else
                            {
                                System.out.println("STEP 16 POSITIVE");
                                finalanswer = toActualBase2(Long.parseLong(toDecimal(finalanswer, 10)), base);
                                System.out.println(finalanswer);
                                if (answerdisplayed == 1) {
                                    answer.setText("=" + finalanswer);
                                }
                            }
                        }
                        break;
                    case 16:base=2;
                        bnumbersystem.setText("BIN");
                        if(question1.equals("")==false)
                        {
                            question1=changequestionbase(question1,16);
                            question2=changequestionbase(question2,16);
                            question.setText(question1);
                        }
                        if(answerfound==1)
                        {
                            if(finalanswer.charAt(0)=='-')
                            {
                                System.out.println("STEP 2 NEGATIVE");
                                finalanswer=toActualBase2(Long.parseLong(toDecimal(finalanswer.substring(1),16)),base);
                                if(answerdisplayed==1)
                                {
                                    answer.setText("=-"+finalanswer);
                                }
                                finalanswer="-"+finalanswer;
                            }
                            else
                            {
                                System.out.println("STEP 2 POSITIVE");
                                finalanswer = toActualBase2(Long.parseLong(toDecimal(finalanswer, 16)), base);
                                System.out.println(finalanswer);
                                if (answerdisplayed == 1) {
                                    answer.setText("=" + finalanswer);
                                }
                            }
                        }
                        break;
                }

            }
        });
        bbits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question1.equals(""))
                {
                    switch (bits) {
                        case 8:
                            bits = 16;
                            bbits.setText("16B");
                            break;
                        case 16:
                            bits = 32;
                            bbits.setText("32B");
                            break;
                        case 32:
                            bits = 64;
                            bbits.setText("64B");
                            break;
                        case 64:
                            bits = 8;
                            bbits.setText("8B");
                            break;
                    }
                }
            }
        });
        bbracketopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question1=question1+"(";
                question2=question2+"(";
                question.setText(question1);
                answer.setText("");
            }
        });
        bbracketclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question1=question1+")";
                question2=question2+")";
                question.setText(question1);
                answer.setText("");
            }
        });

        question.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if(question1.length()!=0)
                {
                    ClipData clip = ClipData.newPlainText("COPIED TEXT", question1);
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(programable2_calculator.this, "EXPRESSION COPIED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(programable2_calculator.this, "ERROR: NO TEXT TO COPY", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        answer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if(answerfound==1 && answerdisplayed==1)
                {
                    ClipData clip = ClipData.newPlainText("COPIED TEXT", finalanswer);
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(programable2_calculator.this, "ANSWER COPIED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(programable2_calculator.this, "ERROR: NO TEXT TO COPY", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
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
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(programable2_calculator.this);
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

    String changequestionbase(String str,int methodbase)
    {
        int k=0,i;
        StringTokenizer stz= new StringTokenizer(str,"+-*/()^%<<>>>",true);
        String arr1[]= new String[stz.countTokens()];
        while(stz.hasMoreTokens())
        {
            arr1[k]=stz.nextToken();
            k++;
        }
        for(i=0;i<arr1.length;i++)
        {
            if("+-*.%/<<>>>()ANS ".indexOf(arr1[i])==-1 || "ABCDEF".indexOf(arr1[i])>-1 )
            {
                arr1[i]= toActualBase2(Long.parseLong(toDecimal(arr1[i],methodbase)),base);

            }
        }
        String newstr="";
        for(i=0;i<arr1.length;i++)
        {
            newstr=newstr+arr1[i];
        }
        return newstr;



    }

    void evaluate(String str, int base)
    {
        int k=0,i,j;
        //System.out.println(str);
        StringTokenizer stz= new StringTokenizer(str,"+-*/()^%",true);
        String arr1[]= new String[stz.countTokens()];
        String arr2[];
        String arr3[]= new String[str.length()];
        String arr4[];
        while(stz.hasMoreTokens())
        {
            arr1[k]=stz.nextToken();
            k++;
        }
        //System.out.println("pass 1");
        //for(i=0;i<arr1.length;i++)
        //{
        //    System.out.print(arr1[i]+" ");
        //}
        //System.out.println();
        k=0;
        for(i=0;i<arr1.length;i++)
        {
            if((arr1[i].indexOf("<<")>-1) || (arr1[i].indexOf(">>")>-1) || (arr1[i].indexOf(">>>")>-1) )
            {
                arr4=separate(arr1[i]);
                for(j=0;j<arr4.length;j++)
                {
                    arr3[k]=arr4[j];
                    k++;
                }
            }
            else
            {
                arr3[k]=arr1[i];
                k++;
            }
        }
        arr1=new String[k];
        arr2=new String[k];
        for(i=0;i<k;i++)
        {
            arr1[i]=arr3[i];
        }
        //System.out.println("pass 2");
        //for(i=0;i<arr1.length;i++)
        //{
        //System.out.print(arr1[i]+" ");
        //}
        //System.out.println();
        for(i=0;i<arr1.length;i++)
        {
            if("+-* /()<<<>>^%".indexOf(arr1[i])==-1)
            {
                arr2[i]=toDecimal(arr1[i],base);
            }
            else
            {
                arr2[i]=arr1[i];
            }
        }
        //System.out.println("pass 3");
        //for(i=0;i<arr1.length;i++)
        //{
        //System.out.print(arr2[i]+" ");
        //}

        if(bracketcheck(arr1)==false)
        {
            errorcode=1;
            return;
        }
        stackarr1=postfix(arr2);
        //System.out.println();
        //System.out.println("pass 4");
        //for(i=0;i<stackarr1.length;i++)
        //{
        //    System.out.print(stackarr1[i]+" ");
        //}
        long answer=solve(stackarr1);
        String answer2=toActualBase2(answer,base);
        //if(errorcode==2)
        //{
        //   System.out.println("WRONG EXPRESSION");
        //}
        //else
        //{
        //System.out.println("ANSWER = "+answer2);
        //}
        finalanswer=answer2;
    }
    boolean checkbits(String str,int bits,int mbase)
    {
        int k=0,i,j;
        String str2;
        StringTokenizer stz= new StringTokenizer(str,"+-*/()^%<>");
        String arr1[]= new String[stz.countTokens()];
        while(stz.hasMoreTokens())
        {
            arr1[k]=stz.nextToken();
            k++;
        }
        for(i=0;i<arr1.length;i++)
        {
            if("+-*.%<<>>>() ".indexOf(arr1[i])==-1)
            {
                if(toActualBase2(Long.parseLong(toDecimal(arr1[i],mbase)),2).length()>=bits)
                {
                    return false;
                }
            }
        }
        return true;
    }
    String[] separate(String str)
    {
        String arr1[]=new String[str.length()];
        int i,k=0;
        char ch;
        String w="";
        for(i=0;i<str.length();i++)
        {
            ch=str.charAt(i);
            if(str.indexOf("<<",i)==i)
            {
                if(w.equals("")==false)
                {
                    arr1[k]=w;
                    k++;
                }
                arr1[k]="<<";
                k++;
                i++;
                w="";
            }
            else if(str.indexOf(">>>",i)==i)
            {
                if(w.equals("")==false)
                {
                    arr1[k]=w;
                    k++;
                }
                arr1[k]=">>>";
                k++;
                i+=2;
                w="";
            }
            else if(str.indexOf(">>",i)==i)
            {
                if(w.equals("")==false)
                {
                    arr1[k]=w;
                    k++;
                }
                arr1[k]=">>";
                k++;
                i++;
                w="";
            }
            else
            {
                w=w+ch;
            }
        }
        if(w.equals("")==false)
        {
            arr1[k]=w;
            k++;
        }
        String arr2[]=new String[k];
        for(i=0;i<arr2.length;i++)
        {
            arr2[i]=arr1[i];
        }
        return arr2;
    }
    String toDecimal(String str, int base)
    {
        str=str.toUpperCase();
        if(base ==10)
        {
            return str;
        }
        else
        {
            int i,n,newnum=0;
            char ch;
            if(base==10)
            {
                System.out.println(str);
                System.exit(0);
            }
            for(i=0;i<str.length();i++)
            {
                ch=str.charAt(str.length()-1-i);
                if(ch>='A' && ch<='Z')
                {
                    n=(int)ch-55;
                }
                else
                {
                    n=Integer.parseInt(ch+"");
                }
                newnum=newnum+(n*((int)Math.pow(base,i)));
            }
            System.out.println(newnum);
            System.out.println(""+newnum);
            return ""+newnum;
        }
    }
    String toActualBase(int num, int base)
    {
        if(base==10)
        {
            return ""+num;
        }
        else
        {
            int i;
            String arr[]= new String[base];
            for(i=0;i<=9 && i< base;i++)
            {
                arr[i]=Integer.toString(i);
            }
            for(i=10;i<base;i++)
            {
                arr[i]=(char)(55+i)+"";
            }
            String number="";
            int d;
            while(num>0)
            {
                d=num%base;
                number = arr[d]+ number;
                num/=base;
            }
            return number;
        }
    }
    String toActualBase2(long num, long base)
    {
        if(base==10)
        {
            return ""+num;
        }
        else
        {
            long i;
            String arr[]= new String[(int) base];
            for(i=0;i<=9 && i< base;i++)
            {
                arr[(int)i]=Integer.toString((int)i);
            }
            for(i=10;i<base;i++)
            {
                arr[(int) i]=(char)(55+((int)i))+"";
            }
            String number="";
            long d;
            while(num>0)
            {
                d=num%base;
                number = ""+arr[(int) d]+ number;
                num/=base;
            }
            System.out.println("long ="+number+" + "+number.length());
            if(number.length()==0)
            {
                return "0";
            }
            else
                return number;
        }
    }
    long solve(String arr[])
    {
        stack_long obj1= new stack_long(arr.length);
        int i;
        long a,b;
        for(i=0;i<arr.length;i++)
        {
            if("+-*/^%<<>>>".indexOf(arr[i])>-1)
            {
                //System.out.println("pass execution");
                a=obj1.pop();
                //System.out.println("A = "+a);
                if(obj1.top==-1)
                {
                    errorcode=2;
                    return 0;
                }
                b=obj1.pop();
                //System.out.println("B = "+b);
                if(arr[i].charAt(0)=='+')
                {
                    obj1.push(b+a);
                }
                else if(arr[i].charAt(0)=='-')
                {
                    obj1.push(b-a);
                }
                else if(arr[i].charAt(0)=='*')
                {
                    obj1.push(b*a);
                }
                else if(arr[i].charAt(0)=='/')
                {
                    if(a==0)
                    {
                        errorcode=3;
                        return 0;
                    }
                    obj1.push(b/a);
                }
                else if(arr[i].charAt(0)=='%')
                {
                    obj1.push(b%a);
                }
                else if(arr[i].charAt(0)=='^')
                {
                    obj1.push((int)Math.pow(b,a));
                }
                else if(arr[i].equals("<<"))
                {
                    obj1.push(b<<a);
                }
                else if(arr[i].equals(">>"))
                {
                    obj1.push(b>>a);
                }
                else if(arr[i].equals(">>>"))
                {
                    obj1.push(b>>>a);
                }
            }
            else
            {
                obj1.push(Integer.parseInt(arr[i]));
            }
        }
        return obj1.peek();
    }
    String[] postfix(String arr[])
    {
        stack_String obj1= new stack_String(arr.length);
        stack_String obj2= new stack_String(arr.length);
        int i,c=0;
        for(i=0;i<arr.length;i++)
        {
            if("(+-*/^)%<<>>>".indexOf(arr[i])==-1)
            {
                obj1.push(arr[i]);
            }
            else if("+-*/^%<<>>>".indexOf(arr[i])>-1)
            {
                if(presedence(arr[i])> presedence(obj2.peek()))
                {
                    obj2.push(arr[i]);
                }
                else
                {
                    while(presedence(arr[i])<=presedence(obj2.peek()))
                    {
                        obj1.push(""+obj2.pop());
                    }
                    obj2.push(arr[i]);
                }
            }
            else
            {
                if(arr[i].equals("("))
                {
                    obj2.push("(");
                    c+=2;
                }
                else if(arr[i].equals(")"))
                {
                    while(obj2.peek().equals("(")==false)
                    {
                        obj1.push(""+obj2.pop());
                    }
                    obj2.pop();
                }
            }
        }
        while(obj2.isEmpty()==false)
        {
            obj1.push(""+obj2.pop());
        }
        String arr3[]= new String[arr.length-c];
        for(i=0;i<arr3.length;i++)
        {
            arr3[i]=obj1.arr[i];
        }
        return arr3;
    }
    int presedence(String ch)
    {
        if(ch.equals("+"))
        {
            return 1;
        }
        else if(ch.equals("-"))
        {
            return 1;
        }
        else if(ch.equals("*"))
        {
            return 2;
        }
        else if(ch.equals("/"))
        {
            return 2;
        }
        else if(ch.equals("%"))
        {
            return 2;
        }
        else if(ch.equals("^"))
        {
            return 3;
        }
        else if(ch.equals("<<"))
        {
            return 4;
        }
        else if(ch.equals(">>"))
        {
            return 4;
        }
        else if(ch.equals(">>>"))
        {
            return 4;
        }
        return 0;
    }
    boolean bracketcheck(String arr[])
    {
        stack_char obj1= new stack_char(arr.length);
        int i,l=arr.length;
        char ch2;
        for(i=0;i<l;i++)
        {
            if("(){}[]".indexOf(arr[i])!=-1)
            {
                if("({[".indexOf(arr[i])!=-1)
                {
                    obj1.push(arr[i].charAt(0));
                }
                else
                {
                    ch2=obj1.peek();
                    if(ch2==32)
                    {
                        //System.out.println("RIGHT EXTRA");
                        return false;
                    }
                    if((""+ch2+arr[i].charAt(0)).equals("()") || (""+ch2+arr[i].charAt(0)).equals("{}") || (""+ch2+arr[i].charAt(0)).equals("[]"))
                    {
                        obj1.pop();
                    }
                    else
                    {
                        //System.out.println("bracket mismatch");
                        return false;
                    }
                }
            }
        }
        if(obj1.isEmpty())
        {
            //System.out.println("CORRECT EQUATION");
            return true;
        }
        else
        {
            //System.out.println("LEFT EXTRA");
            return false;
        }
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

        bleftshift=findViewById(R.id.bleftshift);
        bleftshift.setText("<<");
        brightshift=findViewById(R.id.brightshift);
        bunsignedrightshift=findViewById(R.id.bunsignedrightshift);
        bANS=findViewById(R.id.bANS);
        bequal=findViewById(R.id.bEQUAL);
        bbits=findViewById(R.id.bbits);
        bnumbersystem=findViewById(R.id.bnumbersystem);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        bdel=findViewById(R.id.bDEL);
        bac=findViewById(R.id.bAC);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        ba=findViewById(R.id.bA);
        bb=findViewById(R.id.bB);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        bc=findViewById(R.id.bC);
        bd=findViewById(R.id.bD);
        b0=findViewById(R.id.b0);
        bbracketopen=findViewById(R.id.bBRACKETOPEN);
        bbracketclose=findViewById(R.id.bBRACKETCLOSE);
        be=findViewById(R.id.bE);
        bf=findViewById(R.id.bF);
        baddition=findViewById(R.id.bADDITION);
        bsubstraction=findViewById(R.id.bSUBSTRACTION);
        bmultiplication=findViewById(R.id.bMULTIPLICATION);
        bdivision=findViewById(R.id.bDIVISION);
        bmod=findViewById(R.id.bMOD);
        question=findViewById(R.id.question);
        question.setMovementMethod(new ScrollingMovementMethod());
        answer=findViewById(R.id.ANSWER);
        answer.setMovementMethod(new ScrollingMovementMethod());
    }
}