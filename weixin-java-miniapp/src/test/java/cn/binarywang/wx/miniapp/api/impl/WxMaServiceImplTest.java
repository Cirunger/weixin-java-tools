package cn.binarywang.wx.miniapp.api.impl;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMaServiceImplTest {

  @Inject
  private WxMaService wxService;

  public void testRefreshAccessToken() throws WxErrorException {
    WxMaConfig configStorage = this.wxService.getWxMaConfig();
    String before = configStorage.getAccessToken();
    this.wxService.getAccessToken(false);

    String after = configStorage.getAccessToken();
    assertNotEquals(before, after);
    assertTrue(StringUtils.isNotBlank(after));
  }

}
