package com.example.madeinindiafurniture;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.madeinindiafurniture.auth_fragments.LoginFragment;
import com.example.madeinindiafurniture.auth_fragments.SignUpFragment;
import com.example.madeinindiafurniture.auth_fragments.ViewPagerAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

//    List<AuthUI.IdpConfig> providers;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        tabLayout = findViewById(R.id.tab_auth_id);
        appBarLayout = findViewById(R.id.appbar_auth);
        viewPager = findViewById(R.id.view_pager_auth);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new LoginFragment(),"Log In");
        adapter.AddFragment(new SignUpFragment(),"Sign Up");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        //init provider
//        providers = Arrays.asList(new AuthUI.IdpConfig.FacebookBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build(),
//                new AuthUI.IdpConfig.EmailBuilder().build());
//        showSignInOptions();




//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
    }

    private void showSignInOptions() {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
