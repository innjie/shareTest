package ddwu.mobile.final_project.sharetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
//https://developers.facebook.com/docs/sharing/android/?locale=ko_KR
public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    Button shareFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        shareFacebook = (Button)findViewById(R.id.share2);
    }
    public void shareTwitter() {
        String strLink = null;
        try {
            strLink = String.format("http://twitter.com/intent/tweet?text=%s", URLEncoder.encode("공유할 텍스트를 입력하세요", "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strLink));
        startActivity(intent);

    }
    public void shareCacao() {


    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.share1:
                shareTwitter();
            case R.id.share2:
                shareCacao();
        }
    }

}
