package me.chanjar.weixin.mp.bean.membercard;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author YuJian
 * @date 2017/7/11
 */
@Data
public class NameValues implements Serializable{
  private static final long serialVersionUID = -8529369702944594330L;

  private String name;

  private String value;

  private String[] valueList;

}
