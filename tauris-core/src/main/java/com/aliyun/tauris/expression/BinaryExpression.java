package com.aliyun.tauris.expression;

import com.aliyun.tauris.TObject;

/**
 * Created by yundun-waf-dev
 */
public class BinaryExpression extends TExpression {

    private TExpression left;
    private TExpression right;

    private BinaryOp op;

    public BinaryExpression(TExpression left, BinaryOp op, TExpression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public Object eval(TObject e) {
        return op.eval(e, left, right);
    }

    public String toString() {
        return String.format("%s %s %s", left, op, right);
    }
}
