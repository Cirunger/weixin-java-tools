package cn.binarywang.wx.miniapp.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaRetainInfo;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaUserPortrait;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaVisitDistribution;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeCommitRequest;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeVersionDistribution;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaGsonBuilder {
  private static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxMaTemplateMessage.class, new WxMaTemplateMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeCommitRequest.class, new WxMaCodeCommitRequestGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeVersionDistribution.class, new WxMaCodeVersionDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaVisitDistribution.class, new WxMaVisitDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaRetainInfo.class, new WxMaRetainInfoGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaUserPortrait.class, new WxMaUserPortraitGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
