package me.chanjar.weixin.mp.bean.device;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.common.util.json.WxGsonBuilder;

/**
 * @author keungtung.
 * @date 10/12/2016
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxDeviceAuthorizeResult extends AbstractDeviceBean {
  private static final long serialVersionUID = 9105294570912249811L;

  private List<BaseResp> resp;

  public static WxDeviceAuthorizeResult fromJson(String response) {
    return WxGsonBuilder.create().fromJson(response, WxDeviceAuthorizeResult.class);
  }

}
