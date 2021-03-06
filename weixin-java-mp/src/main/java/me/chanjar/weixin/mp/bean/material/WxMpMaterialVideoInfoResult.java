package me.chanjar.weixin.mp.bean.material;

import java.io.Serializable;

import lombok.Data;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

@Data
public class WxMpMaterialVideoInfoResult implements Serializable {
  private static final long serialVersionUID = 1269131745333792202L;

  private String title;
  private String description;
  private String downUrl;

  public static WxMpMaterialVideoInfoResult fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMpMaterialVideoInfoResult.class);
  }

}
