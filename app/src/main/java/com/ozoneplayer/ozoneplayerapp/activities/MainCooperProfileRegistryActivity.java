package com.ozoneplayer.ozoneplayerapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.ozoneplayer.ozoneplayerapp.R;


/**
 * Created by Das on 10/5/17.
 */

public class MainCooperProfileRegistryActivity extends AppCompatActivity {

    public static final String EXTRA_PROFILE = "com.gto.odc.sumaco.lpa.profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooper_profile_registry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intent = getIntent();

        // Set the icon
        final ImageView ivIcon = (ImageView) findViewById(R.id.imgIcon);

        final RecyclerView recyclerView = (RecyclerView) findViewById(android.R.id.list);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onBackPressed() {
        finish();
        onNavigateUp();
    }

    @Override
    public boolean onSupportNavigateUp() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        }
        return super.onSupportNavigateUp();

    }
}