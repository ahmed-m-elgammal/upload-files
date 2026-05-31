package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.microsoft.clarity.e.Z$$ExternalSyntheticApiModelOutline0;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* loaded from: classes3.dex */
public class NioPathDeserializer extends StdScalarDeserializer<Path> {
    private static final long serialVersionUID = 1;

    public NioPathDeserializer() {
        super((Class<?>) Z$$ExternalSyntheticApiModelOutline0.m1811m());
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Path deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Path path;
        Path path2;
        if (!jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            return Z$$ExternalSyntheticApiModelOutline0.m(deserializationContext.handleUnexpectedToken(Z$$ExternalSyntheticApiModelOutline0.m1811m(), jsonParser));
        }
        String text = jsonParser.getText();
        if (text.indexOf(58) < 0) {
            path2 = Paths.get(text, new String[0]);
            return path2;
        }
        try {
            path = Paths.get(new URI(text));
            return path;
        } catch (URISyntaxException e) {
            return Z$$ExternalSyntheticApiModelOutline0.m(deserializationContext.handleInstantiationProblem(handledType(), text, e));
        }
    }
}
