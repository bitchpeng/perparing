package com.bitchpeng.design.pattern.observer.example03;

import com.bitchpeng.design.pattern.observer.example02.LotteryResult;

/**
 * 事件监听接口
 * @author spikeCong
 * @date 2022/10/12
 **/
public interface EventListener {

    void doEvent(LotteryResult result);
}
