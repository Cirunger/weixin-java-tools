package me.chanjar.weixin.mp.bean.membercard;

import java.io.Serializable;

import lombok.Data;

/**
 * @author YuJian
 * @date 2017/7/11
 */
@Data
public class MemberCardUserInfo implements Serializable {
  private static final long serialVersionUID = -4259196162619282129L;

  private NameValues[] commonFieldList;

  private NameValues[] customFieldList;

}
