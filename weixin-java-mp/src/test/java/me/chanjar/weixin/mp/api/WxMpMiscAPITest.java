package me.chanjar.weixin.mp.api;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.test.ApiTestModule;

/**
 * @author chanjarster
 */
@Test(groups = "miscAPI")
@Guice(modules = ApiTestModule.class)
public class WxMpMiscAPITest {

  @Inject
  protected WxMpService wxService;

  @Test
  public void testGetCallbackIP() throws WxErrorException {
    String[] ipArray = this.wxService.getCallbackIP();
    System.out.println(Arrays.toString(ipArray));
    Assert.assertNotNull(ipArray);
    Assert.assertNotEquals(ipArray.length, 0);
  }

}
