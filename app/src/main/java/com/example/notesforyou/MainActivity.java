package com.example.notesforyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnClear;
    ImageView firstPin;
    ImageView secondPin;
    ImageView thirdPin;
    ImageView fourthPin;
    int read = 1;
    int clear = 4;
    EditText pinText;
    String pincodeString;
    StringBuilder pincodeStringBuilder;
    List<String> list;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        btnClear = findViewById(R.id.buttonClear);

        firstPin = findViewById(R.id.firstPin);
        secondPin = findViewById(R.id.secondPin);
        thirdPin = findViewById(R.id.thirdPin);
        fourthPin = findViewById(R.id.fourthPin);

        pinText = findViewById(R.id.pinText);
        list = new ArrayList<>();

    }

    public void touchButton(View view) {

        switch (view.getId()) {
            case R.id.button0:
                if (list.size() < 4) {
                    list.add("0");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button1:
                if (list.size() < 4) {
                    list.add("1");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button2:
                if (list.size() < 4) {
                    list.add("2");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button3:
                if (list.size() < 4) {
                    list.add("3");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button4:
                if (list.size() < 4) {
                    list.add("4");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button5:
                if (list.size() < 4) {
                    list.add("5");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button6:
                if (list.size() < 4) {
                    list.add("6");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button7:
                if (list.size() < 4) {
                    list.add("7");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button8:
                if (list.size() < 4) {
                    list.add("8");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.button9:
                if (list.size() < 4) {
                    list.add("9");
                } else {
                    break;
                }
                changeColor();
                break;
            case R.id.buttonClear:
                list.remove(list.size() - 1);
                clearColor();
                break;
        }
        setPinText();
        checkPassword(PreferenceManager.getDefaultSharedPreferences(this));
    }

    private void changeColor() {
        if (read == 1) {
            firstPin.setImageResource(R.drawable.after_24dp);
            read = 2;
            clear = 2;
        } else if (read == 2) {
            secondPin.setImageResource(R.drawable.after_24dp);
            read = 3;
            clear = 3;
        } else if (read == 3) {
            thirdPin.setImageResource(R.drawable.after_24dp);
            read = 4;
            clear = 4;
        } else if (read == 4) {
            fourthPin.setImageResource(R.drawable.after_24dp);
        }
    }

    private void clearColor() {
        if (clear == 4) {
            fourthPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
            clear = 3;
            read = 3;
        } else if (clear == 3) {
            thirdPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
            clear = 2;
            read = 2;
        } else if (clear == 2) {
            secondPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
            clear = 1;
            read = 1;
        } else if (clear == 1) {
            firstPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
        }
    }

    private void setPinText() {
        pincodeStringBuilder = new StringBuilder();
        for (String s : list) {
            pincodeStringBuilder.append(s);
        }
        pincodeString = pincodeStringBuilder.toString();
        pinText.setText(pincodeString);
    }

    private void checkPassword(SharedPreferences sharedPreferences) {
        password = sharedPreferences.getString("password", "0000");
        if (list.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String charOfPassword : list) {
                sb.append(charOfPassword);
            }

            if (password.equals(sb.toString())) {
                Intent intent = new Intent(this, Notes.class);
                startActivity(intent);
                finish();
            }else if (password.equals(null)){
                password = sb.toString();
                Intent intent = new Intent(this, Notes.class);
                startActivity(intent);
                finish();
            } else {
                incorrectPassword();
            }
        }
    }

    private void incorrectPassword() {
        firstPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
        secondPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
        thirdPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
        fourthPin.setImageResource(R.drawable.ic_brightness_1_black_24dp);
        list.removeAll(list);
        pinText.setText("");
        read = 1;
        clear = 1;
        Toast.makeText(this, "Incorrect password", Toast.LENGTH_LONG).show();
    }

}
