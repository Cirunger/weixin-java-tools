package me.chanjar.weixin.mp.bean.template;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Daniel Qian
 */
@Data
public class WxMpTemplateData implements Serializable {
  private static final long serialVersionUID = 6301835292940277870L;

  private String name;
  private String value;
  private String color;

  public WxMpTemplateData() {
  }

  public WxMpTemplateData(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public WxMpTemplateData(String name, String value, String color) {
    this.name = name;
    this.value = value;
    this.color = color;
  }

}
