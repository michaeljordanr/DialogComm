package com.example.michael.dialogcomm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements ExitDialog.ExitListerner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        ExitDialog dialog = new ExitDialog();
        dialog.show(getFragmentManager(), "exitDialog");
    }

    @Override
    public void onExit() {
        finish();
    }
}
