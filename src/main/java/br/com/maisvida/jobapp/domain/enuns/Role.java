package br.com.maisvida.jobapp.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by loliveira on 18/02/19.
 */
@Getter
@AllArgsConstructor
public enum Role {
    ADMIN(1, "ROLE_ADMIN"); //the word Role is required for spring security

    private Integer id;
    private String description;

    public static Role toEnum(Integer code) {
        if(code == null) {
            return null;
        }

        for(Role type : Role.values()) {
            if(code.equals(type.getId())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}
