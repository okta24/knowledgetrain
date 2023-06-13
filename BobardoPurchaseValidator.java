package com.shahruie.www.Knowledge_Train;


        import android.content.Context;
        import android.os.AsyncTask;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.Reader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.util.LinkedHashMap;
        import java.util.Map;

/****

 Apache License. Copyright (C) Bobardo Studio - All Rights Reserved.
 http://bobardo.com
 http://opensource.org/licenses/Apache-2.0

 ****/

public class BobardoPurchaseValidator {

    private Context context;

    private String refresh_token;
    private String client_id;
    private String client_secret;

    private String sku;
    private String orderId;

    private OnValidatePurchaseListener listener;

    public void setup(Context context, String client_id, String client_secret, String refresh_token) {

        if(context instanceof OnValidatePurchaseListener){
            listener = (OnValidatePurchaseListener) context;
            this.context = context;
            this.client_id = client_id;
            this.client_secret = client_secret;
            this.refresh_token = refresh_token;
        }
        else {
            throw new RuntimeException("you should implement OnValidatePurchaseListener in your activity");
        }
    }

    public void validatePurchase(String sku, String orderId) {
        if(context == null){
            throw new RuntimeException("you should call setup() before using validatePurchase()");
        }

        this.sku = sku;
        this.orderId = orderId;

        new getAccessCodeAsync().execute(context.getPackageName(), sku, orderId);

    }

    private class getAccessCodeAsync extends AsyncTask<String, Object, String> {

        @Override
        protected String doInBackground(String... params) {
            return getAccessCode(params[0], params[1], params[2]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            checkPurchase(result);
        }
    }

    private void checkPurchase(String checkUrl) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, checkUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(response.has("error")){
                            listener.onValidatePurchase(false, false, false, sku, orderId, null);
                        }
                        else if(response.has("developerPayload")) {

                            try {
                                listener.onValidatePurchase
                                        (true, response.getInt("purchaseState") == 1,
                                                response.getInt("consumptionState") == 0,
                                                sku, orderId, response.getString("developerPayload"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                listener.onValidatePurchase(false, false, false, sku, orderId, null);
                            }

                        }else {
                            listener.onValidatePurchase(false, false, false, sku, orderId, null);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onValidatePurchase(false, false, false, sku, orderId, null);
                    }
                }
        );

        queue.add(request);
    }

    private String getAccessCode(String packageName, String product, String token) {

        try {
            URL url = new URL("https://pardakht.cafebazaar.ir/devapi/v2/auth/token/");
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("grant_type", "refresh_token");
            params.put("client_id", client_id);
            params.put("client_secret", client_secret);
            params.put("refresh_token", refresh_token);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0; )
                sb.append((char) c);
            String result = sb.toString();
            JSONObject json = new JSONObject(result);
            String accessCode = json.getString("access_token");

            return "https://pardakht.cafebazaar.ir/devapi/v2/api/validate/" + packageName + "/inapp/" + product + "/purchases/" + token + "/?access_token=" + accessCode;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public interface OnValidatePurchaseListener{

        void onValidatePurchase(boolean isValid, boolean isRefund, boolean isConsumed, String sku, String orderId, String payload);
    }
}
