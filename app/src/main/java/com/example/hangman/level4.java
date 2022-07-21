package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hangman.gameover;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class level4 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser mUser;

    String uid;

    SharedPreferences sp4;
    EditText inputedittext;
    TextView tw1,tw2,tw3,tw4,tw5,tw6,lifetextview,questextview,tv_score;//changable
    Button buttoncheck, skip;
    ImageButton back;
    //gamelife var condition
    Integer life=4;
    //gameword completing var condition
    Integer wordsize =6;
    //gameword already existed var condition
    Integer valid1 =0;
    Integer valid2 =0;
    Integer valid3 =0;
    Integer valid4 =0;
    Integer valid5 =0;
    Integer valid6 =0;

    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        uid = mUser.getUid();

        skip = findViewById(R.id.skip);
        back = findViewById(R.id.back2);

        inputedittext = findViewById(R.id.inputedittext);
        buttoncheck = findViewById(R.id.buttoncheck);
        lifetextview = findViewById(R.id.lifetextview);
        questextview = findViewById(R.id.questextview);
        tv_score =findViewById(R.id.tv_score);
        tw1 = findViewById(R.id.tw1);
        tw2 = findViewById(R.id.tw2);
        tw3 = findViewById(R.id.tw3);
        tw4 = findViewById(R.id.tw4);
        tw5 = findViewById(R.id.tw5);
        tw6 = findViewById(R.id.tw6);
        buttoncheck = (Button) findViewById(R.id.buttoncheck);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();



        buttoncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamestart();

            }
        });

        SharedPreferences scorebox = getSharedPreferences(uid+"myusername", Context.MODE_PRIVATE);
        Integer finalscore = scorebox.getInt("thiscore",0);
        tv_score.setText(String.valueOf(finalscore));


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goskip();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();

            }
        });

    }


    @Override
    public void onBackPressed() {
        myAlert(level4.this);
    }

    public  void myAlert(Context mContext) {
        new AlertDialog.Builder(mContext)
                .setIcon(R.drawable.incorrect)
                .setTitle("Exit?")
                .setMessage("Do you Want to Stop Playing?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sigOutUser();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void sigOutUser() {
        Intent intent = new Intent(getApplicationContext(), landingpage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    private void goback() {
        Intent intent = new Intent(this, level3.class);
        recreate();
        startActivity(intent);
    }

    private void goskip() {
        Intent intent = new Intent(this, level5.class);
        recreate();
        startActivity(intent);
    }
    private void gamestart() {
        String str = inputedittext.getText().toString().toLowerCase(Locale.ROOT);
        if (life <5 && life > 0) {
            if (str.matches("")) {
                Toast.makeText(this, "please enter a letter", Toast.LENGTH_SHORT).show();
            }else{
                switch (str) {
                    case "s":
                        if(valid1 == 0) {
                            tw1.setText(str);
                            wordsize = wordsize - 1;
                            valid1 = valid1 + 1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }

                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "w":
                        if(valid2 == 0) {
                            tw2.setText("" + str);
                            wordsize = wordsize - 1;
                            valid2=valid2+1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }
                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "i":
                        if(valid3 == 0) {
                            tw3.setText("" + str);
                            wordsize = wordsize - 1;
                            valid3 = valid3 + 1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }
                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "t":
                        if(valid4 == 0) {
                            tw4.setText("" + str);
                            wordsize = wordsize - 1;
                            valid4 = valid4 + 1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }
                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "c":
                        if(valid5 == 0) {
                            tw5.setText("" + str);
                            wordsize = wordsize - 1;
                            valid5=valid5+1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }
                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "h":
                        if(valid6 == 0) {
                            tw6.setText("" + str);
                            wordsize = wordsize - 1;
                            valid6=valid6+1;
                            inputedittext.setText("");
                            if (wordsize < 1) {
                                finishinglevelone();
                            }
                        }else{
                            inputedittext.setText("");
                            Toast.makeText(this, "already existed", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        life--;
                        lifetextview.setText("" + life);
                        inputedittext.setText("");
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout));
                        final Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();                }
            }
        }else{
            Intent intent = new Intent(this, gifhangingpage.class);
            recreate();
            startActivity(intent);
        }
    }

    public void finishinglevelone(){
        //sharedusername
        SharedPreferences sharedusername = getSharedPreferences("myusername", Context.MODE_PRIVATE);
        String str = sharedusername.getString("thisusername", "");
        //check score if 0
        SharedPreferences  sp1 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        Integer Int = sp1.getInt("levelonescore", 0);
        SharedPreferences sp2  = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        Integer Int2 = sp2.getInt("leveltwoscore", 0);
        SharedPreferences sp3 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        Integer Int3 = sp3.getInt("levelthreescore", 0);
        sp4 = getSharedPreferences(uid+"myuserdata", Context.MODE_PRIVATE);
        Integer Int4 = sp4.getInt("levelfourscore", 0);
        if (Int4 == 0) {
            //getscore
            SharedPreferences.Editor editor = sp4.edit();
            editor.putInt("levelfourscore", 1);
            editor.commit();
            Integer Int5 = Int+Int2+Int3+sp4.getInt("levelfourscore", 0);
            String strint = String.valueOf(Int5);
            //getdate
            Calendar calendar = Calendar.getInstance();
            String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
            //add score and date to database
            myRef = FirebaseDatabase.getInstance().getReference().child("User Highscores");
            myRef.child(uid).child("un").setValue(str);
            myRef.child(uid).child("highscore").setValue(strint);
            myRef.child(uid).child("date").setValue(currentdate);

            //scorebox
            SharedPreferences scorebox = getSharedPreferences(uid+"myusername", Context.MODE_PRIVATE);
            Integer prefinalscore = 1+scorebox.getInt("thiscore",0);
            SharedPreferences.Editor ScoreEditor = scorebox.edit();
            ScoreEditor.putInt("thiscore", prefinalscore);
            ScoreEditor.commit();


        }else{
            Toast.makeText(this, "you already finish this level", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, thispage4.class);
        recreate();
        startActivity(intent);



    }
}