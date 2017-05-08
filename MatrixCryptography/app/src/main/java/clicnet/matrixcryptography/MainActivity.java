package clicnet.matrixcryptography;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText text,m1_1,m1_2,m2_1,m2_2;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        text = (EditText)findViewById(R.id.editTextMessage);
        m1_1 = (EditText)findViewById(R.id.m1_1);
        m1_2 = (EditText)findViewById(R.id.m1_2);
        m2_1 = (EditText)findViewById(R.id.m2_1);
        m2_2 = (EditText)findViewById(R.id.m2_2);


        result = (TextView) findViewById(R.id.textViewResult);
    }


    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                crypto();


            }

        });

    }

    public void crypto(){

        result.setText(" ");
        String x = text.getText().toString();


        int mMul[][] = new int[2][2];

        mMul[0][0] = Integer.valueOf(m1_1.getText().toString());
        mMul[0][1] = Integer.valueOf(m1_2.getText().toString());
        mMul[1][0] = Integer.valueOf(m2_1.getText().toString());
        mMul[1][1] = Integer.valueOf(m2_2.getText().toString());

        if(x.length()%2!=0){
            x += " ";
        }

        int[][]mTemp = new int[2][x.length() / 2];
        int[][]mUser = new int[2][x.length() / 2];



        int pos = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < x.length() / 2; j++) {
                mUser[i][j] = x.charAt(pos);
                Log.v("int",Integer.toString(mUser[i][j]));
                pos++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < x.length() / 2; j++) {
                for (int k = 0; k < 2; k++) {
                    mTemp[i][j] = mMul[i][k] * mUser[k][j];

                    Log.v("int",Integer.toString(mTemp[i][j]));
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < x.length() / 2; j++) {
                for (int k = 0; k < 2; k++) {
                    mTemp[i][j] = mMul[i][k] * mUser[k][j];
                    result.append(Integer.toString(mTemp[i][j])+" ");
                    Log.v("int",Integer.toString(mTemp[i][j]));
                }
            }
        }

        Log.v("EditText", x);

//        result.setText(Arrays.toString(mTemp));

    }




}
