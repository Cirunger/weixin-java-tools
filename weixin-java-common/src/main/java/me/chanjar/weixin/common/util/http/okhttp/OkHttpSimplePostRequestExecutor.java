package me.chanjar.weixin.common.util.http.okhttp;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestHttp;
import me.chanjar.weixin.common.util.http.SimplePostRequestExecutor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ecoolper on 2017/5/4.
 */
public class OkHttpSimplePostRequestExecutor extends SimplePostRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public OkHttpSimplePostRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public String execute(String uri, String postEntity) throws WxErrorException, IOException {
    logger.debug("OkHttpSimplePostRequestExecutor running");
    //得到httpClient
    OkHttpClient client = requestHttp.getRequestHttpClient();

    MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
    RequestBody body = RequestBody.create(mediaType, postEntity);

    Request request = new Request.Builder().url(uri).post(body).build();

    Response response = client.newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }
    return responseContent;
  }

}
