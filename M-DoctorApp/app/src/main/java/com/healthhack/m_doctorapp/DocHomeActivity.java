package com.healthhack.m_doctorapp;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class DocHomeActivity extends ActionBarActivity {

    TextView pat_idView,symptom,description;
    Button nextPat;
    int doc_id,pat_id;
    String url="http://192.168.1.217:3000/doctorpatientlist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pat_idView=(TextView)findViewById(R.id.pat_id);
        symptom=(TextView)findViewById(R.id.symptom);
        description=(TextView)findViewById(R.id.description);

        nextPat=(Button)findViewById(R.id.nextbutton);


        doc_id=1001;


        nextPat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parse json and get nextPatient record
                new HttpAsyncTask().execute(url);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String POST(String url, int doc_id){
        String response;

        try {
            /*SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            final SSLSocketFactory sslSocketFactory = SSLSocketFactory.getSocketFactory();
            sslSocketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            registry.register(new Scheme("https", sslSocketFactory, 80));*/

            /*DefaultHttpClient httpclient = new DefaultHttpClient(
                    new ThreadSafeClientConnManager(+
                    (new BasicHttpParams()), registry), new BasicHttpParams()
            );*/
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            JSONObject json = new JSONObject();
            //json.put("DOC_ID",doc_id);
            json.accumulate("DOC_ID",doc_id);
            Log.d("doc_id", "" + doc_id);
            System.out.println(json.toString());
            httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setHeader("Accept","application/json");
            StringEntity e = new StringEntity(json.toString());
           // httppost.setEntity(new ByteArrayEntity(
             //       json.toString().getBytes("UTF8")));
            httppost.setEntity(e);
            HttpResponse responce = httpclient.execute(httppost);
            HttpEntity httpEntity = responce.getEntity();

            response = EntityUtils.toString(httpEntity);
            Log.d("response is", response);

            //JSONObject jsonObject = new JSONObject(response);
            //return jsonObject.toString();
            return response;

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return null;
    }

    public String parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("translations");
        jobject = jarray.get(0).getAsJsonObject();
        String result = jobject.get("translatedText").toString();
        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        int i=0;JSONParser jsonParser;
        JSONArray array=new JSONArray();
        @Override
        protected String doInBackground(String... urls) {

            //return GET(urls[0]);
           // return POST(urls[0], doc_id);


            List<NameValuePair> args = new ArrayList<NameValuePair>();
            //args.add(new BasicNameValuePair("PAT_ID", String.valueOf(idCounter++)));
            args.add(new BasicNameValuePair("DOC_ID", String.valueOf(1001)));

            jsonParser = new JSONParser();
            //JSONArray obj = new JSONArray(args);
            JSONObject json = jsonParser.makeHttpRequest(urls[0], "POST", args);



           Log.d("JSON Contents", "JSON IS =------------------------"+json.toString());
            try{
                array=json.getJSONArray("");
                Log.d("Success value", "Value is: ------------------------"+json.get("success"));

                //int success = Integer.parseInt(json.getString("success"));
                //if(success == 1){
                    i=1;
                //}
                //else{i=0;}
            }
            catch(Exception e){

            }
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            //setdata to TextViews
            //String data = parse(result);
            Log.d("parse json",""+result);
            //etResponse.setText(result);
        }
    }

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

}
