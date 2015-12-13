package com.yjl.rest.core;

import com.google.inject.Singleton;
import com.yjl.rest.message.server.MQServer;

@Singleton
public class GlobalContainer implements Container{
  
  private MQServer mqs;
  
  public GlobalContainer(){
    init();
  }
  
  private void init(){
    // startup message queue socket listener
    mqs = new MQServer();
    mqs.startupServer();
  }
}
