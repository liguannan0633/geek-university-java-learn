package com.xiu.rule.listener;

import com.xiu.rule.service.AuditService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * @Author: Mr.xiu
 * @Description: 默认规则监听
 * @Date: 2020/12/24 16:43
 */
@Slf4j
public class DefaultRulesListener implements RuleListener {

  @Resource
  private AuditService auditService;

  @Override
  public boolean beforeEvaluate(Rule rule, Facts facts) {
    System.out.println("哈哈哈哈哈 beforeEvaluate");
    return true;
  }

  @Override
  public void afterEvaluate(Rule rule, Facts facts, boolean b) {
    System.out.println("哈哈哈哈哈 afterEvaluate");
    if (!b) {
      auditService.failDeal(rule,facts);
    }
  }

  @Override
  public void beforeExecute(Rule rule, Facts facts) {
    System.out.println("哈哈哈哈哈 beforeExecute");
  }

  @Override
  public void onSuccess(Rule rule, Facts facts) {
    System.out.println("哈哈哈哈哈 onSuccess");
    log.info("rule execute success...ruleName:{}", rule.getName());
  }

  @Override
  public void onFailure(Rule rule, Facts facts, Exception e) {
    System.out.println("哈哈哈哈哈 onFailure");
    log.info("rule execute fail...ruleName:{}", rule.getName());
  }
}