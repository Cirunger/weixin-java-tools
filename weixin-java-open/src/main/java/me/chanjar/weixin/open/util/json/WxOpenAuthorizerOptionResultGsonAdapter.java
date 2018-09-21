package me.chanjar.weixin.open.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerOptionResult;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
public class WxOpenAuthorizerOptionResultGsonAdapter implements JsonDeserializer<WxOpenAuthorizerOptionResult> {
  @Override
  public WxOpenAuthorizerOptionResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    WxOpenAuthorizerOptionResult authorizerOptionResult = new WxOpenAuthorizerOptionResult();
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    authorizerOptionResult.setAuthorizerAppid(GsonHelper.getString(jsonObject, "authorizer_appid"));
    authorizerOptionResult.setOptionName(GsonHelper.getString(jsonObject, "option_name"));
    authorizerOptionResult.setOptionValue(GsonHelper.getString(jsonObject, "option_value"));
    return authorizerOptionResult;
  }
}
