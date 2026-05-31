package org.bouncycastle.math.field;

/* loaded from: classes7.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
