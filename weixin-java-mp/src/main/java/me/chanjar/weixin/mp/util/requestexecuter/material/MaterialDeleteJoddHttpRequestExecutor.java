package me.chanjar.weixin.mp.util.requestexecuter.material;

import java.io.IOException;

import jodd.http.HttpConnectionProvider;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.util.StringPool;
import me.chanjar.weixin.common.WxType;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestHttp;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialDeleteJoddHttpRequestExecutor extends MaterialDeleteRequestExecutor<HttpConnectionProvider, ProxyInfo> {
  public MaterialDeleteJoddHttpRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public Boolean execute(String uri, String materialId) throws WxErrorException, IOException {
    HttpRequest request = HttpRequest.post(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      requestHttp.getRequestHttpClient().useProxy(requestHttp.getRequestHttpProxy());
    }
    request.withConnectionProvider(requestHttp.getRequestHttpClient());

    request.query("media_id", materialId);
    HttpResponse response = request.send();
    response.charset(StringPool.UTF_8);
    String responseContent = response.bodyText();
    WxError error = WxError.fromJson(responseContent, WxType.MP);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    } else {
      return true;
    }
  }
}
