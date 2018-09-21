package me.chanjar.weixin.open.bean.result;

import java.io.Serializable;

import lombok.Data;
import me.chanjar.weixin.open.bean.auth.WxOpenAuthorizationInfo;

/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@Data
public class WxOpenQueryAuthResult implements Serializable {
  private static final long serialVersionUID = 2394736235020206855L;

  private WxOpenAuthorizationInfo authorizationInfo;
}
