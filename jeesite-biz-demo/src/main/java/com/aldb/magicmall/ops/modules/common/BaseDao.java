package com.aldb.magicmall.ops.modules.common;

public interface BaseDao<T, K> {

   
    public T get(K arg0);

   
    public abstract int add(T arg0);

  
    public abstract int del(K arg0);


    public abstract int update(T arg0);
}