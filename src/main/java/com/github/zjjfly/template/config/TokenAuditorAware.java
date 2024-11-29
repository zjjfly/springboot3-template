package com.github.zjjfly.template.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.zjjfly.template.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Optional;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@Component
@RequiredArgsConstructor
public class TokenAuditorAware implements AuditorAware<String> {

    private final Token token;

    private static final Base64.Decoder decoder = Base64.getUrlDecoder();

    @Override
    public Optional<String> getCurrentAuditor() {
        if (token.getValue() == null) {
            return Optional.empty();
        }
        String[] tokenParts = token.getValue().split("\\.");
        String encodedClaims = tokenParts[1];
        byte[] claims = decoder.decode(encodedClaims);
        JsonNode jsonNode = JsonUtils.fromJson(new String(claims), JsonNode.class);
        String sub = jsonNode.get("sub").asText();
        return Optional.of(sub);
    }
}
