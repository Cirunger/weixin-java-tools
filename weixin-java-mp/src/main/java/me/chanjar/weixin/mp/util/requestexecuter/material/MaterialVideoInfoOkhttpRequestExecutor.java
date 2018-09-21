package me.chanjar.weixin.mp.util.requestexecuter.material;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.weixin.common.WxType;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestHttp;
import me.chanjar.weixin.common.util.http.okhttp.OkHttpProxyInfo;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialVideoInfoResult;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialVideoInfoOkhttpRequestExecutor extends MaterialVideoInfoRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public MaterialVideoInfoOkhttpRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public WxMpMaterialVideoInfoResult execute(String uri, String materialId) throws WxErrorException, IOException {
    logger.debug("MaterialVideoInfoOkhttpRequestExecutor is running");
    //得到httpClient
    OkHttpClient client = requestHttp.getRequestHttpClient();

    RequestBody requestBody = new FormBody.Builder().add("media_id", materialId).build();
    Request request = new Request.Builder().url(uri).post(requestBody).build();
    Response response = client.newCall(request).execute();
    String responseContent = response.body().string();
    WxError error = WxError.fromJson(responseContent, WxType.MP);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    } else {
      return WxMpMaterialVideoInfoResult.fromJson(responseContent);
    }
  }
}
