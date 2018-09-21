package me.chanjar.weixin.mp.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

public class WxUserListGsonAdapter implements JsonDeserializer<WxMpUserList> {

  @Override
  public WxMpUserList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonObject o = json.getAsJsonObject();
    WxMpUserList wxMpUserList = new WxMpUserList();
    wxMpUserList.setTotal(GsonHelper.getLong(o, "total"));
    wxMpUserList.setCount(GsonHelper.getInteger(o, "count"));
    wxMpUserList.setNextOpenid(GsonHelper.getString(o, "next_openid"));
    if (o.get("data") != null && !o.get("data").isJsonNull() && !o.get("data").getAsJsonObject().get("openid").isJsonNull()) {
      JsonArray data = o.get("data").getAsJsonObject().get("openid").getAsJsonArray();
      for (int i = 0; i < data.size(); i++) {
        wxMpUserList.getOpenids().add(GsonHelper.getAsString(data.get(i)));
      }
    }
    return wxMpUserList;
  }

}
