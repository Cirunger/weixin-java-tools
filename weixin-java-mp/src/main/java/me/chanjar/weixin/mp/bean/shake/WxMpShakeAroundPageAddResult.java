package me.chanjar.weixin.mp.bean.shake;

import java.io.Serializable;

import com.google.gson.JsonObject;

import lombok.Data;
import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

@Data
public class WxMpShakeAroundPageAddResult implements Serializable {
  private Integer errorCode;
  private String errorMsg;
  private Integer pageId;
  public static WxMpShakeAroundPageAddResult fromJson(String json) {
    JsonObject jsonObject = WxMpGsonBuilder.INSTANCE.create().fromJson(json, JsonObject.class);
    WxMpShakeAroundPageAddResult result = new WxMpShakeAroundPageAddResult();
    result.setErrorCode(GsonHelper.getInteger(jsonObject, "errcode"));
    result.setErrorMsg(GsonHelper.getString(jsonObject, "errmsg"));
    jsonObject = jsonObject.getAsJsonObject("data");
    if(jsonObject != null){
      result.setPageId(GsonHelper.getInteger(jsonObject, "page_id"));
    }
    return result;
  }
}
