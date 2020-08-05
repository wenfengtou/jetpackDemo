package cn.com.ava.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import cn.com.ava.jetpackdemo.bean.Note;
import cn.com.ava.jetpackdemo.di.DaggerNoteComponent;
import cn.com.ava.jetpackdemo.viewmodel.LoginViewModel;

import static androidx.navigation.Navigation.findNavController;

public class LoginActivity extends AppCompatActivity  implements LoginFragment.OnFragmentInteractionListener, MainFragment.OnFragmentInteractionListener {

    private LoginViewModel mLoginViewModel_Temp;

    @Inject
    public Note mInjectNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerNoteComponent.create().inject(this);
        Toast.makeText(this, "mInjectNote=" + mInjectNote, Toast.LENGTH_SHORT).show();
        mLoginViewModel_Temp = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return findNavController(this, R.id.my_nav_host_fragment).navigateUp();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
