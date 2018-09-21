package me.chanjar.weixin.open.bean.auth;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import lombok.Data;

@Data
public class WxOpenMiniProgramInfo {
  private Map<String, List<String>> network;
  private List<Pair<String, String>> categories;
  private Integer visitStatus;
}
