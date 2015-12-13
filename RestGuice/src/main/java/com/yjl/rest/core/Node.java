package com.yjl.rest.core;

public class Node {
  
  private String host = "127.0.0.1";
  private int port = 18000;
  private boolean isLeader = false;
  
 public Node(String host, int port, boolean isLeader){
    this.host = host;
    this.port = port;
    this.isLeader = isLeader;
  }
  
  public boolean isLeader() {
    return isLeader;
  }
  
  public String getHost() {
    return host;
  }
  
  public int getPort() {
    return port;
  }
}
