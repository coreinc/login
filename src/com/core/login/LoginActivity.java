package com.core.login;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
EditText username;
EditText password;
Button signin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setupParse();
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		signin = (Button)findViewById(R.id.signIn);
		signin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ParseUser.logInInBackground(username.getText().toString(),password.getText().toString(),new LogInCallback() {
					
					@Override
					public void done(ParseUser user, ParseException error) {
						// TODO Auto-generated method stub
						if (error == null) {
							System.out.println("Berhasil Login!");
						}
						else
						{
							System.out.println("Error!");
						}
					}
				});
			}
		});
	}
	public void setupParse () {
		Parse.initialize(this, "0GIauv76xvT5lthi4HKOuCUuF6GELGZm2RjOYd16", "oeu1GSk7zQrpXY8yvgN0v1GIIce2jFiBZ4Kr308l");
	}
	public boolean signup1 (MenuItem item) {
		Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
