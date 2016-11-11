package deint.jroldan.logintextinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Logintextinputlayout_Activity extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnLogin;
    private final String TAG="logintextinputlayout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logintextinputlayout);
        loginMvp = new LoginPresenter(this);
        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });

        // Checking the persistence of the Application object
        if(((LoginApplication)getApplicationContext()).getUser()!=null)
            Log.d("TAG",((LoginApplication)getApplicationContext()).getUser().toString());

        Log.d("TAG","Created Activity");
    }

    @Override
    public void setMessageError(String messageError, int idView) {
        switch (idView) {
            case R.id.edtPassword:
                tilPassword.setError(messageError);
                break;
            case R.id.edtUser:
                tilUser.setError(messageError);
        }
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Destroyed Activity");
    }
}
