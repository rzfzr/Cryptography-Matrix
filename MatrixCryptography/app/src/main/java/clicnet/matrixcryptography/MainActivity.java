package clicnet.matrixcryptography;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button button;
    EditText text,m1_1,m1_2,m1_3,m1_4,m2_1,m2_2,m2_3,m2_4,m3_1,m3_2,m3_3,m3_4,m4_1,m4_2,m4_3,m4_4;
    private Spinner spinner;
    TextView result;

    int mSize = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.editTextMessage);
        m1_1 = (EditText)findViewById(R.id.m1_1);
        m1_2 = (EditText)findViewById(R.id.m1_2);
        m1_3 = (EditText)findViewById(R.id.m1_3);
        m1_4 = (EditText)findViewById(R.id.m1_4);

        m2_1 = (EditText)findViewById(R.id.m2_1);
        m2_2 = (EditText)findViewById(R.id.m2_2);
        m2_3 = (EditText)findViewById(R.id.m2_3);
        m2_4 = (EditText)findViewById(R.id.m2_4);

        m3_1 = (EditText)findViewById(R.id.m3_1);
        m3_2 = (EditText)findViewById(R.id.m3_2);
        m3_3 = (EditText)findViewById(R.id.m3_3);
        m3_4 = (EditText)findViewById(R.id.m3_4);

        m4_1 = (EditText)findViewById(R.id.m4_1);
        m4_2 = (EditText)findViewById(R.id.m4_2);
        m4_3 = (EditText)findViewById(R.id.m4_3);
        m4_4 = (EditText)findViewById(R.id.m4_4);

        result = (TextView) findViewById(R.id.textViewResult);





        addListenerOnButton();



        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.matrix_selection, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

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



        int mMul[][] = new int[mSize][mSize];

        mMul[0][0] = Integer.valueOf(m1_1.getText().toString());
        mMul[0][1] = Integer.valueOf(m1_2.getText().toString());
        mMul[0][2] = Integer.valueOf(m1_3.getText().toString());
        mMul[0][3] = Integer.valueOf(m1_4.getText().toString());

        mMul[1][0] = Integer.valueOf(m2_1.getText().toString());
        mMul[1][1] = Integer.valueOf(m2_2.getText().toString());
        mMul[1][2] = Integer.valueOf(m2_3.getText().toString());
        mMul[1][3] = Integer.valueOf(m2_4.getText().toString());

        mMul[2][0] = Integer.valueOf(m3_1.getText().toString());
        mMul[2][1] = Integer.valueOf(m3_2.getText().toString());
        mMul[2][2] = Integer.valueOf(m3_3.getText().toString());
        mMul[2][3] = Integer.valueOf(m3_4.getText().toString());

        mMul[3][0] = Integer.valueOf(m4_1.getText().toString());
        mMul[3][1] = Integer.valueOf(m4_2.getText().toString());
        mMul[3][2] = Integer.valueOf(m4_3.getText().toString());
        mMul[3][3] = Integer.valueOf(m4_4.getText().toString());

        while(x.length()%mSize!=0){
            x += " ";
        }

        int[][]mTemp = new int[mSize][x.length() / mSize];
        int[][]mUser = new int[mSize][x.length() / mSize];



        int pos = 0;
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < x.length() / mSize; j++) {
                mUser[i][j] = x.charAt(pos);
                Log.v("int",Integer.toString(mUser[i][j]));
                pos++;
            }
        }
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < x.length() / mSize; j++) {
                for (int k = 0; k < mSize; k++) {
                    mTemp[i][j] = mMul[i][k] * mUser[k][j];
                    result.append(Integer.toString(mTemp[i][j])+" ");
                    Log.v("int",Integer.toString(mTemp[i][j]));
                }
            }
        }

//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < x.length() / size; j++) {
//                for (int k = 0; k < size; k++) {
//                    mTemp[i][j] = mMul[i][k] * mUser[k][j];
//                    result.append(Integer.toString(mTemp[i][j])+" ");
//                    Log.v("int",Integer.toString(mTemp[i][j]));
//                }
//            }
//        }

        Log.v("EditText", x);

//        result.setText(Arrays.toString(mTemp));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: //2x2
//                Log.v("caso 0","teste");
                mSize = 2 ;

                m1_3.setVisibility(View.GONE);
                m1_4.setVisibility(View.GONE);

                m2_3.setVisibility(View.GONE);
                m2_4.setVisibility(View.GONE);

                m3_1.setVisibility(View.GONE);
                m3_2.setVisibility(View.GONE);
                m3_3.setVisibility(View.GONE);
                m3_4.setVisibility(View.GONE);

                m4_1.setVisibility(View.GONE);
                m4_2.setVisibility(View.GONE);
                m4_3.setVisibility(View.GONE);
                m4_4.setVisibility(View.GONE);

                break;
            case 1: //3x3

                mSize = 3 ;

                m1_3.setVisibility(View.VISIBLE);
                m1_4.setVisibility(View.GONE);

                m2_3.setVisibility(View.VISIBLE);
                m2_4.setVisibility(View.GONE);

                m3_1.setVisibility(View.VISIBLE);
                m3_2.setVisibility(View.VISIBLE);
                m3_3.setVisibility(View.VISIBLE);
                m3_4.setVisibility(View.GONE);

                m4_1.setVisibility(View.GONE);
                m4_2.setVisibility(View.GONE);
                m4_3.setVisibility(View.GONE);
                m4_4.setVisibility(View.GONE);

                break;
            case 2: //4x4

                mSize = 4 ;

                m1_3.setVisibility(View.VISIBLE);
                m1_4.setVisibility(View.VISIBLE);

                m2_3.setVisibility(View.VISIBLE);
                m2_4.setVisibility(View.VISIBLE);

                m3_1.setVisibility(View.VISIBLE);
                m3_2.setVisibility(View.VISIBLE);
                m3_3.setVisibility(View.VISIBLE);
                m3_4.setVisibility(View.VISIBLE);

                m4_1.setVisibility(View.VISIBLE);
                m4_2.setVisibility(View.VISIBLE);
                m4_3.setVisibility(View.VISIBLE);
                m4_4.setVisibility(View.VISIBLE);

                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
