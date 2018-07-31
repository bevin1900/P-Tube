package mylocker;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragement.CreateUserFragment;
import fragement.LoginUserFragment;
import mylocker.bk.com.ptube.R;

public class


AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("AuthPref", 0);
        Boolean isLogin =  pref.getBoolean("isLogin",false);

        if (isLogin) {
            LoginUserFragment loginFragment = LoginUserFragment.newInstance();
            addFragment(loginFragment, LoginUserFragment.class.getName());
        }
        else
        {
            CreateUserFragment createFragment = CreateUserFragment.newInstance();
            addFragment(createFragment, CreateUserFragment.class.getName());
            SharedPreferences.Editor editor = pref.edit();
            //editor.putBoolean("isLogin",true);
            editor.commit();
        }
    }
    public void addFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.maninFrame, fragment, tag);
        transaction.addToBackStack(null);

        transaction.commitAllowingStateLoss();
    }
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1){
            finish();
        }
        else{
            super.onBackPressed();
        }
    }
}
