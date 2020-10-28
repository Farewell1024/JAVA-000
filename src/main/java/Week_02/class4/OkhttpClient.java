package Week_02.class4;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2020/10/28 15:06
 * @since JDK 1.8
 */
public class OkhttpClient {

    private OkhttpClient(){

    }

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    public static void main(String[] args) {
        OkhttpClient.get("http://localhost:8088/api/hello");
    }

    private static void get(String url){
        Request request = new Request.Builder().url(url).get().build();
        Call call = OK_HTTP_CLIENT.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
