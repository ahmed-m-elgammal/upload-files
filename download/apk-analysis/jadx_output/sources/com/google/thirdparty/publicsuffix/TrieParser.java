package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import java.util.Deque;

/* loaded from: classes5.dex */
final class TrieParser {
    private static final Joiner DIRECT_JOINER = Joiner.on("");

    TrieParser() {
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence... encodedChunks) {
        return parseFullString(DIRECT_JOINER.join(encodedChunks));
    }

    static ImmutableMap<String, PublicSuffixType> parseFullString(String encoded) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = encoded.length();
        int i = 0;
        while (i < length) {
            i += doParseTrieToBuilder(Queues.newArrayDeque(), encoded, i, builder);
        }
        return builder.buildOrThrow();
    }

    private static int doParseTrieToBuilder(Deque<CharSequence> stack, CharSequence encoded, int start, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        int length = encoded.length();
        char c = 0;
        int i = start;
        while (i < length && (c = encoded.charAt(i)) != '&' && c != '?' && c != '!' && c != ':' && c != ',') {
            i++;
        }
        stack.push(reverse(encoded.subSequence(start, i)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            String join = DIRECT_JOINER.join(stack);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c));
            }
        }
        int i2 = i + 1;
        if (c != '?' && c != ',') {
            while (i2 < length) {
                i2 += doParseTrieToBuilder(stack, encoded, i2, builder);
                if (encoded.charAt(i2) == '?' || encoded.charAt(i2) == ',') {
                    i2++;
                    break;
                }
            }
        }
        stack.pop();
        return i2 - start;
    }

    private static CharSequence reverse(CharSequence s) {
        return new StringBuilder(s).reverse();
    }
}
