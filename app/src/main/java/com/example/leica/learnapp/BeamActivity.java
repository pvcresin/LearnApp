package com.example.leica.learnapp;

import android.app.ActionBar;
import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;


public class BeamActivity extends ActionBarActivity {
    TextView beamTv, receivedTv;
    EditText beamEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beam);

        beamEt = (EditText) findViewById( R.id.beamEdit );
        beamTv = (TextView) findViewById( R.id.beamText );
        receivedTv = (TextView) findViewById( R.id.receivedT );


        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (nfcAdapter == null){                                                        // nfc check
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        nfcAdapter.setNdefPushMessageCallback(
            new NfcAdapter.CreateNdefMessageCallback() {
                public NdefMessage createNdefMessage(NfcEvent event) {
                    return createMessage();
                }
            },
            this
        );
    }

    public void setText(View v) {
        if (v.getId() == R.id.beamSet) {
            beamTv.setText(beamEt.getText());       // button -> set text to beam
        }
    }

    private NdefMessage createMessage() {
        String mimeType = "application/com.example.leica.learnapp";

        byte[] mimeBytes = mimeType.getBytes( Charset.forName("UTF-8") );

        byte[] payLoad = beamTv.getText().toString().getBytes();                    //generate payload (data body)

        return new NdefMessage(                                                     //generate nfc message
                new NdefRecord[]{
                        new NdefRecord( NdefRecord.TNF_MIME_MEDIA, mimeBytes, null, payLoad)

                        //,NdefRecord.createApplicationRecord("com.example.leica.learnapp")    // AAR = run application
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        if ( NfcAdapter.ACTION_NDEF_DISCOVERED.equals( getIntent().getAction() ) ) {        //received message

            Parcelable[] messages = getIntent().getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

            NdefMessage message = (NdefMessage) messages[0];
            NdefRecord record = message.getRecords()[0];

            String payload = new String( record.getPayload() );

            receivedTv.setText( payload );
        }
    }

}
