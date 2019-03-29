package com.ozoneplayer.ozoneplayerapp.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ozoneplayer.ozoneplayerapp.R;
import com.ozoneplayer.ozoneplayerapp.adapters.UserItemsAdapter;
import com.ozoneplayer.ozoneplayerapp.listeners.OnRecyclerViewItemClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;




public class UsersActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {
    private static final String TAG = UsersActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    protected Context context;
    private Map<String, String> containerMap = new LinkedHashMap<>();
    private HashMap<String, String> userSettingsMap = new LinkedHashMap<>();
    private RecyclerView.LayoutManager layoutManager;
    private UserItemsAdapter userSettingsAdapter;
    private Gson gson = new Gson();
    private enum OptionsState {
        USER_SETTINGS_1,
        USER_SETTINGS_2,
        USER_SETTINGS_3,
    }
    private OptionsState currentState = OptionsState.USER_SETTINGS_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        resetAdapter(userSettingsMap);


    }

    @Override
    protected void onResume() {
        super.onResume();
        hideKeyboard(this);
    }

    private void resetAdapter(HashMap<String, String> hashMap) {
        userSettingsAdapter = new UserItemsAdapter(this, hashMap);
        userSettingsAdapter.setOnRecyclerViewItemClickListener(this);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(userSettingsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.user_settings_1) {
            // user_settings_1
            setTitle(R.string.user_settings_1);
            currentState = OptionsState.USER_SETTINGS_1;
            userSettingsMap.clear();
            Toast.makeText(UsersActivity.this, R.string.user_settings_1, Toast.LENGTH_LONG).show();
            resetAdapter(userSettingsMap);
            userSettingsAdapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.user_settings_2) {
            // user_settings_2
            setTitle(R.string.user_settings_2);
            currentState = OptionsState.USER_SETTINGS_2;
            Toast.makeText(UsersActivity.this, R.string.user_settings_2, Toast.LENGTH_LONG).show();

            resetAdapter(userSettingsMap);
            userSettingsAdapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.user_settings_3) {
            // user_settings_3
            setTitle(R.string.user_settings_3);
            currentState = OptionsState.USER_SETTINGS_3;

            Toast.makeText(UsersActivity.this, R.string.user_settings_3, Toast.LENGTH_LONG).show();

            resetAdapter(userSettingsMap);
            userSettingsAdapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.action_dynamic_config_apply) {
            Toast.makeText(UsersActivity.this, R.string.user_config_saved, Toast.LENGTH_LONG).show();

            final Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent);
            finish();
            return true;
        } else if (id == R.id.action_dynamic_config_cancel) {
            Toast.makeText(UsersActivity.this, R.string.user_button_cancelled, Toast.LENGTH_LONG).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(int position, View view) {
        final View itemView = layoutManager.findViewByPosition(position);
        if (view != null){
            final TextView textView = itemView.findViewById(R.id.fieldName);
            final EditText editTextField = itemView.findViewById(R.id.fieldValue);
            final String itemKey = textView.getText().toString();
            final String itemValue = editTextField.getText().toString();
            hideKeyboard(this);
            Toast.makeText(UsersActivity.this, itemKey
                            + " : "
                            + itemValue
                    , Toast.LENGTH_LONG).show();
            switch (this.currentState) {
                case USER_SETTINGS_1:
                    break;
                case USER_SETTINGS_2:
                    break;
                case USER_SETTINGS_3:
                    break;
                default:
                    Toast.makeText(UsersActivity.this,
                            R.string.unexpected_error, Toast.LENGTH_LONG).show();

            }
        }

    }
    private void hideKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        final Activity activity = (Activity) context;
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}