package com.example.leica.learnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == R.id.Menu1 ) startActivity( new Intent( this, TitleActivity.class ) );
        else if ( id == R.id.Menu2  ) startActivity( new Intent( this, ToastActivity.class )  );
        else if ( id == R.id.Menu3  ) startActivity( new Intent( this, AlertActivity.class )  );
        else if ( id == R.id.Menu4  ) startActivity( new Intent( this, DrawActivity.class )  );
        else if ( id == R.id.Menu5  ) startActivity( new Intent( this, ImageActivity.class )  );
        else if ( id == R.id.Menu6  ) startActivity( new Intent( this, SurfaceActivity.class )  );
        else if ( id == R.id.Menu7  ) startActivity( new Intent( this, BeamActivity.class )  );
        else if ( id == R.id.Menu8  ) startActivity( new Intent( this, ListActivity.class )  );
        else if ( id == R.id.Menu9  ) startActivity( new Intent( this, TextActivity.class )  );
        else if ( id == R.id.Menu10 ) startActivity( new Intent( this, AudioActivity.class )  );
        else if ( id == R.id.Menu11 ) startActivity( new Intent( this, MapActivity.class )  );
        else if ( id == R.id.Menu12 ) startActivity( new Intent( this, GpsActivity.class )  );
        else if ( id == R.id.Menu13 ) startActivity( new Intent( this, UploadActivity.class )  );
        else if ( id == R.id.Menu14 ) startActivity( new Intent( this, PlayActivity.class )  );
        else if ( id == R.id.Menu15 ) startActivity( new Intent( this, TimeActivity.class )  );
        else if ( id == R.id.Menu16 ) startActivity( new Intent( this, VoiceActivity.class )  );
        else if ( id == R.id.Menu17 ) startActivity( new Intent( this, SQLiteActivity.class )  );
        else if ( id == R.id.Menu18 ) startActivity( new Intent( this, NavigationActivity.class )  );
        else if ( id == R.id.Menu19 ) startActivity( new Intent( this, TabActivity.class )  );
        else if ( id == R.id.Menu20 ) startActivity( new Intent( this, OpenCVActivity.class )  );
        else if ( id == R.id.Menu21 ) startActivity( new Intent( this, SensorActivity.class )  );
        else if ( id == R.id.Menu22 ) startActivity( new Intent( this, FaceCVActivity.class )  );
        else if ( id == R.id.Menu23 ) startActivity( new Intent( this, AdMobActivity.class )  );
        // else if ( id == R.id.Menu24 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu25 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu26 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu27 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu28 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu29 ) startActivity( new Intent( this, Activity.class )  );
        // else if ( id == R.id.Menu30 ) startActivity( new Intent( this, Activity.class )  );

        return true;
    }
}
