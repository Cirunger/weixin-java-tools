package me.chanjar.weixin.mp.demo;

import java.io.InputStream;
import java.util.concurrent.locks.ReentrantLock;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

/**
 * @author Daniel Qian
 */
@XStreamAlias("xml")
class WxMpDemoInMemoryConfigStorage extends WxMpInMemoryConfigStorage {

  public static WxMpDemoInMemoryConfigStorage fromXml(InputStream is) {
    XStream xstream = XStreamInitializer.getInstance();
    xstream.processAnnotations(WxMpDemoInMemoryConfigStorage.class);
    WxMpDemoInMemoryConfigStorage wxMpDemoInMemoryConfigStorage = (WxMpDemoInMemoryConfigStorage) xstream.fromXML(is);
    wxMpDemoInMemoryConfigStorage.accessTokenLock = new ReentrantLock();
    wxMpDemoInMemoryConfigStorage.cardApiTicketLock = new ReentrantLock();
    wxMpDemoInMemoryConfigStorage.jsapiTicketLock = new ReentrantLock();
    return wxMpDemoInMemoryConfigStorage;
  }

  @Override
  public String toString() {
    return "SimpleWxConfigProvider [appId=" + this.appId + ", secret=" + this.secret + ", accessToken=" + this.accessToken
      + ", expiresTime=" + this.expiresTime + ", token=" + this.token + ", aesKey=" + this.aesKey + ", templateId=" + this.templateId + "]";
  }

}
