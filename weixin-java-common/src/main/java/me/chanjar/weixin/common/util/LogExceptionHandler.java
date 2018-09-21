package me.chanjar.weixin.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.weixin.common.api.WxErrorExceptionHandler;
import me.chanjar.weixin.common.error.WxErrorException;


public class LogExceptionHandler implements WxErrorExceptionHandler {

  private Logger log = LoggerFactory.getLogger(WxErrorExceptionHandler.class);

  @Override
  public void handle(WxErrorException e) {

    this.log.error("Error happens", e);

  }

}
