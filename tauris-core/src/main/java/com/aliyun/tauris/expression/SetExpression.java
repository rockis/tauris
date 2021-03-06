package com.aliyun.tauris.expression;

import com.aliyun.tauris.TObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhangLei on 17/5/26.
 */
public class SetExpression extends TExpression implements ContainerExpression {

    private Set<?> set;

    public SetExpression(Set<?> set) {
        this.set = set;
    }

    public boolean contains(TObject c, Object o) {
        return set.contains(o);
    }

    @Override
    public Object eval(TObject e) {
        return set;
    }

    @Override
    public String toString() {
        List<String> strs = new ArrayList<>();
        for (Object o : set) {
            strs.add(o.toString());
        }
        return String.join(",", strs);
    }
}
