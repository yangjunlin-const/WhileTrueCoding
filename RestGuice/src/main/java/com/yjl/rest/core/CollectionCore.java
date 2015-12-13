package com.yjl.rest.core;

import java.util.List;

public class CollectionCore {
  
  public boolean isLeader = false;
  
  public CollectionCore(){
    //TODO check leader
    //TODO if leader, get replicas
  }

  public Node getLeader(){
    return null;
  }
  
  public List<Node> getNodes(){
    return null;
  }
}
