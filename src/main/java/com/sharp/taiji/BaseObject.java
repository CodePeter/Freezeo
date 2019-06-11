package com.sharp.taiji;

import org.apache.commons.pool2.impl.BaseGenericObjectPool;

public class BaseObject {

    private String nameValue;

    public BaseObject(String nameValue) {
        this.nameValue = nameValue;
    }

//    @Override
//    public int hashCode() {
//        return System.identityHashCode(this);
//    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(final Object other) {
        return other instanceof BaseObject &&
                ((BaseObject) other).nameValue.equals(this.nameValue);
    }

    public static void main(String[] args) {
        BaseObject b1 = new BaseObject("durant");
        BaseObject b2 = new BaseObject("durant");
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        CompareObject c1 = new CompareObject();
        System.out.println(b1.equals(c1));
        System.out.println(b1.equals(b2));

    }
}
