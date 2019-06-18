package com.example.madeinindiafurniture.auth_fragments;

import com.example.madeinindiafurniture.home_pcg.HomeActivity;
import com.example.madeinindiafurniture.LoginActivity;
import com.example.madeinindiafurniture.R;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginFragment extends Fragment {
    private static final int MY_REQ_CODE = 7117;
    TextView resetpass;
    View view;
    Button loginbtn;
//    List<AuthUI.IdpConfig> providers;
    public LoginFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment,container,false);
        loginbtn = view.findViewById(R.id.login_button);
        resetpass = view.findViewById(R.id.reset_pass_id);
        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupresetpass();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInternetConnection();
//                validateInput();


            }
        });
        //init provider
//        providers = Arrays.asList(new AuthUI.IdpConfig.FacebookBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build());
//        showSignInOptions();
        return view;
    }

    private void popupresetpass() {
        final Dialog dialog;
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.reset_pass);

        Button reset_p = dialog.findViewById(R.id.btn_reset);
        Button goback_p = dialog.findViewById(R.id.btn_back);
        goback_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;

        reset_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                dialog.dismiss();

            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }



    private void validateInput() {
        EditText uname = view.findViewById(R.id.user_id);
        EditText password = view.findViewById(R.id.l_pass_id);
        String username = uname.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (username.length() == 0 || TextUtils.isEmpty(username)){
            uname.setError("Field Required");
            return;
        }
        if (pass.length() == 0 || TextUtils.isEmpty(pass)){
            password.setError("Field Error");
            return;
        }
        getActivity().finish();
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        getActivity().startActivity(intent);
    }

    private void checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()) {
            Snackbar snackbar = Snackbar.make(view.findViewById(R.id.container), "No Internet Connection", Snackbar.LENGTH_LONG);
            snackbar.show();
            return;
        }
        validateInput();
    }
//    public void showSignInOptions(){
//        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
//        .setAvailableProviders(providers)
//        .setTheme(R.style.AppTheme).build(),MY_REQ_CODE);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == MY_REQ_CODE){
//            IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
//            if (resultCode == RESULT_OK){
//                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//                Toast.makeText(getActivity(),""+firebaseUser.getEmail(),Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//                startActivity(intent);
//            }
//            else {
//                Toast.makeText(getActivity(),""+idpResponse.getError(),Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}

