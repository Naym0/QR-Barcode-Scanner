package com.example.barcodescanner;

import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.Result;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {

    private ZXingScannerView scannerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scanCode(View view){
        scannerview = new ZXingScannerView(this);
        scannerview.setResultHandler(new ZXingScannerResultHandler());

        setContentView(scannerview);
        scannerview.startCamera();
    }

    public void onPause(){
        super.onPause();
        scannerview.stopCamera();
    }

    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler{
        public void handleResult(Result result){
            String resultCode = result.getText();
            Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_main);
            scannerview.stopCamera();
        }
    }
}
