package id.ac.unej.inaparadise.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.adapter.ChatAdapter;
import id.ac.unej.inaparadise.model.Chat;

public class ChatActivity extends AppCompatActivity {

    ImageView attach, send;
    EditText input;

    List<Chat> daftarChat;
    RecyclerView chat;
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_chat);
        setSupportActionBar(myToolbar);
        attach = findViewById(R.id.attach);
        send = findViewById(R.id.send);
        input = findViewById(R.id.input_chat);
        chat = findViewById(R.id.list_chat);
        daftarChat = new ArrayList<>();
        adapter = new ChatAdapter(daftarChat);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.load_chat).setVisibility(View.GONE);
                chat.setVisibility(View.VISIBLE);
            }
        }, 2000);

        chat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        chat.setAdapter(adapter);

        String nama = this.getIntent().getExtras().getString("nama");
        getSupportActionBar().setTitle(nama);


        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().toString().equalsIgnoreCase("")) {
                    send.setEnabled(false);
                } else {
                    send.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirim();
            }
        });
        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void kirim() {
        String teks = input.getText().toString().trim();
//        if (teks.equalsIgnoreCase("")) {
//            return;
//        }
        //String chat, String senderLevel, String uidSender, String uidRecipient, Long time
        daftarChat.add(new Chat(teks, "penerima", "123", "123"));
        if (teks.equalsIgnoreCase("hai")) {
            daftarChat.add(new Chat("halo", "pengirim", "123", "123"));
        } else if (teks.equalsIgnoreCase("hari ini di kota ada event")) {
            daftarChat.add(new Chat("ok", "pengirim", "123", "123"));
        } else {
            daftarChat.add(new Chat("maaf saya tidak mengerti", "pengirim", "123", "123"));
        }
        findViewById(R.id.load_chat).setVisibility(View.GONE);
        if (chat.getVisibility() == View.GONE) {
            chat.setVisibility(View.VISIBLE);
        }
        adapter.notifyDataSetChanged();
        input.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);

        MenuItem searchItem = menu.findItem(R.id.cari);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Define the listener
        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when action item collapses
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        };

        // Get the MenuItem for the action item
        MenuItem actionMenuItem = menu.findItem(R.id.cari);

        // Assign the listener to that action item
        MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);

        // Any other things you have to do when creating the options menu...

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cari:

                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
