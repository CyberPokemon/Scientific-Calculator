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

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout cal1,cal2,cal3,about,exit;
    TextView question,answer;
    Button b0,bdot,bpower,banswer,equal,b1,b2,b3,baddition,bsubtraction,b4,b5,b6,bmultiply,bdivision,b7,b8,b9,bdel,bAC,bFraction,bcuberoot,bsquareroot,bopenbracket,bclosebracket;
    String question1="",question2="";
    String stackarr1[];
    double stackarr2[];
    int errorcode=-1,answercalculated=0,INFRACTION=0;
    double answerstored;

    String answerstoredstring="";
    int answerstoredlength=0;
    String question2lengthsq="";

    int lastindexclosedsq=-1,lastindexclosedcu=-1;

    int bracketsq[][]=new int[50][3];
    int bracketcu[][]=new int[50][3];
    int k1=-1,k2=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                //recreate();
                closeDrawer(drawerLayout);
            }
        });

        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, programable2_calculator.class);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, about_page.class);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAffinity();
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

                    Toast.makeText(MainActivity.this, "EXPRESSION COPIED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "ERROR: NO TEXT TO COPY", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        answer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if(INFRACTION==0)
                {
                    ClipData clip = ClipData.newPlainText("COPIED TEXT", Double.toString(answerstored));
                    clipboard.setPrimaryClip(clip);

                    Toast.makeText(MainActivity.this, "ANSWER COPIED", Toast.LENGTH_SHORT).show();
                }
                else if(INFRACTION==1)
                {
                    if(answerstored<0)
                    {
                        ClipData clip = ClipData.newPlainText("COPIED TEXT", "-"+toFraction(Math.abs(answerstored)));
                        clipboard.setPrimaryClip(clip);

                        Toast.makeText(MainActivity.this, "ANSWER COPIED", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ClipData clip = ClipData.newPlainText("COPIED TEXT", toFraction(Math.abs(answerstored)));
                        clipboard.setPrimaryClip(clip);

                        Toast.makeText(MainActivity.this, "ANSWER COPIED", Toast.LENGTH_SHORT).show();
                    }

                }
                return true;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"1";
                question2=question2+"1";
                question.setText(question1);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"2";
                question2=question2+"2";
                question.setText(question1);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"3";
                question2=question2+"3";
                question.setText(question1);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"4";
                question2=question2+"4";
                question.setText(question1);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"5";
                question2=question2+"5";
                question.setText(question1);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"6";
                question2=question2+"6";
                question.setText(question1);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"7";
                question2=question2+"7";
                question.setText(question1);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"8";
                question2=question2+"8";
                question.setText(question1);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"9";
                question2=question2+"9";
                question.setText(question1);

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"0";
                question2=question2+"0";
                question.setText(question1);

            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                if(question1.equals(""))
                {
                    question1=question1+"0.";
                    question2=question2+"0.";
                    question.setText(question1);
                }
                else if (Math.max(Math.max(Math.max(question1.lastIndexOf('+'),question1.lastIndexOf('-')),Math.max(question1.lastIndexOf("*"),question1.lastIndexOf("/"))),Math.max(Math.max(question1.lastIndexOf("%"),question1.lastIndexOf("^")),Math.max(question1.lastIndexOf("("),question1.lastIndexOf(")"))))>question1.lastIndexOf("."))
                {
                    question1=question1+".";
                    question2=question2+".";
                    question.setText(question1);
                }
                else if(question1.lastIndexOf("+")==-1 && question1.lastIndexOf("-")==-1 && question1.lastIndexOf("*")==-1 && question1.lastIndexOf("/")==-1 && question1.lastIndexOf("%")==-1 && question1.lastIndexOf("^")==-1 &&question1.lastIndexOf("(")==-1 && question1.lastIndexOf(")")==-1 )
                {
                    question1=question1+".";
                    question2=question2+".";
                    question.setText(question1);

                }

            }
        });
        bpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS"+"^";
                    question2=question2+answerstored+"^";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(MainActivity.this, "ERROR:POWER CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(MainActivity.this, "ERROR:POWER CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='/')
                {
                    question1=question1.substring(0,question1.length()-1)+"^";
                    question2=question2.substring(0,question2.length()-1)+"^";
                    question.setText(question1);
                }
                else if(question1.charAt(question1.length()-1)!='^')
                {
                    question1=question1+"^";
                    question2=question2+"^";
                    question.setText(question1);
                }

            }
        });
        baddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS"+"+";
                    question2=question2+answerstored+"+";
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
                else if(question1.charAt(question1.length()-1)!='+')
                {
                    question1=question1+"+";
                    question2=question2+"+";
                    question.setText(question1);
                }
            }
        });
        bsubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS"+"-";
                    question2=question2+answerstored+"-";
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
                else if(question1.charAt(question1.length()-1)!='-')
                {
                    question1=question1+"-";
                    question2=question2+"-";
                    question.setText(question1);
                }

            }
        });
        bmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS"+"*";
                    question2=question2+answerstored+"*";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(MainActivity.this, "ERROR:MULTIPLY CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(MainActivity.this, "ERROR:MULTIPLY CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='/'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"*";
                    question2=question2.substring(0,question2.length()-1)+"*";
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
            public void onClick(View view)
            {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS"+"/";
                    question2=question2+answerstored+"/";
                    question.setText(question1);
                }
                else if(question1.equals(""))
                {
                    Toast.makeText(MainActivity.this, "ERROR:DIVISION CANNOT BE PUT AT THE BEGINNING OF THE EQUATION", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='(')
                {
                    Toast.makeText(MainActivity.this, "ERROR:DIVISION CANNOT BE PUT AFTER BEGINNING OF THE BRACKET", Toast.LENGTH_SHORT).show();
                }
                else if(question1.charAt(question1.length()-1)=='-'||question1.charAt(question1.length()-1)=='*'||question1.charAt(question1.length()-1)=='+'||question1.charAt(question1.length()-1)=='%'||question1.charAt(question1.length()-1)=='^')
                {
                    question1=question1.substring(0,question1.length()-1)+"/";
                    question2=question2.substring(0,question2.length()-1)+"/";
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
        banswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                    question1=question1+"ANS";
                    question2=question2+answerstored;
                    question.setText(question1);
                }
                else if(question1.equals("")==false && "+-*/^(".indexOf((question1.charAt(question1.length()-1)))!=-1) {
                    question1 = question1 + "ANS";
                    question2 = question2 + Double.toString(answerstored);
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2);
                }
                else if(question1.equals(""))
                {
                    question1 = question1 + "ANS";
                    question2 = question2 + Double.toString(answerstored);
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2);
                }

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "ERROR: EQUATION NOT ENTERED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    evaluate(question2);
                    //question.setText(question1+"\n"+question2);
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
                    else
                    {
                        answerstoredstring=Double.toString(answerstored);
                        answerstoredlength=answerstoredstring.length();
                        answer.setText("= "+answerstored);
                        answercalculated=1;
                    }
                }

            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    answer.setText("");
                }
                if(question1.length()==0)
                {
                    question.setText("");
                    answer.setText("");
                }
                else if(question1.length()>=5 && question1.lastIndexOf("SQRT(")==question1.length()-5 )
                {
                    question1 = question1.substring(0, question1.length() - 5);
                    question2 = question2.substring(0, question2.length() - 5);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    bracketsq[k1][0]=-1;
                    for(int i=0;i<k1;i++)
                    {
                        bracketsq[i][1]-=2;
                    }
                    k1--;
                }
                else if(question1.length()>=5 && question1.lastIndexOf("CBRT(")==question1.length()-5 )
                {
                    question1 = question1.substring(0, question1.length() - 5);
                    question2 = question2.substring(0, question2.length() - 5);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    bracketcu[k2][0]=-1;
                    for(int i=0;i<k2;i++)
                    {
                        bracketcu[i][1]-=2;
                    }
                    k2--;

                }
                else if(question2.length()>=9 &&question2.indexOf("}}^{1/2}}")==question2.length()-9)
                {
                    question1 = question1.substring(0, question1.length() - 1);
                    question2 = question2.substring(0, question2.length() - 9);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    int index,index2=-1;
                    if(lastindexclosedsq==-1)
                    {
                        for(index=0;index<=k1;index++)
                        {
                            if(bracketsq[index][0]==bracketsq[index][2] && bracketsq[index][1]>=3)
                            {
                                index2=index;
                            }
                        }
                        index=index2+1;
                        bracketsq[index][0]=bracketsq[index][2];
                        bracketsq[index][1]=3;
                    }
                    else
                    {
                        for(index=0;index<=k1;index++)
                        {
                            if(bracketsq[index][2]==lastindexclosedsq)
                            {
                                bracketsq[index][0]=bracketsq[index][2];
                                bracketsq[index][1]=3;
                                lastindexclosedsq=-1;
                            }
                        }
                    }
                }
                else if(question2.length()>=9 &&question2.indexOf("]]^[1/3]]")==question2.length()-9)
                {
                    question1 = question1.substring(0, question1.length() - 1);
                    question2 = question2.substring(0, question2.length() - 9);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    int index,index2=-1;
                    if(lastindexclosedsq==-1)
                    {
                        for(index=0;index<=k2;index++)
                        {
                            if(bracketcu[index][0]==bracketcu[index][2] && bracketcu[index][1]>=3)
                            {
                                index2=index;
                            }
                        }
                        index=index2+1;
                        bracketcu[index][0]=bracketcu[index][2];
                        bracketcu[index][1]=3;
                    }
                    else
                    {
                        for(index=0;index<=k1;index++)
                        {
                            if(bracketcu[index][2]==lastindexclosedcu)
                            {
                                bracketcu[index][0]=bracketcu[index][2];
                                bracketcu[index][1]=3;
                                lastindexclosedcu=-1;
                            }
                        }
                    }
                }
                else if(question1.indexOf("ANS")==question1.length()-3  && question1.indexOf("ANS")!=-1)
                {
                    question1 = question1.substring(0, question1.length() - 3);
                    question2 = question2.substring(0, question2.length() - answerstoredlength);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    //answer.setText("CRASH1");
                    //question.setText(question1 +"\n"+question2 +"\n"+question1.length()+"\n"+question2.length());
                }
                /*else if(question2.charAt(question2.length()-1)=='}')
                {
                }
                */
                else if(question1.lastIndexOf('(')==question1.length()-1)
                {
                    question1 = question1.substring(0, question1.length() - 1);
                    question2 = question2.substring(0, question2.length() - 1);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    int i;
                    for(i=0;i<=k1;i++)
                    {
                        if(bracketsq[i][0]!=-1)
                        {
                            bracketsq[i][1]--;
                        }
                    }
                    for(i=0;i<=k2;i++)
                    {
                        if(bracketcu[i][0]!=-1)
                        {
                            bracketcu[i][1]--;
                        }
                    }
                }
                else if(question1.lastIndexOf(')')==question1.length()-1)
                {
                    question1 = question1.substring(0, question1.length() - 1);
                    question2 = question2.substring(0, question2.length() - 1);
                    question.setText(question1);
                    //question.setText(question1+"\n"+question2);
                    int i;
                    for(i=0;i<=k1;i++)
                    {
                        if(bracketsq[i][0]!=-1)
                        {
                            bracketsq[i][1]++;
                        }
                    }
                    for(i=0;i<=k2;i++)
                    {
                        if(bracketcu[i][0]!=-1)
                        {
                            bracketcu[i][1]++;
                        }
                    }
                }
                else if(question1.equals("")==false && question2.equals("")==false)
                {
                    question1 = question1.substring(0, question1.length() - 1);
                    question2 = question2.substring(0, question2.length() - 1);
                    question.setText(question1);
                    //answer.setText("CRASH2");
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());


                }
                else
                {
                    question.setText(question1);
                    //answer.setText("CRASH3");
                }


            }
        });
        bdel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                question1="";
                question2="";
                question.setText(question1);
                answer.setText("");
                for(int i=0;i<bracketsq.length;i++)
                {
                    bracketsq[i][0]=-1;
                    bracketsq[i][1]=0;
                    bracketsq[i][2]=-1;
                }
                for(int i=0;i<bracketcu.length;i++)
                {
                    bracketcu[i][0]=-1;
                    bracketcu[i][1]=0;
                    bracketcu[i][2]=-1;
                }
                return true;
            }
        });
        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question1="";
                question2="";
                answerstored=0;
                answercalculated=0;
                question.setText(question1);
                answer.setText("");
                for(int i=0;i<bracketsq.length;i++)
                {
                    bracketsq[i][0]=-1;
                    bracketsq[i][1]=0;
                    bracketsq[i][2]=-1;
                }
                for(int i=0;i<bracketcu.length;i++)
                {
                    bracketcu[i][0]=-1;
                    bracketcu[i][1]=0;
                    bracketcu[i][2]=-1;
                }

            }
        });
        bFraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    if(INFRACTION==0)
                    {
                        if(answerstored<0)
                        {
                            answer.setText("= -" +toFraction(Math.abs(answerstored)));
                            INFRACTION=1;
                        }
                        else
                        {
                            answer.setText("= " +toFraction(Math.abs(answerstored)));
                            INFRACTION=1;
                        }
                    }
                    else if(INFRACTION==1)
                    {
                        answer.setText("= "+answerstored);
                        INFRACTION=0;
                    }
                }


            }
        });
        bsquareroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"SQRT(";
                int index=question2.length();
                question2=question2+"{{0+{";
                question.setText(question1);
                //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                bracketsq[k1+1][0]=index;
                bracketsq[k1+1][2]=index;
                bracketsq[k1+1][1]=3;
                k1++;
                for(int i=0;i<k1;i++)
                {
                    bracketsq[i][1]+=1;
                }
                //question2lengthsq=question2lengthsq+index+",";
            }
        });
        bcuberoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                question1=question1+"CBRT(";
                int index=question2.length();
                question2=question2+"[[0+[";
                question.setText(question1);
                //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                bracketcu[k2+1][0]=index;
                bracketcu[k2+1][2]=index;
                bracketcu[k2+1][1]=3;
                k2++;
                for(int i=0;i<k2;i++)
                {
                    bracketcu[i][1]+=1;
                }

            }
        });
        bopenbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }

                if(question1.equals("")==false && (question1.charAt(question1.length()-1)==')'||"1234567890".indexOf(question1.charAt(question1.length()-1) )!=-1))
                {
                    question1 = question1 + "(";
                    int index=question2.length();
                    question2 = question2 + "*(";
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                    for(int i=0;i<=k1;i++)
                    {
                        if(bracketsq[i][0]<index && bracketsq[i][0]!=-1)
                        {
                            bracketsq[i][1]++;
                        }
                    }
                    for(int i=0;i<=k2;i++)
                    {
                        if(bracketcu[i][0]<index && bracketcu[i][0]!=-1)
                        {
                            bracketcu[i][1]++;
                        }
                    }
                }
                else
                {
                    question1 = question1 + "(";
                    int index=question2.length();
                    question2 = question2 + "(";
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                    for(int i=0;i<=k1;i++)
                    {
                        if(bracketsq[i][0]<index && bracketsq[i][0]!=-1)
                        {
                            bracketsq[i][1]++;
                        }
                    }
                    for(int i=0;i<=k2;i++)
                    {
                        if(bracketcu[i][0]<index && bracketcu[i][0]!=-1)
                        {
                            bracketcu[i][1]++;
                        }
                    }
                }

            }
        });
        bclosebracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag=0;
                int index1=-1,index2=-1;
                int i=0,j=0;
                if(answercalculated==1)
                {
                    answercalculated=0;
                    question1="";
                    question2="";
                    answer.setText("");
                }
                if(k1>-1)
                {
                    for( i = 0;i<=k1;i++)
                    {
                        if(bracketsq[i][0]!=-1)
                        {
                            if(bracketsq[i][1]==3)
                            {
                                /*
                                question1=question1+")";
                                question2=question2+"))^(1/2))";
                                bracketsq[i][0]=-1;
                                */
                                index1=bracketsq[i][0];
                                break;
                            }
                            else
                            {
                                bracketsq[i][1]-=1;
                            }
                        }
                    }
                }
                if(k2>-1)
                {
                    for(j = 0;j<=k2;j++)
                    {
                        if(bracketcu[j][0]!=-1)
                        {
                            if(bracketcu[j][1]==3)
                            {
                                /*
                                question1=question1+")";
                                question2=question2+"))^(1/2))";
                                bracketsq[i][0]=-1;
                                */
                                index2=bracketcu[j][0];
                                break;
                            }
                            else
                            {
                                bracketcu[j][1]-=1;
                            }
                        }
                    }
                }
                if(index1!=-1 && index2!=-1)
                {
                    if(index1>index2)
                    {
                        question1=question1+")";
                        question2=question2+"}}^{1/2}}";
                        lastindexclosedsq=bracketsq[i][0];
                        bracketsq[i][1]=0;
                        bracketsq[i][0]=-1;
                        question.setText(question1);
                        //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                    }
                    else
                    {
                        question1=question1+")";
                        question2=question2+"]]^[1/3]]";
                        lastindexclosedcu=bracketcu[j][0];
                        bracketcu[j][1]=0;
                        bracketcu[j][0]=-1;
                        question.setText(question1);
                        //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                    }
                }
                else if( index1!=-1 && index2==-1)
                {
                    question1=question1+")";
                    question2=question2+"}}^{1/2}}";
                    lastindexclosedsq=bracketsq[i][0];
                    bracketsq[i][1]=0;
                    bracketsq[i][0]=-1;
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                }
                else if(index1==-1 && index2!=-1)
                {
                    question1=question1+")";
                    question2=question2+"]]^[1/3]]";
                    lastindexclosedcu=bracketcu[j][0];
                    bracketcu[j][1]=0;
                    bracketcu[j][0]=-1;
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                }
                else
                {
                    question1 = question1 + ")";
                    question2 = question2 + ")";
                    question.setText(question1);
                    //question.setText(question1 + "\n" + question2 + "\n" + question1.length() + "\n" + question2.length());
                }

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
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
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

    void evaluate(String str)
    {
        int k=0,i;
        char ch;
        StringTokenizer stz= new StringTokenizer(str,"+-*/()[]{}^",true);
        String arr1[]= new String[stz.countTokens()];
        while(stz.hasMoreTokens())
        {
            arr1[k]=stz.nextToken();
            k++;
        }

        //stack_char obj1= new stack_char(arr1.length);
        if(bracketcheck(arr1)==false)
        {
            errorcode=1;
            return;
        }
        stackarr1=postfix(arr1);
        System.out.println();
        //Toast.makeText(this, "solve pass1", Toast.LENGTH_SHORT).show();
        //String temp="";
        //for(i=0;i<stackarr1.length;i++)
        //{
        //   temp= temp+stackarr1[i];
        //}
        //question.setText(temp);
        System.out.println("ANSWER = "+solve(stackarr1));
        //Toast.makeText(this, "solve pass2", Toast.LENGTH_SHORT).show();
        answerstored=solve(stackarr1);

    }
    double solve(String arr[])
    {
        stack_double obj1= new stack_double(arr.length);
        int i;
        double a,b;
        for(i=0;i<arr.length;i++)
        {
            if("+-*/^".indexOf(arr[i])>-1)
            {
                a=obj1.pop();
                if(obj1.top==-1)
                {
                    errorcode=2;
                    return 0;
                }
                b=obj1.pop();
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
                    obj1.push(b/a);
                }
                else if(arr[i].charAt(0)=='^')
                {
                    obj1.push(Math.pow(b,a));
                }

            }
            else
            {
                obj1.push(Double.parseDouble(arr[i]));
            }
        }
        return obj1.peek();
    }
    String[] postfix(String arr[])
    {
        stack_String obj1= new stack_String(arr.length);
        stack_char obj2= new stack_char(arr.length);
        int i,c=0;
        for(i=0;i<arr.length;i++)
        {
            if("(+-*/^)[]{}".indexOf(arr[i])==-1)
            {
                obj1.push(arr[i]);
            }
            else if("+-*/^".indexOf(arr[i])>-1)
            {
                if(presedence(arr[i].charAt(0))> presedence(obj2.peek()))
                {
                    obj2.push(arr[i].charAt(0));
                }
                else
                {
                    while(presedence(arr[i].charAt(0))<=presedence(obj2.peek()))
                    {
                        obj1.push(""+obj2.pop());
                    }
                    obj2.push(arr[i].charAt(0));
                }
            }
            else
            {
                if(arr[i].equals("(")|| arr[i].equals("{")|| arr[i].equals("["))
                {
                    obj2.push(arr[i].charAt(0));
                    c+=2;
                }
                else if(arr[i].equals(")"))
                {
                    while(obj2.peek()!='(')
                    {
                        obj1.push(""+obj2.pop());
                    }
                    obj2.pop();
                }
                else if(arr[i].equals("}"))
                {
                    while(obj2.peek()!='{')
                    {
                        obj1.push(""+obj2.pop());
                    }
                    obj2.pop();
                }
                else if(arr[i].equals("]"))
                {
                    while(obj2.peek()!='[')
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
    int presedence(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':return 1;
            case '*':
            case '%':
            case '/': return 2;
            case '^': return 3;
            default : return 0;
        }
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
    String toFraction(double x)
    {
        if(x<0)
        {
            return "-"+toFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1;
        double h2=0;
        double k1=0;
        double k2=1;
        double b=x;
        do
        {
            double a= Math.floor(b);
            double aux = h1;
            h1=a*h1+h2;
            h2=aux;
            aux=k1;
            k1=a*k1+k2;
            k2=aux;
            b=1/(b-a);
        }while(Math.abs(x-h1/k1)>x*tolerance);
        return ((int)h1)+((k1==1.0)?"":"/"+((int)k1));
    }

    int countbracket(String str,int pos)
    {
        int c=0;
        for(;pos<str.length();pos++)
        {
            if(str.charAt(pos)=='(')
            {
                c++;
            }
            else if(str.charAt(pos)==')')
            {
                c--;
            }
        }
        return c;
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

        question=findViewById(R.id.question);
        question.setMovementMethod(new ScrollingMovementMethod());
        answer=findViewById(R.id.ANSWER);
        answer.setMovementMethod(new ScrollingMovementMethod());
        b0=findViewById(R.id.b0);
        bdot=findViewById(R.id.bdot);
        bpower=findViewById(R.id.bpower);
        banswer=findViewById(R.id.answer);
        equal=findViewById(R.id.equal);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        baddition=findViewById(R.id.baddition);
        bsubtraction=findViewById(R.id.bsubtraction);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        bmultiply=findViewById(R.id.bmultiply);
        bdivision=findViewById(R.id.bdivetion);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        bdel=findViewById(R.id.bdel);
        bAC=findViewById(R.id.bAC);
        bFraction=findViewById(R.id.bFRACTION);
        bcuberoot=findViewById(R.id.bCUBEROOT);
        bsquareroot=findViewById(R.id.bSQUAREROOT);
        bopenbracket=findViewById(R.id.bOPENBRACKET);
        bclosebracket=findViewById(R.id.bCLOSEBRACKET);

        for(int i=0;i<bracketsq.length;i++)
        {
            bracketsq[i][0]=-1;
            bracketsq[i][2]=-1;
        }
        for(int i=0;i<bracketcu.length;i++)
        {
            bracketcu[i][0]=-1;
            bracketcu[i][2]=-1;
        }
    }
}