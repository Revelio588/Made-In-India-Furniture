package com.example.madeinindiafurniture.auth_fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.madeinindiafurniture.home_pcg.HomeActivity;
import com.example.madeinindiafurniture.R;

public class SignUpFragment extends Fragment {

    View view;
    View popup;
    Button reg;
    PopupWindow popupWindow;
    LinearLayout linearLayout;
    public SignUpFragment() {
    }
//    private static final int MY_REQ_CODE = 7117;
//    List<AuthUI.IdpConfig> providers;
    Button signup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_fragment,container,false);
        popup = inflater.inflate(R.layout.otp_popup,null);
        reg = view.findViewById(R.id.reg_id);
        linearLayout = popup.findViewById(R.id.pop_id);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInput();

            }
        });
        //init provider
//        providers = Arrays.asList(new AuthUI.IdpConfig.FacebookBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build());
//        showSignInOptions();
        return view;
    }

    private void validateInput() {
        EditText uname = view.findViewById(R.id.user_sign_id);
        EditText email = view.findViewById(R.id.email_id);
        EditText pass = view.findViewById(R.id.pass_id);
        EditText confirm = view.findViewById(R.id.confirmpass_id);
        EditText contact = view.findViewById(R.id.contact_id);
        String username = uname.getText().toString().trim();
        String emailid = email.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String confirmpass = confirm.getText().toString().trim();
        String phone = contact.getText().toString().trim();
        if (username.length() == 0 || TextUtils.isEmpty(username)){
            uname.setError("Field Required");
            return;
        }
        if (password.length() == 0 || TextUtils.isEmpty(password) || password.length()<5){
            pass.setError("Field Error");
            return;
        }
        if (confirm.length() == 0 || TextUtils.isEmpty(confirmpass)){
            pass.setError("Field Error");
            return;
        }
        if (emailid.length() == 0 || TextUtils.isEmpty(emailid)){
            email.setError("Field Required");
            return;
        }
        if (phone.length() == 0 || TextUtils.isEmpty(phone)){
            contact.setError("Field Required");
            return;
        }
        popupdialog();

    }

    private void popupdialog() {
        final Dialog dialog;
        dialog = new Dialog(getActivity());
        dialog.setTitle("ONE TIME PASSWORD");
        dialog.setContentView(R.layout.otp_popup);

        Button submitotp = dialog.findViewById(R.id.submit_otp_id);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        submitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

//                int flag = 0;
//                if (otp_true != inpurOTP && flag<=1){
//                    flag++;
//                    otp.setError("Incorrect OTP... Try Again!!!");
//                    dialog.dismiss();
//                    popupdialog();
//                }
//                else if (flag>1 && otp_true!=inpurOTP){
//                    otp.setError("Incorrect OTP!");
//                    dialog.dismiss();
//                }

                    dialog.dismiss();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    getActivity().startActivity(intent);


            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
//    public void showSignInOptions(){
//        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
//                .setAvailableProviders(providers)
//                .setTheme(R.style.AppTheme).build(),MY_REQ_CODE);
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
