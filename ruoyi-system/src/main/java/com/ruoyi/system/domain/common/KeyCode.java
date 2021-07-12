/*
 * 文件名: KeyCode.java
 * 版权: Copyright 2018-2019, 重庆励祺科技有限公司
 * 作者: liuhongliang
 * 创建时间: 2019年07月02日 16时04分
 * 描述: 键值 - 对象
 */
package com.ruoyi.system.domain.common;


/**
 * description:
 *
 * @Author: aolang
 * @Date: 2020/10/23 0023
 */
public class KeyCode<K, V> {

    private K key;

    private V val;

    public KeyCode() {
    }

    public KeyCode(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}
