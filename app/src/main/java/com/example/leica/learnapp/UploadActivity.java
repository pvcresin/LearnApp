package com.example.leica.learnapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.IOException;

public class UploadActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
    }

    public void uploadFile(View v) {
        int id = v.getId();

        if( id == R.id.uploadButton ) {     // upload button
            Context c = this;

            String filePath = Environment.getExternalStorageDirectory() + "/GeoMelody.3gp";

            new UploadAsyncTask( c ).execute( filePath );         // サーバにアップロード
        }
    }
}


@SuppressWarnings("deprecation")
class UploadAsyncTask extends AsyncTask<String , Integer, Integer> {

    private Context context;
    private String ReceiveStr;

    public UploadAsyncTask(Context context) {
        this.context = context;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Integer doInBackground(String... params) {
        try {
            String key = "";                             // パラメータ作成

            String URL = "http://mloa.net/openhacku/upload.php" + key;      // add to url

            String fileName = params[0];

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost( URL );
            ResponseHandler<? extends String> responseHandler = new BasicResponseHandler();

            MultipartEntity multipartEntity = new MultipartEntity();

            multipartEntity.addPart("upfile", new FileBody( new File( fileName ) ) );

            httpPost.setEntity( multipartEntity );

            ReceiveStr = httpClient.execute( httpPost, responseHandler );

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    protected void onPostExecute(Integer result) {
        Toast.makeText(context, ReceiveStr, Toast.LENGTH_SHORT).show();   // サーバ側phpでechoした内容を表示
    }
}