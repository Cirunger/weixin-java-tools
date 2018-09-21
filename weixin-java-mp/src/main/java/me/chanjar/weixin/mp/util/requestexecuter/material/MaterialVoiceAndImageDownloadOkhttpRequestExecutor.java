package me.chanjar.weixin.mp.util.requestexecuter.material;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.weixin.common.WxType;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.RequestHttp;
import me.chanjar.weixin.common.util.http.okhttp.OkHttpProxyInfo;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class MaterialVoiceAndImageDownloadOkhttpRequestExecutor extends MaterialVoiceAndImageDownloadRequestExecutor<OkHttpClient, OkHttpProxyInfo> {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public MaterialVoiceAndImageDownloadOkhttpRequestExecutor(RequestHttp requestHttp, File tmpDirFile) {
    super(requestHttp, tmpDirFile);
  }

  @Override
  public InputStream execute(String uri, String materialId) throws WxErrorException, IOException {
    logger.debug("MaterialVoiceAndImageDownloadOkhttpRequestExecutor is running");
    OkHttpClient client = requestHttp.getRequestHttpClient();
    RequestBody requestBody = new FormBody.Builder().add("media_id", materialId).build();
    Request request = new Request.Builder().url(uri).get().post(requestBody).build();
    Response response = client.newCall(request).execute();
    String contentTypeHeader = response.header("Content-Type");
    if ("text/plain".equals(contentTypeHeader)) {
      String responseContent = response.body().string();
      throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
    }
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); BufferedSink sink = Okio.buffer(Okio.sink(outputStream))) {
      sink.writeAll(response.body().source());
      return new ByteArrayInputStream(outputStream.toByteArray());
    }
  }
}
