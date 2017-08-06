package com.example.srikanth.urlshortener;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    int flag = 0;
    @BindView(R.id.input_url) EditText editText;
    @BindView(R.id.conv_url) TextView textView;

    @OnClick({R.id.l_to_s, R.id.s_to_l})
    public void ls(View view){
        boolean checked  = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.s_to_l:
                if(checked) {
                    flag = 0;
                    textView.setHint("Long Url");
                }
                break;
            case R.id.l_to_s:
                if(checked) {
                    flag = 1;
                    textView.setHint("Short Url");
                }
                break;
        }
    }

    @OnClick(R.id.convert)
    public void conv(){
        UrlShortenerService service = UrlShortenerService.retrofit.create(UrlShortenerService.class);
        if(flag==0) {
            textView.setText("");
            ShortToLongUrl shortToLongUrl = new ShortToLongUrl(this, service, this);
            shortToLongUrl.performConversion(editText.getText().toString());
        }
        else{
            textView.setText("");
            LongToShortUrl longToShortUrl = new LongToShortUrl(this, service, this);
            longToShortUrl.performConversion(editText.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
