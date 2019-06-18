package com.example.madeinindiafurniture.home_pcg;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.madeinindiafurniture.account_details.AccountActivity;
import com.example.madeinindiafurniture.MyCart;
import com.example.madeinindiafurniture.OrderHistoryFragment;
import com.example.madeinindiafurniture.R;
import com.example.madeinindiafurniture.notifications_pcg.Notification;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView notificationbtn;
    ImageView home_icon;
    ImageView cart_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cart_icon = findViewById(R.id.cart_app_bar);
        cart_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyCart.class);
                startActivity(intent);
            }
        });

        notificationbtn = findViewById(R.id.notify_id_app_bar);
        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Notification.class);
                startActivity(intent);
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.fragement_container, homeFragment,"home");

        fragmentTransaction.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        home_icon = navigationView.getHeaderView(0).findViewById(R.id.home_img_id);
        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_history) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            OrderHistoryFragment orderHistoryFragment = new OrderHistoryFragment();
            fragmentTransaction.replace(R.id.fragement_container, orderHistoryFragment,"home").addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_cart) {
            Intent intent = new Intent(getApplicationContext(),MyCart.class);
            startActivity(intent);

        } else if (id == R.id.nav_wishlist) {

        } else if (id == R.id.nav_notification) {
            Intent intent = new Intent(getApplicationContext(),Notification.class);
            startActivity(intent);

        } else if (id == R.id.help_id) {

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","alisha.nitd@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Feedback/Help");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        else if (id == R.id.acc_id) {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.logout_menu_id) {

        }
        else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Please check out our app - Made In India Furniture on Play Store");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            Toast.makeText(HomeActivity.this,"Share",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.home_img_id){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fragement_container, homeFragment,"home");

            fragmentTransaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
