package com.zaguiini.RNPureJwt;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultClaims;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class RNPureJwtModule extends ReactContextBaseJavaModule {
    public RNPureJwtModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNPureJwt";
    }

    private String toBase64(String str) {
        return Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 0);
    }

    private String base64toString(String str) {
        return new String(Base64.decode(str, 0));
    }

    private void getResponse(String str, Promise promise) {
        ObjectMapper objectMapper = new ObjectMapper();
        WritableMap createMap = Arguments.createMap();
        String[] split = str.split(Pattern.quote("."));
        try {
            createMap.putMap("headers", Arguments.makeNativeMap((Map<String, Object>) objectMapper.readValue(base64toString(split[0]), new TypeReference<Map<String, Object>>() { // from class: com.zaguiini.RNPureJwt.RNPureJwtModule.1
            })));
        } catch (IOException unused) {
            promise.reject("7", "Invalid header");
        }
        try {
            createMap.putMap("payload", Arguments.makeNativeMap((Map<String, Object>) objectMapper.readValue(base64toString(split[1]), new TypeReference<Map<String, Object>>() { // from class: com.zaguiini.RNPureJwt.RNPureJwtModule.2
            })));
        } catch (IOException unused2) {
            promise.reject("8", "Invalid payload");
        }
        promise.resolve(createMap);
    }

    private void getResponse(Jwt jwt, Promise promise) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = (Map) objectMapper.convertValue(jwt.getHeader(), DefaultClaims.class);
        Map map2 = (Map) objectMapper.convertValue(jwt.getBody(), DefaultClaims.class);
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("headers", Arguments.makeNativeMap((Map<String, Object>) map));
        createMap.putMap("payload", Arguments.makeNativeMap((Map<String, Object>) map2));
        promise.resolve(createMap);
    }

    @ReactMethod
    public void decode(String str, String str2, ReadableMap readableMap, Promise promise) {
        JwtParser signingKey = Jwts.parser().setSigningKey(toBase64(str2));
        Boolean bool = false;
        for (Map.Entry<String, Object> entry : readableMap.toHashMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            key.hashCode();
            if (key.equals("skipValidation")) {
                Boolean bool2 = (Boolean) value;
                bool2.booleanValue();
                bool = bool2;
            }
        }
        try {
            getResponse(signingKey.parse(str), promise);
        } catch (ExpiredJwtException unused) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject(ExifInterface.GPS_MEASUREMENT_3D, "The JWT is expired.");
            }
        } catch (MalformedJwtException unused2) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject(ExifInterface.GPS_MEASUREMENT_2D, "The JWT is invalid.");
            }
        } catch (SignatureException unused3) {
            if (bool.booleanValue()) {
                getResponse(str, promise);
            } else {
                promise.reject("6", "Invalid signature.");
            }
        } catch (Exception e) {
            promise.reject("0", e);
        }
    }

    @ReactMethod
    public void sign(ReadableMap readableMap, String str, ReadableMap readableMap2, Promise promise) {
        String key;
        Object value;
        String string = readableMap2.hasKey("alg") ? readableMap2.getString("alg") : "HS256";
        JwtBuilder headerParam = Jwts.builder().signWith(SignatureAlgorithm.forName(string), toBase64(str)).setHeaderParam("alg", string).setHeaderParam("typ", Header.JWT_TYPE);
        for (Map.Entry<String, Object> entry : readableMap.toHashMap().entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            key.hashCode();
            switch (key) {
                case "alg":
                    break;
                case "aud":
                    headerParam.setAudience(value.toString());
                    break;
                case "exp":
                    Double d = (Double) value;
                    d.doubleValue();
                    headerParam.setExpiration(new Date(d.longValue()));
                    break;
                case "iat":
                    Double d2 = (Double) value;
                    d2.doubleValue();
                    headerParam.setIssuedAt(new Date(d2.longValue()));
                    break;
                case "iss":
                    headerParam.setIssuer(value.toString());
                    break;
                case "jti":
                    headerParam.setId(value.toString());
                    break;
                case "nbf":
                    Double d3 = (Double) value;
                    d3.doubleValue();
                    headerParam.setNotBefore(new Date(d3.longValue()));
                    break;
                case "sub":
                    headerParam.setSubject(value.toString());
                    break;
                default:
                    headerParam.claim(key, value);
                    break;
            }
        }
        promise.resolve(headerParam.compact());
    }
}
