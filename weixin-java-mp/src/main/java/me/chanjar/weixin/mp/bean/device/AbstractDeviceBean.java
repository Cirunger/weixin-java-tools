package me.chanjar.weixin.mp.bean.device;

import java.io.Serializable;

import me.chanjar.weixin.common.util.json.WxGsonBuilder;

/**
 * 设备抽象类.
 *
 * @author keungtung
 * @date 14/12/2016
 */
public abstract class AbstractDeviceBean implements Serializable {
  private static final long serialVersionUID = 4359729626772515385L;

  public String toJson() {
    return WxGsonBuilder.create().toJson(this);
  }
}
