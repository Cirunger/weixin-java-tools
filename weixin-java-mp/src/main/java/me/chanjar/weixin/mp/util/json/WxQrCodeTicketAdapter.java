package me.chanjar.weixin.mp.util.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import me.chanjar.weixin.common.util.json.GsonHelper;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

/**
 * @author Daniel Qian
 */
public class WxQrCodeTicketAdapter implements JsonDeserializer<WxMpQrCodeTicket> {

  @Override
  public WxMpQrCodeTicket deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    WxMpQrCodeTicket ticket = new WxMpQrCodeTicket();
    JsonObject ticketJsonObject = json.getAsJsonObject();

    if (ticketJsonObject.get("ticket") != null && !ticketJsonObject.get("ticket").isJsonNull()) {
      ticket.setTicket(GsonHelper.getAsString(ticketJsonObject.get("ticket")));
    }
    if (ticketJsonObject.get("expire_seconds") != null && !ticketJsonObject.get("expire_seconds").isJsonNull()) {
      ticket.setExpireSeconds(GsonHelper.getAsPrimitiveInt(ticketJsonObject.get("expire_seconds")));
    }
    if (ticketJsonObject.get("url") != null && !ticketJsonObject.get("url").isJsonNull()) {
      ticket.setUrl(GsonHelper.getAsString(ticketJsonObject.get("url")));
    }
    return ticket;
  }

}
