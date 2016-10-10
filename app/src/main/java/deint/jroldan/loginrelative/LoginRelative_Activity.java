package deint.jroldan.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelative_Activity extends AppCompatActivity implements ILoginMvp.View {

    private ILoginMvp.Presenter loginMvp;
    private EditText edtPassword;
    private EditText edtUser;
    private Button btnOk;
    private Button btnCancel;
    private final String TAG="loginrelative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);
        loginMvp = new LoginPresenter(this);
        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Checking the persistence of the Application object
        if(((LoginApplication)getApplicationContext()).getUser()!=null)
            Log.d("TAG",((LoginApplication)getApplicationContext()).getUser().toString());
    }

    @Override
    public void setMessageError(String messageError, int idView) {
        switch (idView) {
            case R.id.edtPassword:
                edtPassword.setError(messageError);
                break;
            case R.id.edtUser:
                edtUser.setError(messageError);
        }
        //Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();
    }

    private void resetValues() {
        edtPassword.setText("");
        edtUser.setText("");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Activity finalizada");
    }
}
